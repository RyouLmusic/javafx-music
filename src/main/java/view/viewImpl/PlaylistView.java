package view.viewImpl;

import javafx.scene.Parent;
import view.BaseView;
import viewFactory.ViewFactory;
import viewFactory.viewFactoryImpl.PlaylistViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 20:00
 */
public class PlaylistView implements BaseView {

    ViewFactory viewFactory;

    public PlaylistView(){
        viewFactory = new PlaylistViewFactory();
    }

    @Override
    public Parent view() {
        return viewFactory.createView();
    }
}
