
//
// Kontaktbuch, OOP-Version
// Stefan Gerecke
// 14.01.2020

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static String[] b = { "Name:          ", "Telefonnummer: ", "Emailadresse:  " };
	static ArrayList<Kontakt> speicher = new ArrayList<>();
	static boolean anfang = true;

	public static void main(String[] args) {


		menu();
	}

	static void menu() {

		boolean lebt = true;
		while (lebt) {
			while (anfang) {
				System.out.println("K o n t a k t o r d n e r OOP\n\n");
				anfang = false;
			}
			System.out.println("Kontakt (s)chreiben");
			System.out.println("Kontakt (l)esen");
			System.out.println("Kontakt (f)inden");
			System.out.println("Kontakt (a)endern");
			System.out.println("Kontakt (e)ntfernen");
			System.out.println("        (b)eenden");
			String menu = scanner.next();
			switch (menu.toLowerCase()) {

			case "s": {
				schreiben(0);
				break;
			}

			case "l": {
				lesen();
				break;
			}
			case "f": {
				finden();
				break;
			}
			case "a": {

				aendern("aender");
				break;
			}

			case "e": {

				aendern("loesch");
				break;
			}

			case "b": {
				scanner.close();
				System.exit(1);
			}
			default: {
				System.out.println("falsche Taste");
				menu();
			}
			}
		}
	}

	static void check() {

		if (speicher.size() == 0) {
			System.out.println("Datenbank leer!\n");
			menu();
		}

	}

	
	
	
	static void schreiben(int db) {

		Kontakt kontakt = new Kontakt();
		boolean ch=true;
		int auswahl =0;
		if (db>=1) {
			
			System.out.println("Was soll geändert werden?");
			System.out.println("\nAlle Daten:    (0)\n"+b[0]+"(1)\n"+b[1]+"(2)\n"+b[2]+"(3)");
			auswahl= scanner.nextInt();
		}
		
		if(auswahl ==0 || auswahl==1 && ch) {
		System.out.println(b[0]);
		kontakt.setName(scanner.next());
		if(auswahl==1) { 
			kontakt.setTelnr(speicher.get(db-1).getTelnr());
			kontakt.setEmail(speicher.get(db-1).getEmail());
			ch=false; };
		}
		if(auswahl ==0 || auswahl==2 && ch) {
		System.out.println(b[1]);
		kontakt.setTelnr(scanner.next());
		if(auswahl==2) { 
			kontakt.setEmail(speicher.get(db-1).getEmail());
			kontakt.setName(speicher.get(db-1).getName());
			ch=false; };
		}
		if(auswahl ==0 || auswahl==3 && ch) {
		System.out.println(b[2]);
		kontakt.setEmail(scanner.next());
		if(auswahl==3) { 
			kontakt.setTelnr(speicher.get(db-1).getTelnr());
			kontakt.setName(speicher.get(db-1).getName());
			ch=false; };
		}
		if (db == 0) {
			speicher.add(kontakt);
		}
		if (db >= 1) {
			speicher.set((db - 1), kontakt);
		}

	}

	static void anzeige(int i) {

		System.out.println("Eintrag:      (" + (i + 1) + ")\n");
		System.out.println(b[0] + speicher.get(i).getName());
		System.out.println(b[1] + speicher.get(i).getTelnr());
		System.out.println(b[2] + speicher.get(i).getEmail() + "\n");
	}

	static void lesen() {
		check();
		for (int i = 0; i < speicher.size(); i++) {
			anzeige(i);
		}

	}

	static void finden() {
		check();
		boolean fund = false;
		System.out.println("Suchbegriff eingeben:");
		String find = scanner.next();

		for (int i = 0; i < speicher.size(); i++) {

			if (speicher.get(i).getName().contains(find) || speicher.get(i).getTelnr().contains(find)
					|| speicher.get(i).getEmail().contains(find)) {

				System.out.print("Gefunden in ");
				anzeige(i);
				fund = true;

			}
		}
		if (!fund) {
			System.out.println("Keinen Eintrag gefunden.\n");
		}

	}

	static void aendern(String s) {
		int a=0;

		check();

		System.out.println("Welcher Datenbankeintrag soll ge" + s + "t werden?\n");

		lesen();
	
	
			
		try {
		a = scanner.nextInt();

		} catch(Exception e) {
			String weg = scanner.next();
			System.out.println("Falsche Eingabe: "+weg+"\n");
		}
		if(a>0 && a<=speicher.size()) {
		
	
		
		if (s == "aender") {
			schreiben(a);
		}
		if (s == "loesch") {
			speicher.remove(a - 1);
		}
		
	}else {System.out.println("Falsche Daten-ID.\n");}

	}

}
