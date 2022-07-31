/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VierGewinnt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anisdoudech
 * @param <M>
 */
public class StrategyMinimax<M> implements IGameKI<M> {
    

    @Override
    public IGame<M> doBestMove(IGame<M> g) {
    
        return g.doMove(bestMove(g));
    }

    @Override
    public M bestMove(IGame<M> g) {
        return bestMove(g, getDepth(g));
    }
    
    private M bestMove(IGame<M> g, int depth) {
        final byte player = g.currentPlayer();                                  
        int val = Integer.MIN_VALUE;                                           
        M result = null;                                                       
        
        for (M m : g.moves()) {                                                 
            final IGame<M> s = g.doMove(m);                                     
            final int eval = evalNextState(s, player, depth - 1);           
            
            if (eval > val) {                                                
                val = eval;             
                result = m;  
            }
        }
        int p = g.currentPlayer();
        if(p == 22) p = 2;
        
        return result;
    }
    
    private int getDepth(IGame<M> g) {
          
        return Utils.getInstance().getDepthMm();
    }
    
    private int evalNextState(IGame<M> g, byte player, int depth) {
        return minimax(g, player, depth);
    }

    private int minimax(IGame<M> g, byte player, int depth) {
        if (depth == 0 || g.endedGame()) {                                               
            return g.evalState(player);
        }
        
        boolean isMax = g.currentPlayer() == player;                                    
        int resultVal = isMax ? -Integer.MAX_VALUE : Integer.MAX_VALUE;                
        for (M m : g.moves()) {                                                         
            final IGame<M> child = g.doMove(m);                                         
            final int nextVal = minimax(child, player, depth - 1);                     
            
            if ((isMax && nextVal >= resultVal) || !isMax && nextVal <= resultVal) {   
                resultVal = nextVal;                                                    
            }
        }
        return resultVal;                                                               
    }

    




    
}