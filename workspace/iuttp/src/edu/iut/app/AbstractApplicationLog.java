package edu.iut.app;

import java.util.ArrayList;

public abstract class AbstractApplicationLog implements IApplicationLog {

	protected String message;
	/** TP1 : Tableau au sens des collections **/
	protected ArrayList<IApplicationLogListener> listeners;
	
	public AbstractApplicationLog() {
		message = null;
		listeners = new ArrayList<IApplicationLogListener>();
	}
	
    /** TP1 : Fonction venant de l'interface par héritage */
	public abstract void setMessage(String message);
	
	public String getMessage(){
		return this.message;
	}
	
	public void addListener(IApplicationLogListener listener){
		listeners.add(listener);
	}
	
	public IApplicationLogListener[] getApplicationLogListeners(){
		IApplicationLogListener[] tabListeners = new IApplicationLogListener[listeners.size()];
		for(int i = 0; i < listeners.size(); i++) {
			tabListeners[i] = listeners.get(i);
		}
		return tabListeners;
	}
	

	/** Listener action */
	protected void fireMessage(String level, String message) {
		for (IApplicationLogListener listener_i : listeners) {
			listener_i.newMessage(level, message);
		}
	}
}