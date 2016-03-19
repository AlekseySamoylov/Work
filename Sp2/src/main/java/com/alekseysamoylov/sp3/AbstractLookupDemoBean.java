package com.alekseysamoylov.sp3;

/**
 * Created by alekseysamoylov on 3/9/16.
 */
public abstract class AbstractLookupDemoBean implements DemoBean {
    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}
