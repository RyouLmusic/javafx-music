package util;

import com.jfoenix.svg.SVGGlyph;
import javafx.scene.paint.Color;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/7 12:14
 */
public class ObtainSvgUtil {


    public static SVGGlyph createSVGGlyph(String glyph){
        return createSVGGlyph(glyph, 24, 24, Color.WHITE);
    }

    public static SVGGlyph createSVGGlyph(String glyph, int width, int height, Color color){
        SVGGlyph svgGlyph = new SVGGlyph(0, "", glyph, color);
//    svgGlyph.setFill(Color.WHITE);
        svgGlyph.setSize(width,height);

        return svgGlyph;
    }
}
