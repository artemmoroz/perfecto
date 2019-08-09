package com.quantum.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateParser {

    private static final String TIME_ZONE = "US/Central";

    public LocalDate parseDateToUSZone(String dateStr) {
        Date date = null;
        try {
            date = new SimpleDateFormat("MM/dd/yyyy").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ZonedDateTime utcZoned = ZonedDateTime.of(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), ZoneOffset.UTC);
        ZoneId swissZone = ZoneId.of(TIME_ZONE);
        ZonedDateTime usZoned = utcZoned.withZoneSameInstant(swissZone);
        return usZoned.toLocalDate().withDayOfMonth(usZoned.toLocalDate().getDayOfMonth() + 1);
    }
}
