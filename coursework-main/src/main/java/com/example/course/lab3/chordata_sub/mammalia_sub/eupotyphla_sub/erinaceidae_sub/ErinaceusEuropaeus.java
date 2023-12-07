package com.example.course.lab3.chordata_sub.mammalia_sub.eupotyphla_sub.erinaceidae_sub;

import com.example.course.lab3.StringConstants;
import com.example.course.lab3.chordata_sub.mammalia_sub.eupotyphla_sub.Erinaceidae;

public final class ErinaceusEuropaeus extends Erinaceidae {
    public ErinaceusEuropaeus(String name) {
        this.name = name;
    }
    @Override
    public String getGenus() {
        return StringConstants.GENUS_ERINACEUS_EUROPAEUS;
    }
}
