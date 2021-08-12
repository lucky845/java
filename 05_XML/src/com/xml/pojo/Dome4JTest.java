package com.xml.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author lichuang
 * @description
 * @create 2021-08-12 17:10
 */
public class Dome4JTest {

    @Test
    public void test1() {
        try {
            // 创建一个SAXReader输入流，去读取 xml 配制文件，生成Document对象
            SAXReader saxReader = new SAXReader();

            Document document = saxReader.read("src/books.xml");

            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /***
     * @Author lichuang
     * @Description //TODO 读取books.xml文件生成Book类
     * @Date 2021/8/12 17:15
     * @param
     * @return void
     */
    @Test
    public void test2() throws Exception {
        // 1 读取books.xml文件
        SAXReader Reader = new SAXReader();
        // 在Junit测试中，相对路径从模块名开始算
        Document document = Reader.read("src/books.xml");
        // 2 通过Document对象获取根元素
        Element rootElement = document.getRootElement();
        // 3 通过根元素获取book标签对象
        // element() 和 elements() 都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        // 4 遍历，处理每个book标签转换为Book类
        for (Element book : books) {
            // asXML() 把标签对象转换为标签字符串
            Element nameElement = book.element("name");
            // getText() 可以获取标签中的文本内容
            String nameText = nameElement.getText();
            // elementText() 直接获取标签中的文本内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");
            // attributeValue() 获取属性Value值
            String snValue = book.attributeValue("sn");

            System.out.println(new Book(snValue,nameText,Double.parseDouble(priceText),authorText));
        }
    }

}
