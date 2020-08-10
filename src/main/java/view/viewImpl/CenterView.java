package view.viewImpl;

import javafx.scene.Parent;
import view.BaseView;
import viewFactory.ViewFactory;
import viewFactory.viewFactoryImpl.CenterViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 20:00
 */
public class CenterView implements BaseView {

    ViewFactory viewFactory;

    public CenterView(){
        viewFactory = new CenterViewFactory();
    }

    @Override
    public Parent view() {
        return viewFactory.createView();
    }
}
