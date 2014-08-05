import java.util.Scanner;
/**
 * Here is a palindrome checker. It returns true for an empty list and also if the list has only one element.
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */

public class PalindromeChecker {

	public static void main(String[] args) {
		System.out.println("Enter the number of elements that you want to enter");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		for(int i = 0; i < num; i++){
			System.out.println("Enter element " + (i + 1));
			list.addToHead(scan.nextInt());
		}
		
		System.out.println("The fact that the list is a pallendrome is " + PalindromeChecker.checker(list));
	}

	private static boolean checker(DoubleLinkedList<Integer> list) {
		// TODO Auto-generated method stub
		DoubleNode<Integer> h = list.head;
		DoubleNode<Integer> t = list.tail;
		int counter = 0;
		while(counter < list.size){
			if(h.data == t.data){
				h = h.next;
				t = t.previous;
				counter++;
			}
			else
				return false;
		}
		
		return true;
		
	}
}
