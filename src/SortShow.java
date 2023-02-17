/**
 *
 * @author Ouda
 */

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Random;

//The class that has all the sorts in it
public class SortShow extends JPanel {
	
	// An array to hold the lines_lengths to be sorted
	public int[] lines_lengths;
	//The amount of lines needed
	public final int total_number_of_lines = 256;
	 // An array to holds the scrambled lines_lengths
	public int[] scramble_lines;
	//A temp Array that is used later for sorts
	public int[] tempArray;

	//the default constructor for the SortShow class
	public SortShow(){
		//assigning the size for the lines_lengths below
		lines_lengths = new int[total_number_of_lines];
		for(int i = 0; i < total_number_of_lines; i++)
			lines_lengths[i] =  i+5;

	}
		

	//A method that scrambles the lines
	public void scramble_the_lines(){
		//A random generator
		Random num = new Random();
		//Randomly switching the lines
		for(int i = 0; i < total_number_of_lines; i++){
			//getting a random number using the nextInt method (a number between 0 to i + 1)
			int j = num.nextInt(i + 1);
			//swapping The element at i and j
			swap(i, j);
		}
		//assigning the size for the scramble_lines below
		scramble_lines = new int[total_number_of_lines];
		//copying the now scrambled lines_lengths array into the scramble_lines array
		//to store for reuse for other sort methods
		//so that all sort methods will use the same scrambled lines for fair comparison
		for (int i = 0; i < total_number_of_lines; i++)
		{
			scramble_lines[i] = lines_lengths[i];
		}
		//Drawing the now scrambled lines_lengths
		paintComponent(this.getGraphics());
	}

	//Swapping method that swaps two elements in the lines_lengths array
	public void swap(int i, int j){
		//storing the i element in lines_lengths in temp
		int temp = lines_lengths[i];
		//giving i element in lines_lengths the value of j element in lines_lengths
		lines_lengths[i] = lines_lengths[j];
		//giving j element in lines_lengths the value of temp
		lines_lengths[j] = temp;
	}
	// Order method that order two elements in array into ascending order
	public void order(int i, int j){
		if (lines_lengths[i] > lines_lengths[j])
			swap(i, j);
	}

	//The bubbleSort method
	public void BubbleSort(){
		//getting the date and time when the selection sort starts
		Calendar start = Calendar.getInstance();

		for (int i = 0 ; i < total_number_of_lines - 1; i++) {
			for (int j = 0; j < total_number_of_lines - i - 1; j++) {
				if (lines_lengths[j] > lines_lengths[j + 1]) {
					swap(j, j + 1);

				}
			}
			paintComponent(this.getGraphics());
			delay(10);


		}

		//getting the date and time when the selection sort ends
		Calendar end = Calendar.getInstance();

		//getting the time took for the selection sort to execute
		SortGUI.bubbleTime  = end.getTime().getTime() - start.getTime().getTime();
	}


	//The selectionSort method
	public void SelectionSort() {
		//getting the date and time when the selection sort starts
		Calendar start = Calendar.getInstance();
		//Using the selection sort to lines_lengths sort the array

		for (int i = 0; i < total_number_of_lines; i++) {
			int minIdx = getIndexOfSmallest(i, total_number_of_lines - 1);
			swap(i, minIdx);

			//get the graphic of the sorting algorithm
			paintComponent(this.getGraphics());
			delay(10);

		}

		//getting the date and time when the selection sort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the selection sort to execute
		//subtracting the end time with the start time
		SortGUI.selectionTime = end.getTime().getTime() - start.getTime().getTime();
	}

	//this method gets the smallest element in the array of lines_lengths
	public int getIndexOfSmallest(int first, int last){
		int min = lines_lengths[first];
		int minIdx = first;
		while (first <= last) {
			if (lines_lengths[first] < min) {
				min = lines_lengths[first];
				minIdx = first;
			}
			first++;
		}

		return minIdx; //modify this line
	}

	//Insertion sort method
	public void insertionSort(int[] a, int first, int last){
		for (int i = 1; i < total_number_of_lines; i++){
			int element = lines_lengths[i];
			int element_idx = i;
			while ((element_idx > 0) && (element < lines_lengths[element_idx-1])){
				lines_lengths[element_idx] = lines_lengths[element_idx-1];
				element_idx--;
			}
			lines_lengths[element_idx] = element;
			paintComponent(this.getGraphics());
			delay(10);
		}
	}
	public void InsertionSort(){
		Calendar start = Calendar.getInstance();
		insertionSort(lines_lengths, 0, total_number_of_lines);

		Calendar end = Calendar.getInstance();
		SortGUI.insertionTime = end.getTime().getTime() - start.getTime().getTime();
	}

