package com.example.mushroomadmin.module.excel.service.entity.dto;

import com.example.mushroomadmin.module.excel.service.entity.dto.AlbumDto;

import java.io.Serializable;
import java.util.List;

/**
 * 歌手的基本信息
 * @author ting.xu
 * @date 2023-04-21 15:26
 */
public class SingerDto implements Serializable {
    /**
     * 歌手名称
     */
    private String singerName;
    /**
     * 专辑数量
     */
    private Integer albumCount;
    /**
     * 专辑信息
     */
    private List<AlbumDto> albumDtos;

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

    public List<AlbumDto> getAlbumDtos() {
        return albumDtos;
    }

    public void setAlbumDtos(List<AlbumDto> albumDtos) {
        this.albumDtos = albumDtos;
    }
}
