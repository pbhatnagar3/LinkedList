import java.util.LinkedList;
import java.util.Scanner;

/**
 * adding two linkedLists
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class AddLinkedList<T> {

	public static LinkedList<Integer> add(SingleLinkedList l1, SingleLinkedList l2){
		final LinkedList<Integer> output = new LinkedList<Integer>();
		int size1 = l1.size;
		Node n = l1.head;
		Node m = l2.head;
		int sum = 0;
		int carryOver = 0;
		int firstElement = 0;
		int secondElement = 0;
		while(true){
			
			if(m!= null)
			    firstElement = (Integer)m.data;
			else
				firstElement = 0;
			if(n!= null)
				secondElement = (Integer)n.data;
			else
				secondElement = 0;
				
			sum = firstElement + secondElement + carryOver;
			carryOver = sum / 10;
			output.addFirst(sum % 10);
			if(n != null)
				n = n.next;
			if(m!= null)
				m = m.next;
			if(n == null && m == null)
				break;
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> list1 = new SingleLinkedList<Integer>();
		SingleLinkedList<Integer> list2 = new SingleLinkedList<Integer>();
		System.out.println("How many elements in the first element");
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		System.out.println("How many elements in the second element");
		int num2 = scan.nextInt();
		System.out.println("When entering the elements of the number, start with the units place and then the tens place and move forward");
		for(int i = 0; i < num1; i++){
			System.out.println("enter number " + (i+1));
			list1.appendToTail(scan.nextInt());
		}
		
		for(int i = 0; i < num2; i++){
			System.out.println("enter number " + (i+1));
			list2.appendToTail(scan.nextInt());
		}
		
//		System.out.println(AddLinkedList.add(list1, list2));
		LinkedList<Integer> output = AddLinkedList.add(list1, list2);
		for(Integer t : output){
			System.out.print(t + " -->  ");
		}
	}
}
