package view.viewImpl;

import javafx.scene.Parent;
import view.BaseView;
import viewFactory.ViewFactory;
import viewFactory.viewFactoryImpl.LeftViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 16:24
 */
public class LeftView implements BaseView {

    ViewFactory viewFactory;

    public LeftView() {
        viewFactory = new LeftViewFactory();
    }

    @Override
    public Parent view() {
        return viewFactory.createView();
    }
}
