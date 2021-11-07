package es.unileon.prg1.date;

import java.nio.file.FileStore;

import javax.xml.namespace.QName;

public class Date {
	private int day;
	private int month;
	private int year;
	

	// Class constructor
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
	

	//GetDaysOfMonth -- returns the number of days of the month given
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


	//nameMonth -- returns the name of the month
	public String nameMonth() {
		String mes="";
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
		return mes;

	}


	//dayOfTheMonthRight --  returns if the day of the month is right
	public boolean dayOfTheMonthRight() {
		if (this.day > this.getDaysOfMonth() || this.day < 1) {
			return true;
		} else {
			return false;
		}
	}


	//seasonOfMonth -- returns the season 
	public String seasonOfMonth() {
		String season = "";
		switch (this.month) {
			case 1:
			case 2:
			case 12:
				season = "Invierno";
				break;
			case 3:
			case 4:
			case 5:
				season = "Primaver";
				break;
			case 6:
			case 7:
			case 8:
				season = "Verano";
				break;
			case 9:
			case 10:
			case 11:
				season = "Otoño";
				break;
		}
		return season;
	}


	//monthsUntilEndYear -- returns the months until the end of the year
	public int monthsUntilEndYear () {
		int months = (int) 12 - this.month;
		return months;
	}


	//dateToStringVersion --  returns the string version of a date: 12th of Nov 2017
	public String dateToStringVersion () {
		String dateInString;
		String month = "";
		String superscript;
		// Changes the variable mes depending of the month given
		month = nameMonth();

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
		dateInString = this.day + superscript + " of " + month + " of " + this.year;
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
			String mes = "";

			for (int i = 0; i < 12; i++) {
				if (getDaysOfMonth(i) == getDaysOfMonth()) {
					if (i != this.month) {
						switch (i) {
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
						result.append(mes + " ");
					}
				}
			}
			return result.toString();
		}
		
	
	//daysSinceStartOfYear -- returns the days since the beginning of the year
	public int daysSinceStartOfYear() {
		int days = 0;
		switch (this.month) {
			case 1:
				days = this.day;
				break;
			case 2:
				days = 31 + this.day;
				break;
			case 3:
				days = 59 + this.day;
				break;
			case 4:
				days = 90 + this.day;
				break;
			case 5:
				days = 120 + this.day;
				break;
			case 6:
				days = 151 + this.day;
				break;
			case 7:
				days = 181 + this.day;
				break;
			case 8:
				days = 212 + this.day;
				break;
			case 9:
				days = 243 + this.day;
				break;
			case 10:
				days = 273 + this.day;
				break;
			case 11:
				days = 302 + this.day;
				break;
			case 12:
				days = 334 + this.day;
				break;
			default:
				break;
		}
		return days;
	}


	//attempsToRandomDateWhile -- returns the number of attemps needed to generate a random date equal to the given date uing WHILE
	public int attempsToRandomDateWhile() {
		int attemp = 0;
		int numAttemps = 0;
		while (attemp != daysSinceStartOfYear()) {
			attemp = (int) (Math.random() * (366 - 1)) + 1;
			numAttemps++;
		}
		return numAttemps;
		
	}


	//attempsToRandomDateDoWhile -- returns the number of attemps needed to generate a random date equal to the given date uing DOWHILE
	public int attempsToRandomDateDoWhile() {
		int attemp = 0;
		int numAttemps = 0;
		do {
			attemp = (int) (Math.random() * (366 - 1)) + 1;
			numAttemps++;
		} while (attemp != daysSinceStartOfYear());
		
		return numAttemps;
		
	}


	//dayOfTheWeek -- returns the day of the week knowing the day of the week of the first week of that year
	// firstDay is the dat of the week of the first week of that year, being 7 for Sunday, 1 for Monday, 2 for Tuesday...
	public String dayOfWeek(int firstDay){
			String name = "";
 
			int day = (this.daysSinceStartOfYear()%7)+firstDay;
			switch (day) {
				case 7:
					name = "Sunday";
					break;
				case 1:
					name = "Monday";
					break;
				case 2:
					name = "Tuesday";
					break;
				case 3:	
					name = "wednesday";
					break;
				case 4:
					name = "Thursday";
					break;
				case 5:
					name = "Friday";
					break;
				case 6:
					name = "Saturday";
					break;
			}
		return name;
	}



}