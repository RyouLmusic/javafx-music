package controller;

import com.jfoenix.controls.JFXTabPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.BaseView;
import view.viewImpl.PlaylistView;
import view.viewImpl.SongListView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 20:56
 */
public class TabPaneViewController implements BaseViewController, Initializable {


    @FXML private AnchorPane tabPaneView;

    @FXML private JFXTabPane tabPane;


    BaseView songListView;
    BaseView centerView;

    public TabPaneViewController(){
        centerView = new PlaylistView();
        songListView = new SongListView();
    }





    @Override
    public void initSvg() {

    }

    @Override
    public void initAllEvent(Stage stage) {

    }


    public void initTab(){


//        JFXTabPane tabPane = new JFXTabPane();

      /*  Tab tab = new Tab();
        tab.setText("歌单详情");
        tab.setContent(songListView.view());
        tabPane.getTabs().add(tab);*/





        Tab hotPlaylist = new Tab();
        hotPlaylist.setText("热门歌单");

        /*HBox pane = new HBox();
        pane.getChildren().add(new Label("**************---------------*************"));*/
        hotPlaylist.setContent(centerView.view());
        tabPane.getTabs().add(hotPlaylist);
        tabPane.setStyle("-fx-tile-alignment: center;" + "-fx-text-alignment: center");

        tabPane.setTabMinHeight(40);

//        System.out.println(tabPane.tabMinHeightProperty());
//        tabPane.setSide(Side.BOTTOM);


//        tabPaneView.getChildren().add(tabPane);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTab();
    }
}
