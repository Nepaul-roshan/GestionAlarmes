package GestionAlarme;

import java.util.EventListener;

public interface RadiationListener extends EventListener{
	
	public String attentionRadiation(RadiationEvent event);

}
