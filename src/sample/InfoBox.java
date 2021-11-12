package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InfoBox {

    public static Stage window;

    public static void display(String title, String msg) {

        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(125);
        window.setResizable(false);

        Label text = new Label(msg);
        text.setAlignment(Pos.BASELINE_LEFT);
        text.setTextFill(Color.rgb(255, 255, 255));

        ImageView textGraphic = new ImageView(new Image("assets/images/info.png"));
        textGraphic.setFitHeight(30);
        textGraphic.setFitWidth(30);
        text.setGraphic(textGraphic);

        VBox layout = new VBox(15);
        layout.getChildren().addAll(text);
        layout.setAlignment(Pos.CENTER);

        //layout.setStyle("-fx-background-color: #323232;");
        layout.getStyleClass().add("layout");

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.getIcons().add(new Image("assets/images/GameIcon.png"));
        scene.getStylesheets().add("assets/styles/InfoBoxStyle.css");
        window.show();

    }

    public static void stopDisplay() {

        window.close();

    }

}
