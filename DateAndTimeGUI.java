

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DateAndTimeGUI extends JFrame{

 private JLabel hourLabel, minuteLabel, secondLabel, monthLabel, dayLabel, yearLabel, filler;
 private JComboBox hourBox, minuteBox, secondBox, monthBox, dayBox, yearBox;
 private JTextField txtBox= new JTextField(30);
 private JButton sdtButton, incSecButton, decSecButton, incHrButton, decHrButton, incDayButton, decDayButton;
 private DateAndTime dntOb;

 public final static String monthNames[]={"January", "Feburary", "March", "April","May", "June", "July", "August", "September", "October", "November", "December"};

 public DateAndTimeGUI(){
  super("Date and Time");
  //create date and time object
  dntOb = new DateAndTime();

  Container container = getContentPane();
  container.setLayout(new GridLayout(7,3));

  txtBox.setEditable(false);
  //create the labels
  hourLabel = new JLabel("Hour");
  minuteLabel = new JLabel("Minute");
  secondLabel = new JLabel("Second");
  monthLabel = new JLabel("Month");
  dayLabel = new JLabel("Day");
  yearLabel = new JLabel("Year");
  filler = new JLabel("");

  //create an empty combo box, and then add values 0-23 using for loop
  hourBox = new JComboBox();
  for (int i=0;i<24 ; i++) 
   hourBox.addItem(i+"");

  //create empty combo box for minute and second, add values 0-59
  minuteBox = new JComboBox();
  secondBox = new JComboBox();
  for (int i=0;i<60 ; i++) {
   minuteBox.addItem(i+"");
   secondBox.addItem(i+"");
  }

  //create a drop down list with the name of the months, using an array
  monthBox = new JComboBox(monthNames);


  //create empty combo box and add values 1-31 for days using for loop
  dayBox = new JComboBox();
  for (int i =1 ; i<32; i++) 
   dayBox.addItem(i+"");

  //create empty combo box and add values 1900-2050 for the years, using for loop
  yearBox = new JComboBox();
  for (int i =1900 ; i<2051; i++) 
   yearBox.addItem(i+"");

  Buttonhandler bhandler = new Buttonhandler();
  //create the buttons with their respective text
  sdtButton = new JButton("Set Date And Time");
  sdtButton.addActionListener(bhandler);

  incSecButton = new JButton("Increase Second");
  incSecButton.addActionListener(bhandler);

  decSecButton = new JButton("Decrease Second");
  decSecButton.addActionListener(bhandler);

  incHrButton = new JButton("Increase Hour");
  incHrButton.addActionListener(bhandler);

  decHrButton = new JButton("Decrease Hour");
  decHrButton.addActionListener(bhandler);

  incDayButton = new JButton("Increase Day");
  incDayButton.addActionListener(bhandler);

  decDayButton = new JButton("Decrease Day");
  decDayButton.addActionListener(bhandler);

  //Row 1
  
  container.add(hourLabel);
  container.add(hourBox);
  container.add(sdtButton);

  //Row 2
  container.add(minuteLabel);
  container.add(minuteBox);
  container.add(incSecButton);

  //Row 3
  container.add(secondLabel);
  container.add(secondBox);
  container.add(decSecButton);

  //Row 4
  container.add(monthLabel);
  container.add(monthBox);
  container.add(incHrButton);

  //Row 5
  container.add(dayLabel);
  container.add(dayBox);
  container.add(decHrButton);

  //Row 6
  container.add(yearLabel);
  container.add(yearBox);
  container.add(incDayButton);
  

  //Row 7
  container.add(filler);
  container.add(txtBox);
  container.add(decDayButton);
  

  setSize(600,300);
  setVisible(true);



 }
 
 private class Buttonhandler implements ActionListener{

  public void actionPerformed(ActionEvent e){
    boolean validDate;

   if(e.getSource() == sdtButton){
    validDate = dntOb.SetDateAndTime(hourBox.getSelectedIndex(), minuteBox.getSelectedIndex(), secondBox.getSelectedIndex(),
      monthBox.getSelectedIndex()+1, dayBox.getSelectedIndex() +1, yearBox.getSelectedIndex() +1900);
      if(validDate)
        txtBox.setText(dntOb.toString());
      else
        txtBox.setText("Invalid Date and/or Time");
   	}

    if(e.getSource() == incDayButton){
      dntOb.increaseDay();
    	txtBox.setText(dntOb.toString());
  	 }

    if(e.getSource() == decDayButton){
      dntOb.decreaseDay();
    	txtBox.setText(dntOb.toString());
   	}

   	if(e.getSource() == incHrButton){
    	dntOb.increaseHour();
      txtBox.setText(dntOb.toString());
   	}

   	if(e.getSource() == decHrButton){
      dntOb.decreaseHour();
    	txtBox.setText(dntOb.toString());
   	}

   	if(e.getSource() == incSecButton){
      dntOb.increaseSecond();
    	txtBox.setText(dntOb.toString());
   	}

   	if(e.getSource() == decSecButton){
      dntOb.decreaseSecond();
    	txtBox.setText(dntOb.toString());   	}
  }

 }


}


