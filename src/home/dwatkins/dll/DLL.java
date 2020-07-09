package home.dwatkins.dll;

public class DLL {
	public Node head;
	public Node tail;
	
	DLL() {
		this.head = null;
		this.tail = null;
	}
	
	public void push(Node newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		else {
			this.tail.next = newNode;
			newNode.prev = this.tail;
		}
		this.tail = newNode;
	}
	
	public Node pop() {
		if (this.head == null) {
			System.out.println("List is empty");
			return null;
		}
		else {
			Node popNode = this.tail;
			this.tail = this.tail.prev;
			if (popNode == this.head) {
				this.head = null;
			}
			else {
				this.tail.next = null;
			}
			return popNode;
		}
	}
	
	public boolean contains(int value) {
		Node runner = this.head;
		while (runner != null) {
			if (runner.value == value) {
				return true;
			}
			runner = runner.next;
		}
		return false;
	}
	
	public int size() {
		int size = 0;
		Node runner = this.head;
		while (runner != null) {
			size++;
			runner = runner.next;
		}
		return size;
	}
	
	public void insertAt(Node newNode, int index) {
		if (index > this.size()) {
			System.out.println("Index out of range");
			return;
		}
		else if (this.size() == 0) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}
		else if (index == 0) {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
			return;
		}
		else if (index == this.size()) {
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
			return;
		}
		else {
			int location = 0;
			Node runner = this.head;
			while (location < index) {
				location++;
				runner = runner.next;
			}
			newNode.next = runner;
			newNode.prev = runner.prev;
			runner.prev = newNode;
			newNode.prev.next = newNode;
			return;
		}
	}
	
	public void removeAt(int index) {
		if (index >= this.size()) {
			System.out.println("Index out of range");
			return;
		}
		else if (this.size() == 1) {
			this.head = null;
			this.tail = null;
			return;
		}
		else if (index == 0) {
			this.head = this.head.next;
			this.head.prev = null;
			return;
		}
		else if (index == this.size() - 1) {
			this.tail = this.tail.prev;
			this.tail.next = null;
			return;
		}
		else {
			int location = 0;
			Node runner = this.head;
			while (location < index) {
				location++;
				runner = runner.next;
			}
			runner.prev.next = runner.next;
			runner.next.prev = runner.prev;
			return;
		}
	}
	
	public boolean isPalindrome() {
		Node frontRunner = this.head;
		Node backRunner = this.tail;
		while (frontRunner != backRunner && frontRunner != backRunner.next) {
			if (frontRunner.value != backRunner.value) {
				return false;
			}
			frontRunner = frontRunner.next;
			backRunner = backRunner.prev;
		}
		return true;
	}
	
	public void printValuesForward() {
		Node runner = this.head;
		while (runner != null) {
			System.out.println(runner.value);
			runner = runner.next;
		}		
	}
	
	public void printValuesBackward() {
		Node runner = this.tail;
		while (runner != null) {
			System.out.println(runner.value);
			runner = runner.prev;
		}
	}
}
