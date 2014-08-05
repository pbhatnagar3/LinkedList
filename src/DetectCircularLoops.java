import java.util.Scanner;

/**
 * NOTE: FOR THE FOLLOWING PROBLEM, WE WILL HAVE TO CREATE AN EVIL LINKEDLIST WITH LOOPS AND THIS IS NOT RECOMMENDED TO BE DONE AS A PRACTISE. PEOPLE, PLEASE DONT TRY THIS AT HOME :P
 * Interesting problem... We have to detect circles in the linkedList. 
 * 	One of the ways of doing this is making a HashMap and adding everything to it and checking at the same time if the same thing is being added twice
 * ^this approach is cool but it takes alot of space
 * But, there is one other thing that we can do and have two pointers running at different speeds and then whenever these two meet 
 * 
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class DetectCircularLoops {

	public static void main(String[] args) {
		//we will have to create a bad list with loops in it. HAHAHAHA (evil laugh) 
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements that you want to enter in the linked List. Please enter atleast 3 elements");
		int num = scan.nextInt();
		for(int i = 0; i < num; i++){
			System.out.println("enter element number " + (i+1));
			list.appendToTail(scan.nextInt());
		}
		
		//right now, we have a good list,
		//lets make it into a bad one. ***EVIL LAUGH.***
		//creating the loop on the 3rd Object
		list.head.next.next.next.next = list.head;
		
		DetectCircularLoops.detective(list);
	}

	//You guys are noticiing some real awesomeness here. This is the Sherlock Holmes of the linkedList world. LOL. just kidding. :P 
	private static void detective(SingleLinkedList<Integer> list) {
		// TODO Auto-generated method stub
		Node<Integer> normalSpeed = list.head;
		Node<Integer> highSpeed = list.head.next;
		while(true){
			if(highSpeed == normalSpeed){
				System.out.println("There is a loop on the object with the following data " + highSpeed.data);
				break;
			}
			else{
				highSpeed = highSpeed.next.next;
				normalSpeed = normalSpeed.next;
			}
		}
	}
}
