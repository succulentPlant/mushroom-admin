package com.example.mushroomadmin.module.excel.controller;

import com.example.mushroomadmin.module.excel.service.ExportService;
import com.example.mushroomadmin.module.login.common.response.Result;
import com.example.mushroomadmin.module.login.common.response.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * excel导出
 * @author ting.xu
 * @date 2023-04-21 14:59
 */
@RestController
@RequestMapping(value = "/export")
public class ExportController {

    ExportService exportService;

    public ExportController(ExportService exportService) {
        this.exportService = exportService;
    }

    /**
     * 导出
     * Demo，最简单的导出
     * @return
     * @throws IOException
     */
    @PostMapping("/demo")
    public Result exportDemo() throws IOException {
        exportService.exportDemo();
        return ResultUtils.success();
    }

    /**
     * 导出+设置单元格格式
     * Demo1，在Demo的基础上通过在导出的实体类上增加注解，设置单元格格式及多表头
     * @return
     * @throws IOException
     */
    @PostMapping("/demo1")
    public Result exportDemo1() throws IOException {
        exportService.exportDemo1();
        return ResultUtils.success();
    }

    /**
     * 导出+设置单元格格式+动态的单元格合并（行合并）
     * Demo2，在Demo1的基础上通过拦截器自定义合并策略，进行行合并
     * @return
     * @throws IOException
     */
    @PostMapping("/demo2")
    public Result exportDemo2() throws IOException {
        exportService.exportDemo2();
        return ResultUtils.success();
    }


}
