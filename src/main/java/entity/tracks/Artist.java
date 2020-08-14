package entity.tracks;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 14:47
 */
public class Artist {


    /**
     * 歌手的注册的id
     * 如果没有的话为0
     */
    private String id;
    /**
     * 歌手的名字
     */
    private String name;

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

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
