package org.openjfx.InetecSRL.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openjfx.InetecSRL.domain.User;
import org.openjfx.InetecSRL.logicaDiBusiness.UserDatabase;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Registration extends Application {
	private String name = "";
	private String surname = "";
	private String email = "";
	private String password = "";
	private Label statusLabel;
	private UserDatabase userDatabase = new UserDatabase("src/main/resources/org/openjfx/database/registration.txt");

	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception{
		VBox root = new VBox();
		root.setSpacing(10);
		root.setPadding(new Insets(20));
		
		Label nameLabel = new Label ("Nome:");
		TextField nameField = new TextField();
		nameField.setMaxWidth(200);
		nameField.setPromptText("Inserisci il tuo nome");
		
		Label surnameLabel = new Label ("Cognome:");
		TextField surnameField = new TextField();
		surnameField.setMaxWidth(200);
		surnameField.setPromptText("Inserisci il tuo cognome");
		
		Label emailLabel = new Label ("Email:");
		TextField emailField = new TextField();
		emailField.setMaxWidth(200);
		emailField.setPromptText("Inserisci email");
		
		Label passwordLabel = new Label("Passwrod:");
		PasswordField passwordField = new PasswordField();
		passwordField.setMaxWidth(200);
		passwordField.setPromptText("Inserisci password:");
		
		root.getChildren().addAll(nameLabel, nameField, surnameLabel, surnameField, emailLabel, emailField, passwordLabel, passwordField, statusLabel = new Label());
		
		Button registerButton = new Button ("Registra");
		registerButton.disableProperty().bind(nameField.textProperty().isEmpty());
		registerButton.disableProperty().bind(surnameField.textProperty().isEmpty());
		registerButton.disableProperty().bind(emailField.textProperty().isEmpty());
		registerButton.disableProperty().bind(passwordField.textProperty().isEmpty());
		registerButton.setOnAction(e ->{
			name = nameField.getText();
			surname = surnameField.getText();
			email = emailField.getText();
			password = passwordField.getText();
			Boolean control = true;
			
			try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/org/openjfx/database/registration.txt"))){
	        	String line;
	        	
	        	while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                String storedEmail = parts[2];
	                
	                if (storedEmail.equals(email)) {
	                	statusLabel.setText("Email già registrata");
	                	control = false;
	                	
	                }
	        	}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	        
			if(control == true) {
			User user = new User(name, surname, email, password);
			userDatabase.addUser(user);
			Label confirmationLabel = new Label("Registrazione completata");
			HBox confirmationBox = new HBox(confirmationLabel);
			confirmationBox.setAlignment(Pos.CENTER);
			root.getChildren().add(confirmationBox);
			statusLabel.setText("");
			}
		});
		
		Button loginButton = new Button("Già registrato, premi qui");
		loginButton.setOnAction(e -> {
			Login login = new Login("src/main/resources/org/openjfx/database/registration.txt");
			login.start(primaryStage);
		});
		
		root.getChildren().add(registerButton);
		root.getChildren().add(loginButton);
		
		Scene scene = new Scene (root, 600, 400);
		primaryStage.setTitle("Pagina di registrazione");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
