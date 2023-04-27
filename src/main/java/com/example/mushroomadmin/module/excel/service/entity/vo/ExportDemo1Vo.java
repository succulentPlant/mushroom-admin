package com.example.mushroomadmin.module.excel.service.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;

import java.io.Serializable;

/**
 * @author ting.xu
 * @date 2023-04-21 17:14
 */
@HeadRowHeight(15)      //设置表头的行高
@ContentRowHeight(15)   //设置内容的行高
public class ExportDemo1Vo implements Serializable {
    /**
     * 歌手名称
     */
    @ExcelProperty(value = "歌手名称", index = 0)   //设置列名，并指定列的位置
    @ColumnWidth(20)                               //设置列的宽度
    @ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER)     //居中
    private String singerName;
    /**
     * 专辑数量
     */
    @ExcelProperty(value = "专辑数量", index = 1)
    @ColumnWidth(20)
    @ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER)
    private Integer albumCount;
    /**
     * 专辑名称
     */
    @ExcelProperty(value = {"专辑","专辑名称"}, index = 2) //多表头，值一样自动合并
    @ColumnWidth(20)
    @ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT)
    private String albumName;
    /**
     * 发表时间
     */
    @ExcelProperty(value = {"专辑","发表时间"}, index = 3)
    @ColumnWidth(20)
    @ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT)
    private String publishDate;
    /**
     * 唱片公司
     */
    @ExcelProperty(value = {"专辑","唱片公司"}, index = 4)
    @ColumnWidth(20)
    @ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT)
    private String recordCompany;

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public Integer getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(Integer albumCount) {
        this.albumCount = albumCount;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getRecordCompany() {
        return recordCompany;
    }

    public void setRecordCompany(String recordCompany) {
        this.recordCompany = recordCompany;
    }
}
