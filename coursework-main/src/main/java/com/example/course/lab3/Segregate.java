package com.example.course.lab3;

import com.example.course.lab3.chordata_sub.mammalia_sub.carnivora_sub.felidae_sub.LynxKerr;
import com.example.course.lab3.chordata_sub.mammalia_sub.carnivora_sub.felidae_sub.OtocolobusManul;
import com.example.course.lab3.chordata_sub.mammalia_sub.eupotyphla_sub.erinaceidae_sub.ErinaceusEuropaeus;

import java.util.ArrayList;

public class Segregate {

    public void segregate(ArrayList<? extends Chordata> srcCollection,
                          ArrayList<? super ErinaceusEuropaeus> Collection1,
                          ArrayList<? super OtocolobusManul> Collection2,
                          ArrayList<? super LynxKerr> Collection3) {
        if (srcCollection == null) {
            return;
        }

        for (Chordata o : srcCollection) {
            if (o instanceof ErinaceusEuropaeus) {
                Collection1.add((ErinaceusEuropaeus) o);
            }
            if (o instanceof OtocolobusManul) {
                Collection2.add((OtocolobusManul) o);
            }
            if (o instanceof LynxKerr) {
                Collection3.add((LynxKerr) o);
            }
        }
    }
}
