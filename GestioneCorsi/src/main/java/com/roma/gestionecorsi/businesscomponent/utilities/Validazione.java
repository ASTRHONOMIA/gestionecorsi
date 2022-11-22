package com.roma.gestionecorsi.businesscomponent.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validazione {

	public Validazione() {
	}

	public boolean convalidaStringa(String stringa) {
		Pattern p = Pattern.compile("[a-zA-Z ',òàèùì]{2,30}");// minimo due lettere
		Matcher m = p.matcher(stringa);
		return m.matches();

	}

	public boolean convalidaAula(String stringa) {
		Pattern p = Pattern.compile("[a-zA-Z0-9 ]{2,30}");// minimo due lettere
		Matcher m = p.matcher(stringa);
		return m.matches();

	}

	public boolean convalidaFormatoDate(String date) {
		Pattern p = Pattern.compile(
				"^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
		Matcher m = p.matcher(date);
		return m.matches();
	}
	
	
	public boolean convalidaCommento(String stringa)
	{
		return stringa.length() <= 200;
	}
	

	public boolean convalidaDate(String data1, String data2) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			GregorianCalendar inizio = new GregorianCalendar();
			inizio.setTime(format.parse(data1));
			GregorianCalendar fine = new GregorianCalendar();
			fine.setTime(format.parse(data2));
			if (inizio.get(GregorianCalendar.DAY_OF_WEEK) == 7 || inizio.get(GregorianCalendar.DAY_OF_WEEK) == 1)
			{
				return false;
			}
			if (fine.get(GregorianCalendar.DAY_OF_WEEK) == 7 || fine.get(GregorianCalendar.DAY_OF_WEEK) == 1)
			{
				return false;
			}
			if (inizio.before(fine)) {
				if (Math.round((fine.getTimeInMillis() - inizio.getTimeInMillis()) / 86400000.0) >= 1) {
					int giorni = 0;
					GregorianCalendar date1 = new GregorianCalendar();
					GregorianCalendar date2 = new GregorianCalendar();
					date2 = fine;
					date2.add(GregorianCalendar.DATE, 1);
					for (date1 = inizio; !date1.equals(date2) && giorni < 2; date1.add(GregorianCalendar.DATE,1)) {
						
						if (date1.get(GregorianCalendar.DAY_OF_WEEK) != 7 && date1.get(GregorianCalendar.DAY_OF_WEEK) != 1)
							{
								giorni = giorni + 1;
							}
					}
					if (giorni == 2) {
						return true;
					}

				}
			}
			return false;

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean convalidaCosto(Double costo)
	{
		return costo>0;
	}

}