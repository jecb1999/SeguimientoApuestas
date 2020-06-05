package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Controladora {

	private ArrayList<Equipo> listaequipos;

	public Controladora() {
		listaequipos = new ArrayList<Equipo>();
		read();
	}

	public void anhadirEquipo(String name) {
		Equipo nuevo = new Equipo(name, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		listaequipos.add(nuevo);
	}

	public Equipo getEquipo(String name) {
		boolean found = false;
		Equipo EquipoRetornar = null;
		for (int i = 0; i < listaequipos.size() && found == false; i++) {
			if (name.equalsIgnoreCase(listaequipos.get(i).getName())) {
				EquipoRetornar = listaequipos.get(i);
				found = true;
			}
		}
		return EquipoRetornar;
	}

	public void anhadirPartido(String local, String visitante, int golesLocal, int golesVisitante) throws IOException {
		if (getEquipo(local) != null && getEquipo(visitante) != null) {
			getEquipo(local).anhadirPartido(local, visitante, golesLocal, golesVisitante);
			getEquipo(visitante).anhadirPartido(local, visitante, golesLocal, golesVisitante);
			guardar();
		}
	}

	public void guardar() throws IOException {
		FileOutputStream archivo = new FileOutputStream(".\\informacion\\info.txt");
		ObjectOutputStream salida = new ObjectOutputStream(archivo);
		salida.writeObject(listaequipos);
		salida.close();
		archivo.close();
	}
	
	public void read() {
		try {
			File f = new File(".\\informacion\\info.txt");
			if(f.exists()) {
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				listaequipos = (ArrayList<Equipo>) ois.readObject();
				ois.close();
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
