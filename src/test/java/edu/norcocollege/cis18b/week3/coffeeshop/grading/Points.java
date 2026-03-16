package edu.norcocollege.cis18b.week3.coffeeshop.grading;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Points {
    int value();
}