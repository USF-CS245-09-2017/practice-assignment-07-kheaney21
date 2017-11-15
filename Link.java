public class Link {
	
	private String value;
	private String key;
	private Link next;
	
	public Link(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
	public String getKey() {
		return key;
	}
	
	public Link next() {
		return next;
	}
	
	public boolean hasNext() {
		return next != null;
	}
	
	public void setNext(Link newLink) {
		next = newLink;
	}
}
