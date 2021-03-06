package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
    
    private Dictionary dizionario = new Dictionary();
    
    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
    	txtWord.clear();
    	String s = txtWord.getText().toLowerCase();
    	StringTokenizer st = new StringTokenizer(s, " ");
    	
    	String Word = st.nextToken();
    	String translation = null;
    	if(st.hasMoreTokens())
    		translation=st.nextToken();
    	
    	if(translation!=null) {
    		if (!Word.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserisci solo lettere");
    		}
    		else {
    			dizionario.addWord(Word, translation);
    			txtResult.setText("Aggiunta: " + Word + " " + translation);
    		}
    	}
    	else {
    		String traduzione = dizionario.translate(Word);
    		if(traduzione==null)
    			txtResult.setText("Parola non presente nel dizionario");
    		else
    			txtResult.setText("La traduzione � : " + traduzione);
    	}    	
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtWord.clear();
    	dizionario.resetDictionary();
    }
  
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
}
