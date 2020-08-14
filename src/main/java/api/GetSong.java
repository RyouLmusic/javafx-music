package api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Song;
import util.ObtainWallpaperUtil;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/14 20:59
 */
public class GetSong {

    /**
     * 获取歌曲详情信息， 歌手，专辑
     * @param songId
     * @return
     */
    public Song getSong(String songId){

        JsonObject jsonObject = ObtainWallpaperUtil.getXpath(StaticAPI.SONG_DETAIL_API+songId);

        JsonArray songs = jsonObject.get("songs").getAsJsonArray();

        Gson gson = new Gson();

        Song song = gson.fromJson(songs.get(0).getAsJsonObject(), Song.class);

        return song;
    }


    public static void main(String[] args) {
        GetSong song = new GetSong();
        System.out.println(song.getSong("347230"));
    }
}
