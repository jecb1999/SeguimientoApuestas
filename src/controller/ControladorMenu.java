package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import model.*;
import aplicacion.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorMenu implements Initializable {
	
	private static Main main;
	private static Controladora controladora;
	
	@FXML
	private TextField nombrequipoconsultar;
	@FXML
	private Button buscar;
	@FXML
	private TextField equipoLocal;
	@FXML
	private TextField equipoVisitante;
	@FXML
	private TextField golLocal;
	@FXML
	private TextField golVisitante;
	@FXML
	private Button agregarPartido;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		main = new Main();
		controladora = new Controladora();
		
	}
	
	public void clickBuscar(ActionEvent ae) {
		Equipo EquipoConsulta = controladora.getEquipo(nombrequipoconsultar.getText());
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "Victorias de Local: "+EquipoConsulta.getVictoriaLocal()+"\n"+"Empates de Local: "+EquipoConsulta.getEmpateLocal()+"\n"+"Derrotas de Local: "+EquipoConsulta.getDerrotaLocal()+"\n"+"Marcados de Local: "+EquipoConsulta.getMarcadoLocal()+"\n"+"Recibidos de Local: "+EquipoConsulta.getRecibidoLocal()+"\n"+"Victorias de Visitante: "+EquipoConsulta.getVictoriaVisitante()+"\n"+"Empates de Visitante: "+EquipoConsulta.getEmpateVisitante()+"\n"+"Derrotas de Visitante: "+EquipoConsulta.getDerrotaVisitante()+"\n"+"Marcados de Visitante: "+EquipoConsulta.getMarcadoVisitante()+"\n"+"Recibidos de Visitante: "+EquipoConsulta.getRecibidoVisitante()+"\n");
		alert.show();
	}
	
	public void clickAgregar(ActionEvent ae) {
		try {
			controladora.anhadirPartido(equipoLocal.getText(), equipoVisitante.getText(), Integer.parseInt(golLocal.getText()), Integer.parseInt(golVisitante.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}

}
