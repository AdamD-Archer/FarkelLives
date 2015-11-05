/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author zev
 */
public class Players {
    private String name;
    private int arrayPosition;
    private int score = 0;
    private boolean isPerson;

    public Players() {
    }
    
    public Players(String name, int position, boolean ishuman) {
        this.arrayPosition = position;
        this.name = name;
        this.isPerson = ishuman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArrayPosition() {
        return arrayPosition;
    }

    public void setArrayPosition(int arrayPosition) {
        this.arrayPosition = arrayPosition;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isIsPerson() {
        return isPerson;
    }

    public void setIsPerson(boolean isPerson) {
        this.isPerson = isPerson;
    }

    @Override
    public String toString() {
        return "Players{" + "name=" + name + ", arrayPosition=" + arrayPosition + ", score=" + score + ", isPerson=" + isPerson + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.arrayPosition;
        hash = 23 * hash + this.score;
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
        final Players other = (Players) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.arrayPosition != other.arrayPosition) {
            return false;
        }
        if (this.score != other.score) {
            return false;
        }
        if (this.isPerson != other.isPerson) {
            return false;
        }
        return true;
    }
    
    
}
