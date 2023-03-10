/**
 *
 * @author Ouda
 */

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//the class with button and main method
public class SortGUI {

	// import javax.swing.JFrame;
	//amount of time for bubble sort
	public static double bubbleTime = 0.0;
	//a variable that holds the amount of time for the selection sort takes to execute
	public static double selectionTime = 0.0;
	//a variable that holds the amount of time for the recursive merge sort takes to execute
	public static double rmergeTime = 0.0;
	//amount of time for insertion sort
	public static double insertionTime = 0.0;
	//amount of time for shell sort
	public static double shellTime = 0.0;
	//a variable that holds the amount of time for the iterative merge sort takes to execute
	public static double imergeTime = 0.0;
	//amount of time for quick sort
	public static double quickTime = 0.0;

	//Boolean variable that is made to keep track whether or not the bubble sort has already been used
	public boolean Bubble_Done = false;
	//Boolean variable that is made to keep track whether or not the selection sort has already been used
	public boolean Selection_Done = false;
	//Boolean variable that is made to keep track whether or not the insertion sort has already been used
	public boolean Insertion_Done = false;
	//Boolean variable that is made to keep track whether or not the shell sort has already been used
	public boolean Shell_Done = false;
	//Boolean variable that is made to keep track whether or not the recursive merge sort has already been used
	public boolean Recersive_Merge_Done = false;
	//Boolean variable that is made to keep track whether or not the iterative merge sort has already been used
	public boolean Iterative_Merge_Done = false;
	//Boolean variable that is made to keep track whether or not the quick sort has already been used
	public boolean Quick_Done = false;
	//Making a object from the class SortShow
	SortShow sortArea = new SortShow();
	
	//Default constructor for SortGUI
	public SortGUI() {
		//making a MyScreen object

		// You need to adjust the following values to your Screen dimensions

		MyScreen screen = new MyScreen();
		//Setting a title to the GUI window
		screen.setTitle("Assignment-1 by Abdelnasser Ouda");
		//setting the size of the window 
		screen.setSize(975+sortArea.total_number_of_lines, 450);
		//the operation when the frame is closed
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//is set to true to display the frame
		screen.setVisible(true);
	}
	//A public class that extends JFrame
	public class MyScreen extends JFrame {
		//making a scramble button with a text "Scramble Lines" on it
		JButton scramble_button = new JButton("Scramble Lines");
		//making a selection button with a text "Bubble" on it
		JRadioButton bubble = new JRadioButton("Bubble");
		//making a selection button with a text "Selection" on it
		JRadioButton selection = new JRadioButton("Selection");
		//making a selection button with a text "Insertion" on it
		JRadioButton insertion = new JRadioButton("Insertion");
		//making a selection button with a text "Shell" on it
		JRadioButton shell = new JRadioButton("Shell");
		//making a recursive merge button with a text "Scramble Lines" on it
		JRadioButton rmerge = new JRadioButton("Merge Recursive");
		//making a iterative merge button with a text "Selection" on it
		JRadioButton imerge = new JRadioButton("Merge Iterative");
		//making a selection button with a text "Quick Sort" on it
		JRadioButton quick = new JRadioButton("Quick Sort");
		//making a reset button with a text "Selection" on it
		JRadioButton reset = new JRadioButton("Reset");

		//A label that displays the time it took for the Bubble sort took to execute
		JLabel bubble_time_label = new JLabel("Bubble Time");
		JLabel bubble_time_taken = new JLabel("");
		//A label that displays the time it took for the Selection sort took to execute 
		JLabel selection_time_label = new JLabel("Selection Time");
		JLabel selection_time_taken = new JLabel("");
		//A label that displays the time it took for the Insertion sort took to execute
		JLabel insertion_time_label = new JLabel("Insertion Time");
		JLabel insertion_time_taken = new JLabel("");
		//A label that displays the time it took for the Shell sort took to execute
		JLabel shell_time_label = new JLabel("Shell Time");
		JLabel shell_time_taken = new JLabel("");
		//A label that displays the time it took for the recursive merge sort took to execute 
		JLabel rmerge_time_label = new JLabel("Merge-Rec Time");
		JLabel rmerge_time_taken = new JLabel("");
		//A label that displays the time it took for the iterative merge sort took to execute
		JLabel imerge_time_label = new JLabel("Merge-Ita Time");
		JLabel imerge_time_taken = new JLabel("");
		//A label that displays the time it took for the Quick sort took to execute
		JLabel quick_time_label = new JLabel("Quick Sort Time");
		JLabel quick_time_taken = new JLabel("");
	
