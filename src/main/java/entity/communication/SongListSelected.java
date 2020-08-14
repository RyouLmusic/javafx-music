package entity.communication;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/12 20:02
 */
public class SongListSelected {

    /**
     * 选中了某个歌单，通知歌单详情页显示歌单内容，container的center部分显示为songList页面
     */
    private StringProperty songListId = new SimpleStringProperty();

    public SongListSelected(){
        songListId = new SimpleStringProperty();
    }

    public StringProperty songListSelected() {
        return songListId;
    }

    public final String getSongListSelectedId() {
        return songListSelected().get();
    }

    public final void setSongListSelectedId(String songListSelectedId) {
        songListSelected().set(songListSelectedId);
    }
}
