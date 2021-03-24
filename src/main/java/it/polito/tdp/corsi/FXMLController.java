/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtPeriodo"
    private TextField txtPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorso"
    private TextField txtCorso; // Value injected by FXMLLoader

    @FXML // fx:id="btnCorsiPerPeriodo"
    private Button btnCorsiPerPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="btnNumeroStudenti"
    private Button btnNumeroStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnStudenti"
    private Button btnStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnDivisioneStudenti"
    private Button btnDivisioneStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML
    void corsiPerPeriodo(ActionEvent event) {
    	
    	txtRisultato.clear();	
    	String periodoString = txtPeriodo.getText();
    	Integer periodo;
    	
    	try {
    		periodo = Integer.parseInt(periodoString);
    	} catch (NumberFormatException e) {
    		txtRisultato.setText("Devi inserire il numero 1 o 2 per il periodo didattico");
    		txtPeriodo.clear();
    		return ;
    	} catch (NullPointerException npe) {
    		txtRisultato.setText("Devi inserire il numero 1 o 2 per il periodo didattico");
    		txtPeriodo.clear();
    		return ;
    	}
    	
    	if (periodo > 2 || periodo < 1) {
    		txtRisultato.setText("Devi inserire il numero 1 o 2 per il periodo didattico");
    		txtPeriodo.clear();
    		return ;
    	}
    	
    	List <Corso> corsi = this.model.getCorsiByPeriodo(periodo);
    	
    	for (Corso cc: corsi) {
    		txtRisultato.appendText(cc.toString() + "\n");
    	}
    	corsi.clear();
    	txtPeriodo.clear();
    	
    }

    @FXML
    void numeroStudenti(ActionEvent event) {
    	
    	txtRisultato.clear();	
    	String periodoString = txtPeriodo.getText();
    	Integer periodo;
    	
    	try {
    		periodo = Integer.parseInt(periodoString);
    	} catch (NumberFormatException e) {
    		txtRisultato.setText("Devi inserire il numero 1 o 2 per il periodo didattico");
    		txtPeriodo.clear();
    		return ;
    	} catch (NullPointerException npe) {
    		txtRisultato.setText("Devi inserire il numero 1 o 2 per il periodo didattico");
    		txtPeriodo.clear();
    		return ;
    	}
    	
    	if (periodo > 2 || periodo < 1) {
    		txtRisultato.setText("Devi inserire il numero 1 o 2 per il periodo didattico");
    		txtPeriodo.clear();
    		return ;
    	}
    	
    	Map <Corso, Integer> corsiIscrizioni = this.model.getIscrittibyPeriodo(periodo);
    	
    	for (Corso c : corsiIscrizioni.keySet()) {
    		txtRisultato.appendText(c.toString());
    		Integer n = corsiIscrizioni.get(c);
    		txtRisultato.appendText("\t"+ n+ "\n");
    	}
    }

    @FXML
    void stampaDivisione(ActionEvent event) {

    }

    @FXML
    void stampaStudenti(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCorsiPerPeriodo != null : "fx:id=\"btnCorsiPerPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNumeroStudenti != null : "fx:id=\"btnNumeroStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStudenti != null : "fx:id=\"btnStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDivisioneStudenti != null : "fx:id=\"btnDivisioneStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
    
    
}