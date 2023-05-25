import java.security.CryptoPrimitive;
import java.util.Scanner;

public class main {

	public static void main(String args[]) {

		boolean end = false;
		Crypt cr = new Crypt();
		Scanner strinScanner = new Scanner(System.in);
		Scanner intScanner = new Scanner(System.in);

		while (!end) {
			System.out.println("Encrypt(1)/Decrypt(2)/End(3)?");

			int y = intScanner.nextInt();

			switch (y) {
			case 1:
				System.out
						.println("Geben sie ihren Text an und um wieviele Stellen sie den Text verschluesseln wollen.");

				String input = strinScanner.nextLine().toLowerCase();
				int x = intScanner.nextInt();
				cr.encrypt(input, x);
				break;
			case 2:
				System.out.println(cr.decrypt());
				break;
			case 3:
				end = true;
				break;
			default:
				System.out.println("invalid.");
			}

		}
	}
}
