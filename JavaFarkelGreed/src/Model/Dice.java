/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author zev
 */
public class Dice {
    private int value;
    private int arrayPosition;

    public Dice() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getArrayPosition() {
        return arrayPosition;
    }

    public void setArrayPosition(int arrayPosition) {
        this.arrayPosition = arrayPosition;
    }

    @Override
    public String toString() {
        return "Dice{" + "value=" + value + ", arrayPosition=" + arrayPosition + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.value;
        hash = 53 * hash + this.arrayPosition;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dice other = (Dice) obj;
        if (this.value != other.value) {
            return false;
        }
        if (this.arrayPosition != other.arrayPosition) {
            return false;
        }
        return true;
    }
    
    
    
}
