package model.engine.game_objects;

import model.SimpleCreature;
import model.cards_templates.Card;

import java.util.LinkedList;


public class Deck {
    LinkedList<Card> cards;


    {
        cards = new LinkedList<Card>();
    }

    public void shuffleDeck(){

    }

    public Card getTopCard(){
        return cards.peek();
    }

    public static Deck getTestDeck(){
        Deck result = new Deck();

        for(int i = 0;i<30;i++){
            result.cards.add(new SimpleCreature());
        }
        return result;
    }
}