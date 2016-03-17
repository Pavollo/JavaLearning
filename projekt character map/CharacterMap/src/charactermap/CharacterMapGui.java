/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charactermap;

import java.awt.*;
import javax.swing.*;
//import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pawcio
 */

public class CharacterMapGui implements ActionListener {
    JFrame ramka;
    JTextField wynik;
    JPanel buttonArea;
    JButton znaki[];
    
    //utworzenie okna
    private void createFrame(){
        ramka = new JFrame("Character Map");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.getContentPane().setLayout(new BoxLayout(ramka.getContentPane(), BoxLayout.Y_AXIS));
        ramka.setVisible(true);
        ramka.setSize(1000, 500);
    }
    
    //utworzenie pola z wynikiem
    private void addIo(){
        wynik = new JTextField(40);        
        ramka.getContentPane().add(wynik);
        wynik.setVisible(true);
        wynik.setEditable(false);
        wynik.setText("********");
    }
    
    //utworzenie konteneru z przyciskami
    private void createButtonArea(){
        //adding container
        buttonArea = new JPanel(new GridLayout(10,10));
        ramka.getContentPane().add(buttonArea);
        buttonArea.setVisible(true);
    }
    
    //uzupelnienie przyciskami do wartosci ascii +33 do i
    public void zbudujGUI(){
        
        int i;
        znaki = new JButton[94];
        
        for(i=0;i<94;i++){
            znaki[i] = new JButton();
            buttonArea.add(znaki[i]);
            znaki[i].setVisible(true);
            znaki[i].addActionListener(this);
            znaki[i].setText(String.valueOf((char)(i+33)));
        }
            
    }
    //przechwycenie konkretnego przycisku
    @Override
    public void actionPerformed(ActionEvent akcja){
        Object source = akcja.getSource();
        int i;
        String s;
        //String s;
        for (i=0;i<96;i++){
            if (source == znaki[i]){
                if(CharacterMapEngine.getInstance().getState() == CharacterMapEngine.CharacterMapState.GOTOWY){
                    CharacterMapEngine.getInstance().setState(CharacterMapEngine.CharacterMapState.POKAZ);
                    CharacterMapEngine.getInstance().setCharacter((char)(i+33));
                    CharacterMapEngine.getInstance().setostatniZnak((char)(i+33));
                    wynik.setText(String.valueOf(i+33));
                }
                else if (CharacterMapEngine.getInstance().getState() == CharacterMapEngine.CharacterMapState.POKAZ){
                    CharacterMapEngine.getInstance().setCharacter((char)(i+33));
                    if (CharacterMapEngine.getInstance().getCharacter() == CharacterMapEngine.getInstance().getostatniZnak()){
                        CharacterMapEngine.getInstance().setState(CharacterMapEngine.CharacterMapState.GOTOWY);
                        //s = String.valueOf(i+33);
                        wynik.setText(String.valueOf(i+33));
                        CharacterMapEngine.getInstance().setIO(String.valueOf(i+33));
                    } else{
                        CharacterMapEngine.getInstance().setCharacter((char)(i+33));
                        CharacterMapEngine.getInstance().setCharacter((char)(i+33));
                        wynik.setText(String.valueOf(i+33));
                    }
                }
            }
            
        }
        
    }
    
    public CharacterMapGui(){
        createFrame();
        addIo();
        createButtonArea();
        zbudujGUI();
    }
   
}
