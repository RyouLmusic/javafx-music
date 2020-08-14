package entity.communication;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/9 22:13
 *
 * 屏幕大小变换的通信
 */
public class AppModel {


    /**
     * 屏幕是否为最大
     */
    private BooleanProperty isFullScreen = new SimpleBooleanProperty();


    public AppModel()
    {
        this.isFullScreen = new SimpleBooleanProperty();
    }

    /**
     * 屏幕是否为最大的一些方法
     * @return
     */
    public BooleanProperty isFullScreenProperty() {
        return isFullScreen;
    }

    public final boolean getIsFullScreenProperty() {
        return isFullScreenProperty().get();
    }

    public final void setIsFullScreen(boolean isFullScreen) {
        isFullScreenProperty().set(isFullScreen);
    }


}
