package entity;

import entity.tracks.TrackId;

import java.util.List;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 8:54
 */
public class SongList {

    /**
     * 收藏此歌单的用户，请求的数量有StaticAPI.SONG_LIST_DETAIL的链接决定
     */
    private List<Subscriber> subscribers;
    /**
     * 创建此歌单的用户
     */
    private User creator;
    /**
     * 音乐,每首歌的信息都在里面
     */
    private List<Song> tracks;
    /**
     * 只有歌曲的信息的id
     */
    private List<TrackId> trackIds;

    /**
     * 收藏人数
     */
    private Integer subscribedCount;
    /**
     * 歌单图片
     */
    private String coverImgUrl;
    /**
     * 歌单的歌曲数目
     */
    private Integer trackCount;
    /**
     * 歌单描述
     */
    private String description;
    /**
     * 歌单标签
     */
    private List<String> tags;
    /**
     * 歌单名字
     */
    private String name;
    /**
     * 歌单Id
     */
    private String id;
    /**
     * 分享数量
     */
    private Integer commentCount;


    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Song> getTracks() {
        return tracks;
    }

    public void setTracks(List<Song> tracks) {
        this.tracks = tracks;
    }

    public List<TrackId> getTrackIds() {
        return trackIds;
    }

    public void setTrackIds(List<TrackId> trackIds) {
        this.trackIds = trackIds;
    }

    public Integer getSubscribedCount() {
        return subscribedCount;
    }

    public void setSubscribedCount(Integer subscribedCount) {
        this.subscribedCount = subscribedCount;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

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

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "SongList{" +
                "subscribers=" + subscribers +
                ", creator=" + creator +
                ", tracks=" + tracks +
                ", trackIds=" + trackIds +
                ", subscribedCount=" + subscribedCount +
                ", coverImgUrl='" + coverImgUrl + '\'' +
                ", trackCount=" + trackCount +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", commentCount=" + commentCount +
                '}';
    }
}
