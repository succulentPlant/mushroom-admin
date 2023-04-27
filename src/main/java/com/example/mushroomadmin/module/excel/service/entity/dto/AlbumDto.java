package com.example.mushroomadmin.module.excel.service.entity.dto;

/**
 * @author ting.xu
 * @date 2023-04-21 15:41
 */
public class AlbumDto {
    /**
     * 专辑名称
     */
    private String albumName;
    /**
     * 发表时间
     */
    private String publishDate;
    /**
     * 唱片公司
     */
    private String recordCompany;

    public AlbumDto(String albumName, String publishDate, String recordCompany) {
        this.albumName = albumName;
        this.publishDate = publishDate;
        this.recordCompany = recordCompany;
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
