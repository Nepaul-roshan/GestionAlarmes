package GestionAlarme;

import java.util.ArrayList;

public class SourceRadiation {
	private ArrayList<RadiationListener> listenerList = new ArrayList<RadiationListener>(); 
	
	public void addRadiationListener(RadiationListener listener) {
		if (listener == null) {
			return;
		}
		listenerList.add(listener);
	}
	

	 public void removeRadiationListener(RadiationListener listener) {
		if(listener == null) {
			return;
		}
		listenerList.remove(listener);
	}
	public void generateRadiationEvent( String localisation,int importance,int niveau) {
		RadiationEvent event = new RadiationEvent(this, localisation,importance,niveau);
		for(RadiationListener ie : listenerList) {
			ie.attentionRadiation(event);
		}
		
		
	}
 


}

