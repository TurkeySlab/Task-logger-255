package functions;

public class MockData {
	public static void buildData(DailyTasks DT)
	{
		try {
			TaskItem tM1 = new TaskItem( "CNIT 255 Homework", "Mon Apr 20 by 23:59");			// in format : "Wed Apr 15 by 23:33"
			TaskItem tM2 = new TaskItem( "CNIT 242 Homework", "Mon Apr 20 by 23:59");			// in format : "Wed Apr 15 by 23:33"
			TaskItem tM3 = new TaskItem( "CNIT 280 Final", "Mon Apr 20 by 23:59");				// in format : "Wed Apr 15 by 23:33"
			DT.addMonday(tM1);
			DT.addMonday(tM2);
			DT.addMonday(tM3);

			TaskItem tT1 = new TaskItem( "Visit Grandma", "Tue Apr 21 by 1:00");
			TaskItem tT2 = new TaskItem( "Dinner at Punchies", "Tue Apr 21 by 6:30");
			TaskItem tT3 = new TaskItem( "CNIT 255 Homework", "Tue Apr 21 by 23:59");
			DT.addTuesday(tT1);
			DT.addTuesday(tT2);
			DT.addTuesday(tT3);
			
			TaskItem tW1 = new TaskItem( "Walk the cat", "Wed Apr 22 by 10:00");
			TaskItem tW2 = new TaskItem( "Walk the cat", "Wed Apr 22 by 10:00");
			DT.addWednesday(tW1);
			DT.addWednesday(tW2);
			
			TaskItem tT0 = new TaskItem( "Bake for food drive", "Thu Apr 23 by 23:59");
			DT.addThursday(tT0);
			
			TaskItem tF1 = new TaskItem( "Day off", "Fri Apr 24 by 23:59");
			DT.addFriday(tF1);
			
			TaskItem t6 = new TaskItem( "Soccer Game", "Sat Apr 25 by 10:00");
			DT.addSaturday(t6);
			
			TaskItem t7 = new TaskItem( "Prep for next week", "Sun Apr 26 by 16:00");
			TaskItem t8 = new TaskItem( "Dinner with family", "Sun Apr 26 by 18:00");
			TaskItem t9 = new TaskItem( "CNIT 242 lab report due", "Sun Apr 26 by 23:50");
			DT.addSunday(t7);
			DT.addSunday(t8);
			DT.addSunday(t9);


		} catch (BadTimeException e) {
			e.printStackTrace();
		}
	}
}
