/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.objectStudy2;
import java.util.ArrayList;
/**
 *
 * @author Choir
 */
public abstract class Human 
{
    public abstract int open();
    public abstract void setCard(ArrayList<Integer> card);
    public abstract boolean checkSum();
    ArrayList<Integer> myCards;
}
