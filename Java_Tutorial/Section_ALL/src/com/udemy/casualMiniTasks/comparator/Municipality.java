package com.udemy.casualMiniTasks.comparator;

public class Municipality {

    private String municipalityId;
    private String admCode;
    private String admFromDate;
    private String dependsAdmCode;
    private String name;
    private String type;

    public Municipality(String municipalityId, String admCode, String admFromDate, String dependsAdmCode, String name, String type) {
        this.municipalityId = municipalityId;
        this.admCode = admCode;
        this.admFromDate = admFromDate;
        this.dependsAdmCode = dependsAdmCode;
        this.name = name;
        this.type = type;
    }

    public String getMunicipalityId() {
        return municipalityId;
    }

    public String getAdmCode() {
        return admCode;
    }

    public String getAdmFromDate() {
        return admFromDate;
    }

    public String getDependsAdmCode() {
        return dependsAdmCode;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "\n" +
                "Municipality{" +
                "municipalityId='" + municipalityId + '\'' +
                ", admCode='" + admCode + '\'' +
                ", admFromDate='" + admFromDate + '\'' +
                ", dependsAdmCode='" + dependsAdmCode + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}'
                ;
    }
}
