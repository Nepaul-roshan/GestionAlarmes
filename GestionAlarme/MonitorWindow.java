package GestionAlarme;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MonitorWindow extends JFrame
                           implements ActionListener, ListSelectionListener {

  private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

 
  private Dimension frameSize = new Dimension(800, 1000);

  private DefaultListModel<String> dlm = new DefaultListModel<String>();
  
  private ArrayList<String> listeInfo = new ArrayList<String>();
  
  private JList<String> liste = new JList<String>(this.dlm);

  private JButton archive = new JButton("Traitée");

  private JTextPane infosDisplayer = new JTextPane();

  public ArrayList<Moniteur> monitorList = new ArrayList<Moniteur>();
  
  private Font  f1  = new Font(Font.DIALOG, Font.PLAIN,  32);
  

  



  
  

  public MonitorWindow(String title) throws Exception
  {
    super(title);
    setSize(frameSize);
    setResizable(false);
    setLocationRelativeTo(null);
    setAlwaysOnTop(false);
    this.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
    

    this.initContent();
    


    this.pack();
    setVisible(true);
  }


 
  public void initContent()
  {
    /*----------------------------------
        SOUS PANELS
    -----------------------------------*/
    JPanel left = new JPanel();
    left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
    JPanel right = new JPanel();

    /*----------------------------------
        LISTE DES EVENTS
    ----------------------------------*/
    
    
    JPanel listPanel = new JPanel();
    liste.setPreferredSize(new Dimension(580, 190));
    liste.setFont(f1);
    
    this.liste.addListSelectionListener(this);
    this.liste.setModel(dlm);
    JScrollPane scroller = new JScrollPane(liste);
    scroller.setPreferredSize(new Dimension(600, 180));
    listPanel.add(scroller);
    
    
    

    /*----------------------------------
        BOUTONS
    ----------------------------------*/
    JPanel buttonPanel = new JPanel(new FlowLayout());
    archive.setPreferredSize(new Dimension(300,50));
    archive.setFont(f1);
    buttonPanel.add(archive);
    this.archive.setEnabled(false);
    //ACTION TRAITEE
    this.archive.setActionCommand("Traitée");
    this.archive.addActionListener(this);


    /*----------------------------------
        PANNEAU DROIT AFFICHAGE DES INFOS
    ----------------------------------*/
    JPanel displayPanel = new JPanel();
    this.infosDisplayer.setPreferredSize(new Dimension(600, 200));
    this.infosDisplayer.setFont(f1);
    this.infosDisplayer.setContentType("text/html");
    displayPanel.add(this.infosDisplayer);

    /*----------------------------------
        LEFT PANEL
    ----------------------------------*/
    left.add(listPanel);
    left.add(buttonPanel);

    /*----------------------------------
        RIGHT PANEL
    ----------------------------------*/
    right.add(displayPanel);

    /*----------------------------------
        CONTENEUR PRINCIPAL
    ----------------------------------*/
    this.getContentPane().add(left);
    this.getContentPane().add(right);
  }
/*
 * ACTION LORS DE LA SELECTION D'UN ELEMENT DE LA LISTE 
 */

@Override
public void valueChanged(ListSelectionEvent e) {
	// TODO Auto-generated method stub
	if(e.getValueIsAdjusting() == false) 
    {
      //AUCUN INDEX SELECTIONNNE
      if(liste.getSelectedIndex() == -1 || this.dlm.size() == 0) 
      {
        this.infosDisplayer.setText("");   // nettoyage du panneau d'affichage
        this.archive.setEnabled(false);    // desactivation des boutons
      }
      //AFFICHAGE DE SES INFORMATIONS DANS LE PANNEAU
      else {
        String message = this.listeInfo.get(liste.getSelectedIndex()); // informations de l'evenement
        this.infosDisplayer.setText("");
        this.infosDisplayer.setText(message);   // affichage des informations       
        this.archive.setEnabled(true);          // activation des boutons
      }
    }
	
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getActionCommand().equals("Traitée")) {
		this.listeInfo.remove(liste.getSelectedIndex());
		this.dlm.remove(liste.getSelectedIndex());
		
		
	}
	
}





public DefaultListModel<String> getDlm() {
	return dlm;
}


public void setDlm(DefaultListModel<String> dlm) {
	this.dlm = dlm;
}


public ArrayList<String> getListeInfo() {
	return listeInfo;
}


}