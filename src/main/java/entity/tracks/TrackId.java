package entity.tracks;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 14:45
 *
 * 歌单详情里面的trackIds
 */
public class TrackId {

    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TrackId{" +
                "id='" + id + '\'' +
                '}';
    }
}
