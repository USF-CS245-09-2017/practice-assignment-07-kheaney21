import java.util.Iterator;

public class LinkedList {
	private Link head;
	private Link tail;
	private int size;
	
	public LinkedList() {
		head = null;
		tail = null;
	}
	
	public void add(String key, String value) {
		Link newLink = new Link(key, value);
		if (size  ==  0) {
			head = newLink;
			tail = newLink;
		} else {
			tail.setNext(newLink);
			tail = newLink;
		}
		size++;
	}
	
	public void add(int pos, String key, String value) {
		Link current = head;
		int count = 0;
		while(current.hasNext()) {
			if(count == pos) {
				Link newLink = new Link(key, value);
				newLink.setNext(current.next());
				current.setNext(newLink);
				size++;
			}
		}
	}
	
	public String remove (String key){
		Link current = head;
		
		//remove from head
		if (current.getKey().equals(key)) {
			Link temp = current;
			head = current.next();
			return temp.getValue();
		} else {
			while(current.hasNext()) {
				if(current.next().getKey().equals(key)) {
					Link temp = current;
					current.setNext(current.next().next());
					size--;
					return temp.getValue();
				}
			}
		}
		return "";
	}
	
	public String get(int pos){
		Link current = head;
		int count = 0;
		while(current.hasNext()) {
			if(count == pos) {
				return current.getValue();
			}
		}
		return null;
	}
	
	public int size () {
		return size;
	}
	
	public void printList() {
		Link current = head;
		while (current != null) {
			System.out.println(current.getValue());
			current = current.next();
		}
	}
	
	public ListIterator iterator() {
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Link> {
		private Link current;
		
		ListIterator() {
			current = head;
		}
		public boolean hasNext(){
			return (current != null);
		}
		public Link next() {
			if(!hasNext()) {
				return null;
			}
			//check to use head and current
			Link temp = current;
			current = current.next();
			return temp;
		}
	}
}
