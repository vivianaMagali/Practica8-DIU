
package com.mycompany.practica6diu;

import static com.mycompany.practica6diu.InternalFrame.umbral1;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class Frame extends javax.swing.JFrame {
    JFileChooser fc = new JFileChooser();
    String ruta;
    FileNameExtensionFilter filter = null;
    BufferedImage image;
    String nombre;
   


    public Frame() {
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        initComponents();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        FileMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openFile = new javax.swing.JMenuItem();
        closeFile = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        umbral = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jMenu1.setText("File");

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openFile.setText("Open");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        jMenu1.add(openFile);

        closeFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        closeFile.setText("Close");
        closeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFileActionPerformed(evt);
            }
        });
        jMenu1.add(closeFile);

        FileMenu.add(jMenu1);

        EditMenu.setText("Edit");

        umbral.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        umbral.setText("Umbral");
        umbral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umbralActionPerformed(evt);
            }
        });
        EditMenu.add(umbral);

        FileMenu.add(EditMenu);

        setJMenuBar(FileMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed

        filter = new FileNameExtensionFilter("imagenes", "*.jpg","*.png", "jpg", "png");
        fc.addChoosableFileFilter(filter);
        int res = fc.showOpenDialog(null);
        if( res == JFileChooser.APPROVE_OPTION ){
            
            
            if ( umbral1 != null ){
                JInternalFrame[] ventanasInternas = desktop.getAllFrames();
                for ( JInternalFrame ventana : ventanasInternas){
                    ventana.dispose();
                }
            }
            
            File file = fc.getSelectedFile();
            Mat mat = Imgcodecs.imread(file.getPath());
            image = (BufferedImage) HighGui.toBufferedImage(mat);
            umbral1.setMat(mat);
            InternalFrame ventana = new InternalFrame();
            desktop.add(ventana);
            ventana.setLocation(new Point(30,20));
            ventana.setVisible(true);
            ventana.setTitle(file.getName());
            ventana.setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));
            umbral1.setBufferedImage(image);

        }
        if( res == JFileChooser.CANCEL_OPTION ){
            System.out.println(" se dio a cancelar");
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void closeFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFileActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure exit Program?","EXIT",JOptionPane.YES_NO_OPTION);
        if(confirmed == JOptionPane.YES_OPTION)
        {
            dispose();
        }
    }//GEN-LAST:event_closeFileActionPerformed

    private void umbralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umbralActionPerformed
        String umbralParameter = JOptionPane.showInputDialog(null, "Introduce the number for the desired threshold"); 

        int numericUmbral = 0;
        if( umbralParameter != null ){
            
            try {
               
               numericUmbral = Integer.parseInt(umbralParameter);
               Mat umbralCambiado = umbral1.getMat();
               Mat mat = umbral1.umbralizar(umbral1.getMat(),numericUmbral);
               image = (BufferedImage) HighGui.toBufferedImage(mat);
               //umbral1.setMat(mat);
               umbral1.setMatSave(mat);
               InternalFrame ventana= new InternalFrame();
                desktop.add(ventana);
                ventana.setLocation(new Point(30,20));
                ventana.setVisible(true);
                ventana.setTitle(umbralParameter);
                ventana.setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));
                umbral1.setBufferedImage(image);
               
              
            }catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"The data entered is not numeric");
            }
        }
    }//GEN-LAST:event_umbralActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        int width = desktop.getWidth();
        int height = desktop.getHeight();
        
        JInternalFrame[] ventanasInternas = desktop.getAllFrames();
        for ( JInternalFrame ventana : ventanasInternas){
                Point p = ventana.getLocation();
                if(ventana.getX() > width || ventana.getY() > height) {
                    ventana.setLocation(width - 50, height - 50);
                }
        }
    }//GEN-LAST:event_formComponentResized

    
    /*public void crearVentana(){
        ventana= new InternalFrame();
        desktop.add(ventana);
        ventana.setLocation(new Point(30,20));
        ventana.setVisible(true);
    }
   */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenuBar FileMenu;
    private javax.swing.JMenuItem closeFile;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem umbral;
    // End of variables declaration//GEN-END:variables
}
