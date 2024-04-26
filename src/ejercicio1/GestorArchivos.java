package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GestorArchivos {
	
	private File file;

	public GestorArchivos(File file) {
		super();
		this.file = file;
	}
	
	public GestorArchivos() {
		this(null);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public ArrayList<String> getLineasTexto() {
		ArrayList<String> lineas = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String linea = reader.readLine();
			while (linea != null) {
				lineas.add(linea);
				linea = reader.readLine();
			}
		} catch (IOException e) {}
		
		return lineas;
	}
	
	public void guardarTexto(ArrayList<String> lineas) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (String linea : lineas) {
				writer.write(linea);
			}
		} catch (IOException e) {}
		
		
	}
}
