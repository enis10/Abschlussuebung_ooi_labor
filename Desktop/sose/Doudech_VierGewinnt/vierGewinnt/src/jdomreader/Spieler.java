/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdomreader;

/**
 *
 * @author anisdoudech
 */
public class Spieler {
    private String name, wins,games,loses,draws,id ;
    
    
    public Spieler(String n, String g,String w, String l, String d){
        this.name = n;
        this.games = g;
        this.draws = d;
        this.wins = w;
        this.loses = l;
       
        
        
    }
    
    
    public void  setName(String n){
        this.name = n;
        
    }
    
    public void  setWins(String w){
        this.wins = w;     
    }
    
       public void  setGames(String g){
        this.games = g;
        
    }
       
     public void  setLoses(String l){
        this.loses = l;
        
    }
   
     public void  setDraws(String d){
        this.draws = d;
     }
     
     public String getName (){
         return this.name;
         
     }
     
      public String getGames (){
         return this.games;
         
     }
      
     public String getWins (){
         return this.wins;    
     }
     
     
     public String getLoses (){
         return this.loses;
         
     }
     
     
      public String getDraws (){
         return this.draws;
         
     }
      public String getId(){
          return this.id;
      }
     
    
    
    
   
    
}
