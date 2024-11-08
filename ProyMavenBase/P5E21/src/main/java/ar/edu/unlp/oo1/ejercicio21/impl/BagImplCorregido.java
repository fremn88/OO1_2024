package ar.edu.unlp.oo1.ejercicio21.impl;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BagImplCorregido<T> extends AbstractCollection<T> implements Bag<T> {

    Map<T, Integer> elements;

    public BagImplCorregido() {
    	this.elements = new HashMap<T, Integer>();
    }

    @Override
    public boolean add(T element) {
    	if(elements.containsKey(element)) {
    		elements.put(element, elements.get(element)+1);
    	} else {
    		elements.put(element, 1);
    	}
        return true;
    }

    @Override
    public int occurrencesOf(T element) {
    	if(elements.containsKey(element)) {
    		return elements.get(element);
    	} else return 0;
    }

    @Override
    public void removeOccurrence(T element) {
    	//no chequeo si la llave existe, dado que el map por defecto devuelve null si removemos algo que no existe. (no genera error)
    	if(elements.get(element)>1) {
    		elements.put(element, elements.get(element)-1);
    	} else elements.remove(element);
    }

    @Override
    public void removeAll(T element) {
    	//no chequeo si la llave existe, dado que el map por defecto devuelve null si removemos algo que no existe. (no genera error)
    	elements.remove(element);
    }

    @Override
    public int size() {
       return elements.values().stream().mapToInt(e->e).sum();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<Map.Entry<T, Integer>> entryIterator = elements.entrySet().iterator();
            private Map.Entry<T, Integer> currentEntry;
            private int remainingCount;

            @Override
            public boolean hasNext() {
                return remainingCount > 0 || entryIterator.hasNext();
            }

            @Override
            public T next() {
                if (remainingCount == 0) {
                    currentEntry = entryIterator.next();
                    remainingCount = currentEntry.getValue();
                }
                remainingCount--;
                return currentEntry.getKey();
            }

            @Override
            public void remove() {
                removeOccurrence(currentEntry.getKey());
            }
        };
    }
}
