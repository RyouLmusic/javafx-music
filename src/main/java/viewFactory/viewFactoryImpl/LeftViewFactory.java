package viewFactory.viewFactoryImpl;

import controller.LeftViewController;
import javafx.scene.Parent;
import staticUrl.ViewPath;
import viewFactory.FactoryUtil;
import viewFactory.ViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 16:24
 */
public class LeftViewFactory implements ViewFactory {
    @Override
    public Parent createView() {
        return FactoryUtil.createView(LeftViewController.class, ViewPath.LEFT_VIEW);
    }
}
