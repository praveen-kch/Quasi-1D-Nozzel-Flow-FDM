/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FDM1D;

/**
 *
 * @author Praveen Kumar CH
 */
public class Varstore {

    public String name;
    public int nt, nx, nstp;
    public double[][] dat;
    public double[] x;
    public double[] t;

    Varstore(String name_, int nt_, int nx_, double[] x_) {
        name = name_;
        nt = nt_;
        nx = nx_;
        x=new double[nx];
        t=new double[nt];
        dat = new double[nt][nx];
        nstp = 0;
        for(int i=0;i<nx;i++){
            x[i]=x_[i];
        }
    }

    public void update(Variable var,double t_) {
        for (int i = 0; i < nx; i++) {
            dat[nstp][i] = var.value[i][0][0];
        }
        t[nstp]=t_;
        nstp++;
    }
}
