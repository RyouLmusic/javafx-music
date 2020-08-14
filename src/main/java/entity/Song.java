package entity;

import entity.tracks.Album;
import entity.tracks.Artist;

import java.util.List;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 10:46
 */
public class Song {
    /**
     * 歌曲的名字
     */
    private String name;
    /**
     * 歌曲的id，凭此id可以获取歌曲的资源
     */
    private String id;
    /**
     * 歌手信息
     */
    private List<Artist> ar;
    /**
     * 专辑信息
     */
    private Album al;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Artist> getAr() {
        return ar;
    }

    public void setAr(List<Artist> ar) {
        this.ar = ar;
    }

    public Album getAl() {
        return al;
    }

    public void setAl(Album al) {
        this.al = al;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", ar=" + ar +
                ", al=" + al +
                '}';
    }
}
