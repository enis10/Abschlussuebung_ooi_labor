/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Statistics;

import VierGewinnt.Utils;

/**
 *
 * @author anisdoudech
 */
public class PrintHelp {
    
    public PrintHelp(){
         
    }
    public void printH(){
        System.out.println("###########################################################");
        System.out.println("""
                           Um die Bedienung des Spiels zu gew\u00e4hrleisten sind die 
                           folgende Parameter in der Konsole anzugeben: """);
        System.out.println("Als erster Befehl können PP PC oder CC eingegeben werden");
        System.out.println("""
                           
                           PPS: PLayer 1 als Server.
                           PPCL: PLayer 2 als Server.
                           
                           PP: Erm\u00f6glicht es das Modus Spieler gegen Spieler zu 
                           aktivieren. 
                           
                           -S: Auf Wunsch kann die Konsole der Parametern eingeblendet
                           werden, diese ermoeglicht es beispielweise, einen Spielstand 
                           entweder zu laden oder auch zu speichern.
                           
                           -D:Als Dritter Befehl kann das Modus Mode aktiviert werden,
                            dieser kann aber auch als zweiter Befehl eingegeben werden,
                           wenn man sich auf Einstellungen Konsole verzichtet.
                           
                           PC: Mit diesem Befehl wird das Spiel gegen eine
                           Spiel Algorithmus starten, dafür ist eine Strategie durch 
                           zweiten Befehl festzulegen:
                           
                           PCAB: Gegen Alpha Beta Algorithmus spielen.
                           
                           PCMM: Gegen Minimax Algirithmus spielen.
                           
                           PCB: Gegen Blockierer Strategie.
                           
                           CC: Um das Modus Computer 1 vs Computer 2 zu aktivieren ist 
                           der letzte Befehl abzugeben. Nachdem es ist notwendig
                           den Spiel Algorithmus der beiden Gegnern festzulegen.
                           
                           C1AB: Computer 1 als Alpha Beta.
                           
                           C1MM: Computer 1 als Minimax.
                           
                           C1B: Computer 1 als Blockierer.
                           
                           Nachdem :
                           
                           C2AB: Computer 2 als Alpha Beta.
                           
                           C1MM: Computer 2 als Minimax.
                           
                           C2B: Computer 2 als Blockierer.
                           
                           
                           Nach der Festlegung des Modus sowie der Algorthmen sind
                           die Beide Befehle -S und -D(sieher oben) optional.
                           
                           Um die einen Blick über die Statistik des Spiels zu werfen
                           ist der folgende Befehl abzugeben:
                            
                           S!: Zeigt die Statistik jedes Spielers.
                         ###########################################################
  
                           """);
        
    }
    
  

    public void printModeDetails() {
        String debug;
       if (Utils.debugModus)
           debug = "Ja";
       else
           debug = "kein";
       System.out.println("""
                           ################################
                           Modus: """ +Utils.getInstance().getPlayer1() +" vs "+ Utils.getInstance().getPlayer2()+ "\n"+
                           """
                           Debug: """+debug+"\n"+
                           """
                           Parameterkonsole: """+ Utils.parameterKonsole+"\n"+
                           """
                           #################################
                           """);
        
    }
    
}
