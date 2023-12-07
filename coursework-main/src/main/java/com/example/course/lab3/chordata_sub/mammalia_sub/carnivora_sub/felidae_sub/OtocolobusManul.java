package com.example.course.lab3.chordata_sub.mammalia_sub.carnivora_sub.felidae_sub;

import com.example.course.lab3.StringConstants;
import com.example.course.lab3.chordata_sub.mammalia_sub.carnivora_sub.Felidae;

public final class OtocolobusManul extends Felidae {
    public OtocolobusManul(String name) {
        this.name = name;
    }
    @Override
    public String getGenus() {
        return StringConstants.GENUS_OTOCOLOBUS_MANUL;
    }
}
