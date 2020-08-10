package controller;

import com.jfoenix.controls.JFXButton;
import entity.Playlist;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import service.viewService.TopViewService;
import service.viewService.serviceImpl.DragWindowHandler;
import service.viewService.serviceImpl.TopViewServiceImpl;
import staticUrl.SVGPath;
import view.viewImpl.StageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/6 22:22
 */
public class TopViewController implements Initializable, BaseViewController {

    @FXML private JFXButton close;
    @FXML private Label ApplicationIcon;
    @FXML private JFXButton Max_Minimization;
    @FXML private JFXButton minus;
    @FXML private AnchorPane topView;

    TopViewService topViewService;

    public TopViewController(){
        topViewService = new TopViewServiceImpl();
    }




  /*
    String u = "M626.784 512.032l195.072 195.072c12.672 12.672 12.672 33.248 0 45.92l-68.832 68.832c-12.672 12.672-33.216 12.672-45.92 0l-195.104-195.072-195.104 195.072c-12.672 12.672-33.216 12.672-45.888 0l-68.864-68.832c-12.672-12.672-12.672-33.216 0-45.92l195.104-195.072-195.104-195.104c-12.672-12.672-12.672-33.248 0-45.92l68.896-68.832c12.672-12.672 33.216-12.672 45.888 0l195.072 195.104 195.104-195.104c12.672-12.672 33.216-12.672 45.92 0l68.832 68.864c12.672 12.672 12.672 33.216 0 45.92l-195.072 195.072z";
    String getU = "M288 32c-141.391 0-256 114.609-256 256s114.609 256 256 256 256-114.609 256-256-114.609-256-256-256zM288 480c-105.875 0-192-86.125-192-192s86.125-192 192-192 192 86.125 192 192-86.125 192-192 192z";
    String getGetU = "M375.094 201.344l-0.438-0.438c-11.875-11.875-31.125-11.875-43 0l-43.656 43.656-43.656-43.656c-11.875-11.875-31.125-11.875-43 0l-0.438 0.438c-11.875 11.875-11.875 31.125 0 43l43.656 43.656-43.656 43.656c-11.875 11.875-11.875 31.125 0 43l0.438 0.438c11.875 11.875 31.125 11.875 43 0l43.656-43.656 43.656 43.656c11.875 11.875 31.125 11.875 43 0l0.438-0.438c11.875-11.875 11.875-31.125 0-43l-43.656-43.656 43.656-43.656c11.875-11.875 11.875-31.125 0-43z";
    */

    /**
     * 退出程序
     * @param stage
     */
    public void close(final Stage stage){
        close.setOnMouseClicked(mouseEvent -> topViewService.closeStage(stage));
    }

    /**
     * 全屏和恢复
     * @param stage
     */
    public void maximization(final Stage stage){

        var lambdaContext = new Object() {
            boolean flag = true;
        };
        Max_Minimization.setOnMouseClicked(mouseEvent -> {

//            stage.setFullScreen(true);
            stage.setMaximized(lambdaContext.flag);
//            stage.setMaximized(false);
            if (lambdaContext.flag == true){
                //将歌单的图片增加
                CenterViewController.model.setIsFullScreen(true);
                topViewService.initSvg(Max_Minimization, SVGPath.MINIMIZATION);
            } else{
                CenterViewController.model.setIsFullScreen(false);
                topViewService.initSvg(Max_Minimization, SVGPath.MAXIMIZATION);
            }
            lambdaContext.flag = !lambdaContext.flag;
        });
    }

    /**
     * 频幕直接消失，最小化到任务栏
     * @param stage
     */
    public void minus(final Stage stage){
        minus.setOnMouseClicked(mouseEvent -> {
            stage.setIconified(true);
        });
    }

    public void stageLocation(final Stage stage){

        EventHandler handler = new DragWindowHandler(stage);
        topView.setOnMousePressed(handler);
        topView.setOnMouseDragged(handler);
    }

    /**
     * 将全屏的歌单图片显示出来
     * @param pane
     */


    /**
     * 将图片组装起来
     */
    @Override
    public void initSvg(){

        topViewService.initSvg(close, SVGPath.CLOSE_PATH);
        topViewService.initSvg(ApplicationIcon, SVGPath.APPLICATION_ICON_PATH);
        topViewService.initSvg(Max_Minimization, SVGPath.MAXIMIZATION);
        topViewService.initSvg(minus, SVGPath.MINUS_PATH);

    }

    /**
     * 将所有的事件放在此处
     * @param stage
     */
    @Override
    public void initAllEvent(final Stage stage){
        close(stage);
        maximization(stage);
        minus(stage);
        stageLocation(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initAllEvent(StageView.primaryStage());
        initSvg();


    }
}
