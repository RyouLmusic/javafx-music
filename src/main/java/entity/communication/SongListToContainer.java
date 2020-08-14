package entity.communication;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/12 21:56
 */
public class SongListToContainer {
    /**
     * container的center部分显示为songList页面
     */
    private BooleanProperty toShowSongList = new SimpleBooleanProperty();

    public SongListToContainer(){
        toShowSongList = new SimpleBooleanProperty();
    }

    public BooleanProperty toShowSongList() {
        return toShowSongList;
    }

    public final boolean getSongListToContainer() {
        return toShowSongList().get();
    }

    public final void setSongListToContainer(boolean toShowSongList) {
        toShowSongList().set(toShowSongList);
    }
}
