
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
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
    @Override
    public void start (Stage primaryStage){
        thiccRow.getChildren().add(dropSize);
        thiccRow.getChildren().add(btSize);
        brdpane.setTop(thiccRow);
        brdpane.setCenter(pane);

        btSize.setStyle("-fx-font-size:15 ");

        pane.setOnMouseDragged(e->{
            Rectangle draw = new Rectangle(e.getX(),e.getY(),3,3);
            pane.getChildren().add(draw);
        });

        Scene scene = new Scene(brdpane,1000, 1000);
        primaryStage.setTitle("test2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
