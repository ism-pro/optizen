/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.model;

/**
 * Table Row is a wrapper around Object[] representing a row from the ResultSet
 *
 * @author r.hendrick
 */
public class TableRow {

    private Object[] values;

    public TableRow(Object[] values) {
        this.values = values;
    }

    public int getSize() {
        return values.length;
    }

    public Object getValue(int i) {
        return values[i];
    }
}
