
package com.mycompany.practica6diu;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class Umbral extends JPanel {
    BufferedImage image;
    int umbralValue;
    public static Mat imageMat;
    Mat matSave;
  
    public Umbral(){
       
    }
    
    public BufferedImage getBufferedImage(){
        return image;
    }
    
    public void setBufferedImage(BufferedImage image){
        this.image=image;
        repaint();
    }
    
    public void setUmbralValue(int umbralValue){
        this.umbralValue = umbralValue;
    }
    
    public void setMatSave(Mat matSave) {
        this.matSave = matSave;
    }
    
    public static void setMat(Mat mat){
        imageMat=mat;
    }
    
    
    public static Mat getMat(){
        return imageMat;
    }
    
    public Mat getMatSave() {
        return matSave;
    }
    
    @Override
    public void paintComponent (Graphics g){
        this.setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));
        super.paintComponent(g);
        g.drawImage(image,0,0, null);
    }
    
    
    public Mat umbralizar(Mat imagen_original, Integer umbral) {
    // crear dos imágenes en niveles de gris con el mismo
    // tamaño que la original
    Mat imagenGris = new Mat(imagen_original.rows(),imagen_original.cols(),CvType.CV_8U);
    Mat imagenUmbralizada = new Mat(imagen_original.rows(),imagen_original.cols(),CvType.CV_8U);
    // convierte a niveles de grises la imagen original
    Imgproc.cvtColor(imagen_original,imagenGris,Imgproc.COLOR_BGR2GRAY);
    // umbraliza la imagen:
    // - píxeles con nivel de gris > umbral se ponen a 1
    // - píxeles con nivel de gris <= umbra se ponen a 0
    Imgproc.threshold(imagenGris,imagenUmbralizada,umbral,255,Imgproc.THRESH_BINARY);
    // se devuelve la imagen umbralizada
        return imagenUmbralizada;
    }
}
