package service.viewService;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 11:17
 */
public interface TopViewService {

    void closeStage(Stage stage);
    void initSvg(JFXButton button, String path);
    void initSvg(Label svgGlyph, String path);
}
