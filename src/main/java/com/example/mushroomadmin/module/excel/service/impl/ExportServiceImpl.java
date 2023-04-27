package com.example.mushroomadmin.module.excel.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.example.mushroomadmin.module.excel.service.ExportService;
import com.example.mushroomadmin.module.excel.service.entity.dto.AlbumDto;
import com.example.mushroomadmin.module.excel.service.entity.dto.SingerDto;
import com.example.mushroomadmin.module.excel.service.entity.vo.ExportDemo1Vo;
import com.example.mushroomadmin.module.excel.service.entity.vo.ExportDemoVo;
import com.example.mushroomadmin.module.excel.util.MergeCellWriteHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ting.xu
 * @date 2023-04-21 15:17
 */
@Service
public class ExportServiceImpl implements ExportService {
    /**
     * 导出
     * Demo
     * @return
     * @throws IOException
     */
    @Override
    public void exportDemo() {
        //数据准备
        List<SingerDto> singers = this.getSingers();
        //转换数据格式，ExportDemo1Vo为每一行的列
        List<ExportDemoVo> list = this.changeDataFormate1(singers);
        //写入Excel
        ExcelWriter excelWriter = EasyExcel.write("/Users/sanmaoguka/Documents/Demo/demo.xlsx")
                .excelType(ExcelTypeEnum.XLSX)
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet("Demo").build();
        WriteTable writeTable = EasyExcel.writerTable(0).head(ExportDemoVo.class).build();
        excelWriter.write(list, writeSheet, writeTable);
        excelWriter.finish();
    }
    /**
     * 导出+设置单元格格式
     * Demo1，在Demo的基础上通过在导出的实体类上增加注解，设置单元格格式及多表头
     * @return
     * @throws IOException
     */
    @Override
    public void exportDemo1() throws IOException {
        //数据准备
        List<SingerDto> singers = this.getSingers();
        //转换数据格式，ExportDemo1Vo为每一行的列
        List<ExportDemoVo> list = this.changeDataFormate1(singers);
        //写入Excel
        ExcelWriter excelWriter = EasyExcel.write("/Users/sanmaoguka/Documents/Demo/demo1.xlsx")
                .excelType(ExcelTypeEnum.XLSX)
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet("Demo1").build();
        WriteTable writeTable = EasyExcel.writerTable(0).head(ExportDemo1Vo.class).build();
        excelWriter.write(list, writeSheet, writeTable);
        excelWriter.finish();
    }
    /**
     * 导出+设置单元格格式+动态的单元格合并（行合并）
     * Demo2，在Demo1的基础上通过拦截器自定义合并策略，进行行合并
     * @return
     * @throws IOException
     */
    @Override
    public void exportDemo2() {
        //数据准备
        List<SingerDto> singers = this.getSingers();
        //转换数据格式，ExportDemo1Vo为每一行的列
        List<ExportDemoVo> list = this.changeDataFormate1(singers);
        //写入Excel，自定义拦截器合并单元格
        ExcelWriter excelWriter = EasyExcel.write("/Users/sanmaoguka/Documents/Demo/demo2.xlsx")
                .excelType(ExcelTypeEnum.XLSX)
                .registerWriteHandler(new MergeCellWriteHandler(new int[]{0, 1, 2},new int[]{0},1))     //通过拦截器，自定义单元格的行合并规则，从第1行开始，以第0列数据为合并依据，将0、1、2列的数据进行行合并
                .registerWriteHandler(new MergeCellWriteHandler(new int[]{3, 4, 5},new int[]{0,3},1))   //通过拦截器，自定义单元格的行合并规则，从第1行开始，以第0、3列数据为合并依据，将3、4、5列的数据进行行合并
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet("Demo2").build();
        WriteTable writeTable = EasyExcel.writerTable(0).head(ExportDemo1Vo.class).build();
        excelWriter.write(list, writeSheet, writeTable);
        excelWriter.finish();
    }

    /**
     * 转换数据格式
     * @param singers 源数据
     * @return
     */
    private List<ExportDemoVo> changeDataFormate1(List<SingerDto> singers) {
        List<ExportDemoVo> list = new ArrayList<>();
        singers.forEach(t -> {
            List<AlbumDto> albumDtos = t.getAlbumDtos();
            int size = albumDtos != null && albumDtos.size() > 0 ? albumDtos.size() : 0;
            for (int i = 0; i < size; i++) {
                ExportDemoVo exportDemoVo = new ExportDemoVo();
                exportDemoVo.setSingerName(t.getSingerName());
                exportDemoVo.setAlbumCount(t.getAlbumCount());
                AlbumDto albumDto = albumDtos.get(i);
                exportDemoVo.setAlbumName(albumDto.getAlbumName());
                exportDemoVo.setPublishDate(albumDto.getPublishDate());
                exportDemoVo.setRecordCompany(albumDto.getRecordCompany());
                list.add(exportDemoVo);
            }
        });
        return list;
    }

    /**
     * 数据准备
     * @return
     */
    private List<SingerDto> getSingers() {

        List<SingerDto> singers = new ArrayList<>();
        //歌手1
        SingerDto singer1 = new SingerDto();
        singer1.setSingerName("薛之谦");
        singer1.setAlbumCount(2);
        List<AlbumDto> albumDtos1 = new ArrayList<>();
        albumDtos1.add(new AlbumDto("天外来物","2020-12-31","潮石音乐"));
        albumDtos1.add(new AlbumDto("怪咖","2018-12-31","潮石音乐"));
        singer1.setAlbumDtos(albumDtos1);
        singers.add(singer1);
        //歌手2
        SingerDto singer2 = new SingerDto();
        singer2.setSingerName("林宥嘉");
        singer2.setAlbumCount(3);
        List<AlbumDto> albumDtos2 = new ArrayList<>();
        albumDtos2.add(new AlbumDto("少女","2019-09-24","华研国际音乐"));
        albumDtos2.add(new AlbumDto("美妙生活","2011-05-06","华研国际音乐"));
        albumDtos2.add(new AlbumDto("神秘嘉宾","2008-06-3","华研国际音乐"));
        singer2.setAlbumDtos(albumDtos2);
        singers.add(singer2);

        return singers;
    }
}
