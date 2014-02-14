package model.cards_creature;


import java.util.UUID;

public class CreaturesFactory {

    private CreaturesFactory(){

    }

    public FieldCreature getFieldCreature(UUID uuid){
        // TODO ...
        return null;
    }

    private static CreaturesFactory factory = null;
    public static CreaturesFactory  getInstance(){
        if(factory == null){
            factory = new CreaturesFactory();
        }
        return factory;
    }
}
