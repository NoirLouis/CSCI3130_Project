package com.toyide.csci3130_project;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;



// Check time conflict of two time intervals
public class CheckTimeConflict {


    //@Input: string XXXX-XXXX
    //@Return: true there is conflict
    public boolean confliCtcheck(String str1,String str2){
        //Split input time interval into two seperate time XXXX
        String startTime_1 = str1.split("-")[0];
        String endTime_1 = str1.split("-")[1];
        String startTime_2 = str2.split("-")[0];
        String endTime_2 = str2.split("-")[1];

        if ((startTime_1.compareTo(startTime_2) >= 0 && startTime_1.compareTo(endTime_2) < 0) || (startTime_2.compareTo(startTime_1) >= 0 && startTime_2.compareTo(endTime_1) < 0))
            return true;
        else
            return false;
    }

    //Check if two String contain the same character
    //Parameter: two strings
    //Return: true: there is overlap
    public boolean sameChars(String firstStr, String secondStr) {
        for(int i=0;i <firstStr.length();i++){
            for(int j=0;j<secondStr.length();j++){
                if(firstStr.charAt(i)==secondStr.charAt(j))
                    return true;
            }
        }
        return false;

    }
}
