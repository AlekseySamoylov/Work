package com.alekseysamoylov.sp2;

/**
 * Created by alekseysamoylov on 2/29/16.
 */
public class SetterInjection {
    private Dependency dependency;
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString(){
        return dependency.toString();
    }
}
