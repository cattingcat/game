package model;

import model.cards_creature.FieldCreature;
import model.cards_templates.Card;
import model.cards_templates.Creature;
import model.cards_templates.Effect;
import model.engine.Board;
import model.engine.events.CardPlayedListener;
import model.engine.game_objects.Deck;


public class Test {
    public static Deck getTestDeck(){
        Deck result = new Deck();

        for(int i = 0;i<30;i++){
           result.addTopCard(new Creature("Simple Creature", 0, 2, 2, 2,new Effect() {
                @Override
                public void playEffect(final Board board, FieldCreature target) {
                    board.getCardPlayed().addListener(new CardPlayedListener() {
                        @Override
                        public void playCard(Card card, Board field,int row, int column) {
                            board.playCreature(new Creature("Froggy", 0, 1, 1, 1),row+1,column+1);                      }
                    });
                }
            }));
        }
        return result;
    }
}
