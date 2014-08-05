import java.util.Scanner;

/**
 * So we have to print out the nth last element of the single linked list. 
 * We will use a runners technique for this.
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class NthLastElement {
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		System.out.println("Enter the number of elements that you want to add to the list");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 0; i < num; i++){
			System.out.println("Enter element number " + (i+1));
			list.appendToTail(scan.nextInt());
		}
		
		//now that we have the list, we will ask the user to enter the value of n
		
		System.out.println("what element, counting from the end do you want me to print");
		int n = scan.nextInt();
		Node<Integer> temp = list.head;
		//this is the node that will precede the node temp after n iterations
		Node<Integer> pTemp = temp;
		while(temp.next != null){
			
			temp = temp.next;
			if(n-- <= 0)
				pTemp = pTemp.next;
		}
		
		System.out.println("Master.... the value that you requested is " + pTemp.data);
	}

}
