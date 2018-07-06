/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.util.model;

import java.util.ArrayList;

/**
 *
 * @author r.hendrick
 */
public class LinkModel {

    private Integer row = 0;
    private String table = "";
    private String variable = "";
    private String name = "";
    private String equEquipement = "";
    private String equDesignation = "";
    private String orgOrgane = "";
    private String orgDesignation = "";
    private String unite = "";
    private String comment = "";
    private String datemod = "";
    private Boolean state = true;

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquEquipement() {
        return equEquipement;
    }

    public void setEquEquipement(String equEquipement) {
        this.equEquipement = equEquipement;
    }

    public String getEquDesignation() {
        return equDesignation;
    }

    public void setEquDesignation(String equDesignation) {
        this.equDesignation = equDesignation;
    }

    public String getOrgOrgane() {
        return orgOrgane;
    }

    public void setOrgOrgane(String orgOrgane) {
        this.orgOrgane = orgOrgane;
    }

    public String getOrgDesignation() {
        return orgDesignation;
    }

    public void setOrgDesignation(String orgDesignation) {
        this.orgDesignation = orgDesignation;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDatemod() {
        return datemod;
    }

    public void setDatemod(String datemod) {
        this.datemod = datemod;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * List as object table in secance of register table row, table, variable,
     * name, equEquipement, equDesignation, orgOrgane, orgDesignation, unite,
     * comment, datemod, state
     *
     * @return tableau selon la secance ci-dessus
     */
    public Object[] list() {
        ArrayList<Object> obj = new ArrayList<>();
        obj.add(row);
        obj.add(table);
        obj.add(variable);
        obj.add(name);
        obj.add(equEquipement);
        obj.add(equDesignation);
        obj.add(orgOrgane);
        obj.add(orgDesignation);
        obj.add(unite);
        obj.add(comment);
        obj.add(datemod);
        obj.add(state);

        return obj.toArray();
    }
    public void  set(Object[] link){
        row=Integer.valueOf(link[0].toString());
        table = link[1].toString();
        variable = link[2].toString();
        name = link[3].toString();
        equEquipement = link[4].toString();
        equDesignation = link[5].toString();
        orgOrgane = link[6].toString();
        orgDesignation = link[7].toString();
        unite = link[8].toString();
        comment = link[9].toString();
        datemod = link[10].toString();
        state = Boolean.valueOf(link[11].toString());
    }

    public void set(int index, Object value) {
        switch (index) {
            case 0:
                row = Integer.valueOf(value.toString());
                break;
            case 1:
                table = (String) value;
                break;
            case 2:
                variable = (String) value;
                break;
            case 3:
                name = (String) value;
                break;
            case 4:
                equEquipement = (String) value;
                break;
            case 5:
                equDesignation = (String) value;
                break;
            case 6:
                orgOrgane = (String) value;
                break;
            case 7:
                orgDesignation = (String) value;
                break;
            case 8:
                unite = (String) value;
                break;
            case 9:
                comment = (String) value;
                break;
            case 10:
                datemod = (String) value;
                break;
            case 11:
                state = Boolean.valueOf(value.toString());
                break;
        }
    }

}
