
//the Date class, creates objects with dates and increases and decreases date
public class Date{

	private int month, day, year;

	//Array holds the max number of days in each month
	private int[] array = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	//string array holds the name of each month
	private String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; 

	//no argument constructor
	public Date(){
		month =1;
		day = 1;
		year= 1980;
	}

	//constructor takes in date from the user and sets the date, is invalid date, sets date to 1/1/1980
	public Date(int mo, int da, int ye){
		boolean isDate =false;

		//checks to see if the year is a leapyear
		if (isLeapYear(ye))
			array[1] =29;
		else
			array[1] = 28;
		//if the month, date and year are valid
		if(month<=12&&month>=1){
			if(day>=1&&day<=array[mo - 1]){
				if(year>0)
					isDate = true;
			}
		}

		if(isDate){
			month = mo;
			day = da;
			year = ye;
		}
		else{
			month = 1;
			day = 1;
			year = 1980;
		}



	}

	//thrid constructor takes a date object and creates new object with the same date
	public Date(Date d1){
		month = d1.getMonth();
		day = d1.getDay();
		year = d1.getYear();

	}

	//inceases day by one
	public void increaseDay(){

		if (isLeapYear(year)) 
			array[1] =29;
		else
			array[1] = 28;

		day++;

		if(day > array[month-1]){
			day =1;
			month++;
			if(month>12){
				month = 1;
				year++;
			}
		}


	}


	public String toString(){
		return monthName[month -1] + " "+day+", "+ year;
	}

	//decreases day by one
	public void decreaseDay(){

		if (isLeapYear(year)) 
			array[1] =29;
		else
			array[1] = 28;

		day--;

		if(day==0){
			month--;
			if(month==0){
				month =12;
				day = array[month -1];
				year--;
			}
			day = array[month -1];
		}


		

	}

	public boolean setDate(int moth,int dy, int yr){
		boolean isDate =false;

		if (isLeapYear(yr)) 
			array[1] =29;
		else
			array[1] = 28;

		

		if(moth<=12&&moth>=1){
			if(dy>=1&&dy<=array[moth - 1]){
				if(yr>0)
					isDate = true;
			}
		}

		if(isDate){
			month = moth;
			day = dy;
			year = yr;
			return true;
		}
		else
			return false;

	}

	public int getMonth(){
		return month;
	}

	public int getDay(){
		return day;
	}

	public int getYear(){
		return year;
	}

	//checks year to see if it's a leap year
	public boolean isLeapYear(int yer){

		if((yer % 400==0)||(yer%4==0 && yer%100!=0 ))
			return true;
		else 
			return false;
		
	}
}

