/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.model;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.optizen.util.Util;

/**
 *
 * @author r.hendrick
 */
public class LinkModelCellRenderer extends DefaultTableCellRenderer {

    private Color bgDisable = new Color(255,128,0);
    private Color fgDisable = Color.yellow;
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        TableLinkModel model = (TableLinkModel) table.getModel();
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            c.setBackground(new Color(57,105,138));
            c.setForeground(new Color(255,255,255));
        } else {
            if (model.isRowEnable(row)) {
                c.setBackground(null);
                c.setForeground(null);
            } else {
                c.setBackground(bgDisable);
                c.setForeground(fgDisable);
            }
        }

        return c;
    }

    public Color getBgDisable() {
        return bgDisable;
    }

    public void setBgDisable(Color bgDisable) {
        this.bgDisable = bgDisable;
    }

    public Color getFgDisable() {
        return fgDisable;
    }

    public void setFgDisable(Color fgDisable) {
        this.fgDisable = fgDisable;
    }
    
    
}
