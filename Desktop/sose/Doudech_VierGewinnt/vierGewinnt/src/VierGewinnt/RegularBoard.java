/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VierGewinnt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
import jdomreader.JdomReader_2;

/**
 *
 * @author anisdoudech
 * @param <M>
 */
public class RegularBoard<M> extends JPanel{
       static SettingsConsole   z1=  new SettingsConsole();
    static    Erzaehler   erz ;
    private IRegularGame<M> game;
    public int UNIT = 119;
    private BufferedImage board, redX,blueX,redCircle,blueCircle;
    
    public RegularBoard (IRegularGame<M> g){
        this.game = g;
        loadImages();
       
    }
    
    void setGame(IRegularGame<M> g){
        game = g;
        repaint();
    }
    
    IRegularGame<M> getGame(){
        return game;
    }
    
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(game.getCols()*UNIT, game.getRows()*UNIT);
    }
    
    @Override
    public void paintComponent(Graphics g){
        
           try {
               erz = new Erzaehler(z1);
           } catch (InterruptedException ex) {
               Logger.getLogger(RegularBoard.class.getName()).log(Level.SEVERE, null, ex);
           }
        
       Utils.getInstance().setBoard(game.getBoard());
      
        
        super.paintComponent(g);
          if(Utils.getChangeState() == true){
            game.setState();
            Utils.setChangeState(false);
        }
         if(Utils.getRestart() == true){
            game.restart();
    
            Utils.setRestart(false);
        }
         
        g.drawImage(board, 0, 0, null);
        for(byte r = 0; r < game.getRows();r++)
            for(byte c = 0; c < game.getCols(); c++){
                
                if(game.getAtPosition(r, c) != game.getPlayerNone()){
                    g.drawImage(selectImage(game.getAtPosition(r,c)),c*UNIT, r*UNIT,null);
             
                 
                }
            }
        if(game.endedGame())
        {  
            if(Utils.getSound())
                Utils.getInstance().playSound("/users/shared/Doudech_Ayadi_VierGewinnt/vierGewinnt/gameOver.wav");
                
            
            
       
           g.setColor(Color.ORANGE);
           Font stringFont = new Font( "SansSerif", Font.PLAIN, 65 );
           g.setFont(stringFont);
           
          
           {
                String gewinner, verlierer;
                if(game.currentPlayer()==1){
                gewinner=Utils.getPlayer2();
                verlierer = Utils.getPlayer1();
                }
                    
                else
                {
                    gewinner=Utils.getPlayer1();
                    verlierer = Utils.getPlayer2();
                }
                
                //*************Daten im Datenbank speichern********
                JdomReader_2 myReader = new JdomReader_2("/users/Doudech_Ayadi_VierGewinnt/vierGewinnt/4GewinntDatenbank.xml");
                myReader.ReadData();
                myReader.modifyData(gewinner,"wins");
                myReader.modifyData(verlierer,"loses");
              
                myReader.saveData();
                
                g.drawString(gewinner+" gewinnt!", 150, 300);  
            
           }
       
           
        }else {  
            
            if (game.getMoves()/2 > 0){
               Utils.getInstance().displayState();
               Utils.getInstance().setTurn(Integer.toString(game.nextPlayer()));
               
              
                }}
        
      
        
    }
    

    
     private void loadImages() {
        try {
            board = ImageIO.read(getClass().getResourceAsStream("/Images/board830_710.png"));
            redX = ImageIO.read(getClass().getResourceAsStream("/Images/redX_HD.png"));
            blueX = ImageIO.read(getClass().getResourceAsStream("/Images/blueX_HD.png"));
            redCircle = ImageIO.read(getClass().getResourceAsStream("/Images/redCircle_HD.png"));
            blueCircle = ImageIO.read(getClass().getResourceAsStream("/Images/blueCircle_HD.png"));
            
          
        } catch (IOException ex) {
            Logger.getLogger(RegularBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private BufferedImage selectImage(byte player){
        if (player == game.getPlayer1()) return blueCircle;
        return redCircle;
    }
     


    
}
