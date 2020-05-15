package GestionAlarme;

public class RadiationEvent extends AlarmeEvent{
	private int niveau;

	public RadiationEvent(Object source, String localisation,int importance, int niveau) {
		super(source, localisation,importance);
		if(niveau<=100 & niveau>1) {
			this.niveau = niveau;
			
		}
		else {
			System.out.println("erreur mauvais niveau de radiation");
		}
	}

	@Override
	public String toString() {
		return "Alarme Radiation dans le lieu " + getLocalisation() + ",niveau d'importance "
				+ getImportance();
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}


}
