package com.alekseysamoylov.sp3.annotation;

import org.springframework.stereotype.Component;

/**
 * Created by alekseysamoylov on 3/2/16.
 */
@Component("injectSimpleConfig")
public class InjectSimpleConfig {
    public String name = "Petya";
    public int age = 33;
    public float height = 184.0f;
    public boolean programmer = true;
    public Long ageInSeconds = 1066554332L;
}
