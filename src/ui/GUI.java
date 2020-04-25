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
import functions.MockData;
import functions.TaskItem;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DailyTasks dailyTasks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MockData.buildData();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Set System L&F
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (UnsupportedLookAndFeelException e) {
					// handle exception
				} catch (ClassNotFoundException e) {
					// handle exception
				} catch (InstantiationException e) {
					// handle exception
				} catch (IllegalAccessException e) {
					// handle exception
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
	DefaultTableModel model;
	JPanel calendarPanel = new JPanel();

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
		
		JTextArea textPane = new JTextArea();
		textPane.setBounds(5, 28, 307, 621);
		notePanel.add(textPane);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(5, 5, 307, 20);
			notePanel.add(menuBar);
			
			// ************************************* Menu operations *************************************
			JMenu mnSave = new JMenu("Save");
			menuBar.add(mnSave);
			
				JMenuItem mntmSave = new JMenuItem("Save...");
				mntmSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JFileChooser jfc = new JFileChooser();
						int returnVal = jfc.showOpenDialog((Component)arg0.getSource());
						
					    if (returnVal == JFileChooser.APPROVE_OPTION) {
					        File file = jfc.getSelectedFile();
					        try {
					           fileName = file.toString();
					           FileHandler.writeFile(fileName, textPane.getText());	// sets text to file contents
					           
					        } catch (Exception ex) {
					          System.out.println("problem accessing file" + file.getAbsolutePath());
					        }
					    } 
					    else {
					        System.out.println("File access cancelled by user.");
					    }  
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
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 2, 2);
				contentPane.add(scrollPane);
			// ************************************* 				*************************************

			calendarPanel.setBackground(new Color(0, 102, 0));
			calendarPanel.setBounds(343, 10, 591, 622);
			contentPane.add(calendarPanel);
			calendarPanel.setLayout(null);
			
			model = new DefaultTableModel(){
			    @Override
			    public boolean isCellEditable(int row, int column)
			    {
			    	// all except day label are editable
			        return column > 0 && row > 0;
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
	        buildTask();	// populates table	
	        
			table = new JTable(model);
			table.setBounds(10, 11, 571, 579);
			calendarPanel.add(table);
			table.setColumnModel(columnModel);
			
			JButton btnAddNewTask = new JButton("Add New Task");
			btnAddNewTask.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					/*
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MM/dd HH:mm");
						String today = formatter.format( LocalDateTime.now() );
					*/	
					
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

							if( date.equals("Mon") ) {
								dailyTasks.addMonday(n);
							}
							if( date.equals("Tue") ) {
								dailyTasks.addTuesday(n);
							}
							if( date.equals( "Wed") ) {
								dailyTasks.addWednesday(n);
							}
							if( date.equals( "Thr") ) {
								dailyTasks.addThursday(n);
							}
							if( date.equals( "Fri") ) {
								dailyTasks.addFriday(n);
							}
							if( date.equals( "Sat") ) {
								System.out.println(date);
								dailyTasks.addSaturday(n);
							}
							if( date.equals( "Sun") ) {
								dailyTasks.addSunday(n);
							}
				        }		
				        buildTask();		// builds list
				        	
				        calendarPanel.revalidate();	
				        calendarPanel.repaint();
					} catch ( BadTimeException e ) {
						e.printStackTrace();
						JOptionPane.showConfirmDialog(table, "Time must be between 00:00 and 23:59", "ERROR", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			btnAddNewTask.setBounds(426, 594, 155, 23);
			calendarPanel.add(btnAddNewTask);
			
			JButton btnCompleteTask = new JButton("Complete Tasks");
			btnCompleteTask.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i = 1; i < model.getRowCount(); i++)
					{
						if( model.getValueAt(i, 3).toString().equalsIgnoreCase("yes") || model.getValueAt(i, 3).toString().equalsIgnoreCase("true") )
						{
							if( model.getValueAt(i, 0) == null )
							{
								model.removeRow(i);
								
								calendarPanel.revalidate();
								calendarPanel.repaint();
							}
							
						}
					}
				}
			});
			btnCompleteTask.setBounds(261, 594, 155, 23);
			calendarPanel.add(btnCompleteTask);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MM/dd");
			String today = formatter.format( LocalDateTime.now() );
			
			JLabel lblToday = new JLabel("Welcome back! Today is " + today );
			lblToday.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
			lblToday.setBounds(343, 643, 481, 27);
			contentPane.add(lblToday);
	}

	private void buildTask() {
		model.setRowCount(1);
		Object[][] dayTask = null;
        model.addRow( new Object [] {"MONDAY", "", "", ""});						// Monday tasks
	        try {
	        	dayTask = DailyTasks.tasksForDay(DayOfWeek.MONDAY);
		        for( Object[] task : dayTask ) {
		        	model.addRow(task);
		        }
	        } catch (NullPointerException e ) {
	        	// no task for given day
	        }
         
        model.addRow( new Object [] {"TUESDAY", "", "", ""});						// Tuesday tasks
        	try {
        		dayTask = DailyTasks.tasksForDay(DayOfWeek.TUESDAY);
		        for( Object[] task : dayTask ) {
		        	model.addRow(task);
		        }
        	} catch (NullPointerException e ) {
	        	// no task for given day
	        }
         
        model.addRow( new Object [] {"WEDNEDAY", "", "", ""});						// Wednesday tasks
        	try {
        		dayTask = DailyTasks.tasksForDay(DayOfWeek.WEDNESDAY);
			    for( Object[] task : dayTask ) {
			    	model.addRow(task);
			    }
        	} catch (NullPointerException e ) {
	        	// no task for given day
	        }
	         
        model.addRow( new Object [] {"THURSDAY", "", "", ""});						// Thursday tasks
        	try {
        		dayTask = DailyTasks.tasksForDay(DayOfWeek.THURSDAY);
		        for( Object[] task : dayTask ) {
		        	model.addRow(task);
		        }
        	} catch (NullPointerException e ) {
	        	// no task for given day
	        }
         
        model.addRow( new Object [] {"FRIDAY", "", "", ""});						// Friday tasks
        	try {
        		dayTask = DailyTasks.tasksForDay(DayOfWeek.FRIDAY);
		        for( Object[] task : dayTask ) {
		        	model.addRow(task);
		        }
        	} catch (NullPointerException e ) {
	        	// no task for given day
	        }
	         
        model.addRow( new Object [] {"SATURDAY", "", "", ""});						// Saturday tasks
        	try {
        		dayTask = DailyTasks.tasksForDay(DayOfWeek.SATURDAY);
		        for( Object[] task : dayTask ) {
		        	model.addRow(task);
		        }
        	} catch (NullPointerException e ) {
	        	// no task for given day
	        }
         
        model.addRow( new Object [] {"SUNDAY", "", "", ""});						// Sunday tasks
        	try {
        		dayTask = DailyTasks.tasksForDay(DayOfWeek.SUNDAY);
		        for( Object[] task : dayTask ) {
		        	model.addRow(task); 
		        }	        
        	} catch (NullPointerException e ) {
	        	// no task for given day
	        }
        	
        System.out.println(DailyTasks.tasksForDay(DayOfWeek.SATURDAY).length);
	}
}





















