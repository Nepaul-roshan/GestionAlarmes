package GestionAlarme;

import java.util.ArrayList;

public class SourceGaz {
	private ArrayList<GazListener> listenerList = new ArrayList<GazListener>() ;
	
	public void addGazListener(GazListener listener) {
		if (listener == null) {
			return;
		}
		listenerList.add(listener);
	}
	

	public void removeGazListener(GazListener listener) {
		if(listener == null) {
			return;
		}
		listenerList.remove(listener);
	}
	public void generateGazEvent(int id, String localisation,int importance,String type) {
		GazEvent event = new GazEvent(this, localisation,importance,type);
		for(GazListener ie : listenerList) {
			ie.attentionGaz(event);
		}
		
		
	}

}
