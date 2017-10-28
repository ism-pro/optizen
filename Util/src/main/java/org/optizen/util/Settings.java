/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ini4j.Wini;

/**
 * Settings class allow to create a init file to save current date of
 * application
 *
 * @author r.hendrick
 */
public class Settings {

    /**
     * Specifiy the default init file name.
     */
    public static String iniFilename = "app";
    public static String sectSRV = "server";
    public static String sectSCREEN = "screen";

    public static final String CONFIG = "CONFIG";
    public static final String COMPANY = "company";
    public static final String URL_OPTI = "urloptimaint";
    public static final String URL_ZEN = "urlzenon";
    public static final String LINK_ZEN = "LINKZEN";
    public static final String COUNTER = "COUNTER";

    /**
     * Cette méthod permet de créer un fichier de préférence ini
     *
     * @param filePathName est une définition d'un fichier du type
     * c:\\newfile.txt
     * @return vrai si le fichier a été créé sinon faux
     */
    private static Boolean createIniFile(String filePathName) {
        String methodName = Settings.class.getName() + " : createIniFile(String) >> ";
        try {
            File file = new File(filePathName);
            if (file.createNewFile()) {
                Util.out(methodName + "Le fichier " + filePathName + " vient d'être créé !");
                return true;
            } else {
                Util.out(methodName + "Le fichier " + filePathName + " existe déjà !");
                return false;
            }
        } catch (IOException e) {
            Util.out(methodName + "Erreur suivante lors de la création du fichier : " + e.getMessage());
            return false;
        }
    }

    /**
     * Cette méthod permet de créer un fichier de préférence ini avec le nom de
     * fichier définit par iniFilename
     *
     *
     * @return vrai si le fichier a été créé ou si il existe déjà.
     */
    public static Boolean createIniFile() {
        return createIniFile(Settings.iniFilename);
    }

    /**
     * Ecriture d'une données dans le fichier init définit par iniFilename
     *
     * @param section définit le groupe de paramètre
     * @param param le nom du paramètre
     * @param value la valeur du paramètre
     */
    public static void write(String section, String param, Object value) {
        String methodName = Settings.class.getName() + " : write(section, param, value) >> ";
        try {
            Util.out(methodName + "Tentative d'écriture en section (" + section + ") paramètre " + param + " avec la valeur " + value);
            Wini ini = new Wini(new File(iniFilename));
            ini.put(section, param, value);
            ini.store();
        } catch (IOException ex) {
            Util.out(methodName + "...Erreur suivante est survenue : " + ex.getMessage());
        }
    }

    /**
     * Fonction de lecture du fichier définit par iniFilename
     *
     * @param section définition de la section concernant le paramètre
     * @param param paramètre à récupérer
     * @return renvoi de la valeur du paramètre spécifié
     */
    public static Object read(String section, String param) {
        String methodName = Settings.class.getName() + " : read(section, param, value) >> ";
        try {
            Util.out(methodName + "Tentative de lecture de la section (" + section + ") paramètre " + param + "...");
            Wini ini = new Wini(new File(iniFilename));
            Object obj = ini.get(section, param);
            Util.out(methodName + "...Lecture réussie");
            return obj;
        } catch (IOException ex) {
            Util.out(methodName + "...Erreur suivante est survenue : " + ex.getMessage());
            return null;
        }
    }

