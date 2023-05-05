package org.openjfx.InetecSRL.logicaDiBusiness;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openjfx.InetecSRL.domain.User;

public class UserDatabase {
	private String filename;
	
	public UserDatabase(String filename) {
		this.filename = filename;
	}
	
	public void addUser(User user) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true))){
			writer.write(user.getName()+ "," + user.getSurname() + "," + user.getEmail() + "," + user.getPassword());
			writer.newLine();
		} catch (IOException ex) {
			System.out.println("Errore durante la scrittura del file");
		}
	}
	
	public List<User> getUsers(){
		List<User> users = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
			String line;
			
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String name = parts[0];
				String surname = parts[1];
				String email = parts[2];
				String password = parts[3];
				User user = new User(name, surname, email, password);
				users.add(user);
			}
		} catch (IOException ex) {
			System.out.println("Errore durante la lettura del file");
		}
		return users;
	}
	
	public User findUser (String email) {
		String searchUser = email;
		
		File file = new File("src/main/resources/org/openjfx/database/registration.txt");
		
		try {
			Scanner input = new Scanner (file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String parts[] = line.split(",");
				if (parts[2].equals(searchUser)) {
					User user = new User(parts[0], parts[1], parts[2], parts[3]);
					return user;
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File non trovato: " + ex.getMessage());
		}
		return null;
	}
	
}
