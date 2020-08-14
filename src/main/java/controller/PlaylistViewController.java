package controller;

import api.StaticAPI;
import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXButton;
import entity.communication.AppModel;
import entity.Playlist;
import entity.communication.SongListSelected;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.apiService.PlaylistService;
import service.apiService.SongListService;
import util.ObtainWallpaperUtil;
import view.viewImpl.StageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 20:00
 *
 * 热门歌单的页面
 *
 */
public class PlaylistViewController implements BaseViewController, Initializable {



    /**
     * 监听来自playlistController的选中的歌单
     */
    public static SongListSelected songListSelected = new SongListSelected();
    // 必须static 类型
    public static AppModel model = new AppModel();


    @FXML private FlowPane centerView;
    @FXML private JFXButton pre;
    @FXML private JFXButton next;
    private static Integer page = 0;


    PlaylistService playlistService;
    SongListService songListService;
    SongListController songListController;

    public PlaylistViewController(){
        playlistService = new PlaylistService();
        songListService = new SongListService();
        songListController = new SongListController();
    }


    /**
     * 首次开启应用的图片加载逻辑
     */
    public void setImage(){

        List<Playlist> playlists = playlistService.setPlaylist();
        if (!centerView.getChildren().isEmpty())
            centerView.getChildren().remove(0, 75);
        addImage2(playlists);
    }

    /**
     * 缩小stage的图片加载逻辑
     */
    public void setImage(Integer page){

        if(centerView.getChildren().size() % 28 != 0)
            page = (this.page*75) / 28;
        this.page = page;
        List<Playlist> playlists = playlistService.setPlaylist(page);
        if (!centerView.getChildren().isEmpty() && centerView.getChildren().size() > 28)
            centerView.getChildren().remove(0, 75);
        if (centerView.getChildren().size() > 1)
            centerView.getChildren().remove(0, 28);
        addImage2(playlists);
    }

    /**
     * 最大化的图片逻辑
     */
    public void setFullScreenImage(Integer page){
        // 当屏幕变大时的页数有变化
        if(centerView.getChildren().size() % 75 != 0)
            page = (this.page*28) / 75;
        this.page = page;
        List<Playlist> playlists = playlistService.setFullScreenPlaylist(page);

        if (!centerView.getChildren().isEmpty() && centerView.getChildren().size() > 28)
            centerView.getChildren().remove(0, 75);
        if (centerView.getChildren().size() > 1)
            centerView.getChildren().remove(0, 28);
        addImage2(playlists);

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


            Label label = new Label();

            String path = playlist.getCoverImgUrl();
            Image image = new Image(path, true);
            imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            label.setText(playlist.getName());
            label.setMaxWidth(100);
            label.setStyle("-fx-text-alignment: center;" +
                            "-fx-background-color: rgba(253,115,133,0.6)");

            VBox box = new VBox();
            box.getChildren().add(imageView);
            box.getChildren().add(label);

            //让换行生效
            String description = playlist.getDescription().replaceAll("\\\\n", "\n").replace("\"", "");
            String name = playlist.getName();

            //进行tip装载
            decoration(imageView, description, label, name);

            //进入歌单详情
            intoSongList(imageView, playlist.getId());

            centerView.getChildren().add(box);
        }
    }

    public void intoSongList(ImageView imageView, String songListId){
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //设置一个事件监听，让containerController知道
                songListSelected.setSongListSelectedId(songListId);
                SongListController.songListToContainer.setSongListToContainer(true);
            }
        });
    }

    /**
     * tooltip的装载，鼠标进入之后显示提示信息
     * @param imageView
     * @param description
     * @param label
     * @param name
     */
    public void decoration(ImageView imageView, String description, Label label, String name){

        Tooltip tooltip2 = new Tooltip();
        //让换行生效
//        String text = playlist.getDescription().replaceAll("\\\\n", "\n");

        tooltip2.setText(description);
        tooltip2.setTextAlignment(TextAlignment.CENTER);
        tooltip2.setFont(new Font("Arial", 14));
        tooltip2.setOpacity(0.8);
        tooltip2.setMaxWidth(300);
        tooltip2.setWrapText(true);
        tooltip2.setShowDuration(new Duration(Double.MAX_VALUE));// 默认5秒
        Tooltip.install(imageView, tooltip2);// Node都可以使用，如ImageVie


        Tooltip tooltip = new Tooltip();
        tooltip.setText(name);
        tooltip.setFont(new Font("Arial", 12));
        Tooltip.install(label, tooltip);
    }


    @Override
    public void initSvg() {

    }

    @Override
    public void initAllEvent(Stage stage) {

    }

    /**
     * 监听 最大化，最小化的按钮按下事件
     */
    public void maxToMin(){
        model.isFullScreenProperty().addListener((obs, oldData, newData) -> {
            if (newData == true){
                setFullScreenImage(page);
            } else {
                setImage(page);
            }

        });
    }

    /**
     * 上下页控制
     */
    public void preAndNexPage(){
        pre.setOnMouseClicked(mouseEvent -> {


            if (page > 0 && centerView.getChildren().size() < 75)
                setImage(--page);
            else if (page > 0) {
                setFullScreenImage(--page);
            }else {
                // TODO 提醒已经是最小页
            }
        });

        next.setOnMouseClicked(mouseEvent -> {


            if (page < 16 && centerView.getChildren().size() > 28){
                setFullScreenImage(++page);
            }else if (page < 42 && centerView.getChildren().size() < 75){
                setImage(++page);
            }else {
                // TODO 进行alter提醒 已经是最大页
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        maxToMin();
        preAndNexPage();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //更新JavaFX的主线程的代码放在此处
                if (!StageView.primaryStage().isFullScreen())
                    setImage(page);
                else setFullScreenImage(page);

                /**
                 * TODO 更新imageViewCache
                 */
//                playlistService.setImageViewCache(45, 0);
            }
        });

//        setImage();

        centerView.setPadding(new Insets(10, 15, 10, 15)); //上左下右
        centerView.setHgap(10);
        centerView.setVgap(10);//垂直间距



//        new Thread(() ->  ).start();


    }
}
