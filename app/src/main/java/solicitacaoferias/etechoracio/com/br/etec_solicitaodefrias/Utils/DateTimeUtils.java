package solicitacaoferias.etechoracio.com.br.etec_solicitaodefrias.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static  String formatDate (int dia, int mes, int ano){

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(ano, mes, dia);
            return DATE_FORMAT.format((calendar.getTime()));
        }
        catch (Exception e){
            return null;

    }
    }

    public static Date toDate (String date)
    {
        try {
            return  DATE_FORMAT.parse(date);

            }
            catch (ParseException e){
            return  null;
        }
    }
    public static boolean isSegundaFeira (Date data) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int dia = cal.get(Calendar.DAY_OF_WEEK);
        if (dia == 2) {
            return true;
        } else {
            return false;
        }
    }
        public static  String formatarDataFinal(Calendar cal){
            SimpleDateFormat format1 = new SimpleDateFormat( "dd/MM/yyyy");
            return format1.format(cal.getTime());
        }
    }



