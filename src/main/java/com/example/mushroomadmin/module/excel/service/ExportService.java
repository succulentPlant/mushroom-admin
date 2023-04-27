package com.example.mushroomadmin.module.excel.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 导出
 * @author ting.xu
 * @date 2023-04-21 15:16
 */
public interface ExportService {

    /**
     * 导出，
     * Demo
     * @return
     * @throws IOException
     */
    void exportDemo();

    /**
     * 导出+设置单元格格式
     * Demo1，在Demo的基础上通过在导出的实体类上增加注解，设置单元格格式及多表头
     * @return
     * @throws IOException
     */
    void exportDemo1() throws IOException;

    /**
     * 导出+设置单元格格式+动态的单元格合并（行合并）
     * Demo2，在Demo1的基础上通过拦截器自定义合并策略，进行行合并
     * @return
     * @throws IOException
     */
    void exportDemo2() throws IOException;
}
