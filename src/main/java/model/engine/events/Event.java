package model.engine.events;

import java.util.*;

/**
 * Created by Константин on 23.02.14.
 */
public abstract class Event<T> {
        List<T> listeners = new ArrayList<T>();

        public void addListener(T toAdd) {
            listeners.add(toAdd);
        }


        public void deleteListener(T toDel) {
            if (listeners.contains(toDel)) {
                listeners.remove(toDel);
            }
        }
}

/*
        public void sayHello() {
            System.out.println("Hello!!");

            // Notify everybody that may be interested.
            for (HelloListener hl : listeners)
                hl.someoneSaidHello();
        }
    }
*/

