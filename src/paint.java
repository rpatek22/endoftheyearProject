
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;


public class paint extends Application{
    private Pane pane = new Pane();
    private Button btSize = new Button("Enter");
    private ComboBox dropSize = new ComboBox();
    private ComboBox dropColor = new ComboBox();
    private HBox thiccRow = new HBox();
    private BorderPane brdpane = new BorderPane();
    private Color currentColor = Color.BLACK;

    @Override
    public void start (Stage primaryStage){
        thiccRow.getChildren().add(dropSize);
        thiccRow.getChildren().add(btSize);
        thiccRow.getChildren().add(dropColor);
        brdpane.setTop(thiccRow);
        brdpane.setCenter(pane);

        pane.setStyle("-fx-background-color: #ffffff");
        btSize.setStyle("-fx-font-size:16");

        dropColor.getItems().addAll(
                "Red",
                "Orange",
                "Yellow",
                "Green",
                "Blue",
                "Purple",
                "Black",
                "Eraser"
        );

        dropColor.setOnAction(e -> {
            if (dropColor.getValue().equals("Red")) {
                currentColor = Color.INDIANRED;
            }
            else if (dropColor.getValue().equals("Orange")) {
                currentColor = Color.LIGHTSALMON;
            }
            else if (dropColor.getValue().equals("Yellow")) {
                currentColor = Color.GOLD;
            }
            else if (dropColor.getValue().equals("Green")) {
                currentColor = Color.FORESTGREEN;
            }
            else if (dropColor.getValue().equals("Blue")) {
                currentColor = Color.DEEPSKYBLUE;
            }
            else if (dropColor.getValue().equals("Purple")) {
                currentColor = Color.INDIGO;
            }
            else if (dropColor.getValue().equals("Black")) {
                currentColor = Color.BLACK;
            }
            else if (dropColor.getValue().equals("Eraser")) {
                currentColor = Color.WHITE;
            }

        });

        pane.setOnMouseDragged(e->{
            Rectangle draw = new Rectangle(e.getX(),e.getY(),10,10);
            draw.setFill(currentColor);
            pane.getChildren().add(draw);
        });

        Scene scene = new Scene(brdpane,1000, 1000);
        primaryStage.setTitle("test2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