	//Shell Sort method
	public void incrementalInsertionSort(int[] a, int first, int last, int space){
		int unsorted, idx;
		for (unsorted = first + space; unsorted <= last; unsorted = unsorted + space){
			int firstUnsorted = a[unsorted];
			for (idx = unsorted - space; (idx >= first) && (firstUnsorted<a[idx]); idx -= space){
				a[idx + space] = a[idx];
			}
			a[idx + space] = firstUnsorted;
		}
		paintComponent(this.getGraphics());
		delay(10);
	}
	public void ShellSort() {
		Calendar start = Calendar.getInstance();
		for (int space = total_number_of_lines/2; space > 0; space = space/2){
			for (int begin = 0; begin < space; begin++){
				incrementalInsertionSort(lines_lengths, begin, total_number_of_lines-1, space);
			}
		}
		Calendar end = Calendar.getInstance();
		SortGUI.shellTime = end.getTime().getTime() - start.getTime().getTime();
	}


	//recursive merge sort method
	public void R_MergeSort(){
		//getting the date and time when the recursive merge sort starts
		Calendar start = Calendar.getInstance();
		//assigning the size for the tempArray below

		R_MergeSort(0, total_number_of_lines - 1);

		Calendar end = Calendar.getInstance();
		//getting the time it took for the iterative merge sort to execute
		//subtracting the end time with the start time
		SortGUI.rmergeTime = end.getTime().getTime() - start.getTime().getTime();

	}

	//recursive merge sort method
	public void R_MergeSort(int first, int last){
		if(first < last) {
			//define the middle
			int mid = (first + last) / 2;
			R_MergeSort(first, mid);
			R_MergeSort(mid + 1, last);
			R_Merge(first, mid + 1, last);

			//get the graphic of R_Merge sorting algorithm
			paintComponent(this.getGraphics());
			//Causing a delay for 10ms
			delay(10);
		}
	}


	//recursive merge sort method
	public void R_Merge(int first, int mid, int last){
		int [] tempArr = new int[total_number_of_lines];
		int i, firstEnd, temp_pos, numsElement;
		firstEnd = mid - 1;
		temp_pos = first;
		numsElement = last - first + 1;
		while ((first <= firstEnd) && (mid <= last)) {
			if (lines_lengths[first] <= lines_lengths[mid]) {
				tempArr[temp_pos++] = lines_lengths[first++];
			}
			else {
				tempArr[temp_pos++] = lines_lengths[mid++];
			}
		}

		while (first <= firstEnd) {
			tempArr[temp_pos++] = lines_lengths[first++];
		}
		while (mid <= last) {
			tempArr[temp_pos++] = lines_lengths[mid++];
		}

		for (i = 0; i < numsElement; i++) {
			lines_lengths[last] = tempArr[last];
			last--;
		}
	}

	//

//////////////////////////////////////////////////////////////////////////////////////////

	//iterative merge sort method
	public void I_MergeSort()
	{
	//getting the date and time when the iterative merge sort starts
	Calendar start = Calendar.getInstance();
	//assigning the size for the tempArray below
	tempArray = new int[total_number_of_lines];
	//saving the value of total_number_of_lines
	int beginLeftovers = total_number_of_lines;


	for (int segmentLength = 1; segmentLength <= total_number_of_lines/2; segmentLength = 2*segmentLength)
	{
		beginLeftovers = I_MergeSegmentPairs(total_number_of_lines, segmentLength);
		int endSegment = beginLeftovers + segmentLength - 1;
		if (endSegment < total_number_of_lines - 1)
		{
		I_Merge(beginLeftovers, endSegment, total_number_of_lines - 1);
		}
	}

	// merge the sorted leftovers with the rest of the sorted array
	if (beginLeftovers < total_number_of_lines) {
		I_Merge(0, beginLeftovers-1, total_number_of_lines - 1);
	}
	//getting the date and time when the iterative merge sort ends
	Calendar end = Calendar.getInstance();
	//getting the time it took for the iterative merge sort to execute
	//subtracting the end time with the start time
	SortGUI.imergeTime = end.getTime().getTime() - start.getTime().getTime();
	}




