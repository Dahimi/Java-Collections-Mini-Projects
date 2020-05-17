package abstracltListClass;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.*;
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
	Entry<String> root = new Entry("0");
	@Override
	public String get(int arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		System.out.println("size ");
		Iterator iterator = this.iterator() ;
		int size = 0 ;
		while(iterator.hasNext()) {
			iterator.next();
			size++ ;
			
		}
		return size;
	}
	public String getParent(String name) {
		Iterator iterator = this.iterator() ;
		Entry<String> nextEntry ;
		while(iterator.hasNext()) {
			nextEntry = (Entry<String>) iterator.next();
			if(nextEntry.getElementName().equals(name))  {					
					return nextEntry.getParent();				
			}
		}
		return null ;
	}
	@Override
	public boolean add(String element) {
		Iterator iterator = this.iterator() ;
		Entry<String> nextEntry ;
		while(iterator.hasNext()) {
			nextEntry = (Entry<String>) iterator.next() ;
			if(nextEntry.availableToAddLeftChildren) {
				nextEntry.addLeftChild(new Entry<String>(nextEntry , element));
				return true ;			}
			if(nextEntry.availableToAddRightChildren) {
				nextEntry.addRightChild(new Entry<String>(nextEntry,element));
				return true ;
			}
		}
		return false ;
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
	@Override
	public Iterator iterator() {
		return new TreeIterator(this);
	}
	static class Entry<T> implements Serializable {
	     String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;
        public Entry(String elementName){
            this.elementName = elementName ;
            this.availableToAddRightChildren = true ;
            this.availableToAddLeftChildren = true ;
        }
        public Entry(Entry<T> parent ,String elementName){
            this.elementName = elementName ;
            this.availableToAddRightChildren = true ;
            this.availableToAddLeftChildren = true ;
            this.parent = parent ;
        }
        public String getElementName(){
            return elementName ;
        }
        public String getParent(){
        	if(parent != null)
           return parent.getElementName();
        	return null ;
        }
        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren ;
        }
        public void addLeftChild(Entry<T> child) {
        	leftChild = child ;
        	availableToAddLeftChildren = false ;
        }
        public void addRightChild(Entry<T> child) {
        	rightChild = child ;
        	availableToAddRightChildren = false ;
        }
        public boolean hasRightChild() {
        	return ! availableToAddRightChildren;
        }
        public boolean hasLeftChild() {
        	return ! availableToAddLeftChildren ;
        }
        
	 }
	 static class TreeIterator implements Iterator<Entry>{
		 CustomTree tree ;
		 Queue<Entry> queue = new ArrayDeque<Entry>();
		public TreeIterator(CustomTree tree) {
			super();
			this.tree = tree;
			queue.add((Entry) tree.root);
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return ! queue.isEmpty();
		}

		@Override
		public Entry next() {
			// TODO Auto-generated method stub
			Entry nextEntry = queue.poll();
			if (nextEntry.hasLeftChild()) {
				//System.out.println("Queue size " + queue.size() + "retrieving " + nextEntry.elementName );
				queue.add(nextEntry.leftChild);
			}
			if (nextEntry.hasRightChild()) {
				//System.out.println("Queue size " + queue.size() + "retrieving " + nextEntry.elementName );
				queue.add(nextEntry.rightChild);
			}
			
			return nextEntry;
		}
	     
	 }
}
