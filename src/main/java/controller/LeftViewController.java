package controller;

import com.jfoenix.controls.JFXButton;
import entity.communication.DiscoverMusic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import service.viewService.LeftViewService;
import service.viewService.serviceImpl.LeftViewServiceImpl;
import staticUrl.SVGPath;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 16:23
 */
public class LeftViewController implements Initializable, BaseViewController {


    public static DiscoverMusic discoverMusic = new DiscoverMusic();

    @FXML private JFXButton discover;
    @FXML private JFXButton local;
    @FXML private Label discoverSvg;
    @FXML private Label localSvg;

    LeftViewService leftViewService;

    public LeftViewController() {
        leftViewService = new LeftViewServiceImpl();
    }

    /**
     * 通知ContainerViewController将TabPaneView放入center中
     */
    public void discoverMusic(){
        discover.setOnMouseClicked(mouseEvent -> {
            discoverMusic.setGoToTabPane(true);
        });
    }

    @Override
    public void initSvg() {
        leftViewService.initSvg(discoverSvg, SVGPath.MUSIC_PATH);
        leftViewService.initSvg(localSvg, SVGPath.LOCAL_PATH);
    }

    @Override
    public void initAllEvent(Stage stage) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initSvg();
        discoverMusic();
    }
}
