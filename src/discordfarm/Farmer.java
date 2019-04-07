package discordfarm;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	
public class Farmer extends Thread {
	String url;
	String user;
	String pass;
	WebElement textbox;
	WebDriver driver;
	JSONArray commands;
	ArrayList<Comando> comandos;
	long contador_segundos;
	
	public Farmer(String url, JSONArray commands){
		this.url= url;
		this.contador_segundos = 0;
		comandos = new ArrayList<Comando>();
		guardar_comandos(commands);
	}
	
	public void run() {
		try {
			farmear();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void farmear() throws IOException, InterruptedException {
		driver = new ChromeDriver();
		driver.get(url);
		System.out.println("Ingresar cualquier cosa cuando terminás de loguearte y termina de cargar la página. \nClickeá en el canal donde vas a farmear (si es necesario el subcanal o como se llame el cosito con el #, también)");
		System.in.read();
		textbox = driver.findElement(By.className("textArea-2Spzkt"));		
		while (Main.end == false){
			execute_cmds();
			Thread.sleep(1000);
		}
		cerrar();
	}
	
	private void execute_cmds() {
		System.out.print("Ejecutando comandos..");
		/*int l = commands.size();
		for (int i = 0; i<l ; i++) {
			JSONObject cmd = (JSONObject) commands.get(i);
			int cmd_time = (int) cmd.get("intervalo");
			if (contador_segundos % cmd_time == 0) {
				
			}
			textbox.sendKeys(commands.get(i).toString());
			textbox.sendKeys(Keys.RETURN);
		}
		*/
		int comandos_ejecutados = 0;
		int l = this.comandos.size();
		for (int i = 0; i<l ; i++) {
			Comando c = comandos.get(i);
			if (this.contador_segundos % c.intervalo == 0) {
				comandos_ejecutados++;
				textbox.sendKeys(c.comando);
				textbox.sendKeys(Keys.RETURN);
			}
		}
		this.contador_segundos++;		
		System.out.println(" - " + Integer.toString(comandos_ejecutados) + " comandos ejecutados");
	}
	
	public void cerrar() {
		driver.close();
	}
	
	private void guardar_comandos(JSONArray commands) {
		int l = commands.size();
		for (int i = 0; i<l ; i++) {
			JSONObject cmd = (JSONObject) commands.get(i);
			comandos.add(new Comando(cmd));
		}
	}
}
