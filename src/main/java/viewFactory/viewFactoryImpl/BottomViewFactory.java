package viewFactory.viewFactoryImpl;

import controller.BottomViewController;
import javafx.scene.Parent;
import viewFactory.FactoryUtil;
import viewFactory.ViewFactory;
import staticUrl.ViewPath;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/6 22:56
 */
public class BottomViewFactory implements ViewFactory {
    @Override
    public Parent createView() {
        Parent pane;

        pane = FactoryUtil.createView(BottomViewController.class, ViewPath.BOTTOM_VIEW);

        return pane;
    }
}
