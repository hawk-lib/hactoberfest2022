package project1;
import java.time.LocalDate;

public class JavaDates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate today=LocalDate.now();
		System.out.println(LocalDate.now());
		System.out.println(today.getYear());
		System.out.println(today.getMonth());
		System.out.println(today.getMonthValue());
		System.out.println(today.isLeapYear());
		System.out.println(today.lengthOfMonth());
		
		System.out.println(today.getDayOfMonth());
		System.out.println(today.getDayOfWeek());
		System.out.println(today.getDayOfYear());
		
		//adding days,months,years to current days
		System.out.println(today.plusDays(100));
		System.out.println(today.plusMonths(100));
		System.out.println(today.plusYears(100)); //same way plus ke jagah minus bhi kr skte hain
		
		//setting date to a specific value
		LocalDate yesterday = LocalDate.of(2022, 06, 15);
		System.out.println(yesterday);

	}

}
