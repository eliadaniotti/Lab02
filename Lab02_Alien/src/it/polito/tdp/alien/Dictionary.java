package it.polito.tdp.alien;

import java.util.*;

public class Dictionary {
	
	List<Word> dizionario;
	
	public Dictionary() {
		dizionario = new LinkedList<Word>();
	}
	
	public void resetDictionary() {
		dizionario.clear();
	}
	
	public void addWord(String alienWord , String translation) {
		Word parola = new Word(alienWord, translation);
		if(dizionario.contains(parola)) 
			dizionario.get(dizionario.indexOf(parola)).setTranslation(translation);
		else
			dizionario.add(parola);
	}
	
	public String translate(String alienWord) {
		for (Word w : dizionario)
			if(w.getAlienWord().equals(alienWord))
				return w.getTranslation();
		return null;
	}

}
