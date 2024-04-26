package ejercicio2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {

	private File file;
	
	public FileManager(File file) {
		this.file = file;
	}
	
	public FileManager() {
		this(null);
	}
	
	public ArrayList<Object> readObjects() {
		ArrayList<Object> objetos = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			while(true) {
				objetos.add(ois.readObject());
			}
		} catch (EOFException e) {
			return objetos;
		} catch (IOException e) {} 
		catch (ClassNotFoundException e) {}
		return null;
	}
	
	public void saveObjects(ArrayList<Object> objetos) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			for (Object object : objetos) {
				oos.writeObject(object);
			}
		} catch (IOException e) {}
	}
	
	public void saveObject(Object object) {
		ArrayList<Object> objetos = readObjects();
		readObjects().add(object);
		saveObjects(objetos);
	}
	
}
