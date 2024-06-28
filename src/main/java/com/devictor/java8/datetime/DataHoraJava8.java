package com.devictor.java8.datetime;

import java.time.*;

// Java 8 - API de Data e Hora
public class DataHoraJava8 {

    public static void main(String[] args) {

        // LocalDate = representa uma data: 28/06/2024

        // LocalTime = representa uma hora: 12:05:00

        // LocalDateTime = representa data + hora:
        // 28/06/2024 12:05:00

        // Instant - representa um instante/momento na linha do tempo
        // em milissegundos a partir 00:00:00 01/01/1970
        // sempre no GMT/UTC (fuso 0).

        // ZonedDateTime - LocalDateTime com TimzeZone (fuso)
        // 28/06/2024 12:05:00 GMT-3 (America/Sao_Paulo)

        // ### Não possuem construtor.


        LocalDate ldNow = LocalDate.now();
        System.out.println(ldNow);
        LocalDate ld = LocalDate.of(1996, 4, 29);
//        LocalDate date = LocalDate.of(1996, Month.APRIL, 29);
        System.out.println(ld + "\n");

        System.out.println(ld);
        LocalDate ld2 = ld.plusWeeks(2).plusDays(1);
        System.out.println(ld2 + "\n");


        LocalTime ltNow = LocalTime.now();
        System.out.println(ltNow);
        LocalTime lt = LocalTime.of(12, 10);
        System.out.println(lt + "\n");


        LocalDateTime ldtNow = LocalDateTime.now();
        System.out.println(ldtNow);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        System.out.println(ldt + "\n");


        Instant iNow = Instant.now();
        System.out.println(iNow);
        Instant instant = Instant.ofEpochMilli(29041996);
        System.out.println(instant + "\n");


        ZonedDateTime zdtNow = ZonedDateTime.now();
        System.out.println(zdtNow);
        ZoneId zoneId = ZoneId.of("America/Fortaleza");
        ZonedDateTime zdt = ZonedDateTime.of(ldt, zoneId);
        ZonedDateTime zdt2 = ZonedDateTime.of(ld, lt, zoneId);
        ZonedDateTime zdt3 = ZonedDateTime
            .of(1996, 4, 29, 12, 10, 00, 00, zoneId);
        System.out.println(zdt);
        System.out.println(zdt2);
        System.out.println(zdt3 + "\n");



    }

}
