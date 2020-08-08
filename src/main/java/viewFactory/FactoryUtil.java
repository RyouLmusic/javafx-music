package viewFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import view.viewImpl.TopView;

import java.io.IOException;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/6 22:24
 */
public class FactoryUtil {

    public static Parent createView(Class c, String path) {

        Parent pane = null;

        try {
            FXMLLoader loader = new FXMLLoader(c.getResource(path));
            pane = loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        return pane;

    }

}
