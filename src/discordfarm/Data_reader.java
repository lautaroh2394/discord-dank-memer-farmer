package discordfarm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Data_reader {
	public JSONObject data;
	public Data_reader(String path) throws IOException {
		File data_file = new File(path);
		FileReader data_file_reader;
		String line = "";
		String aux = null;
		try {
			data_file_reader = new FileReader(data_file);
			BufferedReader bfr = new BufferedReader(data_file_reader);
			while ((aux = bfr.readLine())!= null) {
				line = line + aux;
			};
			bfr.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("-----------------------File not found");
			e.printStackTrace();
		}
		JSONParser parser = new JSONParser();
		try {
			//Lista de listas.
			data = (JSONObject) parser.parse(line);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se pudo parsear el archivo "+path);
		}
	}
	
	public String getKey(String s) {
		String k = null;
		if (data.containsKey(s)) {
			k = (String) data.get(s);
		};
		return k;
	}
	
	public JSONArray getKeyList(String s) {
		JSONArray k = null;
		if (data.containsKey(s)) {
			k = (JSONArray) data.get(s);
		};
		return k;
	}
}
