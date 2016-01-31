package programming.set7.date;

public class Date {
	private  int days, months, years;
	
	public Date (int year, int month, int day){
		if (validate(year, month, day)){
			days = day;
			months = month;
			years = year;
		}
		else {
			throw new IllegalArgumentException("This is not a valid date.");
		}
		
	}
	
	public static int getDaysInMonth(int year, int month){
		switch (month){
		case 1:
			return 31;
		case 2:
			if (checkLeapYear (year)){
				return 29;
			}
			else {
				return 28;
			}
		case 3:
			return 31;
		case 4:
			return 30;
		case 5:
			return 31;
		case 6:
			return 30;
		case 7:
			return 31;
		case 8:
			return 31;
		case 9:
			return 30;
		case 10:
			return 31;
		case 11:
			return 30;
		case 12:
			return 31;
		default:
			return 0;
		}
	}
	
	public static boolean checkLeapYear (int year){
		boolean b = year % 4 == 0 && year % 100 != 0 || year % 400 == 0; 
		return b;
	}

	public static boolean validate(int year, int month, int day){
		boolean checkYear = year >= 0;
		boolean checkMonth = month > 0 && month < 13;
		boolean checkDay = day > 0 && day <= getDaysInMonth (year, month);
		boolean validate = checkYear && checkMonth && checkDay;
		return validate;
	}
	
	public int getDay (){
		return this.days;
	}
	
	public int getMonth (){
		return this.months;
	}
	
	public int getYear (){
		return this.years;
	}
	
	public int dayOfYear (){
		int total = 0;
		int m1 = 0;
		for (int i = 1; i < this.months; i++){
			m1 = getDaysInMonth(this.years, i);
			total += m1;
		}
		if (this.months == 1){
			return this.days;
		}
		else return total + this.days;
	}
	
	public int sameYearDiff(Date other){
		if (other.years == this.years){
			return other.dayOfYear() - this.dayOfYear();
		}
		else return 0;
	}
	@Override
	public String toString(){
		String month = "";
		switch (this.months){
		case 1:
			month = "Januar";
			break;
		case 2:
			month = "Februar"; 
			break;
		case 3:
			month = "März";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "Mai";
			break;
		case 6:
			month = "Juni";
			break;
		case 7:
			month = "Juli";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "Oktober";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "Dezember";
			break;
		}
		String date = month + " " + this.days + ", " + this.years;
		return date;
	}

}
