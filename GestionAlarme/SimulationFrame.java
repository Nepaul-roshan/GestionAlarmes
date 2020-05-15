package GestionAlarme;

	
	
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SimulationFrame extends JFrame
                             implements ActionListener {


    private JButton launcher = new JButton("Declencher");

    private JTextField building = new JTextField("Localisation");

    private JComboBox<Integer> critLevel = new JComboBox<>();

    private JComboBox<String> alarmType = new JComboBox<>();

    JPanel moreData  = new JPanel();

    private JTextField gazType = new JTextField("C02, Azote..");

    private JComboBox<Integer>  radiationLevel = new JComboBox();
    
    private Font  f1  = new Font(Font.DIALOG, Font.PLAIN,  32);
    
    public MonitorWindow monitors;


    
    public SimulationFrame(String title)
    {
        super(title);

        this.setSize(new Dimension(800,1000));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.initMenu();
        this.initForm();
        this.setVisible(true);
    }


    
    public void initMenu()
    {
        /*----------------------------------
            BARRE DE MENU
        ----------------------------------*/
        JMenuBar menuBar = new JMenuBar();
        
        
        this.setJMenuBar(menuBar);

        /*----------------------------------
            MENU
        ----------------------------------*/
        JMenu menu = new JMenu("Utils");
        menuBar.setFont(f1);
        menuBar.add(menu);

        /*----------------------------------
            SOUS-MENU
        ----------------------------------*/
        JMenuItem quit = new JMenuItem("Quitter");
        quit.setFont(f1);
        menu.add(quit);

        /*----------------------------------
            ACTIONS
        ----------------------------------*/
        quit.setActionCommand("quit");
        quit.addActionListener(this);
    }

    
    
    public void initForm()
    {
        /* ---------------------------------------
                    LOCALISATION
        --------------------------------------- */
        JPanel locPanel = new JPanel();
        JLabel locLabel = new JLabel("Location :");
        building.setBounds(128, 28, 86, 20);
        building.setColumns(10);
        locLabel.setPreferredSize(new Dimension(200,50));
        locLabel.setFont(f1);
        building.setPreferredSize(new Dimension(800,50));
        building.setFont(f1);
        
        locPanel.add(locLabel);
        locPanel.add(building);

        /* ---------------------------------------
                    NIVEAU D'IMPORTANCE
        --------------------------------------- */
        JPanel critPanel = new JPanel();
        JLabel critLabel = new JLabel("Critical level :");
        Integer[] lvls = {1,2,3};

        for(int i = 0; i < 3; i++)
            critLevel.addItem(lvls[i]);
        
        critLabel.setPreferredSize(new Dimension(300,50));
        critLabel.setFont(f1);
        critLevel.setPreferredSize(new Dimension(80,50));
        critLevel.setFont(f1);

        critPanel.add(critLabel);
        critPanel.add(critLevel);

        /* ---------------------------------------
                     TYPE D'ALARME
        --------------------------------------- */
        JPanel alarmPanel = new JPanel();
        JLabel alarmLabel = new JLabel("Alarm Type :");
        String[] types = {"Fire", "Gaz", "Radiation"};      // UPGRADE : lire les types depuis XML ?

        for(int i = 0; i < 3; i++)
            alarmType.addItem(types[i]);
        alarmLabel.setPreferredSize(new Dimension(300,50));
        alarmLabel.setFont(f1);
        alarmType.setPreferredSize(new Dimension(300,50));
        alarmType.setFont(f1);
        alarmType.addActionListener(this);
        

        alarmPanel.add(alarmLabel);
        alarmPanel.add(alarmType);
        
        /* ---------------------------------------
                BOUTON DECLENCHEUR
        --------------------------------------- */
        JPanel buttonPanel = new JPanel();
        launcher.setPreferredSize(new Dimension(300,50));
        launcher.setFont(f1);
        buttonPanel.add(launcher);
        
        
        
    
        /* ---------------------------------------
                    PANEL PRINCIPAL
        --------------------------------------- */
        this.getContentPane().add(locPanel);
        this.getContentPane().add(critPanel);
        this.getContentPane().add(alarmPanel);
        this.getContentPane().add(moreData);
        this.getContentPane().add(buttonPanel);

        /* ---------------------------------------
                    EVENEMENTS
        --------------------------------------- */
        launcher.setActionCommand("alarm");             // clic sur le bouton de declenchement de l'alarme
        launcher.addActionListener(this);
        alarmType.setActionCommand("typeSelected");     // selection d'un type d'alarme
        alarmType.addActionListener(this);
    }


	@Override
	public void actionPerformed(ActionEvent event) {
		String typeSelected = "";
		int lvl             = 0;                                                // niveau critique
        String loc          = "";                                               // localisation
       
		// TODO Auto-generated method stub
		if(event.getActionCommand().equals("typeSelected"))
        {
            typeSelected = this.alarmType.getSelectedItem().toString();

            // INCENDIE
            if(typeSelected == "Fire")
            {
                this.setVisible(false);
                moreData.removeAll();
                this.setVisible(true);
            }
            
            // GAZ
            if(typeSelected == "Gaz")
            {
                this.setVisible(false);
                moreData.removeAll();       

                gazType.setBounds(128, 28, 86, 20);
                gazType.setColumns(10);
                JLabel gazLabel = new JLabel("Gaz type");
                gazLabel.setPreferredSize(new Dimension(300,50));
                gazLabel.setFont(f1);
                gazType.setPreferredSize(new Dimension(300,50));
                gazType.setFont(f1);
                
                moreData.add(gazLabel);
                moreData.add(gazType);

                this.setVisible(true);
            }

            // RADIATION
            if(typeSelected == "Radiation")
            {
                this.setVisible(false);
                moreData.removeAll();

                radiationLevel.setBounds(128, 28, 86, 20);
                JLabel radLabel = new JLabel("Radiation level");
                radLabel.setPreferredSize(new Dimension(300,50));
                radLabel.setFont(f1);
                radiationLevel.setPreferredSize(new Dimension(300,50));
                radiationLevel.setFont(f1);
                
                

                for(int i = 0; i <100; i++)
                	radiationLevel.addItem(i+1);
                
                moreData.add(radLabel);
                moreData.add(radiationLevel);

                this.setVisible(true);
            }
        }
	
	if (event.getActionCommand().equals("alarm"))
    {
        typeSelected = this.alarmType.getSelectedItem().toString();
        lvl          = this.critLevel.getSelectedIndex()+1;
        loc          = this.building.getText();
        
        
        //date de declenchement
        Date current = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT);

        //FIRE ALARM
        if(typeSelected == "Fire") 
        {
        	SourceIncendie f = new SourceIncendie();
            IncendieEvent feu = new IncendieEvent(event.getSource(),loc,lvl,true);
            Moniteur ecologie = new Moniteur("B");
            f.addIncendieListener(ecologie);
            
            JOptionPane jop2 = new JOptionPane();
            jop2.setPreferredSize(new Dimension(500, 200));
            jop2.setFont(f1);
            jop2.setPreferredSize(new Dimension(480,500));
            String s = "Alerte de type "+ typeSelected +" " + shortDateFormat.format(current);
            this.monitors.getDlm().addElement(s);
            this.monitors.getListeInfo().add(ecologie.attentionFume(feu));
            jop2.showMessageDialog(this, "<html><span style='font-size:18'>"+ecologie.attentionFume(feu), "Attention", JOptionPane.WARNING_MESSAGE);
            
                    }
            
        //GAZ ALARM
        else if(typeSelected == "Gaz") 
        {
        	String gType = this.gazType.getText();
        	SourceGaz g = new SourceGaz();
            GazEvent gaz  = new GazEvent(event.getSource(),loc,lvl,gType);
            
            Moniteur ecologie = new Moniteur("B");
            g.addGazListener(ecologie);
            
          
            
            JOptionPane jop2 = new JOptionPane();
            jop2.setPreferredSize(new Dimension(500, 200));
            jop2.setFont(f1);
            jop2.setPreferredSize(new Dimension(480,500));
            String s = "Alerte de type " +typeSelected +" " + shortDateFormat.format(current);
            this.monitors.getDlm().addElement(s);
            this.monitors.getListeInfo().add(ecologie.attentionGaz(gaz));
            
            jop2.showMessageDialog(this, "<html><span style='font-size:18'> "+ecologie.attentionGaz(gaz) ,"Attention", JOptionPane.WARNING_MESSAGE);
            
            
        }

        //RADIATION ALARM
        else if(typeSelected == "Radiation") 
        {
        	
            int radLvl = this.radiationLevel.getSelectedIndex()+1;
            if(radLvl < 0 || radLvl > 100) {
                int option = JOptionPane.showConfirmDialog(this,
                                                           "Le niveau de radiation doit être compris entre 0 et 100",
                                                           "Attention !",
                                                           JOptionPane.WARNING_MESSAGE);
            }
            else {
            	int radLvl1 = this.radiationLevel.getSelectedIndex()+1;
            	
            	SourceGaz r = new SourceGaz();
                RadiationEvent rad  = new RadiationEvent(event.getSource(),loc,lvl,radLvl1);
                
                Moniteur ecologie = new Moniteur("B");
                r.addGazListener(ecologie);
                
                JOptionPane jop2 = new JOptionPane();
                jop2.setPreferredSize(new Dimension(500, 200));
                jop2.setFont(f1);
                jop2.setPreferredSize(new Dimension(480,500));
                String s ="Alerte de type "+ typeSelected +" " + shortDateFormat.format(current);
                this.monitors.getDlm().addElement(s);
                this.monitors.getListeInfo().add(ecologie.attentionRadiation(rad));
                jop2.showMessageDialog(this, "<html><span style='font-size:32'> "+ecologie.attentionRadiation(rad) ,"Attention", JOptionPane.WARNING_MESSAGE);
                
            }
        }
    }

}
}



















