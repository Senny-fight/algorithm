package com.example.lcall.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class PdfGenerator {

    public static void main(String[] args) {
        // 创建一个 Document 对象
        Document document = new Document();

        try {
            // 创建 PdfWriter 实例，将内容写入指定的文件
            PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));

            // 打开文档开始写入内容
            document.open();

            // 获取字体文件路径
            URL fontUrl = PdfGenerator.class.getClassLoader().getResource("fonts/simsun.ttc");
            if (fontUrl == null) {
                throw new IllegalArgumentException("Font file not found!");
            }

            // 使用字体文件的路径创建 BaseFont 对象
            String fontPath = fontUrl.getPath();
            BaseFont bfChinese = BaseFont.createFont(fontPath + ",1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            // 创建 Font 对象，指定 BaseFont 和字体大小
            com.itextpdf.text.Font fontChinese = new com.itextpdf.text.Font(bfChinese, 12);

            // 添加段落内容，使用中文字体
            document.add(new Paragraph("你好，世界！这是一个包含中文的 PDF 文档示例。", fontChinese));

            System.out.println("PDF created successfully.");

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭文档
            document.close();
        }
    }
}