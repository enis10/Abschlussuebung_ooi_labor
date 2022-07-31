/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VierGewinnt;

import static VierGewinnt.RegularBoard.z1;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author anisdoudech
 */

    


import static VierGewinnt.RegularBoard.z1;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 *
 * @author anisdoudech
 */
public class VierGewinntPlayervsPlayer extends RegularControl<Pair<Byte, Byte>>
{

static int i =1; 

    
  
    VierGewinntPlayervsPlayer(VierGewinnt b)
    {
        super(b);
    }
    
             
             IGameKI <Pair<Byte,Byte>> ki=new StrategyMinimax<>();
             IGameKI <Pair<Byte,Byte>> ki2=new StrategyAlphaBeta<>();
             IGameKI <Pair<Byte,Byte>> ki3 =new StrategyBlocker<>();
             
          
             
@Override
    public void whenMousePressed(byte r,byte c){
   
      
     if(i == 1){
     Utils.getInstance().setTurn("2");
    
     }
  
        i++;
       
            
     if ((i%2 == 0) && (!board.getGame().endedGame())){
        if (Utils.getRestart() == true || (Utils.getChangeState() == true && Utils.getCurrentPlayer() == (byte)1 ) ){
            Utils.getInstance().setTurn("1");
            i= 1;
        } 
       super.whenMousePressed(r, c);  
       Utils.getInstance().playSound("/users/shared/Doudech_Ayadi_VierGewinnt/vierGewinnt/moving.wav");
       
       
       
       
         
       }
      
        else if ((i%2 != 0) && (!board.getGame().endedGame())){
            
              if (Utils.getChangeState() == true && Utils.getCurrentPlayer() == (byte)2 ){
            i= 2;
        }
             super.whenMousePressed(r, c);  
              Utils.getInstance().playSound("/users/shared/Doudech_Ayadi_VierGewinnt/vierGewinnt/moving.wav");
            
             
       
             
        }
      }
    


    public static void main(String[] args) 
    {
         
         Utils.getInstance().setMode("PP");
        JFrame f=new JFrame("Tic Tac Toe"); 
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        f.add(new VierGewinntPlayervsPlayer(new VierGewinnt()));
        JButton btn = new JButton("Settings");
        Container contents = f.getContentPane();
        contents.add(btn, BorderLayout.SOUTH);
        
        
         btn.addActionListener((ActionEvent e) -> {
             z1.setVisible(true);
        
         });
        
        f.pack();
        f.setVisible(true);
        
      
            
              
    }


     
     
}



