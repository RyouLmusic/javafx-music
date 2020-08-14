package entity.tracks;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 14:50
 */
public class Album {

    /**
     * 凭此id可以打开这张专辑
     */
    private String id;
    /**
     * 专辑的名字
     */
    private String name;
    /**
     * 专辑图片
     */
    private String picUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}
