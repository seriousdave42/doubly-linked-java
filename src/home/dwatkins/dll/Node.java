package home.dwatkins.dll;

public class Node {
	public int value;
	public Node next;
	public Node prev;
	
	public Node(int val) {
		this.value = val;
		this.next = null;
		this.prev = null;
	}
}
