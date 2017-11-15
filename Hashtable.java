import java.util.Iterator;

public class Hashtable {

	private LinkedList[] arr;
	private int size;
	
	public Hashtable() {

		arr = new LinkedList[11];
		size = 11;
	}
	
	public boolean containsKey(String key) {
		int index = key.hashCode() % size;
		if (arr[index] != null) {
			Iterator<Link> it = arr[index].iterator();
			
			while(it.hasNext()) {
				Link temp = it.next();
				if(key.equals(temp.getKey())) {
					return true;
				}
			}
		}
		return false;
	}

	public String get(String key) {
		int index = Math.abs(key.hashCode() % size);
		if (Integer.valueOf(index) != null) {
			if (arr[index] != null) {
				Iterator<Link> it = arr[index].iterator();
				
				while(it.hasNext()) {
					Link temp = it.next();
					if(key.equals(temp.getKey())) {
						return temp.getValue();
					}
				}
			}
		}
		return "";
	}
	
	public void put (String key, String value) {
		int index = Math.abs(key.hashCode() % size);
		//System.out.println(index);
		if (Integer.valueOf(index) != null) {
			if(arr[index] == null) {
				LinkedList list = new LinkedList();
				arr[index] = list;
				list.add(key, value);
			} else {
				arr[index].add(key, value);
			}
			//arr[index].printList();
		}
	}
	
	public String remove (String key) { //error
		int index = key.hashCode() % size;
		LinkedList list = arr[index];
		String temp = list.remove(key);
		//arr[index].remove(key);
		return temp;
	}
	
	public void growArray() {
		LinkedList[] newArr = new LinkedList[size * 2 - 1];
		System.arraycopy(arr, 0, newArr, 0, size);
		arr = newArr;
		size = size * 2 - 1;
	}
}
