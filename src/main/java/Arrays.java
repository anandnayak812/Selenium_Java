import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Arrays {

	static void hello() {
		System.out.println("Hello world");
	}

	public static void main(String[] args) {
//		int i = 730 + 183;
//		System.out.println(i);
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date());
//		calendar.add(Calendar.DATE, -i);
//		SimpleDateFormat objSDF = new SimpleDateFormat("M/d/yyyy");
//		String retDate = objSDF.format(calendar.getTime());
//		System.out.println(retDate.contains("4/25/2021"));
		String v = "Hello (World)";
		String value = v.replaceAll("[( )]", "");
		System.out.println(value);
	}

}
