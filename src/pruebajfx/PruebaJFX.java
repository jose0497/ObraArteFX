/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajfx;

import static java.lang.System.gc;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author brend
 */
public class PruebaJFX extends Application {

    private Pane pane;

    private Canvas canvas;
    private Scene scene;
    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Fractal");
        initComponents(primaryStage);

        primaryStage.show();
        this.gc = this.canvas.getGraphicsContext2D();
        paint(gc);
    }

    private void initComponents(Stage primaryStage) {
        this.pane = new Pane();
        this.scene = new Scene(pane, 800, 600);
        this.canvas = new Canvas(800, 600);
        this.canvas.relocate(0, 0);
        this.pane.getChildren().add(this.canvas);

        primaryStage.setScene(this.scene);
    }

    private void draw(int x1, int y1, int y, GraphicsContext gc) {

        int r = (int) (Math.random() * 8);
        
        if (r == 0) {
            gc.setStroke(Color.BLUE);
        }
        if (r == 1) {
            gc.setStroke(Color.BROWN);
        }
        if (r == 2) {
            gc.setStroke(Color.YELLOW);
        }
        if (r == 3) {
            gc.setStroke(Color.CYAN);
        }
        if (r == 4) {
            gc.setStroke(Color.RED);
        }
        if (r == 5) {
            gc.setStroke(Color.GREEN);
        }
        if (r == 6) {
            gc.setStroke(Color.BLACK);
        }
        if (r == 7) {
            gc.setStroke(Color.ORANGE);
        }

        gc.strokeOval(x1, y1, y, y);

        if (y > 10) {
            draw(x1 + 6, y1 - 6, (y / 2) - 5, gc);
            draw((x1 + y / 2) + 3, y1 + 3, (y / 2) - 6, gc);
            draw(x1 + 6, y1 + (y / 2) + 3, (y / 2) - 6, gc);
            draw((x1 + y / 2) - 6, y1 + (y / 2) - 7, (y / 2) - 6, gc);
//            draw((x1 - y - 6) + 7,  (y / 2) + 7, (y / 2) - 6, gc);

        }
    }

    public void paint(GraphicsContext gc) {
        draw(25, 35, 550, gc);
    }

    public static void main(String[] args) {
        launch(args);

    }

}
