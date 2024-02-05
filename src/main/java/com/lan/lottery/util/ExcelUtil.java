package com.lan.lottery.util;

import com.alibaba.excel.EasyExcel;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class ExcelUtil {
    /**
     * 导出Excel表格
     *
     * @param response
     * @param list
     * @param model
     * @param fileName
     * @param sheetName
     * @throws IOException
     */
    public static void exportExcel(HttpServletResponse response, List<?> list, Class model, String fileName, String sheetName) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        // 写入数据
        response.setHeader("axios-show-headers", "true");//暴露header,为了前端获取文件名
        // 通知浏览器以附件的形式下载处理，设置返回头要注意文件名有中文
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        // 设置发送到客户端的响应的内容类型
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");

        // 设置编码格式
        response.setCharacterEncoding("utf-8");
        EasyExcel.write(outputStream, model).sheet(sheetName).doWrite(list);
    }
}

