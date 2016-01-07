
//This class takes the Date.java class and inherites it to create Date and Time.

public class DateAndTime extends Date{

	int hour, minute, second;

	//creates DateAndTime object with default values
	public DateAndTime(){
		super();
		hour =0;
		minute = 0;
		second = 0;

	}

	//sets the date and time returns false otherwise
	public boolean SetDateAndTime(int hrs, int mins, int secs, int mon, int dy, int yr){
		if(super.setDate(mon, dy, yr)){
			if((hrs<24 && hrs>-1)&&(mins<60&&mins>-1)&&(secs<60&&secs>-1)){
				hour = hrs;
				minute = mins;
				second = secs;
				return true;
			}
			else
				return false;

		}
		else
			return false;

	}

	//increases second by one, adjusts hour, minutes, and day accordingly
	public void increaseSecond(){
		second++;

		if (second ==60) {
			second = 0;
			minute++;
			if (minute==60) {
				minute = 0;
				hour++;
				if (hour ==24) {
					hour = 0;
					super.increaseDay();
					
				}
			}
			
		}
	}

	//decreases second by one, adjusts hour, minutes, and day accordingly
	public void decreaseSecond(){
		second--;
		if (second<0) {
			second =59;
			minute--;
			if (minute<0) {
				minute = 59;
				hour--;
				if (hour<0) {
					hour = 23;
					super.decreaseDay();
					
				}
				
			}

			
		}

	}

	//increase second 3600 times to increase hour
	public void increaseHour(){
		for (int x=0;x<3600 ; x++) {
			increaseSecond();
			
		}
	}

	//decrease second 3600 times to increase hour
	public void decreaseHour(){
		for (int x=0;x<3600 ; x++) {
			decreaseSecond();
			
		}
	}

	public void increaseDay(){
		super.increaseDay();
	}
	//calls date class to decrease day
	public void decreaseDay(){
		super.decreaseDay();
	}

	//returns the string in the Monthname, day, year HH:MM:SS AM/PM format
	public String toString(){

		String str = super.toString();
		int num;

		if(hour>12)
			num = hour -12;
		else
			num = hour;


		if(hour<10)
			str = str + " 0"+num+":";
		else
			str = str+" "+num+":";

		if(minute<10)
			str = str + "0"+minute+":";
		else
			str = str+minute+":"; 


		if(second<10)
			str = str + "0"+second;
		else
			str = str+second;

		if (hour<12) 
			str = str + " AM";
		else
			str = str + " PM";


		return str;
	}

}