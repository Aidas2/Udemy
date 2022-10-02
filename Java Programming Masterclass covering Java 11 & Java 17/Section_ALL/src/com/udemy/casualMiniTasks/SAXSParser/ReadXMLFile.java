package com.udemy.casualMiniTasks.SAXSParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ReadXMLFile {

    public static void main(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bADM_KODAS = false;
                boolean bADM_ID = false;
                boolean bTIPAS = false;
                boolean bTIPO_SANTRUMPA = false;
                boolean bVARDAS_K = false;
                boolean bVARDAS_K_LOT = false;
                boolean bPRIKLAUSO_KODAS = false;
                boolean bGYV_KODAS = false;
                boolean bNUO = false;
                boolean bIKI = false;
                boolean bADM_NUO = false;
                boolean bADM_IKI = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {

                    ///System.out.println("Start Element :" + qName);

                    if (qName.equalsIgnoreCase("ADMINISTRACINIS")) {
                        //String id = attributes.getValue("id");  // in case if <ADMINISTRACINIS id = "1001'>
                        System.out.println("\nCurrent Element: " + qName);
                    } else if (qName.equalsIgnoreCase("ADM_KODAS")) {
                        bADM_KODAS = true;
                    } else if (qName.equalsIgnoreCase("ADM_ID")) {
                        bADM_ID = true;
                    } else if (qName.equalsIgnoreCase("TIPAS")) {
                        bTIPAS = true;
                    } else if (qName.equalsIgnoreCase("TIPO_SANTRUMPA")) {
                        bTIPO_SANTRUMPA = true;
                    } else if (qName.equalsIgnoreCase("VARDAS_K")) {
                        bVARDAS_K = true;
                    } else if (qName.equalsIgnoreCase("VARDAS_K_LOT")) {
                        bVARDAS_K_LOT = true;
                    } else if (qName.equalsIgnoreCase("PRIKLAUSO_KODAS")) {
                        bPRIKLAUSO_KODAS = true;
                    } else if (qName.equalsIgnoreCase("GYV_KODAS")) {
                        bGYV_KODAS = true;
                    } else if (qName.equalsIgnoreCase("NUO")) {
                        bNUO = true;
                    } else if (qName.equalsIgnoreCase("IKI")) {
                        bIKI = true;
                    } else if (qName.equalsIgnoreCase("ADM_NUO")) {
                        bADM_NUO = true;
                    } else if (qName.equalsIgnoreCase("ADM_IKI")) {
                        bADM_IKI = true;
                    }

                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                    //System.out.println("End Element :" + qName);

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bADM_KODAS) {
                        System.out.println("ADM_KODAS: " + new String(ch, start, length));
                        bADM_KODAS = false;
                    } else if (bADM_ID) {
                        System.out.println("ADM_ID: " + new String(ch, start, length));
                        bADM_ID = false;
                    } else if (bTIPAS) {
                        System.out.println("TIPAS: " + new String(ch, start, length));
                        bTIPAS = false;
                    } else if (bTIPO_SANTRUMPA) {
                        System.out.println("TIPO_SANTRUMPA: " + new String(ch, start, length));
                        bTIPO_SANTRUMPA = false;
                    } else if (bVARDAS_K) {
                        System.out.println("VARDAS_K: " + new String(ch, start, length));
                        bVARDAS_K = false;
                    } else if (bVARDAS_K_LOT) {
                        System.out.println("VARDAS_K_LOT: " + new String(ch, start, length));
                        bVARDAS_K_LOT = false;
                    } else if (bPRIKLAUSO_KODAS) {
                        System.out.println("PRIKLAUSO_KODAS: " + new String(ch, start, length));
                        bPRIKLAUSO_KODAS = false;
                    } else if (bGYV_KODAS) {
                        System.out.println("GYV_KODAS: " + new String(ch, start, length));
                        bGYV_KODAS = false;
                    } else if (bNUO) {
                        System.out.println("NUO: " + new String(ch, start, length));
                        bNUO = false;
                    } else if (bIKI) {
                        System.out.println("IKI: " + new String(ch, start, length));
                        bIKI = false;
                    } else if (bADM_NUO) {
                        System.out.println("ADM_NUO: " + new String(ch, start, length));
                        bADM_NUO = false;
                    } else if (bADM_IKI) {
                        System.out.println("ADM_IKI: " + new String(ch, start, length));
                        bADM_IKI = false;
                    }

                }

            };

            saxParser.parse("src/com/udemy/casualMiniTasks/SAXSParser/ADM_PILN20190616.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
