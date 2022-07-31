/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VierGewinnt;

/**
 *
 * @author anisdoudech
 * @param <M>
 */
public interface IRegularGame<M> extends IGame<M> {

    
    byte getPlayer1();
    IRegularGame<M> setAtPosition(byte row, byte col);
    
    
    @Override
    byte getRows();
    byte getCols();
    byte getPlayer2();
    byte getPlayerNone();
    byte lastPlayer();
    byte getAtPosition(byte row, byte col);
    public void setPlayer(byte i);
    public byte nextPlayer();
    public int getMoves();
    public void restart();
    public byte[][] getBoard();
    public void setState();

   

 
    
}
