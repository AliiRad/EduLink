package com.EduLink.EduLink.config;


import org.aspectj.weaver.patterns.PerSingleton;

import java.time.LocalDate;
import java.util.Date;

public class Jalali {

    public static String jalaliDate(){
        LocalDate today = LocalDate.now(); // تاریخ میلادی امروز
        int gregorianYear = today.getYear();
        int gregorianMonth = today.getMonthValue();
        int gregorianDay = today.getDayOfMonth();

        int persianYear = gregorianYear - 621;
        if (gregorianMonth < 3 || (gregorianMonth == 3 && gregorianDay < 21)) {
            persianYear--;
        }

       return String.valueOf(persianYear);
    }

}
