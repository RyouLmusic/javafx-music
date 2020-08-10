package service.viewService;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.svg.SVGGlyph;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 18:36
 */
public interface LeftViewService {
    void initSvg(JFXButton button, String path);
    void initSvg(Label svgGlyph, String path);

}
