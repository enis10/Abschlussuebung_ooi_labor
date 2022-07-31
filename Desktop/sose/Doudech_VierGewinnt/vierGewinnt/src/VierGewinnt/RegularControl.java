/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VierGewinnt;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author anisdoudech
 */
public class RegularControl<M> extends JPanel {
    
    RegularBoard<M> board;
    static   byte r2;
    
    public RegularControl(RegularBoard<M> b){
        board = b;
        add(board);
        
        board.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev){
                byte c = (byte)(ev.getPoint().getX() / board.UNIT);
                byte r = (byte)(ev.getPoint().getY()/board.UNIT);                
                whenMousePressed(r,c);
            }
        });
    }    
       
        public RegularControl(IRegularGame<M> game){
            this(new RegularBoard<M>(game));
        }
    
        public byte drop (byte x){
        byte r = (byte) (board.getGame().getRows()-1);
        while (r>=0){
            if ((board.getGame().getAtPosition(r,x)==board.getGame().getPlayerNone())){
                return r;
            }
            r--;
        }
        return -1;
    }

    public void whenMousePressed( byte r, byte c){
      
       
        if (board.getGame().endedGame() || board.getGame().getAtPosition(r, c) != board.getGame().getPlayerNone()) {
           return;
         
            
        }
        r= drop(c);
        r2 = r;
        
                board.setGame(board.getGame().setAtPosition(r, c));
                
                
            } 
    
    byte getNewRow(){
        return r2;
    }
     
        }   



               

