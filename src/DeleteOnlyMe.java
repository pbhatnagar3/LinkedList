import java.util.Random;
import java.util.Scanner;

/**
 * INTERESTING
 * delete a node that is in the middle of the linkedList if you only have access to that node 
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class DeleteOnlyMe {
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		System.out.println("How many elements you will add to the list");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 0; i < num; i++){
			System.out.println("Enter element " + (i+1));
			list.appendToTail(scan.nextInt());
		}
		System.out.println(list);
		/*
		 *NOTE TO SELF :
		 *for finding random numbers between two numbers you should do the following:
		 * int Low = 10;
		 * int High = 100;
		 *  int R = r.nextInt(High-Low) + Low; 
		 */
		Random r = new Random();
		int index = r.nextInt(num - 1);
		Node<Integer> accessPoint = list.get(index);
		//if we have access to only this node in a single LinkedList, then
		//first we will copy the value of next element into this element
		//and then delete the next node
		
		accessPoint.data = accessPoint.next.data;
		accessPoint.next = accessPoint.next.next;
		System.out.println(list);
	}
	

}
