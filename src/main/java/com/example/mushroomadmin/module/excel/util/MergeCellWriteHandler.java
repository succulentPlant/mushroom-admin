package com.example.mushroomadmin.module.excel.util;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

/**
 * 合并单元格
 * @author ting.xu
 * @date 2023-04-24 17:23
 */
public class MergeCellWriteHandler implements CellWriteHandler {
    /**
     * 需要合并的列的索引
     */
    private int[] mergeColumnIndex;
    /**
     * 标识列索引(确定合并列行唯一的列)
     */
    private int[] flagColumnIndex;
    /**
     * 数据起始行索引
     */
    private int mergeRowIndex;

    public MergeCellWriteHandler(int[] mergeColumnIndex, int[] flagColumnIndex, int mergeRowIndex) {
        this.mergeColumnIndex = mergeColumnIndex;
        this.flagColumnIndex = flagColumnIndex;
        this.mergeRowIndex = mergeRowIndex;
    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        CellWriteHandler.super.afterCellDispose(writeSheetHolder, writeTableHolder, cellDataList, cell, head, relativeRowIndex, isHead);
        //当前单元格的行索引
        int curRowIndex = cell.getRowIndex();
        //当前单元格的列索引
        int curColIndex = cell.getColumnIndex();
        // 从下往上合并
        if (curRowIndex > mergeRowIndex) {

            Row row = cell.getSheet().getRow(curRowIndex);
            Row preRow = cell.getSheet().getRow(curRowIndex - 1);

            //根据标识列判断当前行需要合并的列和上一行是否相同
            Boolean flag = false;

            for (int i = 0; i < flagColumnIndex.length; i++) {

                int index = flagColumnIndex[i];

                Cell flagCell = row.getCell(index);
                Object flagCellData = null;
                if(flagCell != null){
                    flagCellData = flagCell.getCellType() == CellType.STRING ? flagCell.getStringCellValue() : flagCell.getNumericCellValue();
                }

                Cell preFlagCell = preRow.getCell(index);
                Object preFlagCellData = null;
                if(preFlagCell != null ){
                    preFlagCellData = preFlagCell.getCellTypeEnum() == CellType.STRING ? preFlagCell.getStringCellValue() : preFlagCell.getNumericCellValue();
                }

                if(flagCellData != null && preFlagCellData != null ){
                    flag = flagCellData.equals(preFlagCellData);
                }else{
                    flag = false;
                }

                if(!flag){
                    break;
                }
            }

            //相同，则逐列合并
            if(flag){
                for (int i = 0; i < mergeColumnIndex.length; i++) {
                    if (curColIndex == mergeColumnIndex[i]) {
                        this.mergeWithPrevRow(writeSheetHolder, cell, curRowIndex, curColIndex);
                        break;
                    }
                }
            }
        }
    }

    /**
     * 当前单元格向上合并
     * @param writeSheetHolder
     * @param cell
     * @param curRowIndex
     * @param curColIndex
     */
    private void mergeWithPrevRow(WriteSheetHolder writeSheetHolder, Cell cell, int curRowIndex, int curColIndex) {
        // 比较当前行的第一列的单元格与上一行是否相同，相同合并当前单元格与上一行
        Object curData = cell.getCellType() == CellType.STRING ? cell.getStringCellValue() : cell.getNumericCellValue();

        Cell preCell = cell.getSheet().getRow(curRowIndex - 1).getCell(curColIndex);
        Object preData = preCell.getCellType() == CellType.STRING ? preCell.getStringCellValue() : preCell.getNumericCellValue();

        //将当前单元格数据与上一个单元格数据比较
        if (curData.equals(preData)) {
            Sheet sheet = writeSheetHolder.getSheet();
            //当前sheet页的合并情况
            List<CellRangeAddress> mergeRegions = sheet.getMergedRegions();
            boolean isMerged = false;
            for (int i = 0; i < mergeRegions.size() && !isMerged; i++) {
                CellRangeAddress cellRangeAddr = mergeRegions.get(i);
                // 若上一个单元格已经被合并，则先移出原有的合并单元，再重新添加合并单元
                if (cellRangeAddr.isInRange(curRowIndex - 1, curColIndex)) {
                    sheet.removeMergedRegion(i);
                    cellRangeAddr.setLastRow(curRowIndex);
                    sheet.addMergedRegion(cellRangeAddr);
                    isMerged = true;
                }
            }
            //若上一个单元格未被合并，则新增合并单元
            if (!isMerged) {
                CellRangeAddress cellRangeAddress = new CellRangeAddress(curRowIndex - 1, curRowIndex, curColIndex, curColIndex);
                sheet.addMergedRegion(cellRangeAddress);
            }
        }
    }
}
