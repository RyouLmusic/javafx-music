package entity;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/9 22:13
 */
public class AppModel {


    private BooleanProperty isFullScreen = new SimpleBooleanProperty();

    public AppModel()
    {
        this.isFullScreen = new SimpleBooleanProperty();
    }

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
