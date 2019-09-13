package ScriptHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Dateinuk {
	
	public static void main(int args)
	{
		String s;
	    DateFormat formatter;       
	    formatter = new SimpleDateFormat("yyMMdd");
	   // formatter=DateFormat.getDateInstance("", aLocale)
	    s = formatter.format(DateFormat.getDateInstance(0, Locale.UK) );
	    //fmt = DateFormat.getDateInstance(styles[i], locale);
	    System.out.println(s);
	}

}
