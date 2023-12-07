package com.example.course.lab3;

import com.example.course.lab3.chordata_sub.Mammalia;
import com.example.course.lab3.chordata_sub.mammalia_sub.Carnivora;
import com.example.course.lab3.chordata_sub.mammalia_sub.Eupotyphla;
import com.example.course.lab3.chordata_sub.mammalia_sub.carnivora_sub.Felidae;
import com.example.course.lab3.chordata_sub.mammalia_sub.carnivora_sub.felidae_sub.LynxKerr;
import com.example.course.lab3.chordata_sub.mammalia_sub.carnivora_sub.felidae_sub.OtocolobusManul;
import com.example.course.lab3.chordata_sub.mammalia_sub.eupotyphla_sub.Erinaceidae;
import com.example.course.lab3.chordata_sub.mammalia_sub.eupotyphla_sub.erinaceidae_sub.ErinaceusEuropaeus;

import java.util.ArrayList;

public class Lab3Handler {
    public static String start(int functionVariant) {
        Segregate segregate = new Segregate();
        return switch (functionVariant) {
            case 1 -> startFirstVariant(segregate);
            case 2 -> startSecondVariant(segregate);
            case 3 -> startThirdVariant(segregate);
            default -> "Something go wrong";
        };
    }

    private static String startFirstVariant(Segregate segregate) {
        Erinaceidae ezh = new ErinaceusEuropaeus("Ежик от 1 примера");
        Mammalia manul = new OtocolobusManul("Манул от 1 примера");
        Mammalia lynx = new LynxKerr("Рысь от 1 примера");

        ArrayList<Mammalia> srcCollection = new ArrayList<>();
        ArrayList<Erinaceidae> Collection1 = new ArrayList<>();
        ArrayList<Felidae> Collection2 = new ArrayList<>();
        ArrayList<Carnivora> Collection3 = new ArrayList<>();

        srcCollection.add(ezh);
        srcCollection.add(manul);
        srcCollection.add(lynx);

        segregate.segregate(srcCollection, Collection1, Collection2, Collection3);

        return collectionOutput(Collection1, Collection2, Collection3);
    }

    private static String startSecondVariant(Segregate segregate) {
        Carnivora lynx2 = new LynxKerr("Рысь от 2 примера");
        Carnivora manul2 = new OtocolobusManul("Манул от 2 примера");
        Carnivora lynx3 = new LynxKerr("Еще рысь");
        Carnivora manul3 = new OtocolobusManul("Еще манул");

        ArrayList<Carnivora> srcCollection2 = new ArrayList<>();
        ArrayList<Chordata> Collection12 = new ArrayList<>();
        ArrayList<OtocolobusManul> Collection22 = new ArrayList<>();
        ArrayList<Felidae> Collection32 = new ArrayList<>();

        srcCollection2.add(lynx2);
        srcCollection2.add(manul2);
        srcCollection2.add(lynx3);
        srcCollection2.add(manul3);

        segregate.segregate(srcCollection2, Collection12, Collection22, Collection32);
        return collectionOutput(Collection12, Collection22, Collection32);
    }

    private static String startThirdVariant(Segregate segregate) {
        ArrayList<Erinaceidae> srcCollection3 = new ArrayList<>();
        ArrayList<Eupotyphla> Collection13 = new ArrayList<>();
        ArrayList<Carnivora> Collection23 = new ArrayList<>();
        ArrayList<Carnivora> Collection33 = new ArrayList<>();

        Erinaceidae ezh = new ErinaceusEuropaeus("Ежик от 1 примера");
        Erinaceidae ezh2 = new ErinaceusEuropaeus("Еж от 3 примера");
        Erinaceidae ezh3 = new ErinaceusEuropaeus("Еж от 3 примера");

        srcCollection3.add(ezh2);
        srcCollection3.add(ezh3);
        srcCollection3.add(ezh);

        segregate.segregate(srcCollection3, Collection13, Collection23, Collection33);
        collectionOutput(Collection13, Collection23, Collection33);
        return collectionOutput(Collection13, Collection23, Collection33);
    }

    public static String collectionOutput(ArrayList<?> Collection1, ArrayList<?> Collection2, ArrayList<?> Collection3) {
        StringBuilder result = new StringBuilder();
        result.append("Коллекция 1:\n");
        for (Object o : Collection1) {
            result.append(o).append("\n");
        }
        result.append("\nКоллекция 2:\n");
        for (Object o : Collection2) {
            result.append(o).append("\n");
        }
        result.append("\nКоллекция 3:\n");
        for (Object o : Collection3) {
            result.append(o).append("\n");
        }
        return result.toString();
    }
}
