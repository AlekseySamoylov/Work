package com.alekseysamoylov.sp3;

/**
 * Created by alekseysamoylov on 3/9/16.
 */
public class ReplacementTarget {
    public String formatMessage(String msg) {
        return"<h1>" + msg + "</h1>";
    }

    public String formatMessage(Object msg) {
        return "<h1>" + msg + "</h1>";
    }
}
