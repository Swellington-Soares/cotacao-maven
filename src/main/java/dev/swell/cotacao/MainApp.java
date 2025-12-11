package dev.swell.cotacao;

import dev.swell.cotacao.api.Cache;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Objects;

public class MainApp extends Application {


    public static FXMLLoader loaderView(String viewName) {
        return new FXMLLoader(Objects.requireNonNull(MainApp.class.getResource("/views/"+viewName+".fxml")));
    }


    @Override
    public void start(Stage stage) throws Exception {
        Cache.Load();
        Parent root = loaderView("main-view").load();//FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/main-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Meu App JavaFX");
        stage.setOnCloseRequest(windowEvent -> {
            Cache.Save();
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
