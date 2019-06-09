
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javax.swing.*;
import java.awt.*;


public class paint extends Application{
    private Pane pane = new Pane();
    private Button btn = new Button("New Canvas");
    private ComboBox comboBox = new ComboBox();
    private ComboBox dropColor = new ComboBox();
    private HBox thiccRow = new HBox();
    private BorderPane brdpane = new BorderPane();
    private Color currentColor = Color.BLACK;
    //private boolean erase = false;
    private double currentBrushSize =10 ;
    private Slider slider = new Slider();


    @Override
    public void start (Stage primaryStage){
        comboBox.getItems().addAll(
                "Black",
                "Blue",
                "Green",
                "Red",
                "Yellow",
                "Eraser"
        );
        slider.setMin(1);
        slider.setMax(35);
        slider.setValue(currentBrushSize);

        thiccRow.getChildren().add(comboBox);


        thiccRow.getChildren().add(slider);
        thiccRow.getChildren().add(btn);
        brdpane.setTop(thiccRow);
        brdpane.setCenter(pane);

        pane.setStyle("-fx-background-color:WHITE");
        thiccRow.setStyle("-fx-background-color:WHITE");


        btn.setStyle("-fx-font-size:16 ");

        pane.setOnMouseDragged(e->{
            Rectangle draw = new Rectangle(e.getX(),e.getY(),currentBrushSize,currentBrushSize);
            draw.setFill(currentColor);

//            if(erase){
//                pane.getChildren().add(draw);
//
//            }
//            else {
//                pane.getChildren().add(draw);
//            }
            pane.getChildren().add(draw);


        });


        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String item = comboBox.getValue().toString();
                Color drawColor = getColor(item);
                currentColor = drawColor;
            }
        });

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                restart();
            }
        });


        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                System.out.println(new_val.doubleValue());
                currentBrushSize = new_val.doubleValue();
            }
        });




        Scene scene = new Scene(brdpane,1000, 1000);
        primaryStage.setTitle("Paint Application");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public Color getColor(String colorName){
        if(colorName.equals("Red"))
            return Color.RED;
        else if(colorName.equals("Blue"))
            return Color.BLUE;
        else if(colorName.equals("Black"))
            return Color.BLACK;
        else if(colorName.equals("Green"))
            return Color.GREEN;
        else if(colorName.equals("Eraser"))
            return Color.WHITE;
        else {
            return Color.YELLOW;
        }
    }

    public void restart(){
        pane.getChildren().clear();
    }

}
