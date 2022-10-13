package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formattimeuril {
    public static String formattime(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String time = sdf.format(data);

        return time;
    }
}
