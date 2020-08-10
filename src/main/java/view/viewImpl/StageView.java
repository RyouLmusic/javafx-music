package view.viewImpl;

import controller.ContainerViewController;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.BaseView;

import static javafx.stage.StageStyle.*;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/6 22:35
 */
public class StageView extends Application {

    public final static Stage primaryStage = new Stage();

    public static Stage primaryStage(){
        return primaryStage;
    }




    BaseView view;
    BaseView bottomView;
    BaseView container;

    public StageView(){
        view = new TopView();
        bottomView = new BottomView();
        container = new ContainerView();
    }


    @Override
    public void start(Stage stage) throws Exception {

        stage = primaryStage;
        BorderPane borderPane = (BorderPane) container.view();
        stage.initStyle(TRANSPARENT);
//        AnchorPane pane = (AnchorPane) view.view();
//        AnchorPane anchorPane = (AnchorPane) bottomView.view();
////        pane.getChildren().add(anchorPane);
//
//        borderPane.setBottom(pane);
//        borderPane.setTop(anchorPane);

        Scene scene = new Scene(borderPane);

        stage.setScene(scene);

        stage.show();

    }
}
