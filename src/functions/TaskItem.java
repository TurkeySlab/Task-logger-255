package functions;

public class TaskItem {
	private static int taskID = 0;	// used to identify multiple tasks on same day
	private String taskCode;		// <3-letter-Named-day-of-week>:<taskID>	 | used with .equals(TaskItem) to compare items

	
	String name;					// name of task
	String dueDate;					// in format : "Wed Apr 15 by 23:33"
									//    		   	
	Boolean isDone = false;			// TRUE : done  |  FASLE : todo
	
	public TaskItem( String name, String dueDate ) throws BadTimeException
	{
		this.name    = name;
		this.dueDate = dueDate;		// testing value only, do TODO block bellow
		
		/*
		 * TODO
		 * check if dueDate time is between 00:00 and 23:59 							dueDate in format : "Wed Apr 15 by 23:33"		
		 * 			1) this.taskCode = <3-letter-Named-day-of-week> + ":" + taskID;		ex 	"Wed Apr 15 by 23:33" taskCode = Wed:<taskID>	
		 * 					= Thu:0
		 * 			2) increment taskID by 1
		 * 
		 * 		if not throw BadTimeException 		// throw new BadTimeException( "message" );
		 */
		this.taskCode = dueDate.substring(0, 4) +":"+ taskID++;
	}
	
	public String toString()
	{
		/* 
		 * Return the task item as a String
		 * "<taskCode> : <name> : <dueDate> : <isDone>"	  // NOTE: spacings
		 * 
		 * Used for debugging and internal operations, will not be connected to tables but is needed
		 */ 
		return this.taskCode +":"+ this.name +":"+ this.dueDate +":"+ this.isDone;
	}
	
	public boolean equals( Object o ) 
	{
		/* TODO
		 * Return TRUE only if object o = the object calling it (.this)
		 * 
		 * 1) check if Object o is a "TaskItem" object    	// o.getClass()
		 * 2) check if this.taskCode = o.taskCode			// remember how to compare String objects
		 */
		
		if( this.getClass() == o.getClass() )
		{
			TaskItem ti = (TaskItem)o;
			if( this.taskCode.equals(ti.taskCode) )
			{
				return true;
			}
		}
		
		return false;
	}
	public String getName()
	{
		return this.name;
	}
	public String getDueDate()
	{
		return this.dueDate;
	}
	public void taskDone()
	{
		/* TODO
		 * Update the correct task to the done status (isDone = true)
		 */
		this.isDone = true;
	}
}
