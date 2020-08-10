package service.viewService.serviceImpl;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.viewService.TopViewService;
import util.ObtainSvgUtil;
import util.SVGPathUtil;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 11:18
 */
public class TopViewServiceImpl implements TopViewService {
    @Override
    public void closeStage(Stage stage) {
        stage.close();
    }

    @Override
    public void initSvg(JFXButton button, String path) {

        button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(10), new Insets(3))));
        String glyph = SVGPathUtil.getSvgGlyph(path);

        button.setGraphic(ObtainSvgUtil.createSVGGlyph(glyph));
    }

    @Override
    public void initSvg(Label svgGlyph, String path) {
        String glyph = SVGPathUtil.getSvgGlyph(path);
        svgGlyph.setGraphic(ObtainSvgUtil.createSVGGlyph(glyph));

    }



}
