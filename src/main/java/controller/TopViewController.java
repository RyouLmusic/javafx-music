package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.ObtainSvgUtil;
import view.viewImpl.StageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/6 22:22
 */
public class TopViewController implements Initializable {

    @FXML private JFXButton close;
    @FXML private JFXButton test;

    String u = "M626.784 512.032l195.072 195.072c12.672 12.672 12.672 33.248 0 45.92l-68.832 68.832c-12.672 12.672-33.216 12.672-45.92 0l-195.104-195.072-195.104 195.072c-12.672 12.672-33.216 12.672-45.888 0l-68.864-68.832c-12.672-12.672-12.672-33.216 0-45.92l195.104-195.072-195.104-195.104c-12.672-12.672-12.672-33.248 0-45.92l68.896-68.832c12.672-12.672 33.216-12.672 45.888 0l195.072 195.104 195.104-195.104c12.672-12.672 33.216-12.672 45.92 0l68.832 68.864c12.672 12.672 12.672 33.216 0 45.92l-195.072 195.072z";
    String getU = "M288 32c-141.391 0-256 114.609-256 256s114.609 256 256 256 256-114.609 256-256-114.609-256-256-256zM288 480c-105.875 0-192-86.125-192-192s86.125-192 192-192 192 86.125 192 192-86.125 192-192 192z";
    String getGetU = "M375.094 201.344l-0.438-0.438c-11.875-11.875-31.125-11.875-43 0l-43.656 43.656-43.656-43.656c-11.875-11.875-31.125-11.875-43 0l-0.438 0.438c-11.875 11.875-11.875 31.125 0 43l43.656 43.656-43.656 43.656c-11.875 11.875-11.875 31.125 0 43l0.438 0.438c11.875 11.875 31.125 11.875 43 0l43.656-43.656 43.656 43.656c11.875 11.875 31.125 11.875 43 0l0.438-0.438c11.875-11.875 11.875-31.125 0-43l-43.656-43.656 43.656-43.656c11.875-11.875 11.875-31.125 0-43z";
    public void close(final Stage stage){
        close.setOnMouseClicked(mouseEvent -> stage.close());
        test.setOnMouseClicked(mouseEvent -> stage.close());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        close(StageView.primaryStage());
        close.setGraphic(ObtainSvgUtil.createSVGGlyph(getU+ getGetU));
//        test.setGraphic(ObtainSvgUtil.createSVGGlyph(getU+getGetU));
    }
}
