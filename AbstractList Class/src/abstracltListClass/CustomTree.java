package abstracltListClass;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.*;
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

	@Override
	public String get(int arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String set(int index, String element) {
		throw new UnsupportedOperationException();
	}
	public void add(int index, String element) {
		throw new UnsupportedOperationException();
	}
	public String remove(int index) {
		throw new UnsupportedOperationException();
	}
	public List<String> subList(int fromIndex, int toIndex){
		throw new UnsupportedOperationException();
	}
	protected void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
	public boolean addAll(int index, Collection<? extends String> c) {
		throw new UnsupportedOperationException();
	}

}
