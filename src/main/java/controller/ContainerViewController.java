package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import util.ObtainWallpaperUtil;
import view.BaseView;
import view.viewImpl.BottomView;
import view.viewImpl.TopView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/7 8:19
 */
public class ContainerViewController implements Initializable{

    @FXML private BorderPane container;

    BaseView view;
    BaseView bottomView;


    public ContainerViewController(){
        view = new TopView();
        bottomView = new BottomView();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        container.setTop(view.view());
        container.setBottom(bottomView.view());
        container.setStyle("-fx-background-image: url(" + ObtainWallpaperUtil.getWallpaperPath() + ")");
    }
}
