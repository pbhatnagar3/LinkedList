import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Simple problem where you have to remove duplicates from a linkedList
 * One could have done this without any additional memory constraint but that would have taken O(n^2) time.
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		List<Integer> input = new LinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements that you will be adding to the list");
		int num = scan.nextInt();
		for(int i = 0; i < num; i++){
			System.out.println("Entger the " + (i + 1) + " element:");
			input.add(scan.nextInt());
		}
		
		//now since we have our list.. lets print out the size of the list
		System.out.println("Here is the initial size of the list " + input.size());
		
		//lets create a Set to check if the list contains unique elements
		final Set<Integer> checker = new HashSet<Integer>();
		for(int i = 0; i < input.size(); i++) {
			if(checker.contains(input.get(i)))
				input.remove(input.get(i));
			else
				checker.add(input.get(i));
		}
		
		System.out.println("the final size is " + input.size());
	}
}
