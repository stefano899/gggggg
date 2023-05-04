package org.openjfx.InetecSRL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
}
