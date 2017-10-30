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
public interface InternalFrameEvent {

    // /////////////////////////////////////////////////////////////////////////
    //
    //
    // Container
    // 
    //
    // /////////////////////////////////////////////////////////////////////////
    void internalFrameOpened(javax.swing.event.InternalFrameEvent e);

    void internalFrameClosing(javax.swing.event.InternalFrameEvent e);

    void internalFrameClosed(javax.swing.event.InternalFrameEvent e);

    void internalFrameIconified(javax.swing.event.InternalFrameEvent e);

    void internalFrameDeiconified(javax.swing.event.InternalFrameEvent e);

    void internalFrameActivated(javax.swing.event.InternalFrameEvent e);

    void internalFrameDeactivated(javax.swing.event.InternalFrameEvent e);

    // /////////////////////////////////////////////////////////////////////////
    //
    //
    // Getter / Setter
    // 
    //
    // /////////////////////////////////////////////////////////////////////////
}
