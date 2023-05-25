import java.util.Scanner;

public class Crypt {

	String text = "";
	
	char[] a = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w','x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w','x', 'y', 'z'}; 
	
	public void encrypt(String input, int x) {
		
		char[] dec = new char[26];
		
		for(int i = 0; i < 25; i++) {
			dec[i] = a[i+x];
		}
		
		for(int i = 0; i < input.length(); i++) {
			
			for(int j = 0; j < dec.length; j++) {
				if(input.charAt(i) == a[j]) {
					text = text + dec[j];
				}
			}
		}
		
	}
	
	public String decrypt() {
		return text;
	}
}
