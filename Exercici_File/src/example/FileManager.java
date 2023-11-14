package example;

import java.io.File;

public final class FileManager {
	
	private static FileManager instance;
		
	private File file;
		
	
	private FileManager() {}
	
	
	public static FileManager getInstance() {
		if (instance == null) instance = new FileManager();
		return instance;
	}
	
	public String unix_ls(String path) {
		this.setFile(path);
		StringBuilder str = new StringBuilder();
		
		if (file.isDirectory()) {
			for(File f: file.listFiles()) {
				char letter = f.isFile() ? 'f' : 'd';
				str.append(f.getName()).append(' ').append(letter).append('\n');
			}
			
			if(str.isEmpty()) {
				str.append("Vacío");
			}
		} else {
			str.append("Ruta incorrecta. Asegurate de seleccionar un directiorio.");
		}
		
		return str.toString();

	}
	
	public String getFileData(String path) {
		this.setFile(path);
		String res;
		if (file.isFile()) {
			String nameFile = file.getName();
			String sizeFile = String.valueOf(file.getTotalSpace());
			String moddataFile = String.valueOf(file.lastModified());
			
			res = String.format("== INFO ==\nNom: %s\nSize: %s\nFecha de la ultima modificacion: %s", nameFile, sizeFile, moddataFile);
		} else {
			res = "Ruta incorrecta. Asegurate de seleccionar un fichero.";
		}
		
		return res;
	}
	
	public void deleteRute(String path) {
		this.setFile(path);
		
		file.delete();
	}
	
	public void goBack(){
		this.setFile(file.getParent());
	}
	
	private void setFile(String path) {
		this.file = new File(path);
	}
	
}
