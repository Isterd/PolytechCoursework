package com.example.course.lab3.chordata_sub.mammalia_sub.carnivora_sub;

import com.example.course.lab3.StringConstants;
import com.example.course.lab3.chordata_sub.mammalia_sub.Carnivora;

public abstract class Felidae extends Carnivora {
    @Override
    public String getFamily() {
        return StringConstants.FAMILY_FELIDAE;
    }
}
