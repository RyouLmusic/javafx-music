package viewFactory.viewFactoryImpl;

import controller.ContainerViewController;
import javafx.scene.Parent;
import viewFactory.FactoryUtil;
import viewFactory.ViewFactory;
import staticUrl.ViewPath;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/7 8:19
 */
public class ContainerViewFactory implements ViewFactory {
    @Override
    public Parent createView() {
        return FactoryUtil.createView(ContainerViewController.class, ViewPath.CONTAINER_VIEW);
    }
}
