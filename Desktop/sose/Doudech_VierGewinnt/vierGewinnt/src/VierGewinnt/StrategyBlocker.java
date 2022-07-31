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
public class StrategyBlocker<M> implements IGameKI<M> {

    @Override
    public IGame<M> doBestMove(IGame<M> g) {
                M result = blockMove(g);
                int p = g.currentPlayer();
                if(p == 22) p = 2;
                
                return g.doMove(result);
    }

    @Override
    public M bestMove(IGame<M> g) {
        return blockMove(g);
    }

  
    
    
    private M blockMove(IGame<M> g){                                             
        
        int count;
        int a = g.moves().size();
        int zahl = (int)((Math.random())*a);  
        M blk = g.moves().get(zahl); 
        byte rows = g.getRows();
        byte cols = g.getCols();
        
        for (byte r = 0; r < rows; r++){                                           
            count = 0;
            for(byte c = 0; c < cols;c++){
                if (g.getAtPosition(r, c) == g.lastPlayer()){
                    count ++; 
                }else{ 
                    count = 0;
                }
                    if( count >= 3){                                              
                        for(M m : g.moves()){
                            if(g.getYCoordinate(m) == r && g.getXCoordinate(m) == c-3) return m;
                            if(g.getYCoordinate(m) == r && g.getXCoordinate(m) == c+1) return m;
                        }
                    }
                    if( count == 2){                                                
                        int speicher = 0;
                        for(M m : g.moves()){
                            if(g.getYCoordinate(m) == r && g.getXCoordinate(m) == c-2 || g.getYCoordinate(m) == r && g.getXCoordinate(m) == c+1) speicher++;
                            if(speicher == 2){
                                blk = m;
                                speicher = 0;
                            }
                        }
                    }                     
            }
        }
        for(byte c = 0; c < cols; c++){                                            
            count = 0;
            for(byte r = 0; r < rows; r++){
                if (g.getAtPosition(r, c) ==g.lastPlayer()){
                    count ++;
                }else{
                    count = 0;
                }
                if( count >= 3){
                        for(M m : g.moves()){
                            if(g.getYCoordinate(m) == r-3 && g.getXCoordinate(m) == c) return m;
                            if(g.getYCoordinate(m) == r+1 && g.getXCoordinate(m) == c) return m;
                        }
                    }
                    if( count == 2){
                        int speicher = 0;
                        for(M m : g.moves()){
                            if(g.getYCoordinate(m) == r-2 && g.getXCoordinate(m) == c || g.getYCoordinate(m) == r+1 && g.getXCoordinate(m) == c) speicher++;
                            if(speicher == 2) {
                                blk = m;
                                speicher = 0;
                            }
                            
                        }
                    }
            }
        }
        for(byte i = 0; i<3; i++){                                               

		count = 0;
                for(byte r = 0; r < rows-i ; r++){
                    if(g.getAtPosition((byte) (r+i), r) == g.lastPlayer()){
                        count++;
                    }
                    else{
                        count = 0;
                    }
                    if(count >= 3) {
                        for(M m : g.moves()){
                            if(g.getYCoordinate(m) == r+i-3 && g.getXCoordinate(m) == r-3){
                                return m;
                            }
                            if(g.getYCoordinate(m) == r+i+1 && g.getXCoordinate(m) == r+1) {
                                return m;
                            }
                        }
                    }
                    if( count == 2){
                        int speicher = 0;
                        for(M m : g.moves()){
                            if((g.getYCoordinate(m) == r+i-2 && g.getXCoordinate(m) == r-2) || (g.getYCoordinate(m) == r+i+1 && g.getXCoordinate(m) == r+1)) speicher++;
                            if(speicher == 2) {
                                blk = m;
                                speicher = 0;
                            }
                        }
                    }   
		}
                count = 0;
                for(byte r =0; r < rows-i;r++){
                    if(g.getAtPosition(r,(byte) (r+i+1)) == g.lastPlayer()){
                        count++;
                    }
                    else{count = 0;}
                    if(count >= 3) {
                        for(M m : g.moves()){
                            if(g.getYCoordinate(m) == r-3 && g.getXCoordinate(m) == r+i+1-3) {
                                return m;
                            }
                            if(g.getYCoordinate(m) == r+1 && g.getXCoordinate(m) == r+i+1+i){;
                                return m;
                            }
                        }
                    }
                    if( count == 2){
                        int speicher = 0;
                        for(M m : g.moves()){
                            if((g.getYCoordinate(m) == r-2 && g.getXCoordinate(m) == r+i+1-2) || (g.getYCoordinate(m) == r+1 && g.getXCoordinate(m) == r+i+1+1)) speicher++;
                            if(speicher == 2) {
                                blk = m;
                                speicher = 0;
                            }
                        }
                    }
                }
                count = 0;
                for(byte r = 5, c = 0; c < rows-i; r--, c++){
                    if(g.getAtPosition((byte) (r-i),c) == g.lastPlayer()){
                        count++;
                    }
                    else{
                        count = 0;
                    }
                    if(count >= 3) {
                        System.out.print("HALLO");
                        for(M m : g.moves()){
                            if(g.getYCoordinate(m) == r-i+3 && g.getXCoordinate(m) == c-3) return m;
                            if(g.getYCoordinate(m) == r-i-1 && g.getXCoordinate(m) == c+1) return m;
                        }
                    }
                    if( count == 2){
                        int speicher = 0;
                        for(M m : g.moves()){
                            if(g.getYCoordinate(m) == r-i+2 && g.getXCoordinate(m) == c-2 || g.getYCoordinate(m) == r-i-1 && g.getXCoordinate(m) == c+1) speicher++;
                            if(speicher == 2) {
                                blk = m;
                                speicher = 0;
                            }
                        }
                    }
                    
                }
                count = 0;
                for(byte r = 5, c = 1; c < cols-i;c++, r--){
                    if(g.getAtPosition(r, (byte) (c+i))== g.lastPlayer()){count++;}
                    else{count = 0;}
                    if(count >= 3) {
                        for(M m : g.moves()){
                            if(g.getYCoordinate(m) == r+3 && g.getXCoordinate(m) == c+i-3) return m;
                            if(g.getYCoordinate(m) == r-1 && g.getXCoordinate(m) == c+i+1) return m;
                        }
                    }
                    if( count == 2){
                        int speicher = 0;
                        for(M m : g.moves()){
                            if(g.getYCoordinate(m) == r+2 && g.getXCoordinate(m) == c+i-2 || g.getYCoordinate(m) == r-1 && g.getXCoordinate(m) == c+i+1) speicher++;
                            if(speicher == 2) {                                
                                blk = m;
                                speicher = 0;
                            }
                        }
                    }
		} 
        }
    return blk;
    }
    
}
