package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable{
	
	private String name;
	private int victoriaLocal;
	private int empateLocal;
	private int derrotaLocal;
	private int marcadoLocal;
	private int recibidoLocal;
	private int victoriaVisitante;
	private int empateVisitante;
	private int derrotaVisitante;
	private int marcadoVisitante;
	private int recibidoVisitante;
	private ArrayList<Partido> listaPartidos;

	public Equipo(String name, int victoriaLocal, int empateLocal, int derrotaLoca, int marcadosLocal, int recibidosLocal, int victoriaVisitante, int empateVisitante, int derrotaVisitante, int marcadoVisitante, int recibidoVisitante) {
		this.name = name;
		this.victoriaLocal = victoriaLocal;
		this.empateLocal = empateLocal;
		this.derrotaLocal = derrotaLoca;
		this.marcadoLocal = marcadosLocal;
		this.recibidoLocal = recibidosLocal;
		this.victoriaVisitante = victoriaVisitante;
		this.empateVisitante = empateVisitante;
		this.derrotaVisitante = derrotaVisitante;
		this.marcadoVisitante = marcadoVisitante;
		this.recibidoVisitante = recibidoVisitante;
		listaPartidos = new ArrayList<Partido>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVictoriaLocal() {
		return victoriaLocal;
	}

	public void setVictoriaLocal(int victoriaLocal) {
		this.victoriaLocal = victoriaLocal;
	}

	public int getEmpateLocal() {
		return empateLocal;
	}

	public void setEmpateLocal(int empateLocal) {
		this.empateLocal = empateLocal;
	}

	public int getDerrotaLocal() {
		return derrotaLocal;
	}

	public void setDerrotaLocal(int derrotaLocal) {
		this.derrotaLocal = derrotaLocal;
	}

	public int getMarcadoLocal() {
		return marcadoLocal;
	}

	public void setMarcadoLocal(int marcadoLocal) {
		this.marcadoLocal = marcadoLocal;
	}

	public int getRecibidoLocal() {
		return recibidoLocal;
	}

	public void setRecibidoLocal(int recibidoLocal) {
		this.recibidoLocal = recibidoLocal;
	}

	public int getVictoriaVisitante() {
		return victoriaVisitante;
	}

	public void setVictoriaVisitante(int victoriaVisitante) {
		this.victoriaVisitante = victoriaVisitante;
	}

	public int getEmpateVisitante() {
		return empateVisitante;
	}

	public void setEmpateVisitante(int empateVisitante) {
		this.empateVisitante = empateVisitante;
	}

	public int getDerrotaVisitante() {
		return derrotaVisitante;
	}

	public void setDerrotaVisitante(int derrotaVisitante) {
		this.derrotaVisitante = derrotaVisitante;
	}

	public int getMarcadoVisitante() {
		return marcadoVisitante;
	}

	public void setMarcadoVisitante(int marcadoVisitante) {
		this.marcadoVisitante = marcadoVisitante;
	}

	public int getRecibidoVisitante() {
		return recibidoVisitante;
	}

	public void setRecibidoVisitante(int recibidoVisitante) {
		this.recibidoVisitante = recibidoVisitante;
	}
	
	public Partido buscarPartido(String local, String visitante) {
		boolean found = false;
		Partido partidoRet = null;
		for(int i=0;i<listaPartidos.size() && found == false;i++) {
			if(listaPartidos.get(i).getLocal().equalsIgnoreCase(local) && listaPartidos.get(i).getVisitante().equalsIgnoreCase(visitante)) {
				partidoRet = listaPartidos.get(i);
				found = true;
			}
		}
		return partidoRet;
	}

	public void anhadirPartido(String local, String visitante, int golesLocal, int golesVisitante) {
		if(buscarPartido(local, visitante) == null) {
		Partido partidonuevo = new Partido(local, visitante, golesLocal, golesVisitante);
		listaPartidos.add(partidonuevo);
		actualizar(partidonuevo);
		}
	}
	
	public void actualizar(Partido partidoNuevo) {
			if(partidoNuevo.getLocal().equalsIgnoreCase(this.name)){
				if(partidoNuevo.getGolesLocal()>partidoNuevo.getGolesVisitante()) {
					victoriaLocal++;
				}else if(partidoNuevo.getGolesLocal() == partidoNuevo.getGolesVisitante()) {
					empateLocal++;
				}else {
					derrotaLocal++;
				}
				if(partidoNuevo.getGolesLocal() > 0) {
					marcadoLocal ++;
				}
				if(partidoNuevo.getGolesVisitante() > 0) {
					recibidoLocal ++;
				}
			}else {
				if(partidoNuevo.getGolesLocal()>partidoNuevo.getGolesVisitante()) {
					derrotaVisitante++;
				}else if(partidoNuevo.getGolesLocal() == partidoNuevo.getGolesVisitante()) {
					empateVisitante++;
				}else {
					victoriaVisitante++;
				}
				if(partidoNuevo.getGolesLocal() > 0) {
					recibidoVisitante ++;
				}
				if(partidoNuevo.getGolesVisitante() > 0) {
					marcadoVisitante ++;
				}
			}
	}
	
	
	

}
