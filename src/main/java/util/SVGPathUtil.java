package util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/7 22:35
 */


public class SVGPathUtil {


    public static String getSvgGlyph(String url){
        SAXReader reader = new SAXReader();
//        String url = "D:/music/cancel.svg";
//        String url = "./src/main/resources/cancel.svg";


        Document document = null;
        try {
            document = reader.read(url);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        String glyph = "";
        // iterate through child elements of root
        for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
            Element element = it.next();
            if (element.getName().equals("path"))
                glyph += element.attribute(new QName("d")).getValue();
//                System.out.println(element.attribute(new QName("d")).getValue());
            // do something
        }
        return glyph;
    }

    public static void main(String[] args) {
        System.out.println(getSvgGlyph("./src/main/resources/images/cross.svg"));;
    }
}