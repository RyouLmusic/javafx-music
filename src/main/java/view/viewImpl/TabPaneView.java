package view.viewImpl;

import javafx.scene.Parent;
import view.BaseView;
import viewFactory.ViewFactory;
import viewFactory.viewFactoryImpl.TabPaneViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 20:59
 */
public class TabPaneView implements BaseView {

    ViewFactory viewFactory;

    public TabPaneView(){
        viewFactory = new TabPaneViewFactory();
    }

    @Override
    public Parent view() {
        return viewFactory.createView();
    }
}
