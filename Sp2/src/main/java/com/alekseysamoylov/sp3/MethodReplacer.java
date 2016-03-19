package com.alekseysamoylov.sp3;

import java.lang.reflect.Method;

/**
 * Created by alekseysamoylov on 3/9/16.
 */
public interface MethodReplacer {
    public Object reimplement(Object org0, Method method, Object[] args)throws Throwable;
}
