/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.listeners;

import java.util.logging.Logger;
import javax.swing.event.InternalFrameListener;
import org.optizen.util.Util;

/**
 * InternalFrameEvent class
 *
 * @author r.hendrick
 */
public class InternalFrameEvent implements InternalFrameListener {

    // /////////////////////////////////////////////////////////////////////////
    //
    //
    // Container
    // 
    //
    // /////////////////////////////////////////////////////////////////////////
    @Override
    public void internalFrameOpened(javax.swing.event.InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class.getName()).getResourceBundleName() + " : internalFrameOpened() >> ";
        System.out.println(methodName + "internalFrameOpened !");
    }

    @Override
    public void internalFrameClosing(javax.swing.event.InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class.getName()).getResourceBundleName() + " : internalFrameClosing() >> ";
        System.out.println(methodName + "internalFrameClosing !");
    }

    @Override
    public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class.getName()).getResourceBundleName() + " : internalFrameClosed() >> ";
        System.out.println(methodName + "internalFrameClosed !");
    }

    @Override
    public void internalFrameIconified(javax.swing.event.InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class.getName()).getResourceBundleName() + " : internalFrameIconified() >> ";
        System.out.println(methodName + "internalFrameIconified !");
    }

    @Override
    public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class.getName()).getResourceBundleName() + " : internalFrameDeiconified() >> ";
        System.out.println(methodName + "internalFrameDeiconified !");
    }

    @Override
    public void internalFrameActivated(javax.swing.event.InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class.getName()).getResourceBundleName() + " : internalFrameActivated() >> ";
        System.out.println(methodName + "internalFrameActivated !");
    }

    @Override
    public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class.getName()).getResourceBundleName() + " : internalFrameDeactivated() >> ";
        System.out.println(methodName + "internalFrameDeactivated !");
    }

    // /////////////////////////////////////////////////////////////////////////
    //
    //
    // Getter / Setter
    // 
    //
    // /////////////////////////////////////////////////////////////////////////
}
