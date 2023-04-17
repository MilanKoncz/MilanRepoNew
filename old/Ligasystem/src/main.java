import java.util.Scanner;

public class main {
	
	public static Verwaltung vw = new Verwaltung();
	
	public Verwaltung getVerwaltung() {
		return vw;
	}
	
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		
		

		System.out.println("Willkommen zum Ligasystem!");
		System.out.println("Mit dem Befehl " + "add_game " + "Koennen sie ein neues Spiel erstellen.");
		System.out.println("Mit dem Befehl " + "add_team " + "Koennen sie ein neues Team erstellen.");
		System.out.println("Mit dem Befehl " + "add_player " + "Koennen sie einen Spieler hinzufügen.");
		System.out.println("Mit dem Befehl " + "teamlist " + "Koennen sie alle Teams ausgeben.");
		System.out.println("Mit dem Befehl " + "playerlist " + "Koennen sie alle Spieler ausgeben.");
		
		
		String eingabe = sc.nextLine();
		String ausgabe = vw.input(eingabe);
		
		System.out.println(ausgabe);
	}

}
