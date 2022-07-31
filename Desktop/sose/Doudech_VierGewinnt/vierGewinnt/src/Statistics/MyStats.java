/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Statistics;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jdomreader.JdomReader_2;
import jdomreader.Spieler;

/**
 *
 * @author anisdoudech
 */
public class MyStats extends JFrame implements ActionListener {
       JComboBox namenBox;
       String[] arrayOfNames;
       List<Spieler> players;
       JLabel wins, draws, loses,games,gamess;
   public  MyStats(){
       
      
        getNames();
        
       
        namenBox = new JComboBox(arrayOfNames);
        namenBox.setBounds(100,10,200,50);
        
        //Wins
        wins = new JLabel();
        wins.setText("Wins: "+players.get(0).getWins());
        wins.setBounds(140,60,200,50);
        wins.setFont(new Font("Consolas", Font.PLAIN,20));
        
        //  loses
        loses = new JLabel();
        loses.setText("Loses: "+players.get(0).getLoses());
        loses.setBounds(140,100,200,50);
        loses.setFont(new Font("Consolas", Font.PLAIN,20));
        
         //  Draws
        draws = new JLabel();
        draws.setText("Draws: "+players.get(0).getDraws());
        draws.setBounds(140,140,200,50);
        draws.setFont(new Font("Consolas", Font.PLAIN,20));
        
        //Total games
        
        gamess = new JLabel();
        gamess.setText("  ");
        gamess.setBounds(100,120,200,50);
        
        games =new JLabel();
        games.setText("Games: "+players.get(0).getGames());
        games.setBounds(140,180,200,50);
        games.setFont(new Font("Consolas", Font.PLAIN,20));
        
        
        
        namenBox.addActionListener(this);
        this.add(namenBox); this.add(wins); this.add(loses); this.add(draws); this.add(games);this.add(gamess);
       
        this.pack();
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == namenBox){
            
            
            wins.setText("Wins: "+players.get(namenBox.getSelectedIndex()).getWins());
            loses.setText("Loses: "+players.get(namenBox.getSelectedIndex()).getLoses());
            games.setText("Games: "+players.get(namenBox.getSelectedIndex()).getGames());
            draws.setText("Draws: "+players.get(namenBox.getSelectedIndex()).getDraws());
            
          
          
            
        }
    }
    
    private void getNames(){
        JdomReader_2 st = new JdomReader_2("/users/Doudech_Ayadi_VierGewinnt/vierGewinnt/4GewinntDatenbank.xml");     
        st.ReadData();
        st.getPlayers();
        players = st.getPlayers();
        int  sizeOfList = players.size();
        
          arrayOfNames = new String[sizeOfList];
        for (int i=0; i<sizeOfList; i++){
            arrayOfNames[i] =  players.get(i).getName();
         
              
        }
        
    }
    
    
    
}
