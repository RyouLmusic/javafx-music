package service.viewService.serviceImpl;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import service.viewService.LeftViewService;
import util.ObtainSvgUtil;
import util.SVGPathUtil;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 18:37
 */
public class LeftViewServiceImpl implements LeftViewService {
    @Override
    public void initSvg(JFXButton button, String path) {
        String glyph = SVGPathUtil.getSvgGlyph(path);

        button.setGraphic(ObtainSvgUtil.createSVGGlyph(glyph));
    }

    @Override
    public void initSvg(Label svgGlyph, String path) {
        String glyph = SVGPathUtil.getSvgGlyph(path);
        svgGlyph.setGraphic(ObtainSvgUtil.createSVGGlyph(glyph));

    }
}
