/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VierGewinnt;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anisdoudech
 */
public class VierGewinnt extends ARegularGame<Pair<Byte,Byte>> {
    

    public VierGewinnt(){
        super((byte)6, (byte) 7);
    }
    
    @Override
    public VierGewinnt setAtPosition(byte row, byte col){
        return doMove(new Pair<>(row, col));
    }
    
    @Override
    public List<Pair<Byte,Byte>> moves(){
        List<Pair<Byte,Byte>> result = new LinkedList<>();
           
        for(byte c = 0; c < getCols();c++){                              
            for(byte r = 5; r >= 0;r--){
                
		if(board[r][c] == getPlayerNone()){
			result.add(new Pair(r,c));

                        break;
                        
		}else{
			if(r == 0) break;               
                }}
	}    
      
        return result;
    }
    
    

    
    @Override
    public VierGewinnt clone() throws CloneNotSupportedException{
        return (VierGewinnt)super.clone();
    }
    
    
    @Override
    public VierGewinnt doMove(Pair<Byte,Byte> m){
        try{   
            VierGewinnt result = clone();
            result.board[m.first][m.second]= currentPlayer();
            result.setPlayer(nextPlayer());
            result.movesDone ++;           
            return result;
        
        }catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    @Override
    public byte getYCoordinate(Pair<Byte, Byte> m) {
        return m.first;
    }
    
    
    @Override
    public boolean noMoreMove(){
        return moves().isEmpty();
    }
    
    @Override
    public boolean wins(byte p){
        return checkRows(p) || checkCols(p) || checkDiag(p);
    }
    
    private boolean checkRows(byte p) {
        int count;
        for (byte r = 0; r < getRows(); r++){
            count = 0;
            for(byte c = 0; c < getCols();c++){
                if (board[r][c] == p){
                    count ++; 
                }else{ count = 0;}
                if( count >= 4){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCols(byte p) {
        int count;
        for(byte c = 0; c < getCols(); c++){
            count = 0;
            for(byte r = 0; r < getRows(); r++){
                if (board[r][c] ==p){
                    count ++;
                }else{count = 0;}
                if ( count >= 4){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiag(byte p) {
        byte count;
	
	for(byte i = 0; i<3; i++){

		count = 0;
                
		for(byte r = 0; r < getRows()-i;r++){
                    
                    if(board[r+i][r] == p){count++;}
                    else{count = 0;}
                    if(count >= 4) {
                        return true;
                    }
		}
                count = 0;
                for(byte r =0; r < getRows()-i;r++){
                    if(board[r][r+(i+1)] == p){count++;}
                    else{count = 0;}
                    if(count >= 4) {
                        return true;
                    }
                }
                count = 0;
                for(byte r = 5, c = 0; c < getRows()-i; r--, c++){
                    if(board[r-i][c] == p){count++;}
                    else{count = 0;}
                    if(count >= 4) {
                        return true;
                    }
                }
                count = 0;
                for(byte r = 5, c = 1; c < getCols()-i;c++, r--){
                    if(board[r][c+i] == p){count++;}
                    else{count = 0;}
                    if(count >= 4) {
                        return true;
                    }
		} 
            }
        return false;
    }
    
    
    
   
    
    
    int ps(byte player, int rV) {
        
        
        return (rV == 3 * player) ? 100 : ((rV == 2 * player) ? 10 : 0); 
    }

        public void restart(){
        
    for(byte c = 0; c < getCols();c++){                              
            for(byte r = 5; r >= 0;r--){
                board[r][c] = getPlayerNone();
            }}
    Utils.getInstance().setTurn("1");
    setPlayer(getPlayer1());
    Utils.setRestart(false);
    

    
    }
    
    public void setState(){
        
       for (int row = 0; row < 6; row++){
	for (int col = 0; col < 7; col++){
       board[row][col] = Utils.getBoard2()[row][col]; }}
       Utils.getInstance().setTurn("1");
       setPlayer(Utils.getCurrentPlayer());
       
    }
    
    int state(byte p) {
        int result = 0;
        for (int c = 0; c < getCols() - 3; c++) {
            for (int r = 0; r < getRows() - 3; r++) {                             
                result = result
                        + ps(p, board[r][c] + board[r + 1][c] + board[r + 2][c] + board[r + 3][c])              
                        + ps(p, board[r][c] + board[r + 1][c + 1] + board[r + 2][c + 2] + board[r + 3][c + 3]) 
                        + ps(p, board[r][c] + board[r][c + 1] + board[r][c + 2] + board[r][c + 3]);             

                final int c2 = getCols() - 1 - c;                                                               
                if (c2 > 3) {           
                    result = result
                            + ps(p, board[r][c2] + board[r + 1][c2] + board[r + 2][c2] + board[r + 3][c2]);     
                }
                final int s = getRows() - 1 - r;                                                                
                result = result
                        + ps(p, board[s][c] + board[s][c + 1] + board[s][c + 2] + board[s][c + 3])              
                        + ps(p, board[s][c] + board[s - 1][c + 1] + board[s - 2][c + 2] + board[s - 3][c + 3]); 

            }
        }
        
        return result;
    }
    

     @Override
    public int evalState(byte player){
        if(wins()) return (lastPlayer() == player) ? Integer.MAX_VALUE:-Integer.MAX_VALUE;    
        

        return state(player)-10*state(otherPlayer(player));                                    
    }
    
    @Override
    public int evalStateBlock(byte player){
        if(wins()&& lastPlayer() != player) return Integer.MAX_VALUE;
        return state(player)-10*state(otherPlayer(player));
    }
    
}
