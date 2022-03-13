package javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * @author: zhaosp1
 * @description:
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2022/02/13 22:02
 */

/**
 * 一点教程网： http://www.yiidian.com
 */
public class Hello_World extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn1 = new Button("Say, Hello World");

        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("hello world");
            }
        });

        StackPane root=new StackPane();
        root.getChildren().add(btn1);
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("第一个JavaFX程序");
        primaryStage.show();
    }

    public static void main (String[] args)
    {
        launch(args);
    }
}