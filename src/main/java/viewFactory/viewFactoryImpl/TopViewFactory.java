package viewFactory.viewFactoryImpl;

import controller.TopViewController;
import javafx.scene.Parent;
import viewFactory.FactoryUtil;
import viewFactory.ViewFactory;
import staticUrl.ViewPath;


/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/6 22:23
 */
public class TopViewFactory implements ViewFactory {


    @Override
    public Parent createView() {
        Parent pane;

        pane = FactoryUtil.createView(TopViewController.class, ViewPath.TOP_VIEW);

        return pane;
    }

}
