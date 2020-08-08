package util;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.io.File;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/7 21:41
 *
 * 对鼠标各种事件的之后的图像处理：鼠标点击, 鼠标进入，鼠标出去, 双击
 *
 * 就是设置伪类
 */
public class MouseEventUtil {


    public static void aVoid(JFXButton button, String id){

        button.setOnMouseEntered(mouseEvent -> {

        });
    }


}
