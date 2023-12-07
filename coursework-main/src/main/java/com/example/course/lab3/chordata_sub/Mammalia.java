package com.example.course.lab3.chordata_sub;

import com.example.course.lab3.Chordata;
import com.example.course.lab3.StringConstants;

public abstract class Mammalia extends Chordata {
    @Override
    public String getClassName() {
        return StringConstants.CLASS_MAMMALIA;
    }
}
