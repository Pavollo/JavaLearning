/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charactermap;

/**
 *
 * @author Pawcio
 */
public class CharacterMapEngine {
 
    private char ostatniZnak;
    private char terazZnak;
    private String IO;
    public enum CharacterMapState{GOTOWY, POKAZ};
    private CharacterMapState status = CharacterMapState.GOTOWY;
    
    public String getIO(){
        return IO;
    }
    
    public void setIO(String IO){
        this.IO = IO;
    }
    
    public char getostatniZnak(){
        return ostatniZnak;
    }
    
    public void setostatniZnak(char ostatniZnak){
        this.ostatniZnak = ostatniZnak;
    }
    
    public CharacterMapState getState(){
        return status;
    }
    
    public void setState(CharacterMapState s){
        status = s;
    }
    
    public char getCharacter(){
        return terazZnak;
    }
    
    public void setCharacter(char c){
        terazZnak = c;
    }
    
    private static final CharacterMapEngine INSTANCE = new CharacterMapEngine();

    CharacterMapEngine(){
        if (INSTANCE != null) {
            //runtime exception
            throw new IllegalStateException("Already instantiated");
        }
        status = CharacterMapState.GOTOWY;
    }

    public static CharacterMapEngine getInstance() {
        return INSTANCE;
    }
    
}
