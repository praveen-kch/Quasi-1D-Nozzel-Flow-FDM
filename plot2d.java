package FDM1D;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class plot2d extends JPanel {

    double[] x, y;
    int npts = 0, npts1 = 0;
    int PAD = 10;
    double[] x1, y1;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();

        //g2.setPaint(Color.lightGray);
        //g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
        //g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
        //g2.draw(new Line2D.Double(w-PAD, PAD, w-PAD, h-PAD));
        //g2.draw(new Line2D.Double(PAD, PAD, w-PAD, PAD));



        if (npts1 > 0) {
            
            double xmax = getMax(x1);
            double ymax = getMax(y1);
            double xmin = getMin(x1);
            double ymin = -getMax(y1);
            double vmax = getMax(y);
            double vmin = getMin(y);
            double vspan= vmax-vmin;
            xmax = xmax + 0.05 * (xmax - xmin);
            ymax = ymax + 0.05 * (ymax - ymin);
            xmin = xmin - 0.15 * (xmax - xmin);
            ymin = ymin - 0.05 * (ymax - ymin);

            double Rx = (w - 2 * PAD) / Math.abs(xmax - xmin);
            double Ry = (h - 2 * PAD) / Math.abs(ymax - ymin);

            // Mark data points.
            g2.setPaint(Color.BLACK);
            for (int i = 0; i < npts1-1; i++) {
                //g2.fill(new Ellipse2D.Double(PAD + (x1[i] - xmin) * Rx - 2, h - PAD - (y1[i] - ymin) * Ry - 2, 2, 2));
                g2.draw(new Line2D.Double(PAD + (x1[i] - xmin) * Rx - 2, h - PAD - (y1[i] - ymin) * Ry - 2,PAD + (x1[i+1] - xmin) * Rx - 2, h - PAD - (y1[i+1] - ymin) * Ry - 2));
                g2.draw(new Line2D.Double(PAD + (x1[i] - xmin) * Rx - 2, h - PAD - (-y1[i] - ymin) * Ry - 2,PAD + (x1[i+1] - xmin) * Rx - 2, h - PAD - (-y1[i+1] - ymin) * Ry - 2));
            }
            
            for (int i = 0; i < npts1; i++) {
                g2.setPaint(Color.getHSBColor((float)(y[i]-vmin/vspan),(float)1,(float)1));
                g2.draw(new Line2D.Double(PAD + (x1[i] - xmin) * Rx - 2, h - PAD - (y1[i] - ymin) * Ry - 2,PAD + (x1[i] - xmin) * Rx - 2, h - PAD - (-y1[i] - ymin) * Ry - 2));
                
            }
            
           for (int i = 0; i < 300; i++) {
                g2.setPaint(Color.getHSBColor((float)((float)i/300),(float)1,(float)1));
                g2.draw(new Line2D.Double(PAD + 0, PAD+320-i,PAD + 25, PAD+320-i));
                
            }         
            // Mark data points
            //g2.setPaint(Color.BLACK);
            //g2.draw(new Line2D.Double(PAD - xmin * Rx - PAD, h - PAD + ymin * Ry, PAD + (xmax - xmin) * Rx, h - PAD + ymin * Ry));
            //g2.draw(new Line2D.Double(PAD - xmin * Rx, h - PAD + ymin * Ry + PAD, PAD - xmin * Rx, h - PAD - (ymax - ymin) * Ry));
           
        } else {
            double xmax = getMax(x);
            double ymax = getMax(y);
            double xmin = getMin(x);
            double ymin = getMin(y);
            xmax = xmax + 0.05 * (xmax - xmin);
            ymax = ymax + 0.05 * (ymax - ymin);
            xmin = xmin - 0.05 * (xmax - xmin);
            ymin = ymin - 0.05 * (ymax - ymin);

            double Rx = (w - 2 * PAD) / Math.abs(xmax - xmin);
            double Ry = (h - 2 * PAD) / Math.abs(ymax - ymin);
            // Mark data points.
            g2.setPaint(Color.blue);
            for (int i = 0; i < npts; i++) {
                g2.fill(new Ellipse2D.Double(PAD + (x[i] - xmin) * Rx - 2, h - PAD - (y[i] - ymin) * Ry - 2, 4, 4));
            }

            g2.setPaint(Color.BLACK);
            g2.draw(new Line2D.Double(PAD - xmin * Rx - PAD, h - PAD + ymin * Ry, PAD + (xmax - xmin) * Rx, h - PAD + ymin * Ry));
            g2.draw(new Line2D.Double(PAD - xmin * Rx, h - PAD + ymin * Ry + PAD, PAD - xmin * Rx, h - PAD - (ymax - ymin) * Ry));

        }
    }
    //Mark data points

    private double getMax(double[] data) {
        double max = -Double.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    private double getMin(double[] data) {
        double min = -Double.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    public void setData(double[] x_, double[] y_) {
        npts = Math.min(x_.length, y_.length);
        x = new double[npts];
        y = new double[npts];
        for (int i = 0; i < npts; i++) {
            x[i] = x_[i];
            y[i] = y_[i];
        }
    }

    public void setData1(double[] x_, double[] y_) {
        npts1 = Math.min(x_.length, y_.length);
        x1 = new double[npts1];
        y1 = new double[npts1];
        for (int i = 0; i < npts1; i++) {
            x1[i] = x_[i];
            y1[i] = y_[i];
        }
    }
}