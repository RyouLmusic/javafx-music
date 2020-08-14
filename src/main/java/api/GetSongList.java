package api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import entity.Song;
import entity.SongList;
import entity.Subscriber;
import entity.tracks.TrackId;
import util.ObtainWallpaperUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 10:57
 */
public class GetSongList {


    public SongList getSongList(String id){

        Gson gson = new Gson();

        final JsonObject jsonObject = ObtainWallpaperUtil.getXpath(StaticAPI.SONG_LIST_DETAIL + id);
        JsonObject playlist = jsonObject.get("playlist").getAsJsonObject();
//        songList = setSongList(jsonObject.get("playlist").getAsJsonObject());
        SongList songList = gson.fromJson(playlist, SongList.class);
        return songList;
    }

    /**
     * 将从StaticAPI.SONG_LIST_DETAIL链接获取的JsonObject装入待真正实例对象中 ,
     * 使用：gson.fromJson(playlist, SongList.class); 实现此功能
     * @param jsonObject
     * @return
     */
    private SongList setSongList(JsonObject jsonObject) {
        Gson gson = new Gson();


        SongList songList = new SongList();

        songList.setName(jsonObject.get("name").getAsString());
        songList.setId(jsonObject.get("id").getAsString());
//        songList.setCreator(jsonObject.get("create").getAsJsonObject());
        songList.setCommentCount(jsonObject.get("commentCount").getAsInt());
        songList.setDescription(jsonObject.get("description").getAsString());
        songList.setSubscribedCount(jsonObject.get("subscribedCount").getAsInt());



        List<Subscriber> subscriberList = new ArrayList<>();
        JsonArray subscribers = jsonObject.get("subscribers").getAsJsonArray();

        for (JsonElement element : subscribers){

            Subscriber subscriber = gson.fromJson(element, Subscriber.class);
            subscriberList.add(subscriber);
        }
        songList.setSubscribers(subscriberList);


        songList.setCoverImgUrl(jsonObject.get("coverImgUrl").getAsString());

        //tags获取下来是个Array，要使用依次装填

        List<String> tags = new ArrayList<>();
        JsonArray jsonElements = jsonObject.get("tags").getAsJsonArray();

        tags = gson.fromJson(jsonElements, tags.getClass());

        songList.setTags(tags);

        songList.setTrackCount(jsonObject.get("trackCount").getAsInt());


        List<TrackId> trackIds = new ArrayList<>();
        trackIds = gson.fromJson(jsonObject.get("trackIds").getAsJsonArray(),trackIds.getClass());
        songList.setTrackIds(trackIds);
//        songList.setTracks(jsonObject.get("tracks").getAsJsonObject());

        return songList;
    }

}
