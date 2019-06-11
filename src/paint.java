
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.*;
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

/*hello*/



public class paint extends Application{
    private Pane pane = new Pane();
    private Button btn = new Button("New Canvas");
    private ComboBox comboBox = new ComboBox();
    private HBox thiccRow = new HBox();
    private BorderPane brdpane = new BorderPane();
    private Color currentColor = Color.BLACK;
    private double currentBrushSize =10 ;
    private Slider slider = new Slider();
    private Slider sliderRed = new Slider();
    private Slider sliderGreen = new Slider();
    private Slider sliderBlue = new Slider();
    private TextField tfSize = new TextField("size");

    @Override
    public void start (Stage primaryStage){
        slider.setMin(1);
        slider.setMax(35);
        slider.setValue(currentBrushSize);

        tfSize.setEditable(false);
        //thiccRow.getChildren().add(comboBox);
        tfSize.setPrefWidth(50);
        tfSize.setStyle( "-fx-text-box-border: transparent");

        thiccRow.getChildren().add(tfSize);
        thiccRow.getChildren().add(slider);
        thiccRow.getChildren().add(sliderRed);
        thiccRow.getChildren().add(sliderGreen);
        thiccRow.getChildren().add(sliderBlue);
        thiccRow.getChildren().add(btn);
        brdpane.setTop(thiccRow);
        brdpane.setCenter(pane);

        //settin slider colors
        sliderRed.setMax(1);
        sliderRed.setValue(0);
        sliderRed.setMin(0);
        sliderRed.valueProperty().addListener(e -> setColor());

        sliderGreen.setMax(1);
        sliderGreen.setValue(0);
        sliderGreen.setMin(0);
        sliderGreen.valueProperty().addListener(e -> setColor());

        sliderBlue.setMax(1);
        sliderBlue.setValue(0);
        sliderBlue.setMin(0);
        sliderBlue.valueProperty().addListener(e -> setColor());



        pane.setStyle("-fx-background-color:WHITE");
        thiccRow.setStyle("-fx-background-color:WHITE");


        btn.setStyle("-fx-font-size:16 ");

        pane.setOnMouseDragged(e->{
            Rectangle draw = new Rectangle(e.getX(),e.getY(),currentBrushSize,currentBrushSize);
            if (e.getY() >= 10) {
                draw.setFill(currentColor);

                pane.getChildren().add(draw);
            }


        });


        //comboBox.setOnAction(new EventHandler<ActionEvent>() {
          //  @Override
           //public void handle(ActionEvent event) {
               // String item = comboBox.getValue().toString();
               // Color drawColor = getColor(item);
               // currentColor = drawColor;
         //   }
        //});

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

    public void setColor()
    {
        currentColor = new Color(sliderRed.getValue(), sliderBlue.getValue(), sliderGreen.getValue(),1);
    }

  /*  public Color getColor(String colorName){
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
    } */

   // clbtn.setOnAction(event -> {
       // Color color = Color.web(colour.getText());
       // R.setValue(color.getRed() * 255);
       // G.setValue(color.getGreen() * 255);
      //  B.setValue(color.getBlue() * 255);
      //  circle.setFill(color);
  //  });

    public void restart(){
        pane.getChildren().clear();
    }

}
