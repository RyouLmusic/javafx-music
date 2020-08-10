package entity;

import java.util.List;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/9 9:17
 */
public class Playlist {

    private String description;
    private String id; //跟在api后边可以获取整个歌单内容   156659312  https://api.itooi.cn/netease/songList?id=2932915124

    private Integer trackCount;//歌单里面的歌曲数目
    private User creator; //创建者

    private boolean highQuality;//不清楚作用

    private List<String> tags;//华语，流行等等标签

    private Integer commentCount; //评论是数量

    private String coverImgUrl;//歌单图片

    private String name;//歌单名字


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public boolean isHighQuality() {
        return highQuality;
    }

    public void setHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", trackCount=" + trackCount +
                ", creator=" + creator +
                ", highQuality=" + highQuality +
                ", tags=" + tags +
                ", commentCount=" + commentCount +
                ", coverImgUrl='" + coverImgUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
