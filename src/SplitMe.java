import java.util.Random;
import java.util.Scanner;

/**
 * Take in a single linked List as the input and then split it based on X
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class SplitMe {

	public static void main(String[] args){
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements that you want to enter in the linked List");
		int num = scan.nextInt();
		for(int i = 0; i < num; i++){
			System.out.println("enter number " + (i+1));
			list.appendToTail(scan.nextInt());
		}
		
		Random r = new Random();
		int pivot = r.nextInt(num);
		int pivotNumber = list.get(pivot).data;
		System.out.println("here is the pivot element " + pivotNumber);
		SingleLinkedList<Integer> less = new SingleLinkedList<Integer>();
		SingleLinkedList<Integer> greater = new SingleLinkedList<Integer>();
		Node<Integer> n = list.head;
		while(n!= null){
			if(n.data < pivotNumber)
				less.appendToTail(n.data);
			else
				greater.appendToTail(n.data);
			n = n.next;
		}
		System.out.println("Here is the original list " + list);
		System.out.println("Here is the smaller list" + less);
		System.out.println("here is the greater list" + greater);
		SingleLinkedList.merge(less, greater);
		System.out.println("Here is the merged version" + less);
	}
}
