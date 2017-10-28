/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.model;

import java.awt.List;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 * TableMOdel Implementation that will be populate by SwingWorker
 *
 * @author r.hendrick
 */
public class ResultSetTableModel extends AbstractTableModel {

    private ResultSetMetaData rsmd;
    private List<TableRow> rows;

    public ResultSetTableModel(ResultSetMetaData rsmd) {
        this.rsmd = rsmd;
        this.rows = new ArrayList<TableRow>();
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Object getValue(int row, int column) {
        return rows.get(row).getValue(column);
    }

    @Override
    public String getColumnName(int col) {
        try {
            return rsmd.getColumnName(col - 1); // ResultSetMetaData columns indexed from 1, not 0.
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public Class<?> getColumnClass(int col) {
        // TODO: Convert SQL type (int) returned by ResultSetMetaData.getType(col) to Java Class.
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
