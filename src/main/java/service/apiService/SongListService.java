package service.apiService;

import api.GetPlaylist;
import api.GetSong;
import api.GetSongList;
import entity.Playlist;
import entity.Song;
import entity.SongList;

import java.util.List;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 11:22
 */
public class SongListService {

    GetSongList getSongList;
    GetPlaylist getPlaylist;
    GetSong getSong;

    public SongListService(){
        getSongList = new GetSongList();
        getPlaylist = new GetPlaylist();
        getSong = new GetSong();
    }

    public SongList getSongList(String id) {

        return getSongList.getSongList(id);
    }

    public List<Playlist> getRelatedPlaylist(String songListId){
        return getPlaylist.getRelatedPlaylist(songListId);
    }

    public Song getSong(String songId){
        return getSong.getSong(songId);
    }
}
