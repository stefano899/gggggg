package org.openjfx.InetecSRL.controller;

import org.openjfx.InetecSRL.domain.User;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HomePageLogged extends Application {
    
    private Stage primaryStage;
    private User user;
    
    public HomePageLogged(User user) {
    	this.user = user;
    }

	@Override
    public void start(Stage primaryStage) {
        		
		// Top menu
        Label companyName = new Label("InetechSRL");
        companyName.setFont(new Font("Arial", 24));
        
        Button structure = new Button("Struttura");
        Button notices = new Button("Avvisi");
        Button calendar = new Button("Calendario Lezioni");

        
        Button profile = new Button("Il Mio Profilo");
        profile.setPrefWidth(120);
        profile.setOnAction(e -> {
            // Apre la finestra di login quando il pulsante viene cliccato
        });
        HBox topMenu = new HBox(10);
        topMenu.setAlignment(Pos.CENTER);
        topMenu.setPadding(new Insets(10, 10, 10, 10));
        topMenu.getChildren().addAll(companyName, structure, notices, calendar, profile);
        
        String welcomeText = "Benvenuto " + user.getName(); 
        
        Label welcome = new Label(welcomeText);
        welcome.setWrapText(true);
        welcome.setAlignment(Pos.CENTER);
        welcome.setFont(new Font("Calibri", 20));
        welcome.setMaxWidth(600);

        // Center content
        String descriptionText = "InetechSRL è un'azienda che fornisce soluzioni innovative per l'industria informatica. Siamo specializzati nella progettazione e sviluppo di software personalizzati, consulenza informatica e formazione IT. Il nostro obiettivo è aiutare le aziende ad aumentare la loro efficienza, migliorare la loro produttività e rimanere al passo con i rapidi sviluppi del settore informatico.";

        Label description = new Label(descriptionText);
        description.setWrapText(true);
        description.setAlignment(Pos.CENTER);
        description.setFont(new Font("Arial", 16));
        description.setMaxWidth(600);

        Button bookButton = new Button("Prenotati alle nostre Strutture");
        Button subscribeButton = new Button("Abbonati");

        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(bookButton, subscribeButton);

        VBox centerContent = new VBox(20);
        centerContent.setAlignment(Pos.CENTER);
        centerContent.getChildren().addAll(welcome, description, buttons);

        // Main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(topMenu);
        mainLayout.setCenter(centerContent);
        
        Scene scene = new Scene(mainLayout, 600, 400);

        primaryStage.setTitle("InetechSRL - Home Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

