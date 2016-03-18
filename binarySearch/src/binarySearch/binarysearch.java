package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class binarysearch {
	
	public binarysearch(){
		super();
	}
	
	public static boolean binarySearch(final List<Integer> numbers, Integer value){
		if (numbers == null || numbers.isEmpty() ) {
			return false;
		}
		
		final Integer comparison = numbers.get(numbers.size()/2);
		if (value.equals(comparison)) {
			return true;
		}
		
		if (value < comparison) {
			return binarySearch(numbers.subList(0, numbers.size()/2), value);
		} else {
			return binarySearch(numbers.subList(numbers.size()/2+1, numbers.size()), value);
		}
	}
	
	public List<Integer> setList(int maxsize) {
		
		// collections do not have .sort function; must use arrays to do the sort.
		int[] arr = new int[maxsize];
		for (int i=0; i<maxsize; i++) {
			int value = (int)(Math.random()*100);
			arr[i] = value;
		}
		Arrays.sort(arr);
		
		// convert int[] to List<Integer>
		List<Integer> alist = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		return alist;
	}
	
	public void display(List<Integer> alist) {
		for (Integer num: alist) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public void perform(){
		List<Integer> originalList = setList(10);
		display(originalList);
		System.out.print(binarySearch(originalList, 80));
	}

	public static void main(String[] args) {
		binarysearch test = new binarysearch();
		test.perform();
		System.exit(0);
	}

}
