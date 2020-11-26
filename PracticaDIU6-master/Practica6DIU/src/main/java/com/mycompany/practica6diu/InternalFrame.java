/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica6diu;

import java.awt.Dimension;

/**
 *
 * @author vivianabenitez
 */
public class InternalFrame extends javax.swing.JInternalFrame {
    
   
    /**
     * Creates new form InternalFrame
     */
    public InternalFrame() {
      
        initComponents();
        this.setPreferredSize(new Dimension(umbral1.getWidth(),umbral1.getHeight()));
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setClosable(true);
        this.setResizable(true);
        
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        umbral1 = new com.mycompany.practica6diu.Umbral();

        setTitle("Ventana Principal");

        javax.swing.GroupLayout umbral1Layout = new javax.swing.GroupLayout(umbral1);
        umbral1.setLayout(umbral1Layout);
        umbral1Layout.setHorizontalGroup(
            umbral1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        umbral1Layout.setVerticalGroup(
            umbral1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(umbral1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(umbral1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static com.mycompany.practica6diu.Umbral umbral1;
    // End of variables declaration//GEN-END:variables

   
    
}
