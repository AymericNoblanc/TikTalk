import java.text.DateFormat;
import java.util.Date;


public class Dates {

public Dates(){

}


public DateFormat nowDate(){
  //Date aujourdhui = new Date();

      DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
        DateFormat.SHORT,
        DateFormat.SHORT);
    //	System.out.println(shortDateFormat.format(aujourdhui));
    return shortDateFormat;


}
}
