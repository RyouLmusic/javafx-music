package view.viewImpl;

import javafx.scene.Parent;
import view.BaseView;
import viewFactory.ViewFactory;
import viewFactory.viewFactoryImpl.TopViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/6 22:18
 */
public class TopView implements BaseView {

    ViewFactory viewFactory;

    public TopView(){
        viewFactory = new TopViewFactory();
    }



    @Override
    public Parent view() {
        return viewFactory.createView();
    }
}
