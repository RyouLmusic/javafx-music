package viewFactory.viewFactoryImpl;

import controller.CenterViewController;
import javafx.scene.Parent;
import staticUrl.ViewPath;
import viewFactory.FactoryUtil;
import viewFactory.ViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 20:01
 */
public class CenterViewFactory implements ViewFactory {
    @Override
    public Parent createView() {
        return FactoryUtil.createView(CenterViewController.class, ViewPath.CENTER_VIEW);
    }
}
