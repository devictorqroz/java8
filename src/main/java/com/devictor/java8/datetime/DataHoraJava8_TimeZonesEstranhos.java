package com.devictor.java8.datetime;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class DataHoraJava8_TimeZonesEstranhos {

    public static void main(String[] args) {

        Locale.setDefault(Locale.forLanguageTag("pt-BR"));

        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateFormat dateFormat =
                DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

        LocalDate localDate = LocalDate.of(1918, 8, 6);
        LocalTime localTime = LocalTime.of(23, 59);
        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime zdt = ZonedDateTime.of(localDate, localTime, zoneId);
        Date date = new Date(zdt.toInstant().toEpochMilli());

        System.out.println(dateTimeFormatter.format(zdt));
        System.out.println(dateFormat.format(date));

        System.out.println(zdt.getOffset());
        System.out.println(date.getTimezoneOffset());


    }

}
