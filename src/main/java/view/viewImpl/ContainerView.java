package view.viewImpl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import view.BaseView;
import viewFactory.ViewFactory;
import viewFactory.viewFactoryImpl.ContainerViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/7 8:18
 */
public class ContainerView implements BaseView {


    ViewFactory viewFactory;

    public ContainerView() {
        viewFactory = new ContainerViewFactory();
    }

    @Override
    public Parent view() {
        return viewFactory.createView();
    }


}
