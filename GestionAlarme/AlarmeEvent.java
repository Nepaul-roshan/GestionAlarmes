package GestionAlarme;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.EventObject;
import java.util.GregorianCalendar;

public class AlarmeEvent extends EventObject{
	private String localisation;
	private int importance;
	
	public AlarmeEvent(Object source,String localisation,int importance) {
		super(source);
		if(importance>=1 & importance<=3) {
			this.localisation = localisation;
			this.importance= importance;
			
		}
		else {
			System.out.println("erreur de niveau d'imporatance il doit être compris en 1 ET 3");
		}
		
	}

	
	public String getLocalisation() {
		return localisation;
	}

	
	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}
	
	
	
	

}