package com.alekseysamoylov.sp2;

/**
 * Created by alekseysamoylov on 2/29/16.
 */
public interface Container {
    Object getDependency(String key);
}
