package discordfarm;

import org.json.simple.JSONObject;

public class Comando {
	long intervalo;
	String comando;
	public Comando(JSONObject jsoncmd) {
		this.intervalo = (long) jsoncmd.get("intervalo");
		this.comando = (String) jsoncmd.get("comando");
	}
}
