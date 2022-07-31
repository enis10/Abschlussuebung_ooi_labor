/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VierGewinnt;

import java.util.List;

/**
 *
 * 
 * @author anisdoudech
 * @param <M>
 */
public interface IGame<M> {
    
    List<M> moves();
    IGame doMove(M m);
    byte currentPlayer();
    byte otherPlayer(byte player);
    boolean noMoreMove();
    boolean endedGame();
    boolean wins (byte player);
    int evalState(byte player);
    int evalStateBlock(byte player);
    byte getYCoordinate(M m);
    byte getXCoordinate(M m);
    byte getRows();
    byte getCols();
    byte getAtPosition(byte row, byte col);
    byte getPlayerNone();
    byte getXCoordinate(Pair<Byte, Byte> m);
    byte getYCoordinate(Pair<Byte, Byte> m);
    byte lastPlayer();
    byte getPlayer2();
    void setPlayer(byte player);
 
            
    
    
}
