/**
 * Simple LinkedList (single) implemented. 
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 * @param <T>
 */
public class SingleLinkedList<T> {

	Node<T> head = null;
	int size = 0;
	public SingleLinkedList(){
		this.head = null;
	}
	public SingleLinkedList(T data){
		head = new Node<T>(data);
	}

	public void appendToTail(T data){
		this.size++;
		Node<T> end = new Node<T>(data);
		Node<T> n = head;
		if(n == null){
			head = end;
			return;
		}
		while(n.next != null)
			n = n.next;
		n.next = end;
	}

	public T remove(T data){
		Node<T> n = head;
		Node<T> prev = null;
		while(n != null){
			if(n.data.equals(data)){
				size--;
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
			prev = n;
			n = n.next;
		}
		return null;
	}
	
	public Node<T> get(int index){
		Node<T> temp = head;
		if( index > size ){
			return null;
		}
		else{
			while(index!=0){
				temp = temp.next;
				index--;
			}
			return temp;
		}
	}

	public String toString(){
		StringBuffer output = new StringBuffer();
		Node<T> n = head;
		while(n != null){
			if(n.next!= null)
				output.append(n.data.toString() + "-->");
			else
				output.append(n.data.toString());
			n = n.next;
		}
		return output.toString();
	}
	
	public static void merge(SingleLinkedList s1, SingleLinkedList s2){
		Node n = s1.head;
		while(n.next != null){
			n = n.next;
		}
		n.next = s2.head;
		//damage done :P
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
		SingleLinkedList<Integer> sList = new SingleLinkedList<Integer>(12);
		sList.appendToTail(15);
		System.out.println(sList);
		sList.remove(15);
		sList.appendToTail(24);
		System.out.println(sList);
		sList.remove(12);
		System.out.println(sList);
	}
}