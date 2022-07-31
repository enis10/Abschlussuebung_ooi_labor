/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package VierGewinnt;

import static VierGewinnt.VierGewinntTest.i;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import jdomreader.StateReader;
import jdomreader.StateSaver;


/**
 *
 * @author anisdoudech
 */
public class SettingsConsole  extends JFrame implements ActionListener, Observer,ChangeListener{
    
    
    
   //Button as a global component 
    JButton button;
    JButton saveState;
    JButton loadState;
    
    
    JSlider slider,slider2;
    JPanel panel ,panel2;
    JLabel label,label2 ,l;
    JLabel labelTiefe,labelTiefe2;
    JButton btn2, btnSavestate, btnLoadState;
    JTextField p1Name;
    JTextField p2Name;
    JRadioButton restart, sound;
    
   
    
    SettingsConsole(){
        
        
        //Spieler 1 Name ändern
        button = new JButton();
        button.setBounds(80,130,100,50);
        button.setText("Name Ändern");
        button.addActionListener(this);
        
        //Text Field 1
    
        p1Name = new JTextField();
        p1Name.setPreferredSize(new Dimension(260,40));
        p1Name.setFont(new Font("Consolas", Font.PLAIN,20));
        p1Name.setText(Utils.getInstance().getPlayer1());
        p1Name.setBounds(210,130,200,50);
        p1Name.setBackground(Color.GRAY);
        
        //Spieler 2 Name ändern
        btn2 = new JButton();
        btn2.setBounds(80,180,100,50);
        btn2.setText("Name Ändern");
        btn2.addActionListener(this);
        
        
        
        
        
        //Text Field 2
        p2Name = new JTextField();
        p2Name.setPreferredSize(new Dimension(260,40));
        p2Name.setFont(new Font("Consolas", Font.PLAIN,20));
        p2Name.setText(Utils.getInstance().getPlayer2());
        p2Name.setBounds(210,180,200,50);
        
  
        
        
        //Label für den nächsten Spieler
        label = new JLabel();
        label.setBounds(130,180,320,300);
        label.setText(Utils.getPlayer1()+" turn !!");
        label.setForeground(new Color(204, 0, 0));
        label.setFont(new Font("MV Boli", Font.PLAIN, 18));
        
        
        //Restart Button
        restart = new JRadioButton("Restart");
        restart.setBounds(80,250,100,50);
        restart.addActionListener(this);
        
        //Sound On Off Button
        
        sound = new JRadioButton("Ton aus ");
        sound.setBounds(180,250,100,50);
        sound.addActionListener(this);
        
        //Button um Spielstand zu speichern
        btnSavestate = new JButton("Spielstand speichern");
        btnSavestate.setBounds(90,310,150,50);
        btnSavestate.addActionListener(this);
        //Buttom um Spielstand zu laden
        btnLoadState = new JButton("Spielstand Laden");
        btnLoadState.setBounds(260,310,150,50);
        btnLoadState.addActionListener(this);
        
        
  
      
     
        
        //Slider für die Einstellung der Tiefe
         slider = new JSlider(JSlider.HORIZONTAL,0,10,Utils.getInstance().getDepth());
         slider.setPaintTicks(true);
         slider.setMajorTickSpacing(1);
         slider.setPaintLabels(true);
         slider.setFont(new Font("MV Boli", Font.PLAIN, 11));
         slider.addChangeListener(this);
         
         labelTiefe = new JLabel();
         labelTiefe.setFont(new Font("MV Boli", Font.PLAIN, 15));
         labelTiefe.setText("        Tiefe "+Utils.getPlayer2()+": "+ slider.getValue());
        //Panel enthält Slider
        panel = new JPanel();
       
       
        
         l = new JLabel();
      
        //Slider für die Einstellung der Tiefe
         slider2 = new JSlider(JSlider.HORIZONTAL,0,10,Utils.getInstance().getDepth());
         slider2.setPaintTicks(true);
         slider2.setMajorTickSpacing(1);
         slider2.setPaintLabels(true);
         slider2.setFont(new Font("MV Boli", Font.PLAIN, 11));
         slider2.addChangeListener(this);
         
         labelTiefe2 = new JLabel();
         l = new JLabel();
        
         l.setText("Tiefe "+Utils.getPlayer1()+": 5");
         l.setBounds(40,0,20,200);
         l.setFont(new Font("MV Boli", Font.PLAIN, 15));
         
         
         labelTiefe2.setFont(new Font("MV Boli", Font.PLAIN, 15));
         labelTiefe2.setText("       ");
        //Panel enthält Slider
        panel2 = new JPanel();
        
        
        
  
        
 
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        this.setSize(500,500);
        this.setTitle("Settings");
        this.add(button);
        this.add(p1Name);
        this.add(restart);
        this.add(sound);
        this.add(btnSavestate);
        this.add(btn2);
        if(  (Utils.getInstance().getC1Mode() == "C1B") ||(Utils.getInstance().getC1Mode() == "C1AB")|| (Utils.getInstance().getC1Mode() == "C1MM")  ){
            button.setVisible(false);
            p1Name.setEditable(false);
        }
        this.add(p2Name);
        
        this.add(btnLoadState);
        if ( (Utils.getInstance().getMode() == "PCAB" || Utils.getInstance().getMode() == "PCMM"|| Utils.getInstance().getMode() == "PCB")  ){
            p2Name.setEditable(false);
            btn2.setVisible(false);
            if(Utils.getInstance().getMode() == "PCAB" || Utils.getInstance().getMode() == "PCMM"){
            panel.add(labelTiefe);
            panel.add(slider);
            }
        }
        if((Utils.getInstance().getC1Mode() == "C1AB" || Utils.getInstance().getC1Mode() == "C1MM") ){
        panel.add(labelTiefe2);
        panel.add(l);
        panel.add(slider2); 
        }
     
        
        this.add(panel);
     
       
        
        
        this.repaint();
        
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== button){
          Utils.setPlayer1( p1Name.getText());
       }
        if(e.getSource()== btn2){
          Utils.setPlayer2( p2Name.getText());
        }
        if(e.getSource() == restart){
            Utils.getInstance().setRestart(true);  
            Utils.getInstance().setTurn("1");
        }
      
