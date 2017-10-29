// Fig. 25.28: ResultSetTableModel.java
// A TableModel that supplies ResultSet data to a JTable.
package org.optizen.model;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

// ResultSet rows and columns are counted from 1 and JTable 
// rows and columns are counted from 0. When processing 
// ResultSet rows or columns for use in a JTable, it is 
// necessary to add 1 to the row or column number to manipulate
// the appropriate ResultSet column (i.e., JTable column 0 is 
// ResultSet column 1 and JTable row 0 is ResultSet row 1).
public class ResultSetTableModel extends AbstractTableModel {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;

    // keep track of database connection status
    private boolean connectedToDatabase = false;

    // constructor initializes resultSet and obtains its meta data object;
    // determines number of rows
    public ResultSetTableModel(DatabaseModel model, String query)
            throws SQLException, ClassNotFoundException {
        // load database driver class
        Class.forName(DatabaseModel.mapReadableToDriver(model.getDriver()));
        
        // Make the url
        String url = url = "jdbc:" + model.getDriver() + "://"
                    + model.getServer() 
                    + (model.getPort()==null ? "" : (model.getPort().trim().isEmpty() ? "" : ":" + model.getPort()))
                    + ";databaseName=" + model.getDatabaseName();
        
        // connect to database
        connection = DriverManager.getConnection(url, model.getUser(), model.getPassword());

        // create Statement to query database
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        // update database connection status
        connectedToDatabase = true;

        // set query and execute it
        setQuery(query);
    } // end constructor ResultSetTableModel

    
    /**
     * get class that represents column type
     * @param column
     * @return
     * @throws IllegalStateException 
     */
    @Override
    public Class getColumnClass(int column) throws IllegalStateException {
        // ensure database connection is available
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        // determine Java class of column
        try {
            String className = metaData.getColumnClassName(column + 1);

            // return Class object that represents className
            return Class.forName(className);
        } // end try
        catch (Exception exception) {
            exception.printStackTrace();
        } // end catch

        return Object.class; // if problems occur above, assume type Object
    } // end method getColumnClass

    /**
     * get number of columns in ResultSet
     * @return
     * @throws IllegalStateException 
     */
    @Override
    public int getColumnCount() throws IllegalStateException {
        // ensure database connection is available
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        // determine number of columns
        try {
            return metaData.getColumnCount();
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch

        return 0; // if problems occur above, return 0 for number of columns
    } // end method getColumnCount

    /**
     * get name of a particular column in ResultSet
     * @param column
     * @return
     * @throws IllegalStateException 
     */
    @Override
    public String getColumnName(int column) throws IllegalStateException {
        // ensure database connection is available
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        // determine column name
        try {
            return metaData.getColumnName(column + 1);
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch

        return ""; // if problems, return empty string for column name
    } // end method getColumnName

    /**
     * return number of rows in ResultSet
     * @return
     * @throws IllegalStateException 
     */
    @Override
    public int getRowCount() throws IllegalStateException {
        // ensure database connection is available
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        return numberOfRows;
    } // end method getRowCount

    /**
     * obtain value in particular row and column
     * @param row
     * @param column
     * @return
     * @throws IllegalStateException 
     */
    @Override
    public Object getValueAt(int row, int column) throws IllegalStateException {
        // ensure database connection is available
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        // obtain a value at specified ResultSet row and column
        try {
            resultSet.absolute(row + 1);
            return resultSet.getObject(column + 1);
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch

        return ""; // if problems, return empty string object
    } // end method getValueAt

    /**
     * set new database query string
     * @param query
     * @throws SQLException
     * @throws IllegalStateException 
     */
    public void setQuery(String query) {
        try {
            // ensure database connection is available
            if (!connectedToDatabase) {
                throw new IllegalStateException("Not Connected to Database");
            }
            
            // specify query and execute it
            resultSet = statement.executeQuery(query);
            
            // obtain meta data for ResultSet
            metaData = resultSet.getMetaData();
            
            // determine number of rows in ResultSet
            resultSet.last();                   // move to last row
            numberOfRows = resultSet.getRow();  // get row number
            
            // notify JTable that model has changed
            fireTableStructureChanged();
        } // end method setQuery
        catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * close Statement and Connection     
     */
    public void disconnectFromDatabase() {
        if (!connectedToDatabase) {
            return;
        }

        // close Statement and Connection            
        try {
            statement.close();
            connection.close();
        } // end try                                 
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch                               
        finally // update database connection status
        {
            connectedToDatabase = false;
        } // end finally                             
    } // end method disconnectFromDatabase   
    
    
    /**
     * Methode permettant de récupérer la liste des données d'une ligne
     *
     * @param row numéro de ligne dont on souhaite récupérer le contenu
     * @return la liste de données de la ligne
     */
    public Object[] selectedRowData(Integer row) {
        if (row >= getRowCount()) {
            return null;
        }

        int sizeData = getColumnCount();
        Object values[] = new Object[sizeData];

        for (int col = 0; col < getColumnCount(); col++) {
            values[row] = getValueAt(row, col);
        }
        return values;
    }
    
    public ArrayList<Object> getSelectedRow(Integer row) {
        if (row >= getRowCount()) {
            return null;
        }

        ArrayList<Object> values= new ArrayList<>();

        for (int col = 0; col < getColumnCount(); col++) {
            values.add(getValueAt(row, col));
        }
        return values;
    }
    
    
    
    
}  // end class ResultSetTableModel

/**
 * ************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 ************************************************************************
 */
