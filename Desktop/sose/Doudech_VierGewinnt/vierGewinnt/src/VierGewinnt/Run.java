/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package VierGewinnt;

import Statistics.MyStats;
import Statistics.PrintHelp;
import static VierGewinnt.RegularBoard.z1;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author anisdoudech
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         PrintHelp ph = new PrintHelp();
        
        // TODO code application logic here
        if (args[0].contains("C4")){
            System.out.println("Wilkommen zum Vier Gweinnt Spiel !!! \n");
        if (args[1].contains("Help")){
         ph.printH();
        } 
        if (args[1].contains("S!")){
         new MyStats();
        } 
        if((args)[1].contains("PPS")){
            
              try {
                  VierGewinntServer.main(args);
              } catch (IOException ex) {
                  Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
              }
              if((args)[2].contains("-D")){
                  Utils.getInstance().debugModus();
              }
              
        }
         if((args)[1].contains("PPCL")){
            
              try {
                  VierGewinntClient.main(args);
              } catch (IOException ex) {
                  Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
              }
               if((args)[2].contains("-D")){
                  Utils.getInstance().debugModus();
              }
              
        }
        
        if(args[1].contains("PP")){
           // Player vs Player MODE
         
          
          Utils.getInstance().setMode("PP");
         JFrame f=new JFrame("Vier Gewinnt");
         
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        f.add(new VierGewinntPlayervsPlayer(new VierGewinnt()));
        f.pack();
        f.setVisible(true);
        
        if(args[2].contains("-S")){
             z1.setVisible(true); 
             Utils.setParameterKonsole();
            
             if(args[3].contains("-D")){ Utils.getInstance().debugModus();
             
             }
        }
        
        
        
         if(args[2].contains("-D")){ Utils.getInstance().debugModus();
        }
         ph.printModeDetails();
         
         
        } 
        
        if(args[1].contains("PC")){
            //Player VS Computer
            if (args[2].contains("PCAB")){Utils.getInstance().setMode("PCAB");
         Utils.getInstance().setMode("PCAB");
        JFrame f=new JFrame("Vier Gewinnt"); 
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        f.add(new VierGewinntTest(new VierGewinnt()));
        f.pack();
        f.setVisible(true);
        
        if(args[3].contains("-S")){
             z1.setVisible(true); 
             Utils.setParameterKonsole();
             
             if(args[4].contains("-D")){ Utils.getInstance().debugModus();
             
             }
        }if(args[3].contains("-D")){ 
            Utils.getInstance().debugModus();

        }
        
        
            
            }
            if (args[2].contains("PCMM")){   Utils.getInstance().setMode("PCMM");
            JFrame f=new JFrame("Vier Gewinnt"); 
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        f.add(new VierGewinntTest(new VierGewinnt()));
        f.pack();
        f.setVisible(true);
        
        if(args[3].contains("-S")){
             z1.setVisible(true); 
             Utils.setParameterKonsole();
             
             if(args[4].contains("-D")){ Utils.getInstance().debugModus();
            }
        }if(args[3].contains("-D")){ Utils.getInstance().debugModus();
        }
            }
            if (args[2].contains("PCB")){Utils.getInstance().setMode("PCB");
            JFrame f=new JFrame("Vier Gewinnt"); 
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        f.add(new VierGewinntTest(new VierGewinnt()));
        f.pack();
        f.setVisible(true);
        
        if(args[3].contains("-S")){
             z1.setVisible(true); 
              Utils.setParameterKonsole();
             
             if(args[4].contains("-D")){ Utils.getInstance().debugModus();
             }
        }if(args[3].contains("-D")){ Utils.getInstance().debugModus();
        }
            }
            
         ph.printModeDetails();
     }
        
     if(args[1].contains("CC")){
         if(args[2].contains("C1AB")){ Utils.getInstance().setC1Mode("C1AB");
         
         if(args[2].contains("C1MM")){ Utils.getInstance().setC1Mode("C1MM");}
         if(args[2].contains("C1B")){ Utils.getInstance().setC1Mode("C1B");}
         
         if(args[3].contains("C2AB")){ Utils.getInstance().setC2Mode("C2AB");}
         if(args[3].contains("C2MM")){ Utils.getInstance().setC2Mode("C2MM");}
         if(args[3].contains("C2B")){ Utils.getInstance().setC2Mode("C2B");}
         
        JFrame f=new JFrame("Vier Gewinnt");
         
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        f.add(new VierGewinntComputerVsComputer(new VierGewinnt()));
        f.pack();
        f.setVisible(true);
        if(args[4].contains("-S")){
            
              z1.setVisible(true);
              Utils.setParameterKonsole();
              if(args[5].contains("-D")){
               
              Utils.debugModus();
              ph.printModeDetails();
        }
        }
         if(args[4].contains("-D")){
              Utils.debugModus();
              ph.printModeDetails();
        }
         
     }
                 
      ph.printModeDetails();
    }
    }}}