    /**
     * Création des paramètres de confirguration par défaut
     */
    public static void writeDefaultClientSetup() {
        try {
            Wini ini = new Wini(new File(iniFilename));
            ini.put(Settings.CONFIG, Settings.COMPANY, "11");

            ini.put(Settings.CONFIG, Settings.URL_OPTI, "jdbc:sqlserver:");
            ini.put(Settings.CONFIG, Settings.URL_ZEN, "jdbc:sqlserver:");

            ini.store();
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get the screen from the ini file with specified data
     *
     * @return screen defined in the ini file
     */
    public static void getScreen() {
//        String methodName = Settings.class.getName() + " : getScreen() >> ";
//        Screen sc = new Screen();
//        try {
//            Util.out(methodName + "Tentative de lecture de la section (screen) paramètre...");
//            Wini ini = new Wini(new File(iniFilename));
//            sc.setId(Integer.valueOf(ini.get(Settings.sectSCREEN, Screen.ID)));
//            sc.setHostname(NetUtil.hostname());
//            sc.setAddress(ini.get(Settings.sectSCREEN, Screen.ADDRESS));
//            sc.setPort(Integer.valueOf(ini.get(Settings.sectSCREEN, Screen.PORT)));
//            sc.setAdopted(Boolean.valueOf(ini.get(Settings.sectSCREEN, Screen.ADOPTED)));
//            sc.setCode(ini.get(Settings.sectSCREEN, Screen.CODE));
//            sc.setGroup(ini.get(Settings.sectSCREEN, Screen.GROUP));
//            sc.setLocation(ini.get(Settings.sectSCREEN, Screen.LOCATION));
//            sc.setMnemonique(ini.get(Settings.sectSCREEN, Screen.MNEMONIQUE));
//            Util.out(methodName + "...Lecture réussie");
//        } catch (IOException ex) {
//            Util.out(methodName + "...Erreur suivante est survenue : " + ex.getMessage());
//            return null;
//        }
//        return sc;

    }

    /**
     * Update Screen parameter
     *
     * @param sc screen à enregistrer
     */
    public static void setScreen(Void sc) {
//        String methodName = Settings.class.getName() + " : setScreen() >> ";
//        try {
//            Util.out(methodName + "Tentative d'écriture de la section (screen) paramètre...");
//            Wini ini = new Wini(new File(iniFilename));
//            ini.put(Settings.sectSCREEN, Screen.ID, sc.getId());
//            ini.put(Settings.sectSCREEN, Screen.HOSTNAME, sc.getHostname());
//            ini.put(Settings.sectSCREEN, Screen.ADDRESS, sc.getAddress());
//            ini.put(Settings.sectSCREEN, Screen.PORT, sc.getPort());
//            ini.put(Settings.sectSCREEN, Screen.ADOPTED, sc.getAdopted());
//            ini.put(Settings.sectSCREEN, Screen.CODE, sc.getCode());
//            ini.put(Settings.sectSCREEN, Screen.GROUP, sc.getGroup());
//            ini.put(Settings.sectSCREEN, Screen.LOCATION, sc.getLocation());
//            ini.put(Settings.sectSCREEN, Screen.MNEMONIQUE, sc.getMnemonique());
//            ini.store();
//            Util.out(methodName + "...Ecriture réussie");
//        } catch (IOException ex) {
//            Util.out(methodName + "...Erreur suivante est survenue : " + ex.getMessage());
//        }
    }

    /**
     * Get server defined in the ini file
     *
     * @return Server defined in the ini file
     */
    public static void getServer() {
//        String methodName = Settings.class.getName() + " : getServer() >> ";
//        Server sc = new Server();
//        try {
//            Util.out(methodName + "Tentative de lecture de la section (server) paramètre...");
//            Wini ini = new Wini(new File(iniFilename));
//            sc.setAddress(NetUtil.hostname());
//            sc.setAddress(ini.get(Settings.sectSRV, Server.ADDRESS));
//            sc.setPort(Integer.valueOf(ini.get(Settings.sectSRV, Server.PORT)));
//            Util.out(methodName + "...Lecture réussie");
//        } catch (IOException ex) {
//            Util.out(methodName + "...Erreur suivante est survenue : " + ex.getMessage());
//            return null;
//        }
//        return sc;
    }

    /**
     * Update Server parameter
     *
     * @param sc screen à enregistrer
     */
    public static void setServer() {
//        String methodName = Settings.class.getName() + " : setServer() >> ";
//        try {
//            Util.out(methodName + "Tentative d'écriture de la section (server) paramètre...");
//            Wini ini = new Wini(new File(iniFilename));
//            ini.put(Settings.sectSRV, Server.HOSTNAME, sc.getHostname());
//            ini.put(Settings.sectSRV, Server.ADDRESS, sc.getAddress());
//            ini.put(Settings.sectSRV, Server.PORT, sc.getPort());
//            ini.store();
//            Util.out(methodName + "...Ecriture réussie");
//        } catch (IOException ex) {
//            Util.out(methodName + "...Erreur suivante est survenue : " + ex.getMessage());
//        }
    }

    /**
     * Zenon table Data allow to read all the data name saved in configuration
     * 
     * @return a list array of the zenon data table contains in configuration
     */
    public static ArrayList<String> zenTableData() {
        String methodName = Settings.class.getName() + " : zenTableData() >> ";
        ArrayList<String> list = new ArrayList<>();
        try {
            Util.out(methodName + "Tentative de lecture de la section zenTableData ...");
            Wini ini = new Wini(new File(iniFilename));

            // Clean previous table
            Integer counter = Integer.valueOf(Settings.read(Settings.LINK_ZEN, Settings.COUNTER).toString());
            for (int count = 0; count < counter; count++) {
                String data = Settings.read(Settings.LINK_ZEN + "\\" + count, "data").toString();
                list.add(data);
            }
            
            Util.out(methodName + "...Lecture réussie");
            return list;
        } catch (IOException ex) {
            Util.out(methodName + "...Erreur suivante est survenue : " + ex.getMessage());
            return null;
        }
    }

}
