package view.viewImpl;

import javafx.scene.Parent;
import view.BaseView;
import viewFactory.ViewFactory;
import viewFactory.viewFactoryImpl.BottomViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/6 22:56
 */
public class BottomView implements BaseView {

    ViewFactory viewFactory;

    public BottomView(){
        viewFactory = new BottomViewFactory();
    }


    @Override
    public Parent view() {
        return viewFactory.createView();
    }
}
