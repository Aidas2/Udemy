package com.udemy.casualMiniTasks.comparator;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Municipality municipality1 = new Municipality("1", "1", "1998-06-01", null, "Alytaus", "apskritis");
        Municipality municipality2 = new Municipality("41", "2", "1998-06-01", null, "Kauno", "apskritis");
        Municipality municipality3 = new Municipality("111", "3", "1998-06-01", null, "Klaipëdos", "apskritis");
        Municipality municipality4 = new Municipality("3", "15", "1998-06-01", "1", "Druskininkø", "savivaldybë");
        Municipality municipality5 = new Municipality("16", "38", "1998-06-01", "1", "Varënos rajono", "savivaldybë");
        Municipality municipality6 = new Municipality("42", "12", "1998-06-01", "2", "Birðtono", "savivaldybë");
        Municipality municipality7 = new Municipality("52", "4620", "1998-06-01", "46", "Ruklos", "seniûnija");
        Municipality municipality8 = new Municipality("80", "5223", "1998-06-01", "46", "Garliavos", "seniûnija");
        Municipality municipality9 = new Municipality("95", "6973", "1998-06-01", "69", "Stakliðkiø", "seniûnija");

        List<Municipality> municipalities = new ArrayList<Municipality>();

        municipalities.add(municipality1);
        municipalities.add(municipality2);
        municipalities.add(municipality3);
        municipalities.add(municipality4);
        municipalities.add(municipality5);
        municipalities.add(municipality6);
        municipalities.add(municipality7);
        municipalities.add(municipality8);
        municipalities.add(municipality9);

        //System.out.println(municipalities.toString());
        Collections.shuffle(municipalities);
        System.out.println(municipalities.toString());


        Comparator<Municipality> comparator = new Comparator<Municipality>() {
            @Override
            public int compare(Municipality m1, Municipality m2) {
                if ((m1.getType().equals("apskritis") && (m2.getType().equals("seniûnija") || m2.getType().equals("savivaldybë"))) ||
                    (m1.getType().equals("savivaldybë") && m2.getType().equals("seniûnija"))) {
                    return -1;
                } else if ((m1.getType().equals("seniûnija") && (m2.getType().equals("apskritis") || m2.getType().equals("savivaldybë"))) ||
                           (m1.getType().equals("savivaldybë") && m2.getType().equals("apskritis")) ) {
                    return 1;
                } else if ((m1.getType().equals("apskritis") && m2.getType().equals("apskritis")) ||
                           (m1.getType().equals("savivaldybë") && m2.getType().equals("savivaldybë")) ||
                           (m1.getType().equals("seniûnija") && m2.getType().equals("seniûnija"))) {
                    return 0;
                }
                return Integer.valueOf(m1.getType()).compareTo(Integer.valueOf(m2.getType()));
            }
        };

        Collections.sort(municipalities, comparator);

        System.out.println(municipalities.toString());

    }


}