	// Merges segments pairs (certain length) within an array 
	public int I_MergeSegmentPairs(int l, int segmentLength)
	{
		//The length of the two merged segments 

		//You suppose  to complete this part (Given).
		int mergedPairLength = 2 * segmentLength;
		int numberOfPairs = l / mergedPairLength;

		int beginSegment1 = 0;
		for (int count = 1; count <= numberOfPairs; count++)
		{
			int endSegment1 = beginSegment1 + segmentLength - 1;

			int beginSegment2 = endSegment1 + 1;
			int endSegment2 = beginSegment2 + segmentLength - 1;
			I_Merge(beginSegment1, endSegment1, endSegment2);

			beginSegment1 = endSegment2 + 1;
			//redrawing the lines_lengths
			paintComponent(this.getGraphics());
			//Causing a delay for 10ms
			delay(10);
		}
		// Returns index of last merged pair
		return beginSegment1;
		//return 1;//modify this line
	}

	public void I_Merge(int first, int mid, int last)
	{
		//You suppose  to complete this part (Given).
		// Two adjacent sub-arrays
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;

		// While both sub-arrays are not empty, copy the
		// smaller item into the temporary array
		int index = beginHalf1; // Next available location in tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
		{
			// Invariant: tempArray[beginHalf1..index-1] is in order
			if (lines_lengths[beginHalf1] < lines_lengths[beginHalf2])
			{
				tempArray[index] = lines_lengths[beginHalf1];
				beginHalf1++;
			}
			else
			{
				tempArray[index] = lines_lengths[beginHalf2];
				beginHalf2++;
			}
		}
		//redrawing the lines_lengths
		paintComponent(this.getGraphics());

		// Finish off the nonempty sub-array

		// Finish off the first sub-array, if necessary
		for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
			// Invariant: tempArray[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf1];

		// Finish off the second sub-array, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
			// Invariant: tempa[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf2];

		// Copy the result back into the original array
		for (index = first; index <= last; index++)
			lines_lengths[index] = tempArray[index];
	}

	//This method is helper method for Quick Sort
	private int partition(int first, int last) {
		int mid = (first + last) / 2;
		int pivot = lines_lengths[mid]; //pivot is the middle line
		boolean done = false;

		while (!done) {

			//if the line length to the left of pivot is smaller that pivot, go to next line
			while(lines_lengths[first] < pivot) {
				++first;
			}

			//if the line length to the right of pivot is greater than pivot, go to preceding line
			while (pivot < lines_lengths[last]) {
				--last;
			}

			//swap the lines until the first counter is larger than the last counter
			if (first >= last) {
				done  = true;
			}
			else {
				swap(first, last);
				++first;
				--last;
			}
		}
		paintComponent(this.getGraphics());
		delay(10);
		return last;
	}

	public void quickSort(int first, int last) {
		int mid;
		if (first >= last) {
			return;
		}

		mid = partition(first, last);
		quickSort(first, mid);
		quickSort(mid + 1, last);
	}


	public void QuickSort() {
		Calendar start = Calendar.getInstance();
		quickSort(0, total_number_of_lines - 1);

		Calendar end = Calendar.getInstance();
		SortGUI.quickTime = end.getTime().getTime() - start.getTime().getTime();
	}

	//////////////////////////////////////////////////////////////////////	
		
		//This method resets the window to the scrambled lines display
		public void reset(){
			if(scramble_lines != null)
			{
				//copying the old scrambled lines into lines_lengths
				for (int i = 0; i < total_number_of_lines; i++)
				{
					lines_lengths[i] = scramble_lines[i] ;
				}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}
			}
		
	
		//This method colours the lines and prints the lines
		public void paintComponent(Graphics g){
 			super.paintComponent(g);
			//A loop to assign a colour to each line
			for(int i = 0; i < total_number_of_lines; i++){
				//using eight colours for the lines
				if(i % 8 == 0){
					g.setColor(Color.green);
				} else if(i % 8 == 1){
					g.setColor(Color.blue);
				} else if(i % 8 == 2){
					g.setColor(Color.yellow);
				} else if(i%8 == 3){
					g.setColor(Color.red);
				} else if(i%8 == 4){
					g.setColor(Color.black);
				} else if(i%8 == 5){
					g.setColor(Color.orange);
				} else if(i%8 == 6){
					g.setColor(Color.magenta);
				} else
					g.setColor(Color.gray);
				
				//Drawing the lines using the x and y-components 
				g.drawLine(4*i + 25, 300, 4*i + 25, 300 - lines_lengths[i]);
			}
			
		}
		
		//A delay method that pauses the execution for the milliseconds time given as a parameter
		public void delay(int time){
			try{
	        	Thread.sleep(time);
	        }catch(InterruptedException ie){
	        	Thread.currentThread().interrupt();
	        }
		}
		
	}

