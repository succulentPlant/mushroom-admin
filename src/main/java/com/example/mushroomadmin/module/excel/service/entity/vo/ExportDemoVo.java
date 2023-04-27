package com.example.mushroomadmin.module.excel.service.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.io.Serializable;

/**
 * @author ting.xu
 * @date 2023-04-21 17:14
 */
public class ExportDemoVo implements Serializable {
    /**
     * 歌手名称
     */
    @ExcelProperty(value = "歌手名称", index = 0)
    @ColumnWidth(20)
    private String singerName;
    /**
     * 专辑数量
     */
    @ExcelProperty(value = "专辑数量", index = 1)
    @ColumnWidth(20)
    private Integer albumCount;
    /**
     * 专辑名称
     */
    @ExcelProperty(value = "专辑名称", index = 2)
    @ColumnWidth(20)
    private String albumName;
    /**
     * 发表时间
     */
    @ExcelProperty(value = "发表时间", index = 3)
    @ColumnWidth(20)
    private String publishDate;
    /**
     * 唱片公司
     */
    @ExcelProperty(value = "唱片公司", index = 4)
    @ColumnWidth(20)
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
