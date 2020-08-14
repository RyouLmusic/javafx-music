package view.viewImpl;

import javafx.scene.Parent;
import view.BaseView;
import viewFactory.ViewFactory;
import viewFactory.viewFactoryImpl.SongListViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 11:32
 */
public class SongListView implements BaseView {

    ViewFactory viewFactory;

    public SongListView(){
        viewFactory = new SongListViewFactory();
    }

    @Override
    public Parent view() {
        return viewFactory.createView();
    }
}
