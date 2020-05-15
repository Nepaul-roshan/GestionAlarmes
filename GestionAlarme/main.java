package GestionAlarme;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class main {
	
	public static void main(String[] args) throws Exception{
		// Apply a new look'n feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		UIManager.put("JOptionPane.font", new Font("yourFontName", Font.BOLD, 30));
		Moniteur pompier  = new Moniteur("A");
	    Moniteur ecologie = new Moniteur("B");
		//Start the window
		SimulationFrame fen = new SimulationFrame("Simulation des alarmes");
		MonitorWindow mon = new MonitorWindow("Caserne");
		fen.monitors = mon;
		mon.monitorList.add(pompier);
		mon.monitorList.add(ecologie);
	  }       
}

