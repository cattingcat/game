package model.engine.game_objects;

import model.cards_creature.FieldCreature;
import model.cards_templates.Card;
import model.cards_templates.Creature;
import model.cards_templates.Effect;

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

    public void addTopCard(Card c){
        cards.add(c);
    }



}