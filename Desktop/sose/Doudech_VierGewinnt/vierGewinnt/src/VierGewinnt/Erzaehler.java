/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package VierGewinnt;


import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anisdoudech
 */
class Erzaehler extends Observable
            {
        Integer i;
        public Erzaehler(SettingsConsole z1) throws InterruptedException
        {
            addObserver(z1);
            
            this.setChanged();
           
            this.notifyObservers((Utils.getInstance().getTurn()));
            this.setChanged();
             
}
        }