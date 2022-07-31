/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VierGewinnt;

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author anisdoudech
 */
public class Utils  {
    private static Utils instance ;
    private static String  turn ;
    private static int depthAb,depthMm;
    private static String player1 ;
    private static String player2, mode ;
    private static int moves;
    private static boolean restart ;
    private static byte board[][], board2[][];
    private static boolean sound, changeState ;
    public static boolean debugModus;
    public static String  parameterKonsole ;
    
    private static byte newCurrentPlayer;
    private static String[] modesPC ;
    private static String C1Mode,C2Mode ;
    
    

    
    private Utils(){
            initData();
       
        
     }
    
    private void initData(){
        //TODO: add initial data
        depthAb = 5;
        player1 = "Player 1";
        player2 = "Player 2";
        moves = 0;
        restart = false;
        sound = true;
        debugModus = false;
        changeState = false;
        depthMm = 5;
        mode = "";
        C2Mode = "";
        C1Mode = "";
        parameterKonsole ="Keine";
        
        // 0: Player vs Ab, 1: Player vs Minimax, 2: Player vs Strategie Blockierer
        // 3: Player vs Rnd
        modesPC = new String[]{"Alpha Beta", "Minimax","Blockierer", "Random" };
           
        
    }
    public static String getMode(){
        return mode;    
    }
    
    public static void setMode(String m){
        if ("PCAB".equals(m)){
            Utils.mode = m;
            Utils.setPlayer2("Alpha Beta");
            
        }
        else if ( "PCMM".equals(m)){
            Utils.mode = m;
             Utils.setPlayer2("Minimax");
             
        }    
        else if ( "PCB".equals(m)){
            Utils.mode = m;
             Utils.setPlayer2("Blockierer");
            
        }   
    }
    
    public static  void setC1Mode(String m){
         if ("C1AB".equals(m)){
            Utils.C1Mode = m;
            Utils.setPlayer1("Alpha Beta");
            
        }
        else if ( "C1MM".equals(m)){
             Utils.C1Mode = m;
             Utils.setPlayer1("Minimax");
             
        }    
        else if ( "C1B".equals(m)){
            Utils.C1Mode = m;
             Utils.setPlayer1("Blockierer");
            
        }   
        
        
    }
    
     public static  String getC1Mode(){
        return C1Mode;
    }
     
         public static  void setC2Mode(String m){
         if ("C2AB".equals(m)){
            Utils.setMode("PCAB");
            
        }
        else if ( "C2MM".equals(m)){
             Utils.setMode("PCMM");
            
             
        }    
        else if ( "C2B".equals(m)){
           Utils.setMode("PCB");
        }   
    }
    
     public static  String getC2Mode(){
        return C2Mode;
    }
    
    
    
  

    
    public static  Utils getInstance(){
        if(null != instance){
      return instance;  
        }
        else {
            instance = new Utils();
            return instance;
        }
    }
    public static String getTurn(){
        return turn ;
    }
    public void setTurn(String t){
        Utils.turn = t;
    }
    
    
    //************+ Getter und Setter von depth***************
    public static int getDepthAb(){
        return depthAb;    
    }
    public static  void setDepthAb(int d){
        Utils.depthAb = d;
        
    }
    
     public static int getDepthMm(){
        return depthMm;    
    }
    public static  void setDepthMm(int d){
        Utils.depthMm = d;
        
    }

   //*********Spiler Namen************
    public static String getPlayer1(){
        return player1;
    }

    
     public static void setPlayer1(String p){
       Utils.player1 = p;
    }
     public static void setPlayer2(String p){
       Utils.player2 = p;
    }

    public static String getPlayer2() {
          return player2;
    }
    
    public static int getMoves(){
        return moves;
    }
    public static void setMoves(int m){
        Utils.moves = m;
    }
    
    public static boolean getRestart(){
        return restart;
    }
    public static void setRestart(boolean r){
        Utils.restart = r;
    }
    public static void setBoard(byte[][] b){
        Utils.board = b;
    }
    public static byte[][] getBoard(){
        return Utils.board;
    }
        public static void setBoard2(byte[][] b){
        Utils.board2 = b;
    }
    public static byte[][] getBoard2(){
        return Utils.board2;
    }
    
    public static void debugModus(){
        Utils.debugModus = !Utils.debugModus;
       
    }
    
    public static void setDepth(int d){
        if (Utils.mode =="PCAB"){
            setDepthAb(d);
           
        }
        else {
            setDepthMm(d);
           
        }
        
    }
    
    public static int getDepth(){
        if (Utils.mode =="PCAB"){
            return depthAb;
        }
        return depthMm;
    }
    
    
    public void displayState(){
        if (debugModus){
            System.out.println("---------------");
		for (int row = 0; row < 6; row++){
			System.out.print("|");
			for (int col = 0; col < 7; col++){
				System.out.print(board[row][col]);
				System.out.print("|");
			}
			System.out.println();
			System.out.println("---------------");
		}
		System.out.println();
            }
       
    }
    
    //spielStand ändern
    public static void setChangeState(boolean s){
        Utils.changeState  =s;
    }
    public static boolean getChangeState(){
        return Utils.changeState ;
    }
    public static byte getCurrentPlayer(){
        return newCurrentPlayer;
    }
    public static void setCurrentPlayer(byte c){
        Utils.newCurrentPlayer = c;
    }
    
    
  // Ton Aus oder zu
    public static void setSound(boolean s){
        Utils.sound = s;
    }
    
      public static boolean getSound(){
        return Utils.sound ;
    }
      
       public static  void playSound(String path){
                    //**********Sound***********
        try{
            
    File file = new File(path);
  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
  Clip clip = AudioSystem.getClip();
  clip.open(audioStream);
  if(Utils.getInstance().getSound())
      clip.start();
  
 
        }catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        System.err.println(e.getMessage());
      }
     }
    
       
       public static void  setParameterKonsole(){
           Utils.parameterKonsole = "Ja";
       }
    
    
    
}
