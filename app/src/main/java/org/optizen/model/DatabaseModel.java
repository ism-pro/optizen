/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.model;

/**
 * DatabaseModel class
 *
 * @author r.hendrick
 */
public class DatabaseModel {

    private String driver;
    private String hostname;
    private String password;
    private String port;
    private String server;
    private String user;
    private String databaseName;

    // /////////////////////////////////////////////////////////////////////////
    //
    //
    // Container
    // 
    //
    // /////////////////////////////////////////////////////////////////////////
    /**
     * Map Driver to a readable text useful for user
     *
     * @param driver is a link where the driver is defined like for
     * mysql(com.mysql.jdbc.Driver), for
     * sqlserver(com.microsoft.sqlserver.jdbc.SQLServerDriver), for
     * postgres(org.postgresql.Driver)
     * @return a readable driver like mysql, sqlserver, postgresql,... or empty
     * if not existing in the list.
     */
    public static String mapDriverToReadable(String driver) {
        // Identifify the driver
        switch (driver) {
            case "com.microsoft.sqlserver.jdbc.SQLServerDriver":
                return "sqlserver";
            case "org.postgresql.Driver":
                return "postgresql";
            case "com.mysql.jdbc.Driver":
                return "mysql";
            default:
                System.err.println(driver + " not recognized !");
                return "";
        }
    }

    /**
     * Map a readable driver to a usable driver for coding
     *
     * @param driver is one of sqlserver, mysql, postgresql...
     * @return driver like for mysql(com.mysql.jdbc.Driver), for
     * sqlserver(com.microsoft.sqlserver.jdbc.SQLServerDriver), for
     * postgres(org.postgresql.Driver) or empty if not exist
     */
    public static String mapReadableToDriver(String driver) {
        // Identifify the driver 
        switch (driver) {
            case "sqlserver":
                return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            case "postgresql":
                return "org.postgresql.Driver";
            case "mysql":
                return "com.mysql.jdbc.Driver";
            default:
                System.err.println(driver + " not recognized");
                return "";

        }
    }

    /**
     * Parse allow from a string definition to recognize each parameter of
     * database frame
     *
     * @param schema is a setup like
     * "jdbc:sqlserver://10.116.26.35\SQLSERVER:1433;databaseName=optimaint"
     * @return true if successfuly parse
     */
    public static DatabaseModel parse(String schema) {
        DatabaseModel model = new DatabaseModel();
        // Split access and driver from database
        String d[] = schema.split(";");

        // If not containing two part separate by ";" quit
        if (d.length < 2) {
            return null;
        }

        // Manage access and driver
        String a[] = d[0].split(":");

        if (a.length < 3) {
            System.err.println("Unable to parse schema " + schema + " due to access driver area which should contain three definitions");
            return null;
        }

        // Check definition of jdbc
        if (!a[0].matches("jdbc")) {
            System.err.println(schema + " does not start with jdbc");
            return null;
        }

        // Identifify the driver
        if (a[1].isEmpty()) {
            System.err.println(schema + " does not contains as second parameter a recognized driver");
            return null;
        }
        model.setDriver(a[1]);

        // Setup server definition
        model.setServer(a[2].replace("//", ""));

        // Setup port if length
        if (a.length == 4) {
            model.setPort(a[3]);
        }

        // Manage second part
        String b[] = d[1].split("\\?");

        // Manage database name
        if (b.length >= 1) {
            String c[] = b[0].split("=");

            if (c.length < 2) {
                System.err.println("No database defined in schema " + schema);
                return null;
            }
            model.setDatabaseName(c[1]);
        }

        // Manage database user
        if (b.length >= 2) {
            model.setUser(b[1]);
        }

        // Manage database password
        if (b.length >= 3) {
            model.setPassword(b[2]);
        }

        return model;
    }

    /**
     * Unparse allow from a database model definition to create a string schema
     * of the connection
     *
     * @param model containt informations for creating a schema
     * @return a string schema of the database model in the way like
     * "jdbc:sqlserver://10.116.26.35\SQLSERVER:1433;databaseName=optimaint"
     */
    public static String unparse(DatabaseModel model) {
        return "jdbc:"
                + model.getDriver() + ":"
                + model.getServer().replace("\\\\", "//") +(model.getPort().trim().isEmpty()?(model.getDriver().matches("sqlserver")?":1433":""): ":")
                + model.getPort() + ";"
                + "databaseName=" + model.getDatabaseName() + "?"
                + model.getUser() + "?"
                + model.getPassword();

    }

    // /////////////////////////////////////////////////////////////////////////
    //
    //
    // Getter / Setter
    // 
    //
    // /////////////////////////////////////////////////////////////////////////
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

}
