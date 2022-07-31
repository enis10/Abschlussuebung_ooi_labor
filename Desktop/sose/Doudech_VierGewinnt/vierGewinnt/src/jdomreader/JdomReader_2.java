/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdomreader;
import VierGewinnt.Utils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;
import org.jdom2.output.*;

/**
 *
 * @author anisdoudech
 */

//OOP Variante
public class JdomReader_2 {
    Element root;
    Document doc;
    String xml_path;
    List<Element> personList;
    List<Spieler> players;
    JDOMWriter myWriter;
    
    public JdomReader_2 (String xml_path){
        this.players = new ArrayList <>();
        this.xml_path = xml_path;
        doc =  this.getDoc(xml_path); // unbedingt ein try-catch entwerrfen 
        root = doc.getRootElement();
        personList = root.getChildren();
        myWriter = new JDOMWriter();
       
        
  

        
    }
    
 public static Document getDoc(String path)
    {
        try {
            SAXBuilder sax = new SAXBuilder();
            return sax.build(path);
        } catch (JDOMException | IOException ex) {
           
            return null;
        }
    }

          private void readPersonNode(Element personNode) {

        players.add(new Spieler(personNode.getChildText("name")
                ,personNode.getChildText("games"),
                personNode.getChildText("wins"),
                personNode.getChildText("loses"),
                personNode.getChildText("draws")));
    }
          
         public void ReadData(){
                for (Element e : personList) {
                
                readPersonNode(e);
            }
              
         }
          
       
  public void modifyData(String name,String game){
      boolean da = false;
      
      for (Spieler s: players){
        if(name.equals(s.getName())){
            da = true;
            newData(s,game); }}
      if (!da){
          players.add(addNewPlayer(name, game));
      }
     
      }
  
  
  public void saveData(){
      for ( Spieler s:players){
                myWriter.createPERSON(s.getName(), s.getGames(), s.getWins(), s.getLoses(), s.getDraws());
               }  
      myWriter.writeXML();
  }
  
  
  //**************Bearbeitung der Datenbank******************
  private void newData(Spieler s, String game){
      s.setGames(Integer.toString(Integer.valueOf(s.getGames())+1 ));
     
      //falls der Spieler gewinnt
      if("wins".equals(game)){
          s.setWins(Integer.toString(Integer.valueOf(s.getWins())+1 ));
      }
      else if( "loses".equals(game)){
           s.setLoses(Integer.toString(Integer.valueOf(s.getLoses()) +1));
          
      }
      else  if( "draws".equals(game)) {
           s.setDraws(Integer.toString(Integer.valueOf(s.getDraws())+1 ));
          
      }
  }
  
  //***************Wenn der Spieler new ist***************
  
  private Spieler addNewPlayer(String name,String game){
       Spieler player;
      if ("wins".equals(game)){
      player = new Spieler(name, "1", "1","0","0");
      }
      else if ("loses".equals(game)){
        player = new Spieler(name, "1", "0","1","0");
      }
      else{
        player = new Spieler(name, "1", "0","0","1");
      }
     return player;
     }
    public List<Spieler> getPlayers(){
        int  sizeOfList = players.size();
        String[] arrayOfNames = new String[sizeOfList];
        for (int i=0; i<sizeOfList; i++){
            arrayOfNames[i] =  players.get(i).getName();
           
        }
        return players;
        
    }
    
    
}
