/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdomreader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author anisdoudech
 */
public class StateReader {
    Element root;
    Document doc;
    String xml_path;
    List<Element> positionenList;
     byte board [][];
     byte currentPlayer ;
  
    
    public StateReader (String xml_path){
       
        this.xml_path = xml_path;
        doc =  this.getDoc(xml_path); // unbedingt ein try-catch entworfen 
        root = doc.getRootElement();
        positionenList = root.getChildren();
        board = new byte[6][7];
        currentPlayer = 0;
       
        
  

        
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
 
  private void readPositionNode(Element pos) {
      byte row, col, player;
      row = Byte.valueOf(pos.getChildText("row"));
      col = Byte.valueOf(pos.getChildText("col"));
      player = Byte.valueOf(pos.getChildText("player"));
      currentPlayer =  Byte.valueOf(pos.getChildText("currentPlayer"));
      
       board[row][col] = player;
       
   
    
  
    }
          
         public void ReadData(){
                for (Element e : positionenList) {  
                readPositionNode(e);
            }
           
                }
         
         public byte[][] getState(){
             return board;
         }
         public byte getCurrentPlayer(){
             return currentPlayer;
         }
     
}
