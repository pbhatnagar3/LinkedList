/**
 * Simple implementation of DoubleLinkedList
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 * @param <T>
 */
public class DoubleLinkedList<T> {

	DoubleNode<T> head;
	DoubleNode<T> tail;
	int size;

	public DoubleLinkedList(T data){
		head = new DoubleNode<T>(data);
		tail = head;
		size = 0;
	}
	
	public DoubleLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}

	public void addToTail(T data){
		size++;
		if(tail == null){
			head = new DoubleNode<T>(data);
			tail = head;
			return;
		}
		tail.next = new DoubleNode<T>(data);
		tail.next.previous = tail;
		tail = tail.next;
		return;
	}

	public void addToHead(T data){
		size++;
		if(head == null){
			head = new DoubleNode<T>(data);
			tail = head;
		}
		else{
			head.previous = new DoubleNode<T>(data);
			head.previous.next = head;
			head = head.previous;
		}
	}

	public T removeFromHead(){
		size--;
		if(head == null)
			return null;
		T temp = head.data;
		if(head.next != null)
			head.next.previous = null;
		head = head.next;
		return temp;
	}

	public T removeFromTail(){
		size--; 
		if(tail == null)
			return null;
		T temp = tail.data;
		tail.previous.next = null;
		tail = tail.previous;
		return temp;
	}

	public T remove(T data){
		if(head == null)
			return null;
		else{
			DoubleNode<T> n = head;
			while(n!= null){
				if(n.data.equals(data)){
					size--;
					T temp = n.data;
					if(n == head){
						head = head.next;
						head.previous = null;
					}
					else if(n == tail){
						tail = tail.previous;
						tail.next = null;
					}
					else{
						n.previous.next = n.next;
						n.next.previous = n.previous;
					}

					return temp;
				}
				n = n.next;	
			}
			return null;
		}// end of else

	}

	public String toString(){
		StringBuffer output = new StringBuffer();
		DoubleNode<T> n = head;
		while(n!= null){
			if(n.next == null)
				output.append(n.data + "-->//");
			else
				output.append(n.data + "<-->");
			n = n.next;
		}
		if (output.length() > 0)
			return output.toString();
		else
			return "Nothing in the list right now";
					
	}
}

class DoubleNode<T>{
	T data;
	DoubleNode<T> previous;
	DoubleNode<T> next;

	public DoubleNode(T data){
		this.data = data;
		this.previous = null;
		this.next = null;
	}

}

class DListTester{
	public static void main(String[] args) {
		System.out.println("Hello world of Double LinkedList");
		DoubleLinkedList<Integer> dList = new DoubleLinkedList<Integer>(12);
		System.out.println(dList);
		dList.addToHead(1);
		dList.addToTail(100);
		System.out.println(dList);
		dList.removeFromHead();
		System.out.println(dList);
		dList.removeFromTail();
		System.out.println(dList);
		dList.removeFromHead();
		System.out.println(dList);
		dList.addToHead(5);
		dList.addToHead(1);
		dList.addToHead(25);
		System.out.println(dList);
		dList.remove(1);
		System.out.println(dList);
		

	}
}
