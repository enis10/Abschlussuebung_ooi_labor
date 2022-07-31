package jdomreader;


import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author anisdoudech
 */

public class JDOMWriter {
    Element root;
    Document doc;
    static int i=0;
    
    public JDOMWriter(){
        this.createDOC();
    
}
   
    
  

     private void createDOC(){
        doc = new Document();
        
        root = new Element ("Gruppe");
        doc.addContent(root);
    
        
        
        
    }
     public void createPERSON (String name, String games, String wins,String loses, String draws){
          Element spieler ,nameE, gamesE, drawsE, winsE, losesE =null;
    
          spieler = new Element ("spieler");
          // Jeder Person hat eine bestimme id um Personen von einander zu unterscheiden
          spieler.setAttribute ("id",""+ i++);
          //Unterelemente erzeugen Vorname Nachname Telefonnummer erstellen
          nameE = new Element ("name");
          //inhalt des Elementes einsetzen
          nameE.setText(name);
          gamesE = new Element ("games");
          gamesE.setText(games);
          
          drawsE = new Element ("draws");
          
          drawsE.setText(draws);
          
          winsE = new Element ("wins");
          winsE.setText(wins);
          
          losesE = new Element("loses");
          losesE.setText(loses);
          
          // Die Unterelelemente sind Komponenten von dem Hauptelement Person
          //diese Komponenten werden zum Hauptelelement hinzugefügt
          spieler.addContent(nameE);
          spieler.addContent(gamesE);
          spieler.addContent(drawsE);
          spieler.addContent(winsE);
          spieler.addContent(losesE);
          root.addContent(spieler);
          
                 
     }
   public void writeXML (){
       
     
       
     XMLOutputter xmloutputter = new XMLOutputter(Format.getPrettyFormat());
     try {
         xmloutputter.output(doc,new FileOutputStream("/users/Doudech_Ayadi_VierGewinnt/vierGewinnt/4GewinntDatenbank.xml"));
     }
     catch (Exception e){
         System.out.println("FEHLER "+e); 
     }
        
    }
         
     }