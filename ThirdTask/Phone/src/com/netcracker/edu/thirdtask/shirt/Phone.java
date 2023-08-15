package com.netcracker.edu.thirdtask.shirt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {

    public static String formatNumber(String number){
        Pattern numPat = Pattern.compile("^(\\+\\d{1,3}||8)(\\d{3})(\\d{3})(\\d{4})$");
        Matcher m = numPat.matcher(number);
        if(m.matches()){
            if (m.group(1).equals("8")){
                return "+7" + m.group(2) + "-" + m.group(3) + "-" + m.group(4);
            }
            return m.group(1) + m.group(2) + "-" + m.group(3) + "-" + m.group(4);
        }
        return "Invalid Number";
    }

}
