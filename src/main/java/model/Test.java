package model;

import model.cards_creature.FieldCreature;
import model.cards_templates.Card;
import model.cards_templates.Creature;
import model.cards_templates.Effect;
import model.engine.Board;
import model.engine.EffectsFactory;
import model.engine.events.CardPlayedListener;
import model.engine.game_objects.Deck;


public class Test {
    public static Deck getTestDeck(){
        EffectsFactory ef = new EffectsFactory();

        Deck result = new Deck();

        for(int i = 0;i<30;i++){
           result.addTopCard(new Creature("Simple Creature", 0, 2, 2, 2,ef.getByName("FrogMaking")));
        }
        return result;
    }
}
