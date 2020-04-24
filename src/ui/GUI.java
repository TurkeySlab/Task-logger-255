package ui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import functions.BadTimeException;
import functions.DailyTasks;
import functions.DayOfWeek;
import functions.FileHandler;
import functions.TaskItem;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DailyTasks dailyTasks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	String fileName = "";

	public GUI() {
		dailyTasks = new DailyTasks();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel notePanel = new JPanel();
		notePanel.setBackground(new Color(102, 51, 0));
		notePanel.setBounds(10, 10, 323, 660);
		contentPane.add(notePanel);
		notePanel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(5, 28, 307, 621);
		notePanel.add(textPane);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(5, 5, 307, 20);
			notePanel.add(menuBar);
			
			// ************************************* Menu operations *************************************
			JMenu mnSave = new JMenu("Save");
			menuBar.add(mnSave);
			
				JMenuItem mntmSaveAs = new JMenuItem("Save as...");
				mntmSaveAs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				mnSave.add(mntmSaveAs);
				
				
				JMenuItem mntmSave = new JMenuItem("Save...");
				mntmSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				mnSave.add(mntmSave);
				
				
				JMenuItem mntmOpen = new JMenuItem("Open");
				mntmOpen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
						JFileChooser jfc = new JFileChooser();
						int returnVal = jfc.showOpenDialog((Component)e.getSource());
						
					    if (returnVal == JFileChooser.APPROVE_OPTION) {
					        File file = jfc.getSelectedFile();
					        try {
					           fileName = file.toString();
					           System.out.println("Opening file: " + fileName);		// the file name returned from view
					           textPane.setText( FileHandler.getFile(fileName) );	// sets text to file contents
					           
					        } catch (Exception ex) {
					          System.out.println("problem accessing file" + file.getAbsolutePath());
					        }
					    } 
					    else {
					        System.out.println("File access cancelled by user.");
					    }  
					}
				});
				menuBar.add(mntmOpen);
			// ************************************* 				*************************************

				
			JPanel calendarPanel = new JPanel();
			calendarPanel.setBackground(new Color(0, 102, 0));
			calendarPanel.setBounds(343, 10, 481, 622);
			contentPane.add(calendarPanel);
			calendarPanel.setLayout(null);
			
			DefaultTableModel model = new DefaultTableModel(){
			    @Override
			    public boolean isCellEditable(int row, int column)
			    {
			    	// all except day label are editable
			        return column > 0 && row >= 0;
			    }
			};  
			model.addColumn("DAY");
			model.addColumn("TASK");
			model.addColumn("DUE ON");
			model.addColumn("DONE?");
			
			DefaultTableColumnModel columnModel = new DefaultTableColumnModel(); 	
			int[] columnsWidth = { 50, 200, 50, 10 };									// DEFINES WIDTH
	        for( int i = 0; i < columnsWidth.length; i++ ) {							
	    		columnModel.addColumn(new TableColumn(i, columnsWidth[i]));
	        }
	        model.addRow( new Object [] {"DAY", "TASK", "DUE ON", "DONE?"});			// SUPER header
	        
	        	String[][] dayTask = null;
		        model.addRow( new Object [] {"MONDAY", "", "", ""});						// Monday tasks
			        try {
			        	dayTask = DailyTasks.tasksForDay(DayOfWeek.MONDAY);
				        for( String[] task : dayTask ) {
				        	model.addRow(task);
				        }
			        } catch (NullPointerException e ) {
			        	// no task for given day
			        }
		         
		        model.addRow( new Object [] {"TUESDAY", "", "", ""});						// Tuesday tasks
		        	try {
		        		dayTask = DailyTasks.tasksForDay(DayOfWeek.TUESDAY);
				        for( String[] task : dayTask ) {
				        	model.addRow(task);
				        }
		        	} catch (NullPointerException e ) {
			        	// no task for given day
			        }
		         
		        model.addRow( new Object [] {"WEDNEDAY", "", "", ""});						// Wednesday tasks
		        	try {
		        		dayTask = DailyTasks.tasksForDay(DayOfWeek.WEDNESDAY);
					    for( String[] task : dayTask ) {
					    	model.addRow(task);
					    }
		        	} catch (NullPointerException e ) {
			        	// no task for given day
			        }
			         
		        model.addRow( new Object [] {"THURSDAY", "", "", ""});						// Thursday tasks
		        	try {
		        		dayTask = DailyTasks.tasksForDay(DayOfWeek.THURSDAY);
				        for( String[] task : dayTask ) {
				        	model.addRow(task);
				        }
		        	} catch (NullPointerException e ) {
			        	// no task for given day
			        }
		         
		        model.addRow( new Object [] {"FRIDAY", "", "", ""});						// Friday tasks
		        	try {
		        		dayTask = DailyTasks.tasksForDay(DayOfWeek.FRIDAY);
				        for( String[] task : dayTask ) {
				        	model.addRow(task);
				        }
		        	} catch (NullPointerException e ) {
			        	// no task for given day
			        }
			         
		        model.addRow( new Object [] {"SATURDAY", "", "", ""});						// Saturday tasks
		        	try {
		        		dayTask = DailyTasks.tasksForDay(DayOfWeek.FRIDAY);
				        for( String[] task : dayTask ) {
				        	model.addRow(task);
				        }
		        	} catch (NullPointerException e ) {
			        	// no task for given day
			        }
		         
		        model.addRow( new Object [] {"SUNDAY", "", "", ""});						// Sunday tasks
		        	try {
		        		dayTask = DailyTasks.tasksForDay(DayOfWeek.FRIDAY);
				        for( String[] task : dayTask ) {
				        	model.addRow(task); 
				        }	        
		        	} catch (NullPointerException e ) {
			        	// no task for given day
			        }
	        
			table = new JTable(model);
			table.setBounds(10, 11, 461, 579);
			calendarPanel.add(table);
			table.setColumnModel(columnModel);
			
			JButton btnAddNewTask = new JButton("Add New Task");
			btnAddNewTask.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MM/dd HH:mm");
					String today = formatter.format( LocalDateTime.now() );
					System.out.println(today);
					
					try {
						// Values needed to make a task
						JDateChooser dateChooser = new JDateChooser();
						MaskFormatter mask = null;						// Used to only accept numeric values to create a "time" representing string
				        try {
				        	mask = new MaskFormatter("##:##");			// the # is for the numeric values
				        } catch (ParseException e) {
				        	e.printStackTrace();
				        }
				        JFormattedTextField ftxtTime = new JFormattedTextField(mask);
						JTextField txtTask = new JTextField();
						
						// Populates JOption pane with headers for text fields
						Object[] params = {"Due Date:", dateChooser, "Due Time:", ftxtTime, "Task Name:", txtTask};

						int result = 0;
				        while( txtTask.getText().isEmpty() && result != JOptionPane.CLOSED_OPTION )
				        {
				        	/*
				        	 * Prompts until canceled or a name is entered 
				        	 */
							result = JOptionPane.showConfirmDialog(table, params, "Create Task", JOptionPane.PLAIN_MESSAGE);
							
							String date  = ((JDateChooser)params[1]).getDate().toString();
								   date  = date.substring(0, date.indexOf(':') - 3);		// removes unused data
							
							String time1 = ((JFormattedTextField)params[3]).getText();		// gets time entered | can be out of bounds
							String taskN = ((JTextField)params[5]).getText();
							
							if( !Character.isDigit( time1.charAt(0)) )
								time1 = "11:59";		// defaults EOD of day sent
							
							TaskItem n = new TaskItem(taskN, date + " by " + time1);

							switch( date.substring(0,4) )
							{
								case( "Mon" ):
									dailyTasks.addMonday(n);
									break;
								case( "Tue" ):
									dailyTasks.addTuesday(n);
									break;
								case( "Wed" ):
									dailyTasks.addWednesday(n);
									break;
								case( "Thr" ):
									dailyTasks.addThursday(n);
									break;
								case( "Fri" ):
									dailyTasks.addFriday(n);
									break;
								case( "Sat" ):
									dailyTasks.addSaturday(n);
									break;
								case( "Sun" ):
									dailyTasks.addSunday(n);
									break;
									
							}
				        }		
					} catch ( BadTimeException e ) {
						e.printStackTrace();
						JOptionPane.showConfirmDialog(table, "Time must be between 00:00 and 23:59", "ERROR", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			btnAddNewTask.setBounds(316, 594, 155, 23);
			calendarPanel.add(btnAddNewTask);
			
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MM/dd");
			String today = formatter.format( LocalDateTime.now() );
			
			JLabel lblToday = new JLabel("Welcome back! Taday is " + today );
			lblToday.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
			lblToday.setBounds(343, 643, 481, 27);
			contentPane.add(lblToday);
	}
}





















