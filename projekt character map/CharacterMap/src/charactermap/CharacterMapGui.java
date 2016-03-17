/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charactermap;

import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;

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
    }
    
    //uzupelnienie przyciskami do wartosci ascii +33 do i
    public void zbudujGUI(){
        
        int i;
        znaki = new JButton[95];
        
        for(i=0;i<96;i++){
            znaki[i] = new JButton();
            buttonArea.add(znaki[i]);
            znaki[i].setVisible(true);
            znaki[i].addActionListener(this);
            znaki[i].setText(String.valueOf((char)i));
        }
            
    }
    //przechwycenie konkretnego przycisku
    @Override
    public void actionPerformed(ActionEvent akcja){
        Object source = akcja.getSource();
        int i;
        String s;
        for (i=0;i<96;i++){
            if (source == znaki[i]){
                wynik.setText(String.valueOf(i));
            }
            else{
                wynik.setText("Error");
                return;
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
