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
public class StrategyAlphaBeta<M> implements IGameKI<M> {

    private int getDepth(IGame<M> g) {
         
        return Utils.getInstance().getDepthAb();
    }
    
    private int evalNextState(IGame<M> g, byte player, int depth){ 
        return alphaBeta(g, player, depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private int alphaBeta(IGame<M> g, byte player, int depth, int alpha, int beta){

        
        if (depth == 0 || g.endedGame()) {                                     
            return g.evalState(player);
        }              
        
        if(g.currentPlayer() == player){
            
            int best=Integer.MIN_VALUE;                                         
            
            for(M m : g.moves()){                                               
                IGame<M> child = g.doMove(m);                                  
                int val = alphaBeta(child,player,depth-1,alpha,beta); 
                best = Math.max(best, val);                                     
                alpha = Math.max(alpha, best);                                

                if(beta <=alpha){  
                    break;
                }
            }
            return best;
        }else{                                                                 
            
            int best=Integer.MAX_VALUE;
            
            for(M m : g.moves()){                                             
                IGame<M> child = g.doMove(m);         
                int val = alphaBeta(child,player,depth-1,alpha,beta); 
                best = Math.min(best, val);
                beta = Math.min(beta, best);

                if(beta <=alpha){                                                             
                    break;
                }
            }
            return best;
        }
    }
    
    @Override 
    public IGame<M> doBestMove(IGame<M> g){ 
        return g.doMove(bestMove(g)); 
    }
    
    @Override 
    public M bestMove(IGame<M> g){ 
        return bestMove(g,getDepth(g)); 
    }
    
    public M bestMove(IGame<M> g,int depth){ 
        final byte player = g.currentPlayer();   
        int val = Integer.MIN_VALUE;    
        M result = null;    
        
        for(M m : g.moves()) { 
            IGame<M> s = g.doMove(m);  
            int eval = evalNextState(s,player,depth-1);
            if(eval > val){ 
                val = eval; 
                result = m;
                
            }   
        }    

        int p = g.currentPlayer();
        if(p == 22) p = 2;
        
        return result; 
    }

   
    
    
}
