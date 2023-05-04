package org.openjfx.InetecSRL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class Login extends Application {
    
    private Stage primaryStage;
    private TextField emailField;
    private PasswordField passwordField;
    private Label statusLabel;
    private String filename;
    
    public Login(String filename) {
    	this.filename = filename;
    }

    @Override
    public void start(Stage primaryStage) {
        
        this.primaryStage = primaryStage;
  
        // Creazione dei campi di testo per username e password
        Label emailLabel = new Label("Username:");
        emailField = new TextField();
        emailField.setMaxWidth(200);
        
        
      


        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        passwordField.setMaxWidth(200);
        // Creazione del pulsante di login
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
        	
            String email = emailField.getText();
            String password = passwordField.getText();
            if (authenticate(email, password)) {
                statusLabel.setText("Login effettuato");
                // Azioni da eseguire se il login è stato effettuato correttamente
            } else {
                statusLabel.setText("Username o password errati");
            }
        });
     // Creazione del pulsante per registrarsi
        Button registerButton = new Button("Nuovo Utente? Registrati");
        registerButton.setOnAction(e -> {
            Registration registration = new Registration();
            try {
				registration.start(primaryStage);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
        });

        // Creazione del layout
        VBox loginLayout = new VBox(10);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.getChildren().addAll(
                emailLabel, emailField,
                passwordLabel, passwordField,
                loginButton,
                registerButton,
                statusLabel = new Label());

        
        Scene scene = new Scene(loginLayout, 600, 400);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }
    
    private boolean authenticate(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
        	String line;
        	
        	while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String storedUsername = parts[2];
                String storedPassword = parts[3];
                
                if (storedUsername.equals(email) && storedPassword.equals(password)) {
                    return true;
                }
        	}
        } catch (IOException ex) {
        	System.out.println("Errore nella lettura del file");
        }
        return false;
    }
        	
    
    public static void main(String[] args) {
        launch(args);
    }
}
