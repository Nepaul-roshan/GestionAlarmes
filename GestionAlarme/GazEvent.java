package GestionAlarme;

import java.util.EventObject;

public class GazEvent extends AlarmeEvent{
	private String type;
	
	public GazEvent(Object source, String localisation,int importance, String type) {
		super(source, localisation,importance);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Alarme Gaz dans le lieu " + getLocalisation() + ",niveau d'importance "
				+ getImportance();
	}
	

}
