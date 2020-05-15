package GestionAlarme;

import java.util.EventListener;

public interface GazListener extends EventListener{
	
	public String attentionGaz(GazEvent event);
}
