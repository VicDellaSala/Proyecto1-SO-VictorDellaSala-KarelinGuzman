/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Victor Daniel
 */
public class driveEpisodes extends drive {
    public driveEpisodes(int number){
        super(number);
    }
    
    @Override
    public int add(int amount){
        int amountAdded = amount;        
        setResourse(getResourse() + amount);                  
        return amountAdded;
    }
}
