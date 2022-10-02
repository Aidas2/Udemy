package com.udemy.casualMiniTasks.SAXSParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class ReadXMLFile2 {


    public static void main(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            List<Municipality> municipalities = new ArrayList<Municipality>();
            final int[] linesCount = { 0 };

            DefaultHandler handler = new DefaultHandler() {

                String currentElementName;
                Municipality currentMunicipality;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {

                    this.currentElementName = qName;

                    ///System.out.println("Start Element :" + qName);
                    if (qName.equalsIgnoreCase("ADMINISTRACINIS")) {
                        this.currentMunicipality = new Municipality();
                        municipalities.add(this.currentMunicipality);
                        linesCount[0]++;
                    }

                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                    //System.out.println("End Element :" + qName);

                }

                public void characters(char[] ch, int start, int length) throws SAXException {

                    if (this.currentElementName.equalsIgnoreCase("ADM_KODAS")) {
                        String admCode = new String(ch, start, length);
                        this.currentMunicipality.setAdmCode(admCode);
                    } else if (this.currentElementName.equalsIgnoreCase("ADM_ID")) {
                        String municipalityId = new String(ch, start, length);
                        this.currentMunicipality.setMunicipalityId(municipalityId);
                    } else if (this.currentElementName.equalsIgnoreCase("TIPAS")) {
                        String type = new String(ch, start, length);
                        this.currentMunicipality.setType(type);
                    } else if (this.currentElementName.equalsIgnoreCase("VARDAS_K")) {
                        String name = new String(ch, start, length);
                        this.currentMunicipality.setName(name);
                    } else if (this.currentElementName.equalsIgnoreCase("PRIKLAUSO_KODAS")) {
                        String dependsAdmCode = new String(ch, start, length);
                        this.currentMunicipality.setDependsAdmCode(dependsAdmCode);
                    } else if (this.currentElementName.equalsIgnoreCase("ADM_NUO")) {
                        String admFromDate = new String(ch, start, length);
                        this.currentMunicipality.setAdmFromDate(admFromDate);
                    }
                    this.currentElementName = "";
                }

            };

            saxParser.parse("src/com/udemy/casualMiniTasks/SAXSParser/ADM_PILN20190616.xml", handler);
            System.out.println(municipalities.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
