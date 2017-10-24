/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.app;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.optizen.util.Util;

/**
 * Icons class
 *
 * @author r.hendrick
 */
public class Ico {

    // /////////////////////////////////////////////////////////////////////////
    //
    //
    // Container
    // 
    //
    // /////////////////////////////////////////////////////////////////////////

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     * @param path chemin du répertoire
     * @param description description du fichier
     * @return ImageIcon
     */
    public static ImageIcon load(String path, String description) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL imgURL = classLoader.getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    public static  ImageIcon load(String path) {
        return load(path, "");
    }
    
    
    public static  Image load(String path, Integer width, Integer height){
        return load(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    
    public static  ImageIcon i16(String path){
        return  new ImageIcon(load(path, 16, 16));
    }
    
    public static  Icon i24(String path){
        return  new ImageIcon(load(path, 24, 24));
    }
    
    public static Icon i32(String path){
        return  new ImageIcon(load(path, 32, 32));
    }
    
    public static Icon i48(String path){
        return  new ImageIcon(load(path, 48, 48));
    }
    
    

    // /////////////////////////////////////////////////////////////////////////
    //
    //
    // Getter / Setter
    // 
    //
    // /////////////////////////////////////////////////////////////////////////
}
