/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.app;

/**
 *
 * @author r.hendrick
 */
public class ExecTest {
    public static void main(String[] args) throws Exception {
        String execStr = "C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE";
        Process proc = Runtime.getRuntime().exec(execStr);
        System.out.println("proc: " + proc);
        Thread.sleep(10000);
        System.out.println("destroying");
        proc.destroy();
        System.out.println("destroyed");
    }
}
