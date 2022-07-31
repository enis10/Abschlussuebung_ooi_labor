package VierGewinnt;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author anisdoudech
 */
public class VierGewinntClient {
    private static String SERVER_IP;
    private static final int SERVER_PORT = 9090;
    private static PrintWriter out;
    private static BufferedReader in;
    private static boolean myTurn = false;
    
    
    public static void main(String[] args) throws IOException{
        System.out.println("Geben bitte Sie Ihre Name: ");
          Scanner myObj = new Scanner(System.in); 
          String userName = myObj.nextLine();  
          System.out.println("Hallo " + userName);
          Utils.getInstance().setPlayer2(userName);
        Socket ServerConnection;
 
        while(true){
            
            SERVER_IP = "127.0.0.1";
            
            try{
                ServerConnection = new Socket(SERVER_IP, SERVER_PORT);
                if(ServerConnection.isConnected()){
                    System.out.println("Erfolgreisch verbunden");
                    break;
                }
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        
        in = new BufferedReader(new InputStreamReader(ServerConnection.getInputStream()));
        out = new PrintWriter(ServerConnection.getOutputStream(), true);
        
        //Warten das start vom Server
     String ServerCommand = in.readLine();
     ClientSide clientSide = new ClientSide();
        try{
            out.println("los");
            System.out.println("Spiel startet");
            clientSide.start();
            
        }catch(Exception e){System.out.println("Server hat die Verbindung abgebrochen.");
        }finally{

          ServerConnection.close();
        }
        
    }
    
    
    
    private  static class ClientSide extends RegularControl<Pair<Byte, Byte>>{
     ClientSide(VierGewinnt b)
    {
        super(b);
    }
       ClientSide()
    {
       this(new VierGewinnt());
    }
     
     
     byte c;
     byte r;
     //startet das Spiel
     public void start() throws IOException {
        JFrame f=new JFrame("VierGewinnt Client"); 
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        ClientSide client =new ClientSide(new VierGewinnt());
        f.add(client);
        f.pack();
        f.setVisible(true);
        
        //Die Antwort vom Client
          String response;
          // solange das Spiel noch nicht fertig ist
          while(client.board.getGame().endedGame() == false){
          response = in.readLine();
          if(response.contains("yourTurn") == true){
                    String[] rowCol = response.split("/");
                    r= Byte.valueOf(rowCol[1]);
                    c = Byte.valueOf(rowCol[2]);
                    Utils.getInstance().setPlayer1(rowCol[3]);
                    client.board.setGame(client.board.getGame().setAtPosition(r, c));
                    Utils.getInstance().playSound("/users/shared/Doudech_Ayadi_VierGewinnt/vierGewinnt/moving.wav");
                    myTurn = true;
          }
         
     
          }
         
     }
     
     @Override
     public void whenMousePressed(byte r, byte c){
          if(board.getGame().endedGame() || myTurn == false){ 
              return;
            }
     
           super.whenMousePressed(r, c);
           String next = "yourTurn" + "/" + getNewRow() + "/" + c+ "/"+Utils.getInstance().getPlayer2();
           Utils.getInstance().playSound("/users/shared/Doudech_Ayadi_VierGewinnt/vierGewinnt/moving.wav");
           out.println(next);
           myTurn = false;
        }
    
     
    
}

    
    
}
