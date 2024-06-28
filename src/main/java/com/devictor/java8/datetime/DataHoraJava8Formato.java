package com.devictor.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class DataHoraJava8Formato {

    public static void main(String[] args) {

        // DateTimeFormatter

//        Locale.setDefault(Locale.US);

//        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        DateTimeFormatter formatter =
            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
//            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
//            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
//            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);


        LocalDateTime ldtNow = LocalDateTime.now();
        ZonedDateTime zdtNow = ZonedDateTime.now();

//        String format = formatter.format(ldtNow);
        String format = formatter.format(zdtNow);

        System.out.println(format);
        System.out.println(zdtNow + "\n");


        DateTimeFormatter formatter2 =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String format2 = formatter2.format(ldtNow);
        System.out.println(format2 + "\n");

        String format3 = ldtNow.format(formatter2);
        System.out.println(format3 + "\n");

        TemporalAccessor parse = formatter2.parse("28-06-2024 17:05:35");
        LocalDateTime from = LocalDateTime.from(parse);
        System.out.println(from + "\n");

        DateTimeFormatter formatterHora =
            DateTimeFormatter.ofPattern("HH:mm:ss");
        TemporalAccessor parse2 = formatterHora.parse("23:38:26");
        LocalTime from2 = LocalTime.from(parse2);

        System.out.println(from2);

    }

}
