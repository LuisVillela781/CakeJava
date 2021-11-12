package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String msg, String btn1Text, String btn2Text) {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(125);
        window.setResizable(false);

        Label text = new Label(msg);
        text.setAlignment(Pos.BASELINE_LEFT);
        text.setTextFill(Color.rgb(255, 255, 255));

        ImageView textGraphic = new ImageView(new Image("assets/images/question.png"));
        textGraphic.setFitHeight(30);
        textGraphic.setFitWidth(30);
        text.setGraphic(textGraphic);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.setPadding(new Insets(0, 25, 0, 0));

        Button Btn1 = new Button(btn1Text);
        //Btn1.setStyle("-fx-background-color: #2174b8;");//-fx-border-color: #2892c7;
        Btn1.setTextFill(Color.WHITE);
        Btn1.getStyleClass().add("Btn1");
        Button Btn2 = new Button(btn2Text);
        //Btn2.setStyle("-fx-background-color: #555555;");
        Btn2.setTextFill(Color.WHITE);
        Btn2.getStyleClass().add("Btn2");

        hBox.getChildren().addAll(Btn1, Btn2);
        //hBox.getStylesheets().add("sample/ConfirmBoxStyle.css");

        Btn1.setOnAction(e -> {
            answer = true;
            window.close();
        });
        Btn2.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(15);
        layout.getChildren().addAll(text, hBox);
        layout.setAlignment(Pos.CENTER);

        //layout.setStyle("-fx-background-color: #323232;");
        layout.getStyleClass().add("layout");

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.getIcons().add(new Image("assets/images/GameIcon.png"));
        scene.getStylesheets().add("assets/styles/ConfirmBoxStyle.css");
        window.showAndWait();

        return answer;

    }

}
