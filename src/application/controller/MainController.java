package application.controller;

import java.net.URL;
import java.util.ResourceBundle;
import application.model.Partita;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class MainController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnNuovaPartita;

	@FXML
	private TextField textTentativo;

	@FXML
	private Button btnProva;

	@FXML
	private TextArea textSchermo;

	@FXML
	private TextField textCorrenteTentativo;

	@FXML
	private TextField textUltimoTentativo;

	private Partita partita;

	@FXML
	void doProva(ActionEvent event) {
		partita.setTentativoCorrente(partita.getTentativoCorrente() + 1);
		String rigaTentativo = String.format("%s)\t%s\t", partita.getTentativoCorrente(), partita.getTentativo());
		
		if (partita.getRisultato()<0) {
			rigaTentativo=rigaTentativo+"Il numero é più piccolo\n";
		} else if (partita.getRisultato()>0) {
			rigaTentativo=rigaTentativo+"Il numero é più grande\n";
		} else {	
			rigaTentativo=rigaTentativo+"\nHai vinto";
			partita.fine();
		}
		
		if (partita.getTentativoCorrente() >= partita.getUltimoTentativo()) {
			rigaTentativo=rigaTentativo+"\nHai perso";
			partita.fine();
		} 

		textSchermo.setText(textSchermo.getText() + rigaTentativo);
	}

	@FXML
	void lanciaNuovaPartita(ActionEvent event) {
		textSchermo.setText("");
		textCorrenteTentativo.setText("0");
		textTentativo.setText("");
		partita.avvia();

	}

	@FXML
	void initialize() {
		assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'main.fxml'.";
		assert textTentativo != null : "fx:id=\"textTentativo\" was not injected: check your FXML file 'main.fxml'.";
		assert btnProva != null : "fx:id=\"textProva\" was not injected: check your FXML file 'main.fxml'.";
		assert textSchermo != null : "fx:id=\"textSchermo\" was not injected: check your FXML file 'main.fxml'.";
	}

	/**
	 * @return the partita
	 */
	public Partita getPartita() {
		return partita;
	}

	/**
	 * @param partita the partita to set
	 */
	public void setPartita(Partita partita) {
		this.partita = partita;
		btnNuovaPartita.disableProperty().bindBidirectional(partita.attivaProperty());
		textCorrenteTentativo.textProperty().bindBidirectional(partita.tentativoCorrenteProperty(),
				new NumberStringConverter());
		textUltimoTentativo.textProperty().bindBidirectional(partita.ultimoTentativoProperty(),
				new NumberStringConverter());
		btnProva.disableProperty().bind(partita.attivaProperty().not());
		textTentativo.textProperty().bindBidirectional(partita.tentativoProperty(), new NumberStringConverter());
		textTentativo.disableProperty().bind(partita.attivaProperty().not());
		textSchermo.disableProperty().bind(partita.attivaProperty().not());
		
	}
}
