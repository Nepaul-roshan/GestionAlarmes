package GestionAlarme;

import java.util.EventListener;

public interface IncendieListener extends EventListener{
	
	public String attentionFume(IncendieEvent event) ;

}
