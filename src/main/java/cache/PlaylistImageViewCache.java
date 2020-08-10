package cache;

import entity.Playlist;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/10 16:01
 *
 * 提前加载图片：只先加载下一页和放大的ImageView数目
 */
public class PlaylistImageViewCache {


    public final static LinkedList<ImageView> imageViews = new LinkedList<>();


    public void setImageViews(List<Playlist> playlists){


        ImageView imageView;

        for (Playlist playlist : playlists) {

            Image image = new Image(playlist.getCoverImgUrl());
            imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println(mouseEvent.getX());
                }
            });

            imageViews.add(imageView);
        }
    }

    public List<ImageView> getImageView(Integer pageSize, Integer page){

        List<ImageView> imageView = new ArrayList<>();

        for (int i = 0; i < pageSize; i++){
            imageView.add(imageViews.get(pageSize*page + i));
        }

        return imageView;
    }

}
