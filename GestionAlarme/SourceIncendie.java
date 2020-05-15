package GestionAlarme;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SourceIncendie{
	private ArrayList<IncendieListener> listenerList = new ArrayList<IncendieListener>(); 
	
		public void addIncendieListener(IncendieListener listener) {
			if (listener == null) {
				return;
			}
			listenerList.add(listener);
		}
		
	
	 public void removeIncendieListener(IncendieListener listener) {
		if(listener == null) {
			return;
		}
		listenerList.remove(listener);
	}
	public void generateIncendieEvent(int id, String localisation, int importance,boolean fume) {
		IncendieEvent event = new IncendieEvent(this, localisation,importance,fume);
		for(IncendieListener ie : listenerList) {
			ie.attentionFume(event);
		}
		
		
	}
	 


}
