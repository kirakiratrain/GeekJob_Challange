/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.objectStudy2;
//import org.objectStudy2.Human;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Choir
 */
public class Dealer extends Human
{
    ArrayList<Integer> cards;
    public Dealer()
    { 
        cards = new ArrayList<Integer>();
        myCards = new ArrayList<Integer>();
        
        int cardsCnt = 13*4;
        for(int i = 0; i < cardsCnt ;i++)
        {
            cards.add(i+1);
        }
    }
    
    //cardsからランダムで2枚のArrayListを返す
    public ArrayList<Integer> deal()
    {
        ArrayList<Integer> randCards = new ArrayList<Integer>();
        Random random = new Random();
        Integer index = random.nextInt(cards.size());
        randCards.add(cards.get(index));
        cards.remove(index);
        
        index = random.nextInt(cards.size());
        randCards.add(cards.get(index));
        cards.remove(index);
        
        return randCards;
    }
    //cardsからランダムで一枚のカードをAllayListに返す。
    public ArrayList<Integer> hit()
    {
        ArrayList<Integer> randCard = new ArrayList<Integer>();
        Random random = new Random();
        Integer index = random.nextInt(cards.size());
        randCard.add(cards.get(index));
        return randCard; 
    }
    //myCardsの合計値を返す
    public int  open()
    {
        int size = myCards.size();
        int sum = 0;
        int cardNum = 0;
        for(int i = 0;i<size;i++)
        {
            if(myCards.get(i) > 9)
            {
                cardNum = 10;
            }
            else
            {
                cardNum = myCards.get(i);
            }
            sum += cardNum;
        }
        
        //A + (10,J、Q, K )の場合 強制的に21
        if(size == 2)
        {
            int bj1,bj2;
            bj1 = myCards.get(0);
            bj2 = myCards.get(1);
            if((bj1 == 1 && bj2 > 9 )
                    || (bj1 >9  && bj2 == 9 ))
            {
                sum = 21;
            }
        }
        
        return sum;
    };
    
    //ArrayListで受けたカードをmyCardsにセットする。
    public void setCard(ArrayList<Integer> card)
    {
        int cnt = card.size();
        for(int i = 0;i<cnt;i++)
        {
             myCards.add(card.get(i));
        }
    };
    
    //myCardsを確認し、まだカードが必要ならTrue,必要なければfalse
    public boolean checkSum()
    {
        boolean ret = false;
        int sum = open();
        
        if(sum < 21)
        {
            ret = true;
        }
        
        return ret;
    };
}
