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
public interface IGameKI<M> {
    
    IGame<M> doBestMove(IGame<M> g);
    M bestMove(IGame<M> g);
 

    
}
