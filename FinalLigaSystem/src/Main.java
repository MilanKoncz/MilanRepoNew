
public class Main {

	public static void main(String args[]) {
		
		Verwaltung vw = new Verwaltung();
		Controller controller = new Controller(vw);
		
		controller.startMainGUI();
		
		/*
		 * ToDo-List
		 * -ListShuffle
		 * -Persistent saving (serialize objects in json)
		 * -Comboboxes

		 */
	}
	
}
