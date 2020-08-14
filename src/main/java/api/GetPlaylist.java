package api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import entity.Playlist;
import service.apiService.PlaylistService;
import util.ObtainWallpaperUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 21:04
 */
public class GetPlaylist {

//    String playlist = "https://api.itooi.cn/netease/songList";

    /**
     * 精品歌单
     */
//    String list = "https://api.itooi.cn/netease/songList/highQuality";

    /*93442475
    https://api.itooi.cn/netease/url?id=93442475&quality=flac*/


    /**
     * 将音乐热门歌单的内容返回
     * @param limit
     * @param offset
     * @return
     */
    public List<Playlist> getPlaylist(int limit , int offset){

        List<Playlist> playlists = new ArrayList<>();

//        String list = "https://api.itooi.cn/netease/songList/hot?pageSize="+ pageSize + "&page=" + page;
        System.out.println("offset"+ limit*offset + " limit: " + limit + " offset: " + offset);
        String list = StaticAPI.GET_PLAYLIST_API(limit, limit*offset);
        JsonObject res = ObtainWallpaperUtil.getXpath(list);
//        System.out.println(res.get("data").getAsJsonArray().get(0).getAsJsonObject().get("description"));
        JsonArray data = res.get("playlists").getAsJsonArray();

        Playlist playlist;
        for (JsonElement element: data) {
            playlist = new Playlist();
            setPlaylist(playlist, element.getAsJsonObject());

            playlists.add(playlist);
        }

        return playlists;
    }

    /**
     * 每次返回45个数据（实例对象）
     * @param page
     * @return
     */
    public List<Playlist> getPlaylist(Integer page){

        return getPlaylist(28, page);
    }

    /**
     * 将每个获取的Json转换为实体对象
     * @param playlist
     * @param object
     */
    public void setPlaylist(Playlist playlist, JsonObject object){

/*
        private boolean highQuality;//不清楚作用

*/
        playlist.setDescription(String.valueOf(object.get("description")));
        playlist.setId(String.valueOf(object.get("id")));
        playlist.setTrackCount(object.get("trackCount").getAsInt());
//        playlist.setCreator((User) object.get("creator").getAsJsonObject()); 要分开来,一个一个装填

        //一个一个的装填tags的内容
        List<String> tags = new ArrayList<>();
        JsonArray jsonElements = object.get("tags").getAsJsonArray();
        for (JsonElement elements: jsonElements) {
            tags.add(elements.getAsString());
        }
        playlist.setTags(tags);

        playlist.setCommentCount(object.get("commentCount").getAsInt());

        playlist.setCoverImgUrl(object.get("coverImgUrl").getAsString());
        playlist.setName(object.get("name").getAsString());

    }


    /**
     * 获取相关歌单，传入自己的歌单的id
     * @param songListId
     * @return
     */
    public List<Playlist> getRelatedPlaylist(String songListId){

        List<Playlist> playlists = new ArrayList<>();

        JsonObject res = ObtainWallpaperUtil.getXpath(StaticAPI.SONG_LIST_RELATED + songListId);

        JsonArray asJsonArray = res.get("playlists").getAsJsonArray();
        Gson gson = new Gson();

        //将每个实例放入
        for (JsonElement element : asJsonArray){
            Playlist playlist = gson.fromJson(element, Playlist.class);

            playlists.add(playlist);
        }

        return playlists;

    }


    public static void main(String[] args) {
        GetPlaylist GetPlaylist = new GetPlaylist();

        List<Playlist> playlists = GetPlaylist.getPlaylist(10, 0);

        for (Playlist playlist: playlists) {
            System.out.println(playlist);
        }
    }

}
