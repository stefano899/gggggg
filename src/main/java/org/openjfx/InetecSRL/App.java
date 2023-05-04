package org.openjfx.InetecSRL;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
    	HomePage homePage = new HomePage();
    	homePage.start(primaryStage);
        

    }

    public static void main(String[] args) {
        launch();
    }

}