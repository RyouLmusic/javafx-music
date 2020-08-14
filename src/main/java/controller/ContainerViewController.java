package controller;

import cache.PlaylistCache;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import util.ObtainWallpaperUtil;
import view.BaseView;
import view.viewImpl.*;

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
    BaseView tabPaneView;

    BaseView songListView;

    SongListController songListController;
    LeftViewController leftViewController;


    AnchorPane tabPane;
    AnchorPane songList;

    public ContainerViewController(){
        topView = new TopView();
        bottomView = new BottomView();
        leftView = new LeftView();
        tabPaneView = new TabPaneView();
//        tabPane = (AnchorPane) tabPaneView.view();
        songListView = new SongListView();
//        songList = (AnchorPane) songListView.view();
        songListController = new SongListController();
        leftViewController = new LeftViewController();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        LeftViewController.discoverMusic.goToTabPane().addListener((obs, oldData, newData) -> {
            if (newData == true){
                container.setCenter(tabPaneView.view());
                LeftViewController.discoverMusic.setGoToTabPane(false);
            }
        });

        SongListController.songListToContainer.toShowSongList().addListener((observableValue, oldV, newV) -> {
            if (newV == true){
//                System.out.println("******3333333*******");
                container.setCenter(songListView.view());
                SongListController.songListToContainer.setSongListToContainer(false);
            }
        });

        /*PlaylistViewController.songListSelected.songListSelected().addListener((obs, oldData, newData) -> {

            container.setCenter(songListView.view());

        });*/



        Platform.runLater(() -> {
            container.setCenter(tabPaneView.view());
//            container.setCenter(centerView.view());
            songListView.view();
            container.setTop(topView.view());
            container.setBottom(bottomView.view());
            container.setLeft(leftView.view());
        });

// 多线程的cache的顺序不好控制
//        new PlaylistCache().setPlaylistCache();

        //新开启一个线程，这样可以提高开启速度
        new Thread(() ->{
            /*ImageView imageView = new ImageView(new Image(ObtainWallpaperUtil.getWallpaperPath()));
            imageView.setEffect(new GaussianBlur(20));
            imageView.setSmooth(true);*/

            container.setStyle("-fx-background-image: url(" + ObtainWallpaperUtil.getWallpaperPath() + ");");

        }).start();
    }
}
