package edu.iut.app;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationSession {
	
	// Exercice 1 : Gérer l'internationation
	protected ResourceBundle resourceBundle;
	protected Locale locale;
	
	
	// Exercice 2 : Logger
	protected Logger sessionGuiLogger;
	protected Logger sessionExceptionLogger;


	private static ApplicationSession session = null;
	private ApplicationSession() {
		/* Definir US comme locale par défaut */
		locale = new Locale("us", "EN");
		locale = Locale.getDefault();
		resourceBundle = ResourceBundle.getBundle("edu.iut.resources.strings.res");
		sessionGuiLogger = Logger.getLogger("Logger");
		sessionGuiLogger.setLevel(Level.ALL);
		sessionExceptionLogger = Logger.getLogger("Exception");
		sessionExceptionLogger.setLevel(Level.ALL);
	}
	
	
	static public ApplicationSession instance() {
		if (session == null) {			
			session = new ApplicationSession();
		}
		return session;
	}
	
	public Logger getGUILogger() {
		return sessionGuiLogger;
	}
	public Logger getExceptionLogger() {
		return sessionExceptionLogger;
	}
	
	public void setLocale(Locale locale){
		this.locale = locale;
		Locale.setDefault(this.locale);
		resourceBundle=ResourceBundle.getBundle("edt.iut.resources.strings.res");
	}
	
	public String getString(String key) {
		return resourceBundle.getString(key);
	}
	
	
}
