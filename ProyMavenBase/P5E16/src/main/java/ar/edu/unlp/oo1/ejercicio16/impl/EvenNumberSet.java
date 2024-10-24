package ar.edu.unlp.oo1.ejercicio16.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("hiding")
public class EvenNumberSet<Integer> implements Set<Integer> {

	private TreeSet<Integer> numerosPares;
	
	public EvenNumberSet() {
		numerosPares = new TreeSet<Integer>();
	}
	
	@Override
	public int size() {
		return numerosPares.size();
	}

	@Override
	public boolean isEmpty() {
		return numerosPares.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return numerosPares.contains(o);
	}

	@Override
	public Iterator<Integer> iterator() {
		return numerosPares.iterator();
	}

	@Override
	public Object[] toArray() {
		return numerosPares.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return numerosPares.toArray(a);
	}

	@Override
	public boolean add(Integer e) {
		if((int)e%2==0) {
			return numerosPares.add(e);
		} else return false;
	}

	@Override
	public boolean remove(Object o) {
		return numerosPares.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return numerosPares.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		return numerosPares.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return numerosPares.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return numerosPares.removeAll(c);
	}

	@Override
	public void clear() {
		numerosPares.clear();
	}

}
