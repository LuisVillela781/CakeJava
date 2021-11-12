package sample;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    public static void display(String title, String msg, String btnText) {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMaxHeight(125);
        window.setResizable(false);

        Label text = new Label(msg);
        text.setTextFill(Color.WHITE);

        Button closeBtn = new Button(btnText);
        closeBtn.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(text, closeBtn);
        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("layout");

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("assets/styles/AlertBoxStyle.css");
        window.setScene(scene);
        window.getIcons().add(new Image("assets/images/GameIcon.png"));
        window.showAndWait();

    }

}
