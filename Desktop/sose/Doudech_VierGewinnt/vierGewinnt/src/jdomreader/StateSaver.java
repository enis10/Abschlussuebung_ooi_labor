/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdomreader;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author anisdoudech
 */
public class StateSaver {
    Element root;
    Document doc;
    static int i=0;
    
    public StateSaver(){
        this.createDOC();
    
}
   
    
  

     private void createDOC(){
        doc = new Document();
        
        root = new Element ("Gruppe");
        doc.addContent(root);
    
        
        
        
    }
     public void setPosition (int row, int col, int player, int currentPlayer){
          Element position ,colE, rowE, playerE,currentPlayerE =null;
    
          position = new Element ("position");
      
          colE = new Element ("col");
          colE.setText(Integer.toString(col));
          
          rowE = new Element ("row");
          rowE.setText(Integer.toString(row)); 
          
          playerE = new Element ("player");
          playerE.setText(Integer.toString(player)); 
          currentPlayerE =new Element("currentPlayer");
          currentPlayerE.setText(Integer.toString(currentPlayer)); 
          
          
          
       
               
          
  
          position.addContent(colE);
          position.addContent(rowE);
          position.addContent(playerE);
          position.addContent(currentPlayerE);
          
          
         
          root.addContent(position);
          
                 
     }
   public void writeXML (String path){ 
     

     XMLOutputter xmloutputter = new XMLOutputter(Format.getPrettyFormat());
     try {
         xmloutputter.output(doc,new FileOutputStream(path));
     }
     catch (Exception e){
         System.out.println("FEHLER "+e); 
     }
        
    }
   
   
   
         
     }

