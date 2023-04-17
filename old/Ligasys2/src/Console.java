import java.util.Scanner;

public class Console {

	private Verwaltung vw = new Verwaltung();
	private Scanner sc = new Scanner(System.in);
	private boolean run;

	public Verwaltung getVW() {
		return vw;
	}

	public void weiter() {
		
		System.out.println("Wollen sie weiter machen? (Y/N)");
		
		String weiter = sc.nextLine();
		if(weiter.equals("Y")) {
			System.out.println("Es geht weiter.");
			run = true;
		}else if(weiter.equals("N")) {
			run = false;
		}else {
			System.out.println("Ungueltige Eingabe!");
			weiter();
		}
	}
	
	public void start() {

		run = false;
		System.out.println("Willkommen zum Ligasystem!");
		do{

			System.out.println("Mit dem Befehl " + "0. " + "Koennen sie den Ligastand anzeigen lassen.");
			System.out.println("Mit dem Befehl " + "1. " + "Koennen sie ein neues Spiel erstellen.");
			System.out.println("Mit dem Befehl " + "2. " + "Koennen sie ein neues Team erstellen.");
			System.out.println("Mit dem Befehl " + "3. " + "Koennen sie einen Spieler hinzufügen.");
			System.out.println("Mit dem Befehl " + "4. " + "Koennen sie alle Teams ausgeben.");
			System.out.println("Mit dem Befehl " + "5. " + "Koennen sie alle Spieler ausgeben.");
			System.out.println("Mit dem Befehl " + "6. " + "Koennen Testdaten erstellen.");

			String eingabe = sc.nextLine();
			String ausgabe = vw.input(eingabe);

			System.out.println(ausgabe);
			
			weiter();
			
		}while (run); 

	}
}
