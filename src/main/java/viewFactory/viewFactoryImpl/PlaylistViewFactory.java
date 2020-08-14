package viewFactory.viewFactoryImpl;

import controller.PlaylistViewController;
import javafx.scene.Parent;
import staticUrl.ViewPath;
import viewFactory.FactoryUtil;
import viewFactory.ViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 20:01
 */
public class PlaylistViewFactory implements ViewFactory {
    @Override
    public Parent createView() {
        return FactoryUtil.createView(PlaylistViewController.class, ViewPath.PLAYLIST_VIEW);
    }
}
