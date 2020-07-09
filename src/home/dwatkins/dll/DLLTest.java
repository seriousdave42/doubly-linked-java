package home.dwatkins.dll;

public class DLLTest {

	public static void main(String[] args) {
		DLL dll = new DLL();
		
		Node n0 = new Node(10);
		Node n1 = new Node(5);
		Node n2 = new Node(23);
//		Node n3 = new Node(23);
		Node n4 = new Node(5);
		Node n5 = new Node(10);
		
		dll.push(n0);
		dll.push(n1);
		dll.push(n2);
//		dll.push(n3);
		dll.push(n4);
		dll.push(n5);

		System.out.println(dll.isPalindrome());
	}

}
