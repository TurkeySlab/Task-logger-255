package functions;

import java.util.ArrayList;

import javax.swing.JRadioButton;

public class DailyTasks {
	/*
	 * Holds daily tasks information for the variable named "x-day"
	 */
	private ArrayList<TaskItem> monday   ;
	private ArrayList<TaskItem> tuesday  ;
	private ArrayList<TaskItem> wednesday;
	private ArrayList<TaskItem> thursday ;
	private ArrayList<TaskItem> friday   ;
	private ArrayList<TaskItem> saturday ;
	private ArrayList<TaskItem> sunday   ;

	
	public DailyTasks()
	{
		this.monday    = new ArrayList<TaskItem>();
		this.tuesday   = new ArrayList<TaskItem>();
		this.wednesday = new ArrayList<TaskItem>();
		this.thursday  = new ArrayList<TaskItem>();
		this.friday    = new ArrayList<TaskItem>();
		this.saturday  = new ArrayList<TaskItem>();
		this.sunday    = new ArrayList<TaskItem>();
	}
	/*
	 *  How data is saved in the ArrayList<TaskItem>
	 *    - holds a reference to the object TaskItem
	 *    - access individual x-day items by x-day.get(index).toPrint() // prints info stored by TaskItem
	 */
	
	
	// methods to add new tasks to the task table | DO NOT TOUCH
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
	public Object[][] tasksForDay(DayOfWeek dayOfWeek)
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
			for( int i = 0; i < this.monday.size(); i++ )
			{
				toReturn[i][1] = this.monday.get(i).name;
				toReturn[i][2] = this.monday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case TUESDAY:
			toReturn = new Object[this.tuesday.size()][4];
			for( int i = 0; i < this.tuesday.size(); i++ )
			{
				toReturn[i][1] = this.tuesday.get(i).name;
				toReturn[i][2] = this.tuesday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case WEDNESDAY:
			toReturn = new Object[this.wednesday.size()][4];
			for( int i = 0; i < this.wednesday.size(); i++ )
			{
				toReturn[i][1] = this.wednesday.get(i).name;
				toReturn[i][2] = this.wednesday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case THURSDAY:
			toReturn = new Object[this.thursday.size()][4];
			for( int i = 0; i < this.thursday.size(); i++ )
			{
				toReturn[i][1] = this.thursday.get(i).name;
				toReturn[i][2] = this.thursday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case FRIDAY:
			toReturn = new Object[this.friday.size()][4];
			for( int i = 0; i < this.friday.size(); i++ )
			{
				toReturn[i][1] = this.friday.get(i).name;
				toReturn[i][2] = this.friday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case SATURDAY:
			toReturn = new Object[this.saturday.size()][4];
			for( int i = 0; i < this.saturday.size(); i++ )
			{
				toReturn[i][1] = this.saturday.get(i).name;
				toReturn[i][2] = this.saturday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		case SUNDAY:
			toReturn = new Object[this.sunday.size()][4];
			for( int i = 0; i < this.sunday.size(); i++ )
			{
				toReturn[i][1] = this.sunday.get(i).name;
				toReturn[i][2] = this.sunday.get(i).dueDate;
				toReturn[i][3] = "no";
			}
			break;
		}
		
		return toReturn;
	}
	
	// Task due?
	public String[] tasksDue()
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
			while( i < this.monday.size() )
			{
				toReturn[i] = this.monday.get(i).name 	 +" due "+ this.monday.get(i).dueDate;
				i++;
			}
			while(i < this.tuesday.size() )
			{
				toReturn[i] = this.tuesday.get(i).name   +" due "+ this.tuesday.get(i).dueDate;
				i++;
			}
			while(i < this.wednesday.size() )
			{
				toReturn[i] = this.wednesday.get(i).name +" due "+  this.wednesday.get(i).dueDate;
				i++;
			}
			while(i < this.thursday.size() )
			{
				toReturn[i] = this.thursday.get(i).name  +" due "+ this.thursday.get(i).dueDate;
				i++;
			}
			while(i < this.friday.size() )
			{
				toReturn[i] = this.friday.get(i).name 	 +" due "+ this.friday.get(i).dueDate;
				i++;
			}
			while(i < this.saturday.size() )
			{
				toReturn[i] = this.saturday.get(i).name  +" due "+ this.saturday.get(i).dueDate;
				i++;
			}
			while(i < this.sunday.size() )
			{
				toReturn[i] = this.sunday.get(i).name 	 +" due "+ this.sunday.get(i).dueDate;
				i++;
			}
		return toReturn;
	}

	public void markDone( String taskCode ) 
	{
		System.out.println("Enter mark done \n   {"+taskCode+"}");
		for( TaskItem t : this.monday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : this.tuesday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : this.wednesday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : this.thursday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : this.friday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : this.saturday)
		{
			if( t.getTaskCode().equals(taskCode) )
				t.isDone = true;
		}
		for( TaskItem t : this.sunday)
		{
			if( t.getTaskCode().equals(taskCode) )
			{
				t.isDone = true;
			}
		}
		removeDone();
	}
	// clean up
	private void removeDone()
	{
		/*
		 * Removes done tasks from list
		 */
		for(int i = 0; i < this.monday.size(); i++)
		{
			if( this.monday.get(i).isDone )
				this.monday.remove(i);
		}
		for(int i = 0; i < this.tuesday.size(); i++)
		{
			if( this.tuesday.get(i).isDone )
				this.tuesday.remove(i);
		}
		for(int i = 0; i < this.wednesday.size(); i++)
		{
			if( this.wednesday.get(i).isDone )
				this.wednesday.remove(i);
		}
		for(int i = 0; i < this.thursday.size(); i++)
		{
			if( this.thursday.get(i).isDone )
				this.thursday.remove(i);
		}
		for(int i = 0; i < this.friday.size(); i++)
		{
			if( this.friday.get(i).isDone )
				this.friday.remove(i);
		}
		for(int i = 0; i < this.saturday.size(); i++)
		{
			if( this.saturday.get(i).isDone )
				this.saturday.remove(i);
		}
		for(int i = 0; i < this.sunday.size(); i++)
		{
			if( this.sunday.get(i).isDone )
				this.sunday.remove(i);
		}
	}
}









