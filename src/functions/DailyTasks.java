package functions;

import java.util.ArrayList;

import javax.swing.JRadioButton;

public class DailyTasks {
	/*
	 * Holds daily tasks information for the variable named "x-day"
	 */
	private static ArrayList<TaskItem> monday    = new ArrayList<TaskItem>();
	private static ArrayList<TaskItem> tuesday   = new ArrayList<TaskItem>();
	private static ArrayList<TaskItem> wednesday = new ArrayList<TaskItem>();
	private static ArrayList<TaskItem> thursday  = new ArrayList<TaskItem>();
	private static ArrayList<TaskItem> friday    = new ArrayList<TaskItem>();
	private static ArrayList<TaskItem> saturday  = new ArrayList<TaskItem>();
	private static ArrayList<TaskItem> sunday    = new ArrayList<TaskItem>();

	
	
	/*
	 *  How data is saved in the ArrayList<TaskItem>
	 *    - holds a refrence to the object TaskItem
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
	static public Object[][] tasksForDay(DayOfWeek dayOfWeek)
	{
		/* 
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
		Object[][] toReturn = null;
		
		switch( dayOfWeek )
		{
		case MONDAY:
			toReturn = new Object[monday.size()][4];
			for( int i = 0; i < monday.size(); i++ )
			{
				toReturn[i][1] = monday.get(i).name;
				toReturn[i][2] = monday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case TUESDAY:
			toReturn = new Object[tuesday.size()][4];
			for( int i = 0; i < tuesday.size(); i++ )
			{
				toReturn[i][1] = tuesday.get(i).name;
				toReturn[i][2] = tuesday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case WEDNESDAY:
			toReturn = new Object[wednesday.size()][4];
			for( int i = 0; i < wednesday.size(); i++ )
			{
				toReturn[i][1] = wednesday.get(i).name;
				toReturn[i][2] = wednesday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case THURSDAY:
			toReturn = new Object[thursday.size()][4];
			for( int i = 0; i < thursday.size(); i++ )
			{
				toReturn[i][1] = thursday.get(i).name;
				toReturn[i][2] = thursday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case FRIDAY:
			toReturn = new Object[friday.size()][4];
			for( int i = 0; i < friday.size(); i++ )
			{
				toReturn[i][1] = friday.get(i).name;
				toReturn[i][2] = friday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case SATURDAY:
			toReturn = new Object[saturday.size()][4];
			for( int i = 0; i < saturday.size(); i++ )
			{
				toReturn[i][1] = saturday.get(i).name;
				toReturn[i][2] = saturday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case SUNDAY:
			toReturn = new Object[sunday.size()][4];
			for( int i = 0; i < sunday.size(); i++ )
			{
				toReturn[i][1] = sunday.get(i).name;
				toReturn[i][2] = sunday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		}
		
		return toReturn;
	}
	
	// Task due?
	public static String[] tasksDue()
	{
		/* TODO
		 * Return the tasks that are due today; excluding tasks marked done
		 * Used TaskItem class methods to do this
		 * 
		 *  Where the length of array.length is = to the amount of "task Items" due today 
		 *  Where each row 			(array[row]) 
		 *  	holds the task name		(array[row][0]) 
		 *  	holds the date due 		(array[row][1])	  // compare date here with local date | be sure to compare correctly
		 *  
		 */
		String[] toReturn = null;
		
			toReturn = new String[10];		// shows 10 closest due dates from monday
			int i = 0;
			while( i < monday.size() )
			{
				toReturn[i] = monday.get(i).name 	+" due "+ monday.get(i).dueDate;
				i++;
			}
			while(i < tuesday.size() )
			{
				toReturn[i] = tuesday.get(i).name 	+" due "+ tuesday.get(i).dueDate;
				i++;
			}
			while(i < wednesday.size() )
			{
				toReturn[i] = wednesday.get(i).name +" due "+  wednesday.get(i).dueDate;
				i++;
			}
			while(i < thursday.size() )
			{
				toReturn[i] = thursday.get(i).name 	+" due "+ thursday.get(i).dueDate;
				i++;
			}
			while(i < friday.size() )
			{
				toReturn[i] = friday.get(i).name 	+" due "+ friday.get(i).dueDate;
				i++;
			}
			while(i < saturday.size() )
			{
				toReturn[i] = saturday.get(i).name 	+" due "+ saturday.get(i).dueDate;
				i++;
			}
			while(i < sunday.size() )
			{
				toReturn[i] = sunday.get(i).name 	+" due "+ sunday.get(i).dueDate;
				i++;
			}
		return toReturn;
	}

	public static void markDone( String taskCode ) 
	{
		System.out.println("{"+taskCode+"}");
		for( TaskItem t : monday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : tuesday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : wednesday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : thursday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : friday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : saturday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : sunday)
		{
			System.out.println("<"+t.getTaskCode()+"}");
			if( t.getTaskCode().equals(taskCode) )
			{
				System.out.println("=<"+t.getTaskCode()+"}");
				t.isDone = true;
			}
		}
		removeDone();
	}
	// clean up
	private static void removeDone()
	{
		/*
		 * Removes done tasks from list
		 */
		for(int i = 0; i < monday.size(); i++)
		{
			if( monday.get(i).isDone )
				monday.remove(i);
		}

		for(int i = 0; i < tuesday.size(); i++)
		{
			if( tuesday.get(i).isDone )
				tuesday.remove(i);
		}
		for(int i = 0; i < wednesday.size(); i++)
		{
			if( wednesday.get(i).isDone )
				wednesday.remove(i);
		}
		for(int i = 0; i < thursday.size(); i++)
		{
			if( thursday.get(i).isDone )
				thursday.remove(i);
		}
		for(int i = 0; i < friday.size(); i++)
		{
			if( friday.get(i).isDone )
				friday.remove(i);
		}
		for(int i = 0; i < saturday.size(); i++)
		{
			if( saturday.get(i).isDone )
			{
				System.out.println(saturday.get(i).toString());
				saturday.remove(i);
			}
		}
		for(int i = 0; i < sunday.size(); i++)
		{
			if( sunday.get(i).isDone )
				
				sunday.remove(i);
		}
	}
}









