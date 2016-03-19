package com.alekseysamoylov.sp3.annotation.two;

import org.springframework.stereotype.Service;

/**
 * Created by alekseysamoylov on 3/1/16.
 */
@Service("oracle")
public class BookwormOracle implements Oracle {

    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of money - use the Internet";
    }
}
