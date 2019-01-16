package mech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {
	
	private File mainFolder;
	private ArrayList<String> usersList = new ArrayList<>();	

	public FileWork() {
		createMainFolder();
	}

	private void createMainFolder() {
		String appData = System.getenv("APPDATA");
		
		mainFolder = new File(appData+"/PlemCo");
		
		mainFolder = new File(mainFolder+"/Interval Learning");
		if (!mainFolder.exists())
			mainFolder.mkdirs();
	}

	public ArrayList<String> getUsersList(){
		for (String string : mainFolder.list()) {
			usersList.add(string);
		}
		return usersList;
	}

	public void createNewUser(String text) throws IOException {
		File newUserFile = new File(mainFolder+"/"+text);
		newUserFile.mkdir();
	}

		public boolean isAlreadyExists(String text) {
			File newUserFolder = new File(mainFolder+"/"+text);
			if (newUserFolder.exists())
				return true;
			else
				return false;
		}

	public ArrayList<Card> extractCardsFromFile(Object userName) throws IOException {
		ArrayList<Card> cards = new ArrayList<>();
		File userFolder = new File(mainFolder+"/"+(String)userName);
		for (File cardFile : userFolder.listFiles()) {
			
			BufferedReader input = new BufferedReader(new FileReader(cardFile));
			input.readLine();
			String str = input.readLine();
			int number = Integer.valueOf(str);
			String dateLine = input.readLine();
			int repeatPeriod = Integer.valueOf(input.readLine());
			String firstSide = input.readLine();
			String secondSide = input.readLine();
			
			Card newCard = new Card(number, dateLine, repeatPeriod, firstSide, secondSide);
			cards.add(newCard);
			input.close();
		}
		return cards;
	}
	
	public void deletUser(String userName){
		File userFolder = new File(mainFolder+"/"+(String)userName);
		userFolder.delete();
	}
}
