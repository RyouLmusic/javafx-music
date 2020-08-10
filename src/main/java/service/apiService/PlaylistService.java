package service.apiService;

import api.GetPlaylist;
import cache.PlaylistCache;
import cache.PlaylistImageViewCache;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import entity.Playlist;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import util.ObtainWallpaperUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/9 9:54
 */
public class PlaylistService {


    PlaylistCache playlistCache;
    GetPlaylist getPlaylist;
    PlaylistImageViewCache playlistImageViewCache;

    public PlaylistService(){
        getPlaylist = new GetPlaylist();
        playlistCache = new PlaylistCache();
        playlistImageViewCache = new PlaylistImageViewCache();
    }



    public List<Playlist> setFullScreenPlaylist(){
        return playlistCache.getPlaylist(45, 0);
    }

    public List<Playlist> setPlaylist(){
        return getPlaylist.getPlaylist(35, 0);
    }
    public List<Playlist> setPlaylistByCache(){
        return playlistCache.getPlaylist(35, 0);
    }

    public List<ImageView> getImageViews(Integer pageSize, Integer page){
        return playlistImageViewCache.getImageView(pageSize, page);
    }

    public void setImageViewCache(Integer pageSize, Integer page){
        new Thread(() -> playlistImageViewCache.setImageViews(playlistCache.getPlaylist(pageSize, page))).start();
    }


}