		//the default constructor for the class MyScreen
		public MyScreen() {
			// Panel where sorted lines_lengths will displayed
			bubble_time_taken.setForeground(Color.RED);
			//The time displayed for selection sort will be the colour red
			selection_time_taken.setForeground(Color.RED);
			insertion_time_taken.setForeground(Color.RED);
			shell_time_taken.setForeground(Color.RED);
			//The time displayed for recursive merge sort will be the colour red
			rmerge_time_taken.setForeground(Color.RED);
			//The time displayed for iterative merge sort will be the colour red
			imerge_time_taken.setForeground(Color.RED);
			quick_time_taken.setForeground(Color.RED);

			//The selection button text will be the colour blue
			bubble.setForeground(Color.BLUE);
			selection.setForeground(Color.BLUE);
			insertion.setForeground(Color.BLUE);
			shell.setForeground(Color.BLUE);
			//The recursive merge button text will be the colour blue
			rmerge.setForeground(Color.BLUE);
			//The iterative merge button text will be the colour blue
			imerge.setForeground(Color.BLUE);
			quick.setForeground(Color.BLUE);
			//The scramble button's text will be blue
			scramble_button.setForeground(Color.BLUE);
			//setting the font of scramble button
			scramble_button.setFont(new Font("Arial", Font.BOLD, 15));
			//A Panel to hold the radio_button_selection and set the GridLayout
			JPanel radio_button_selection_Panel = new JPanel(new GridLayout(4, 1, 0, 0));


			//Adding the selection button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(bubble);
			radio_button_selection_Panel.add(selection);
			radio_button_selection_Panel.add(insertion);
			radio_button_selection_Panel.add(shell);
			//Adding the recursive merge button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(rmerge);
			//Adding the iterative merge button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(imerge);
			radio_button_selection_Panel.add(quick);
			//Adding the reset button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(reset);
			//giving the radio_button_selection_Panel a border with a title 
			radio_button_selection_Panel.setBorder(new javax.swing.border.TitledBorder("Sort Algorithms"));


			//A Panel to hold the time_Panel and set the GridLayout
			JPanel time_Panel = new JPanel(new GridLayout(7, 1, 0, 0));
			//Adding the bubble_time_label to the time_Panel
			time_Panel.add(bubble_time_label);
			//Adding the bubble_time_taken to the time_Panel
			time_Panel.add(bubble_time_taken);
			//Adding the selection_time_label to the time_Panel
			time_Panel.add(selection_time_label);
			//Adding the selection_time_taken to the time_Panel
			time_Panel.add(selection_time_taken);
			//Adding the insertion_time_label to the time_Panel
			time_Panel.add(insertion_time_label);
			//Adding the insertion_time_taken to the time_Panel
			time_Panel.add(insertion_time_taken);
			//Adding the shell_time_label to the time_Panel
			time_Panel.add(shell_time_label);
			//Adding the shell_time_taken to the time_Panel
			time_Panel.add(shell_time_taken);
			//Adding the rmerge_time_label to the time_Panel
			time_Panel.add(rmerge_time_label); 
			//Adding the rmerge_time_taken to the time_Panel
			time_Panel.add(rmerge_time_taken);
			//Adding the imerge_time_label to the time_Panel
			time_Panel.add(imerge_time_label);
			//Adding the imerge_time_taken to the time_Panel
			time_Panel.add(imerge_time_taken);
			//Adding the quick_time_label to the time_Panel
			time_Panel.add(quick_time_label);
			//Adding the quick_time_taken to the time_Panel
			time_Panel.add(quick_time_taken);

			//A Panel to hold the buttons_area_Panel and set the GridLayout
			//This buttons_area_Panel will hold scrambleButton, radio_button_selection and the time_Panel
			JPanel buttons_area_Panel = new JPanel(new GridLayout(5, 1, 5, 5));
			//adding scramble_button to the buttons_area_Panel
			buttons_area_Panel.add(scramble_button);
			//adding radio_button_selection_Panel to the buttons_area_Panel
			buttons_area_Panel.add(radio_button_selection_Panel);
			//adding time_Panel to the buttons_area_Panel
			buttons_area_Panel.add(time_Panel);

			//placing the buttons_area_Panel to the east side of the window
			add(buttons_area_Panel, BorderLayout.EAST);
			//placing the sortArea object in the center of the window
			add(sortArea, BorderLayout.CENTER);
			//setting all booleans to false
			Set_Available_Chooses(false, false, false, false, false, false, false, false);

			//The following code is for creating a listener for each GUI element 

			//Creating an action listener for scramble button
			//This button will be used to scramble the lines in a random way
			//this same scrambled lines will be used for all threes sort methods used in this program
			scramble_button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Scrambling the lines_lengths array
					sortArea.scramble_the_lines(); 
					//Since it has already been clicked, it will no longer be enabled
					scramble_button.setEnabled(false); 
					//setting all booleans true except for reset
					Set_Available_Chooses(true, true, true, true, true, true, true, false);
				}
			});

			//Creating an action listener for bubble button
			bubble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the bubble sort method
					sortArea.BubbleSort();
					//Bubble sort has finished/been clicked
					Bubble_Done = true;
					//The amount of time taken for selection sort took
					bubble_time_taken.setText(bubbleTime / 1000 + " Seconds");
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for selection button
			selection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the selection sort method
					sortArea.SelectionSort(); 
					//Selection sort has finished/been clicked
					Selection_Done = true;
					//The amount of time taken for selection sort took
					selection_time_taken.setText(selectionTime / 1000 + " Seconds");
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for insertion button
			insertion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the insertion sort method
					sortArea.InsertionSort();
					//Insertion sort has finished/been clicked
					Insertion_Done = true;
					//The amount of time taken for insertion sort took
					insertion_time_taken.setText(insertionTime / 1000 + " Seconds");
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for shell button
			shell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the shell sort method
					sortArea.ShellSort();
					//Shell sort has finished/been clicked
					Shell_Done = true;
					//The amount of time taken for shell sort took
					shell_time_taken.setText(shellTime / 1000 + " Seconds");
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for recursive merge button
			rmerge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the recursive merge sort method
					sortArea.R_MergeSort();
					//The amount of time taken for recursive merge sort took
					rmerge_time_taken.setText((rmergeTime / 1000) + " Seconds");
					//recursive merge sort has finished/been clicked
					Recersive_Merge_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});
			
			//Creating an action listener for iterative merge button
			imerge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the iterative merge sort method
					sortArea.I_MergeSort();
					//The amount of time taken for iterative merge sort took
					imerge_time_taken.setText((imergeTime / 1000) + " Seconds");
					//iterative merge sort has finished/been clicked
					Iterative_Merge_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for quick button
			quick.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the quick sort method
					sortArea.QuickSort();
					//Quick sort has finished/been clicked
					Quick_Done = true;
					//The amount of time taken for quick sort took
					quick_time_taken.setText(quickTime / 1000 + " Seconds");
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for reset button
			reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//disabling reset since it was clicked
					reset.setEnabled(false);
					//reseting the lines_lengths to its scrambled lines
					sortArea.reset();

					//There are many different combinations of what could be clicked 
					//The following code below covers all possibilities
					//FOr the following use the same comments as above 
					if (Bubble_Done && Selection_Done && Insertion_Done && Shell_Done && Recersive_Merge_Done && Iterative_Merge_Done && Quick_Done) {
						//
						scramble_button.setEnabled(true);
						Recersive_Merge_Done = false;
						Iterative_Merge_Done = false;
						Selection_Done = false;
						Bubble_Done = false;
						Insertion_Done = false;
						Shell_Done = false;
						Quick_Done = false;
						Set_Available_Chooses(false, false, false, false, false, false, false, false);
						bubble_time_taken.setText("");
						selection_time_taken.setText("");
						insertion_time_taken.setText("");
						shell_time_taken.setText("");
						rmerge_time_taken.setText("");
						imerge_time_taken.setText("");
						quick_time_taken.setText("");

					}
					else Combinations();
				}
			});

		}

		//A method that sets if the button are enabled or disabled
		public void Set_Available_Chooses(boolean bubble_state, boolean selection_state, boolean insertion_state, boolean shell_state, boolean rmerge_state, boolean imerge_state, boolean quick_state,
				boolean reset_state) {
			this.bubble.setEnabled(bubble_state);
			this.selection.setEnabled(selection_state);
			this.insertion.setEnabled(insertion_state);
			this.shell.setEnabled(shell_state);
			this.rmerge.setEnabled(rmerge_state);
			this.imerge.setEnabled(imerge_state);
			this.quick.setEnabled(quick_state);
			this.reset.setEnabled(reset_state);
		}

		public void Combinations(){
			if (Bubble_Done)
				this.bubble.setEnabled(false);
			else this.bubble.setEnabled(true);
			if (Selection_Done)
				this.selection.setEnabled(false);
			else this.selection.setEnabled(true);
			if (Insertion_Done)
				this.insertion.setEnabled(false);
			else this.insertion.setEnabled(true);
			if (Shell_Done)
				this.shell.setEnabled(false);
			else this.shell.setEnabled(true);
			if (Recersive_Merge_Done)
				this.rmerge.setEnabled(false);
			else this.rmerge.setEnabled(true);
			if (Iterative_Merge_Done)
				this.imerge.setEnabled(false);
			else this.imerge.setEnabled(true);
			if (Quick_Done)
				this.quick.setEnabled(false);
			else this.quick.setEnabled(true);

			this.reset.setEnabled(false);

		}
	}



	//The main method
	public static void main(String[] args) {
		//initialize the class
		SortGUI sort_GUI = new SortGUI();

	}

}


