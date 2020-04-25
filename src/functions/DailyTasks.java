package functions;

import java.util.ArrayList;

public class DailyTasks {
	/*
	 * Holds daily tasks information for the variable named "x-day"
	 */
	private ArrayList<TaskItem> monday    = new ArrayList<TaskItem>();
	private ArrayList<TaskItem> tuesday   = new ArrayList<TaskItem>();
	private ArrayList<TaskItem> wednesday = new ArrayList<TaskItem>();
	private ArrayList<TaskItem> thursday  = new ArrayList<TaskItem>();
	private ArrayList<TaskItem> friday    = new ArrayList<TaskItem>();
	private ArrayList<TaskItem> saturday  = new ArrayList<TaskItem>();
	private ArrayList<TaskItem> sunday    = new ArrayList<TaskItem>();

	
	
	/*
	 *  How data is saved in the ArrayList<TaskItem>
	 *    - holds a reference to the object TaskItem
	 *    - access individual x-day items by x-day.get(index).toPrint() // prints info stored by TaskItem
	 */
	
	
	// methods to add new tasks to the task table | DO NOT TOUCH
	// TODO check index of || I/O consistant to stack
	public void addMonday(TaskItem m) {
		this.monday.add(m);
	}
	public void addTuesday(TaskItem t) {
		this.tuesday.add(t);
	}
	public void addWednesday(TaskItem w) {
		this.wednesday.add(w);
	}
	public void addThursday(TaskItem t) {
		this.thursday.add(t);
	}
	public void addFriday(TaskItem f) {
		this.friday.add(f);
	}
	public void addSaturday(TaskItem f) {
		this.saturday.add(f);
	}
	public void addSunday(TaskItem f) {
		this.sunday.add(f);
	}

	// Print method
	static public String[][] tasksForDay(DayOfWeek dayOfWeek)
	{
		/* TODO
		 * Given the dayOfWeek( enum: DayOfWeek ) 
		 * Return the tasks assigned for that day as a 2D String array
		 *  Where the length of array.length is = to the amount of "task Items" in that dayOfWeek
		 *  Where each row 			(array[row]) 
		 *  	left empty				(array[row][0])		done for Day headers
		 *  	holds the task name		(array[row][1]) 
		 *  	holds the date due 		(array[row][2])
		 *  	holds if done			(array[row][3])
		 * 
		 * RETURN : Only the tasks for the sent dayOfWeek
		 * 
		 * Debugging : if the String[][] is created correctly you will see the task for that day populated in the calendar view
		 * 				once mock data is added. Otherwise nothing will happen and the code will compile correctly 
		 */
		return null;
	}
	
	// Task due?
	public String[][] tasksDue()
	{
		/* TODO
		 * Return the tasks that are due today; excluding tasks marked done
		 * Used TaskItem class methods to do this
		 * 
		 *  Where the length of array.length is = to the amount of "task Items" due today 
		 *  Where each row 			(array[row]) 
		 *  	holds the task name		(array[row][0]) 
		 *  	holds the date due 		(array[row][1])	  // compare date here with local date | be sure to compare correctly
		 *  	holds if done			(array[row][2])	  // should only return tasks that are false 
		 *  
		 *  
		 */
		for(int i = 0; i < array[row].length; i++) {
			if() {
				
			}
		}
		return null;
	}

	public void taskDone()
	{
		/* TODO
		 * Update the correct task to the done status (isDone = true)
		 */
	}
}









