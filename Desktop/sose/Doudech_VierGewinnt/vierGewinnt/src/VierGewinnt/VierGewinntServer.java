/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VierGewinnt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JFrame;


/**
 *
 * @author anisdoudech
 */
public class VierGewinntServer {
    
     private static final int PORT = 9090;
     private static Socket client;
     private static PrintWriter out;
     private static BufferedReader in;
     private static boolean myTurn = true ;
    
    public static void main(String[] args) throws UnknownHostException, IOException {
          System.out.println("Geben bitte Sie Ihre Name: ");
          Scanner myObj = new Scanner(System.in); 
          String userName = myObj.nextLine();  
          System.out.println("Hallo " + userName);
          Utils.getInstance().setPlayer1(userName);

        
         ServerSocket listener = new ServerSocket(PORT);
         
         //Verbindung mit dem Client Warten
         System.out.println("Warte auf die Verbindung mit dem Client");
        
     
        client = listener.accept();
        System.out.println("Erfolgreisch verbunden ");
        
        //output und inputStream
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader (new InputStreamReader(client.getInputStream()));
        
        
        ServerSide serverSide = new ServerSide();
        try{
            out.println("los");
            System.out.println(" Spiel startet");
            serverSide.start();
            client.close();
            listener.close();
            
        }catch(Exception e){System.out.println("Client hat die Verbindung abgebrochen.");
        }
    
        
    }

private  static class ServerSide extends RegularControl<Pair<Byte, Byte>>{
     ServerSide(VierGewinnt b)
    {
        super(b);
    }
       ServerSide()
    {
       this(new VierGewinnt());
    }
     
     
     byte c;
     byte r;
     //startet das Spiel
     public void start() throws IOException {
        JFrame f=new JFrame("VierGewinnt Server"); 
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        ServerSide server =new ServerSide(new VierGewinnt());
        f.add(server);
        f.pack();
        f.setVisible(true);
        
        //Die Antwort vom Client
          String response;
          // solange das Spiel noch nicht fertig ist
          while(server.board.getGame().endedGame() == false){
          response = in.readLine();
          if(response.contains("yourTurn") == true){
                   //zwischen den  / / in einem Array speichern 
                    String[] rowCol = response.split("/");
                    r = Byte.valueOf(rowCol[1]);
                    c = Byte.valueOf(rowCol[2]);
                    Utils.getInstance().setPlayer2(rowCol[3]);
                    server.board.setGame(server.board.getGame().setAtPosition(r, c));
                    myTurn = true;
          }
          }
         
     }
     
     @Override
     public void whenMousePressed(byte r, byte c){
          if(board.getGame().endedGame() || myTurn == false ){ 
                return;
            }
          
          super.whenMousePressed(r, c);
          Utils.getInstance().playSound("/users/shared/Doudech_Ayadi_VierGewinnt/vierGewinnt/moving.wav");
          String next = "yourTurn" + "/" + getNewRow() + "/" + c+"/"+ Utils.getPlayer1();
          out.println(next);
          myTurn = false;
        }
    
     
    
}

    
    
}


