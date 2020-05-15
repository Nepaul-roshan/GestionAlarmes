package GestionAlarme;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Moniteur implements IncendieListener,GazListener,RadiationListener {
	private String type;

	public Moniteur(String type) {
		super();
		this.type = type;
	}
	
	
	public String getType() {
		return type;
	}


	@Override
	public String attentionFume(IncendieEvent event) {
		if(event.isFume()) {
			return "Attention il y a possiblement un feu ! dans le lieu " + event.getLocalisation()+" d'importance "+ event.getImportance();
			
		}
		else {
			return "R.A.S";
		}
	}
	@Override
	public String attentionGaz(GazEvent event) {
		if(event.getImportance()>=1) {
			return "Attention Alerte Gaz! dans le lieu " + event.getLocalisation()+" d'importance "+ event.getImportance()+" et de type "+ event.getType();
		}
		else{
			return"R.A.S";
		}
	}


	@Override
	public String attentionRadiation(RadiationEvent event) {
		// TODO Auto-generated method stub
		if(event.getImportance()>=1) {
			return "Attention Alerte Radiation! dans le lieu " + event.getLocalisation()+" d'importance "+ event.getImportance()+" et de niveau "+ event.getNiveau();
		}
		else {
			return "R.A.S";
		}
	}
}
