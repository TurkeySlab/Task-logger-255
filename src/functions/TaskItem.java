package functions;

public class TaskItem {
	private String taskCode;		// <3-letter-Named-day-of-week>:<taskID>	 | used with .equals(TaskItem) to compare items

	
	String name;					// name of task
	String dueDate;					// in format : "Wed Apr 15 by 23:33"
									    		   	
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
		try {
			this.taskCode = dueDate.substring(0, 3) +":"+ name.substring(0, 5);
		} catch (StringIndexOutOfBoundsException e ) {
			this.taskCode = dueDate.substring(0, 3) +":"+ name;
		}
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
	
	public String getName()
	{
		return this.name;
	}
	public String getDueDate()
	{
		return this.dueDate;
	}
	public String getTaskCode()
	{
		return this.taskCode;
	}
}
