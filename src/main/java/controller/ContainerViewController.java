package controller;

import cache.PlaylistCache;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import util.ObtainWallpaperUtil;
import view.BaseView;
import view.viewImpl.BottomView;
import view.viewImpl.CenterView;
import view.viewImpl.LeftView;
import view.viewImpl.TopView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/7 8:19
 *
 * 在这里可以做一个自由拉伸的功能
 */
public class ContainerViewController implements Initializable{

    @FXML private BorderPane container;

    BaseView topView;
    BaseView bottomView;
    BaseView leftView;
    BaseView centerView;


    public ContainerViewController(){
        topView = new TopView();
        bottomView = new BottomView();
        leftView = new LeftView();
        centerView = new CenterView();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        Platform.runLater(() -> {
            container.setCenter(centerView.view());
            container.setTop(topView.view());
            container.setBottom(bottomView.view());
            container.setLeft(leftView.view());
        });


        new PlaylistCache().setPlaylistCache();

        //新开启一个线程，这样可以提高开启速度
        new Thread(() ->{
            container.setStyle("-fx-background-image: url(" + ObtainWallpaperUtil.getWallpaperPath() + ")");
        }).start();
    }
}
