package GestionAlarme;

import java.util.EventObject;

public class IncendieEvent extends AlarmeEvent{
	private boolean fume;
	

	public IncendieEvent(Object source, String localisation,int importance, boolean fume) {
		super(source, localisation,importance);
		this.source = new SourceIncendie();
		this.fume = fume;
	}


	public boolean isFume() {
		return fume;
	}


	public void setFume(boolean fume) {
		this.fume = fume;
	}

	public String toString() {
		return "Alarme Incendie dans le lieu " + getLocalisation() + ",niveau d'importance "
				+ getImportance();
	}


	
	
	
	

}
