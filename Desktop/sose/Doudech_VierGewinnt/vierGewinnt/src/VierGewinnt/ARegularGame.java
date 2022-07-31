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
    
public abstract class ARegularGame<M> implements IRegularGame<M>, Cloneable {
    
 
    private static final byte NONE = 0, ONE = 1, TWO = 2;
    private byte player = getPlayer1();
    private final byte ROWS, COLS;
    public byte[][] board;
    public int movesDone = 0;
    public byte lastCol = -1;
    public byte lastRow = -1;
    private Boolean winsLast = null;
    
    public ARegularGame(byte rows, byte cols) {
        ROWS = rows;
        COLS = cols;
        board = new byte[rows][cols];
       
    }
    public void setMoves(){
        movesDone ++;
    }

    @Override
    public byte getPlayer1() {
        return ONE;
    }

    @Override
    public byte getPlayer2() {
        return TWO;
    }

    @Override
    public byte getPlayerNone() {
        return NONE;
    }
    
    @Override
    public void setPlayer(byte p) {
     
        setMoves();
        this.player = p;
    }

    @Override
    public byte currentPlayer() {
       
     
        return player;
    }
    
  

    @Override
    public byte otherPlayer(byte p) {
        return (p == getPlayer1()) ? getPlayer2() : getPlayer1();
    }
    
  
    @Override
    public byte nextPlayer() {
       
        return otherPlayer(currentPlayer());
    }
    
    @Override
    public byte lastPlayer() {
        return otherPlayer(currentPlayer());
    }

    @Override
    public byte getRows() {
        return ROWS;
    }

    @Override
    public byte getCols() {
        return COLS;
    }

    @Override
    public byte getAtPosition(byte row, byte col) {
        
        return board[row][col];
    }
    
    public boolean wins() {
        if (winsLast == null) {
            winsLast = wins(lastPlayer());
            
        }
        return winsLast;
    }

    @Override
    public boolean endedGame() {
        return noMoreMove() || wins(); 
    }
    
    
    @Override
    public byte getYCoordinate(Pair<Byte, Byte> m) {
        return m.first;
    }
    
    @Override
        public byte getXCoordinate(Pair<Byte, Byte> m) {
        return m.second;
    }
    public int getMoves(){
        return movesDone;
    }
    @Override
   public byte[][] getBoard(){
       return board;
   }

    @Override
    public ARegularGame clone() throws CloneNotSupportedException {
        ARegularGame result = (ARegularGame) super.clone();
        result.board = board.clone();
        
        result.winsLast = null;
        
        for (int i = 0; i < result.board.length; i++) {
            result.board[i] = result.board[i].clone();
        }
        
        return result;
    }
}
