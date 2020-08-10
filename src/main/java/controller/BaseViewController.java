package controller;

import javafx.stage.Stage;
import staticUrl.SVGPath;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/8 15:15
 */
public interface BaseViewController {

    void initSvg();

    /**
     * 将所有的事件放在此处
     * @param stage
     */
    void initAllEvent(final Stage stage);

}
