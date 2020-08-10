package controller;

import api.GetPlaylist;
import com.jfoenix.controls.JFXButton;
import entity.AppModel;
import entity.Playlist;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import service.apiService.PlaylistService;
import view.viewImpl.CenterView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 20:00
 */
public class CenterViewController implements BaseViewController, Initializable {


    // 必须static 类型
    public static AppModel model = new AppModel();


    @FXML private FlowPane centerView;

    PlaylistService playlistService;

    public CenterViewController(){
        playlistService = new PlaylistService();
    }


    /**
     * 首次开启应用的图片加载逻辑
     */
    public void setImage(){

        List<Playlist> playlists = playlistService.setPlaylist();
        if (!centerView.getChildren().isEmpty())
            centerView.getChildren().remove(0, 45);
        addImage2(playlists);
    }

    /**
     * 缩小stage的图片加载逻辑
     */
    public void setImageByCache(){

        List<ImageView> imageViews = playlistService.getImageViews(35, 0);
        if (!centerView.getChildren().isEmpty())
            centerView.getChildren().remove(0, 45);
        addImage(imageViews);
    }

    /**
     * 最大化的图片逻辑
     */
    public void setFullScreenImage(){
        List<ImageView> imageViews = playlistService.getImageViews(45, 0);
        centerView.getChildren().remove(0, 35);
        addImage(imageViews);

//        JFXButton button;
    }

    /**
     * 将歌单图片添加到FlowPane中，第二次请求的时候，ImageView的资源来自cache
     * @param imageView
     */
    public void addImage(List<ImageView> imageView){

        for (ImageView image : imageView)
            centerView.getChildren().add(image);
    }

    /**
     * 首次开启页面的图片资源直接来自网络
     * @param playlists
     */
    public void addImage2(List<Playlist> playlists){

        ImageView imageView;
        for (Playlist playlist : playlists) {

            String path = playlist.getCoverImgUrl();
            Image image = new Image(path);
            imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println(mouseEvent.getX());
                }
            });

            centerView.getChildren().add(imageView);
        }
    }


    @Override
    public void initSvg() {

    }

    @Override
    public void initAllEvent(Stage stage) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /**
         * 监听 最大化，最小化的按钮按下事件
         */
        model.isFullScreenProperty().addListener((obs, oldData, newData) -> {

            if (newData == true){
                Platform.runLater(() -> {
                    //更新JavaFX的主线程的代码放在此处

                    System.out.println(playlistService.getImageViews(45, 0));
                    setFullScreenImage();
                });
            } else {
                Platform.runLater(() -> {
                    //更新JavaFX的主线程的代码放在此处
                    setImageByCache();
                });
            }

        });

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //更新JavaFX的主线程的代码放在此处
                setImage();
                /**
                 * TODO 更新imageViewCache
                 */
                playlistService.setImageViewCache(45, 0);
            }
        });

//        setImage();

        centerView.setPadding(new Insets(20, 15, 20, 15)); //上左下右
        centerView.setHgap(10);
        centerView.setVgap(10);//垂直间距



//        new Thread(() ->  ).start();


/*        JFXButton button = new JFXButton("哟普大小");
        button.setPrefSize(80, 40);
        button.setStyle("-fx-background-image: url(http://p3.music.126.net/SsDWWOP9c9ipsoQ2fL3r4Q==/109951164885691089.jpg)");
        button.setStyle("-fx-background-position: center, 100%");
        centerView.getChildren().add(button);
        centerView.setStyle("-fx-background-image: url(http://p3.music.126.net/SsDWWOP9c9ipsoQ2fL3r4Q==/109951164885691089.jpg)");
   */

    }
}
