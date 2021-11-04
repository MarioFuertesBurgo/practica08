package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	

	// Constructor de la clase
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	

	//SetDay
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	

	//SetMonth
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	

	//SetYear
	public void setYear (int year) {
		this.year = year;
	}


	//getDay
	public int getDay () {
		return this.day;
	}


	//getMonth
	public int getMonth () {
		return this.month;
	}


	//getYear
	public int getYear () {
		return this.year;
	}
	

	//GetDaysOfMonth -- mira cuantos dias tiene que tener cada mes
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
	

	//toString
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}


	//isSameYear -- IF
	public boolean isSameYearIf(int year) {
		boolean isSame = false;
		if (this.year == year) {
			isSame = true;
		}
		return isSame;
	}


	//isSameYear
	public boolean isSameYear(int year) {
		return this.year == year;
	}
	

	//isSameMonth -- IF
	public boolean isSameMonthIf(int month) {
		boolean isSame = false;
		if (this.month == month) {
			isSame = true;
		}
		return isSame;
	}


	//isSameMonth
	public boolean isSameMonth(int month) {
		return this.month == month;
	}


	//isSameDay -- IF
	public boolean isSameDayIf(int day) {
		boolean isSame = false;
		if (this.day == day) {
			isSame = true;
		}
		return isSame;
	}


	//isSameDay
	public boolean isSameDay(int day) {
		return this.day == day;
	}


	//monthsUntilEndYear -- returns the months until the end of the year
	public int monthsUntilEndYear () {
		int months = (int) 12 - this.month;
		return months;
	}


	//dateToStringVersion --  returns the string version of a date: 12th of Nov 2017
	public String dateToStringVersion () {
		String dateInString;
		String mes = "";
		String superscript;
		// Changes the variable mes depending of the month given
		switch (this.month) {
			case 1:
				mes = "January";
				break;
			case 2:
				mes = "February";
				break;
			case 3:
				mes = "March";
				break;
			case 4:
				mes = "April";
				break;
			case 5:
				mes = "May";
				break;
			case 6:
				mes = "June";
				break;
			case 7:
				mes = "July";
				break;
			case 8:
				mes = "August";
				break;
			case 9:
				mes = "September";
				break;
			case 10:
				mes = "October";
				break;
			case 11:
				mes = "November";
				break;
			case 12:
				mes = "December";
				break;
		
			default:
				break;
		}

		//Changes the superscript ordinals depending on the day
		switch (this.day) {
			case 1:
			case 21:
			case 31:
				superscript = "st";
				break;

			case 2:
			case 22:
				superscript = "nd";
				break;
			
			case 3:
			case 23:
				superscript = "rd";
				break;

			default:
				superscript = "th";
				break;
		}
		dateInString = this.day + superscript + " of " + mes + " of " + this.year;
		return dateInString;
		
	}


	//datesUntilEndMonth -- returns all the dates until the end of the month
	public String datesUntilEndMonth() {

		StringBuffer dates = new StringBuffer(60);
		dates.append("The dates until the end of the month are: ");
		int totalDays = getDaysOfMonth();

		for (int i = this.day; i < totalDays+1 ; i++) {
			dates.append(i+" ");
		}
		return dates.toString();
	}


	//GetDaysOfMonth -- mira cuantos dias tiene que tener cada mes
	private int getDaysOfMonth(int mes) {
		int numDays;
		
		numDays = 0;
		switch (mes) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}


	//sameDaysMonths -- returns all the months with the same number of days
	public String sameDaysMonths() {
			StringBuffer result = new StringBuffer(60);


			for (int i = 0; i < 12; i++) {
				if (getDaysOfMonth(i) == getDaysOfMonth()) {
					result.append(result + " ");
				}
			}

			return result.toString();
		
	}
}