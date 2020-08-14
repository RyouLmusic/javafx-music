package controller;

import api.StaticAPI;
import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXTabPane;
import entity.Playlist;
import entity.Song;
import entity.SongList;
import entity.Subscriber;
import entity.communication.SongListSelected;
import entity.communication.SongListToContainer;
import entity.tracks.Album;
import entity.tracks.Artist;
import entity.tracks.TrackId;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import service.apiService.SongListService;
import util.ObtainWallpaperUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 11:31
 */
public class SongListController implements Initializable {

    /**
     * 让Container显示SongListView，true的时候显示
     */
    public static SongListToContainer songListToContainer = new SongListToContainer();

    @FXML private AnchorPane songListView;
    @FXML private TableView<Song> tableView;
    @FXML private ImageView coverImage;
    @FXML private GridPane subscribers; //收藏者
    @FXML private GridPane related; //相关歌单

    @FXML private TableColumn<Song, String> name; //歌曲名
    @FXML private TableColumn<Song, List<Artist>> artist; //歌手
    @FXML private TableColumn<Song, Album> album; //专辑


    public static ObservableList<Song> songModels = FXCollections.observableArrayList();

    SongListService songListService;

    public SongListController(){
        songListService = new SongListService();
    }

    public static String data = "-1";


    /**
     * 将PlaylistController选中的歌单获取到
     */
    public SongList getSongListContent(String songListId){

        return songListService.getSongList(songListId);

    }

    public void init(String id){
        SongList songList = getSongListContent(id);

        System.out.println(songList);

        //歌单图片
        initCoverImage(songList.getCoverImgUrl());

        //收藏此歌单的用户
        List<Subscriber> subscriberList = songList.getSubscribers();
        initSubImage(subscriberList);

        //相关歌单推荐
        List<Playlist> playlists = songListService.getRelatedPlaylist(id);

        initRelatedImage(playlists);


        new Thread(() -> {
            //获取歌曲
            List<TrackId> trackIds = songList.getTrackIds();
            List<Song> songs = getAllSong(trackIds);
            //对获取到的歌曲进行装填
            //装填歌曲
            //setSongInfo(songs);

        }).start();


//        System.out.println(songs.stream().toArray());

//

    }

    public void setCellValueFactory(){
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        artist.setCellValueFactory(new PropertyValueFactory<>("ar"));
        album.setCellValueFactory(new PropertyValueFactory<>("al"));
    }
    /**
     * 装填歌曲信息
     * @param songs
     */
    private void setSongInfo(List<Song> songs) {
        songModels.add(songs.get(0));
    }

    /**
     * 获取所有歌曲
     * @param trackIds
     */
    private List<Song> getAllSong(List<TrackId> trackIds) {
        List<Song> songs = new ArrayList<>();
        for (TrackId trackId : trackIds){
            songs.add(songListService.getSong(trackId.getId()));
        }
        return songs;
    }

    /**
     * 歌单图片
     * @param path
     */
    public void initCoverImage(String path){
        //歌单图片
        Image image = new Image(path, true);

        coverImage.setImage(image);


        //设置圆角
        Rectangle rectangle = new Rectangle(200, 200);
        rectangle.setArcHeight(10);
        rectangle.setArcWidth(10);
        coverImage.setClip(rectangle);
    }

    /**
     * 收藏者
     * @param subscriberList
     */
    public void initSubImage(List<Subscriber> subscriberList){
        subscribers.setHgap(0);
        subscribers.setVgap(0);
        int k = 0;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){

                Image image = new Image(subscriberList.get(k).getAvatarUrl(), true);
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);

                Tooltip tooltip = new Tooltip();
                tooltip.setText(subscriberList.get(k).getNickname());
                tooltip.setFont(new Font("Arial", 14));

                Tooltip.install(imageView, tooltip);
                subscribers.add(imageView, i , j);
                k++;
            }
        }

        //设置圆角
        Rectangle rectangle = new Rectangle(200, 200);
        rectangle.setArcHeight(10);
        rectangle.setArcWidth(10);
        subscribers.setClip(rectangle);
    }

    /**
     * 相关歌单的推荐
     * @param playlists
     */
    public void initRelatedImage(List<Playlist> playlists){
        int k = 0;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){

                Image image = new Image(playlists.get(k).getCoverImgUrl(), true);
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);

                intoSongList(imageView, playlists.get(k).getId());

                Tooltip tooltip = new Tooltip();
                tooltip.setText(playlists.get(k).getName());
                tooltip.setFont(new Font("Arial", 14));

                Tooltip.install(imageView, tooltip);
                related.add(imageView, i , j);
                k++;
            }
        }

        //设置圆角
        Rectangle rectangle = new Rectangle(200, 200);
        rectangle.setArcHeight(10);
        rectangle.setArcWidth(10);
        related.setClip(rectangle);
    }

    /**
     * 点击相关歌单的事件，进入该歌单的详情
     * @param imageView
     * @param songListId
     */
    public void intoSongList(ImageView imageView, String songListId){
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //设置一个事件监听，让containerController知道
                PlaylistViewController.songListSelected.setSongListSelectedId(songListId);
                SongListController.songListToContainer.setSongListToContainer(true);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        setCellValueFactory();
        PlaylistViewController.songListSelected.songListSelected().addListener((obs, oldData, newData) -> {

            if (newData != data) {
                data = newData;
                System.out.println("SongListController: " + newData);
                getSongListContent(newData);

            }
        });

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (data != "-1")
                    init(data);
            }
        });
        System.out.println("initSongList************");


//

    }
}
