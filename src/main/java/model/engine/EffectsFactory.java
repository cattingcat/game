package model.engine;

import model.cards_creature.FieldCreature;
import model.cards_templates.Card;
import model.cards_templates.Creature;
import model.cards_templates.Effect;
import model.engine.events.CardPlayedListener;

import java.util.HashMap;
import java.util.Map;

public class EffectsFactory {

    Map<String,Effect> effectDict;

    public EffectsFactory() {
        this.effectDict = madeEffects();
    }


    public Map<String,Effect> madeEffects(){
        HashMap<String,Effect> result = new HashMap<String, Effect>();
        result.put("FrogMaking",new Effect() {
            @Override
            public void playEffect(final Board board, FieldCreature target) {
                board.getCardPlayed().addListener(new CardPlayedListener() {
                    @Override
                    public void playCard(Card card, Board field,int row, int column) {
                        board.playCreature(new Creature("Froggy", 0, 1, 1, 1),row+1,column+1);                      }
                });
            }
        });

        result.put("Buff",new Effect() {
            @Override
            public void playEffect(final Board board, FieldCreature target) {
                target.setHealth(target.getHealth()+1);
                target.setAttack(target.getAttack() + 1);
            }
        });

        return result;
    }
    public Effect getByName(String name){
        return effectDict.get(name);
    }
}
