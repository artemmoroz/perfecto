package com.quantum.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

public class DateParser {

    private static final String TIME_ZONE = "US/Central";

    public List<String> getParsedToUSZoneDate(String dateStr) {
        Date date = null;
        try {
            date = new SimpleDateFormat("MM/dd/yyyy").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ZonedDateTime utcZoned = ZonedDateTime.of(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), ZoneOffset.UTC);
        ZoneId swissZone = ZoneId.of(TIME_ZONE);
        ZonedDateTime usZoned = utcZoned.withZoneSameInstant(swissZone);
        LocalDateTime dateTime = usZoned.toLocalDateTime().withDayOfMonth(usZoned.toLocalDateTime().getDayOfMonth() + 1);

        String month = dateTime.getMonth().toString().toLowerCase();
        String day = Integer.toString(dateTime.getDayOfMonth());
        String year = Integer.toString(dateTime.getYear());

        return  asList(
                month.substring(0,1).toUpperCase() + month.substring(1), day, year
        );
    }
}
