package test.vinod;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeFormatTest {
	

   public static void main(String[] args)
   {
	    
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format( Calendar.getInstance().getTime());

		 System.out.println(timeStamp);
   }
	
}
