package entity.communication;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/12 20:46
 *
 * 按下本地音乐的按钮，ContainerView的center会变成TabPaneView
 */
public class DiscoverMusic {

    /**
     * 这个为ture的时候就可以返回到TabPaneView
     */
    private BooleanProperty goToTabPane = new SimpleBooleanProperty();

    public DiscoverMusic(){
        this.goToTabPane = new SimpleBooleanProperty();
    }

    public BooleanProperty goToTabPane(){
        return this.goToTabPane;
    }


    public boolean getGoToTabPane(){
        return goToTabPane().get();
    }
    public void setGoToTabPane(boolean goToTabPane){
        goToTabPane().set(goToTabPane);
    }

}
