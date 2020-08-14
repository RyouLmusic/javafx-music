package entity;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/14 19:41
 */
public class Subscriber {

    /**
     * 用户Id
     */
    private String userId;
    /**
     * 用户的头像
     */
    private String avatarUrl;
    /**
     * 用户名字
     */
    private String nickname;
    /**
     * 个人介绍
     */
    private String signature;
    /**
     * 背景图片
     */
    private String backgroundUrl;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "userId='" + userId + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", nickname='" + nickname + '\'' +
                ", signature='" + signature + '\'' +
                ", backgroundUrl='" + backgroundUrl + '\'' +
                '}';
    }
}
