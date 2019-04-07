package discordfarm;

import org.json.simple.JSONArray;

public class Main extends Thread {
	static boolean end;
	static boolean espera;
	static Farmer f;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		Main.end = false;
		Main.espera = true;
		System.out.println("Cargando data.json...");
		Data_reader lector = new Data_reader("data.json");

		String url = lector.getKey("url");
		String driver = lector.getKey("driverpath");
		JSONArray cmds = lector.getKeyList("commands");
		
		System.setProperty("webdriver.chrome.driver", driver);
		
		f = new Farmer(url,cmds);
		
		f.start();
		Closer c = new Closer(f);
		c.run();
	}
}