package viewFactory.viewFactoryImpl;

import controller.TabPaneViewController;
import javafx.scene.Parent;
import staticUrl.ViewPath;
import view.BaseView;
import viewFactory.FactoryUtil;
import viewFactory.ViewFactory;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/11 20:57
 */
public class TabPaneViewFactory implements ViewFactory {
    @Override
    public Parent createView() {
        return FactoryUtil.createView(TabPaneViewController.class, ViewPath.TAB_PANE_VIEW);
    }
}
