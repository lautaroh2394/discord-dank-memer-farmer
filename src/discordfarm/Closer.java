package discordfarm;

import java.util.Scanner;

public class Closer {
	
	Farmer f;
	public Closer(Farmer f) {
		this.f = f;
	}
	@SuppressWarnings("deprecation")
	public void run() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Ingresar close para cerrar");
		while (!Main.end) {
			String s = reader.next(); // Scans the next token of the input as an int.
			if (s.equals("close")) {
				Main.end = true;
				System.out.println("Cerrando..");
			}
		}
			f.driver.close();
			f.stop();
			reader.close();
	}

}
