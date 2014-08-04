
public class SingleLinkedList<T> {

	Node<T> head = null;
	public SingleLinkedList(T data){
		head = new Node<T>(data);
	}
	
	public void appendToTail(T data){
		Node<T> end = new Node<T>(data);
		Node<T> n = head;
		while(n.next != null)
			n = n.next;
		n.next = end;
	}
	
	public T remove(T data){
		Node<T> n = head;
		Node<T> prev = null;
		while(n != null){
			if(n.data.equals(data)){
				if(prev == null){
					T temp = head.data;
					head = head.next;
					return temp;
				}
				else{
					T temp = n.data;
					prev.next = n.next;
					return temp;
				}
			}
		}
		return null;
	}
}

class Node<T>{
	Node<T> next;
	T data;
	
	public Node(T data){
		this.data = data;
		this.next = null;
	}
}

class Tester{
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
}