        if(e.getSource() == sound){
             if (sound.isSelected()){
          Utils.setSound(false);
          }else
          Utils.setSound(true);
        }
        if(e.getSource() == btnSavestate){
            
            String path = "";
            
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("XML FILES", "xml", "xml");
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogTitle("Speichern Sie Ihr Spielstand"); 
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
           File fileToSave = fileChooser.getSelectedFile();
           
           
           if (!(fileToSave.isDirectory() || fileToSave.getName().toLowerCase().endsWith(".xml"))) {
               showMessageDialog(null,"Nur xml Datein können gespeichert werden." +"Der Dateiname soll mit .xml enden.","Fehler",1);     
           }
           path =  fileToSave.getAbsolutePath();
         
}
            StateSaver state = new StateSaver();
        for (int row = 0; row < 6; row++){
			
			for (int col = 0; col < 7; col++){
                           byte[][] board = Utils.getBoard();
                           state.setPosition(row,col,board[row][col],Integer.valueOf(Utils.getTurn())%2 +1);					
			}}
        
        state.writeXML(path);
        }
        if(e.getSource() == btnLoadState){
             String path = "";
            
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("XML FILES", "xml", "xml");
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogTitle("Laden Sie Ihr Spielstand");   
            int userSelection = fileChooser.showOpenDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
           File fileToSave = fileChooser.getSelectedFile();
           path =  fileToSave.getAbsolutePath();
         }
              StateReader state = new StateReader(path);
              state.ReadData();
              Utils.getInstance().setBoard2(state.getState()); 
              Utils.getInstance().setCurrentPlayer(state.getCurrentPlayer());
              if (Utils.getInstance().getCurrentPlayer() == (byte)1){
                  System.out.println(Utils.getInstance().getCurrentPlayer() == (byte)1);
                  System.out.println(Utils.getInstance().getCurrentPlayer());
                  Utils.getInstance().setTurn("1");
                  
              }else{
                  Utils.getInstance().setTurn("2");
              }
              Utils.getInstance().setChangeState(true);
            
        }
    }
    
    
//hier geht es darum, anzuzeigen, welcher Spieler die nächste Runde spielen soll
  @Override
        public void update(Observable o, Object arg) {
          
      restart.setSelected(false);
     
          
      
      if(null == arg){
            p1Name.setBackground(Color.BLUE);
            p1Name.setForeground(Color.white);
          
      }
      else {
          if("1".equals(arg.toString())){
           p1Name.setBackground(Color.BLUE);
           p1Name.setForeground(Color.white);
           p2Name.setBackground(Color.white);
           p2Name.setForeground(Color.BLACK);
          }
          else {
            p1Name.setBackground(Color.WHITE);
            p1Name.setForeground(Color.BLACK);
            p2Name.setBackground(Color.RED);
            p2Name.setForeground(Color.white);
          }
      }
              
        }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == slider){
        labelTiefe.setText("        Tiefe "+Utils.getPlayer2()+": "+ slider.getValue());
        Utils.getInstance().setDepth(slider.getValue());
        }  
          if(e.getSource()== slider2){
            if (Utils.getInstance().getC1Mode() == "C1MM"){
             l.setText("Tiefe "+Utils.getPlayer1()+": "+slider2.getValue());
              Utils.getInstance().setDepthMm(slider2.getValue()); 
            }
            if (Utils.getInstance().getC1Mode() == "C1AB"){
              l.setText("Tiefe "+Utils.getPlayer1()+": "+slider2.getValue());
              Utils.getInstance().setDepthAb(slider2.getValue()); 
            }
        }
    }
      
   
}



