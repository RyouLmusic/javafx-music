package viewFactory.viewFactoryImpl;

import controller.SongListController;
import javafx.scene.Parent;
import staticUrl.ViewPath;
import viewFactory.FactoryUtil;
import viewFactory.ViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 11:32
 */
public class SongListViewFactory implements ViewFactory {
    @Override
    public Parent createView() {
        return FactoryUtil.createView(SongListController.class, ViewPath.SONG_LIST_VIEW);
    }
}
