/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FDM1D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Praveen Kumar CH
 */
public class FDMMain {

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FDMMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDMMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDMMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDMMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        FDMMain FDM1 = new FDMMain();
    }

//constructor 
    public FDMMain() {
        initiate();
    }

// methods 
    private void initiate() {
        frame1 = new JFrame();
        frame1.setBounds(xf, yf, fdx, fdy);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);
        frame1.setBackground(Color.BLUE);

        maintitle_jl = new JLabel("FDM SOLVER-MacCormak Technique-1D Nozzle Flow-IsoEntropic");
        maintitle_jl.setBounds(0, 0, 800, 30);
        maintitle_jl.setFont(new Font("Serif", Font.BOLD, 16));
        maintitle_jl.setHorizontalAlignment(JLabel.CENTER);
        frame1.add(maintitle_jl);

        frame1.getContentPane().add(panel1());
        frame1.setVisible(true);
    }

    private JPanel panel1() {
        // method declerationss
        JPanel transpanel = new JPanel(null);
        JPanel[] subpanels = new JPanel[3];
        transpanel.setBounds(0, 30, 800, 500);
        transpanel.setBorder(BorderFactory.createLineBorder(Color.black));

        nozzleLeng_jl = new JLabel("Nozzle Length");
        nozzleLeng_jl.setBounds(10, 30, 100, 20);
        nozzleLeng_jl.setVerticalAlignment(JLabel.CENTER);
        nozzleLeng_jl.setHorizontalAlignment(JLabel.LEFT);

        nozzleLeng_jtf = new JTextField("3");
        nozzleLeng_jtf.setBounds(120, 30, 100, 25);
        nozzleLeng_jtf.setHorizontalAlignment(JTextField.TRAILING);

        numofNodes_jl = new JLabel("Num of Nodes");
        numofNodes_jl.setBounds(10, 55, 100, 20);
        numofNodes_jl.setVerticalAlignment(JLabel.CENTER);
        numofNodes_jl.setHorizontalAlignment(JLabel.LEFT);

        numofNodes_jtf = new JTextField("1001");
        numofNodes_jtf.setBounds(120, 55, 100, 25);
        numofNodes_jtf.setHorizontalAlignment(JTextField.TRAILING);

        gamma_jl = new JLabel("Gamma");
        gamma_jl.setBounds(10, 30, 100, 20);
        gamma_jl.setVerticalAlignment(JLabel.CENTER);
        gamma_jl.setHorizontalAlignment(JLabel.LEFT);

        gamma_jtf = new JTextField("1.4");
        gamma_jtf.setBounds(120, 30, 100, 25);
        gamma_jtf.setHorizontalAlignment(JTextField.TRAILING);

        gasConstant_jl = new JLabel("R");
        gasConstant_jl.setBounds(10, 55, 100, 20);
        gasConstant_jl.setVerticalAlignment(JLabel.CENTER);
        gasConstant_jl.setHorizontalAlignment(JLabel.LEFT);

        gasConstant_jtf = new JTextField("287.058");
        gasConstant_jtf.setBounds(120, 55, 100, 25);
        gasConstant_jtf.setHorizontalAlignment(JTextField.TRAILING);

        courantNum_jl = new JLabel("Courant Number");
        courantNum_jl.setBounds(10, 30, 100, 20);
        courantNum_jl.setVerticalAlignment(JLabel.CENTER);
        courantNum_jl.setHorizontalAlignment(JLabel.LEFT);

        courantNum_jtf = new JTextField("0.5");
        courantNum_jtf.setBounds(120, 30, 100, 25);
        courantNum_jtf.setHorizontalAlignment(JTextField.TRAILING);

        maxSteps_jl = new JLabel("Max Time Steps");
        maxSteps_jl.setBounds(10, 55, 100, 20);
        maxSteps_jl.setVerticalAlignment(JLabel.CENTER);
        maxSteps_jl.setHorizontalAlignment(JLabel.LEFT);

        maxSteps_jtf = new JTextField("1500");
        maxSteps_jtf.setBounds(120, 55, 100, 25);
        maxSteps_jtf.setHorizontalAlignment(JTextField.TRAILING);

        maxTime_jl = new JLabel("Max Time");
        maxTime_jl.setBounds(10, 80, 100, 20);
        maxTime_jl.setVerticalAlignment(JLabel.CENTER);
        maxTime_jl.setHorizontalAlignment(JLabel.LEFT);

        maxTime_jtf = new JTextField("2000");
        maxTime_jtf.setBounds(120, 80, 100, 25);
        maxTime_jtf.setHorizontalAlignment(JTextField.TRAILING);

        subpanels[0] = new JPanel(null);
        subpanels[0].setBounds(35, 20, 230, 180);
        subpanels[0].setBorder(BorderFactory.createTitledBorder("Grid Data"));
        subpanels[0].add(nozzleLeng_jl);
        subpanels[0].add(numofNodes_jl);
        subpanels[0].add(nozzleLeng_jtf);
        subpanels[0].add(numofNodes_jtf);

        subpanels[1] = new JPanel(null);
        subpanels[1].setBounds(285, 20, 230, 180);
        subpanels[1].setBorder(BorderFactory.createTitledBorder("Material Data"));
        subpanels[1].add(gamma_jl);
        subpanels[1].add(gamma_jtf);
        subpanels[1].add(gasConstant_jl);
        subpanels[1].add(gasConstant_jtf);

        subpanels[2] = new JPanel(null);
        subpanels[2].setBounds(535, 20, 230, 180);
        subpanels[2].setBorder(BorderFactory.createTitledBorder("Solver Setup"));


        subpanels[2].add(courantNum_jl);
        subpanels[2].add(courantNum_jtf);
        subpanels[2].add(maxSteps_jl);
        subpanels[2].add(maxSteps_jtf);
        subpanels[2].add(maxTime_jl);
        subpanels[2].add(maxTime_jtf);

        run_jb = new JButton("RUN");
        run_jb.setBounds(600, 420, 100, 30);
        run_jb.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {
                run_jbmouseclicked(evt);
            }
        });
        transpanel.add(subpanels[0]);
        transpanel.add(subpanels[1]);
        transpanel.add(subpanels[2]);
        transpanel.add(run_jb);


        return transpanel;
    }

    private JPanel panel2() {
        JPanel subpanel = new JPanel(null);
        jComboBox1 = new JComboBox();
        jComboBox2 = new JComboBox();

        plot_jb = new JButton("PLOT");
        xaxis_jl = new JLabel("X-Axis");
        xaxis_jl.setBounds(25, 25, 100, 30);
        xaxis_jl.setHorizontalAlignment(JLabel.LEADING);
        xaxis_jl.setVerticalAlignment(JLabel.CENTER);
        yaxis_jl = new JLabel("Y-Axis");
        yaxis_jl.setBounds(245, 25, 100, 30);
        yaxis_jl.setHorizontalAlignment(JLabel.LEADING);
        yaxis_jl.setVerticalAlignment(JLabel.CENTER);
        node_jl = new JLabel("Node Number");
        node_jl.setBounds(465, 25, 100, 30);
        node_jl.setHorizontalAlignment(JLabel.LEADING);
        node_jl.setVerticalAlignment(JLabel.CENTER);
        time_jl = new JLabel("Time Step");
        time_jl.setBounds(465, 25, 100, 30);
        time_jl.setHorizontalAlignment(JLabel.LEADING);
        time_jl.setVerticalAlignment(JLabel.CENTER);
        ntry_jtf = new JTextField("15");
        ntry_jtf.setBounds(565, 25, 100, 30);
        ntry_jtf.setHorizontalAlignment(JLabel.LEADING);
        time_jl.setVisible(false);
        node_jl.setVisible(true);

        plot_jb.setBounds(675, 25, 100, 30);
        plot_jb.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {
                plot_jbmouseclicked(evt);
            }
        });
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Time", "Length"}));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.setBounds(105, 25, 120, 30);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Density", "Velocity", "Temperature"}));
        jComboBox2.setBounds(325, 25, 120, 30);

        subpanel.add(xaxis_jl);
        subpanel.add(yaxis_jl);
        subpanel.add(node_jl);
        subpanel.add(time_jl);
        subpanel.add(plot_jb);
        subpanel.add(ntry_jtf);
        subpanel.add(jComboBox1);
        subpanel.add(jComboBox2);
        subpanel.setBounds(5, 20, 790, 70);
        subpanel.setBorder(BorderFactory.createTitledBorder("Plot Options"));

        return subpanel;
    }

    private JPanel panel3(int op0, int op1, int op2) {

        double[] x, y;
        x = new double[10];
        y = new double[10];

        if (op0 == 0) {
            x = new double[store[op1].nt];
            y = new double[store[op1].nt];
            for (int i = 0; i < store[op1].nt; i++) {
                x[i] = store[op1].t[i];
                y[i] = store[op1].dat[i][op2];
            }
            graph.npts1 = 0;
        } else if (op0 == 1) {
            x = new double[store[op1].nx];
            y = new double[store[op1].nx];
            for (int i = 0; i < store[op1].nx; i++) {
                x[i] = store[op1].x[i];
                y[i] = store[op1].dat[op2][i];
            }
            graph.setData1(x1, y1);
        }

        graph.setBackground(Color.WHITE);
        graph.setBounds(25, 90, 750, 400);
        graph.setData(x, y);

        return graph;
    }

    public void run_jbmouseclicked(MouseEvent evt) {

        double Ls[] = {Double.valueOf(nozzleLeng_jtf.getText()), 0, 0};
        int Ns[] = {Integer.valueOf(numofNodes_jtf.getText()), 1, 1};

        Grid grid1 = new Grid(Ls, Ns);

        Material mat1 = new Material(Double.valueOf(gamma_jtf.getText()), Double.valueOf(gasConstant_jtf.getText()));

        Area area1 = new Area(Ns);
        area1.setArea(grid1, 1.00);

        Density dens1 = new Density(Ns);
        dens1.setDensity(grid1, 1.25);

        Temperature temp1 = new Temperature(Ns);
        temp1.setTemperature(grid1, 300);

        Velocityx ux1 = new Velocityx(Ns);
        ux1.setVelocityx(grid1, temp1,
                Math.sqrt(mat1.gamma * mat1.R * temp1.DF));

        Pressure pres1 = new Pressure(Ns);
        pres1.setPressure(temp1, dens1, mat1);

        setup set1 = new setup(Integer.valueOf(maxSteps_jtf.getText()), Integer.valueOf(maxTime_jtf.getText()), Double.valueOf(courantNum_jtf.getText()));
        solver1d solver1 = new solver1d(mat1, grid1, area1, set1, dens1, temp1, ux1, pres1);
        store[0] = new Varstore("Density", set1.maxSteps, Ns[0], grid1.x);
        store[1] = new Varstore("Velocity", set1.maxSteps, Ns[0], grid1.x);
        store[2] = new Varstore("Temperature", set1.maxSteps, Ns[0], grid1.x);

        solver1.run(store);

        x1 = new double[grid1.Nx];
        y1 = new double[grid1.Nx];
        for (int i = 0; i < grid1.Nx; i++) {
            x1[i] = grid1.x[i];
            y1[i] = Math.sqrt(area1.value[i][0][0] / Math.PI);
        }

        frame1.getContentPane().removeAll();
        frame1.getContentPane().add(maintitle_jl);
        frame1.getContentPane().add(panel2());
        frame1.getContentPane().add(panel3(0, 0, 15));
        frame1.getContentPane().repaint();
    }

    public void plot_jbmouseclicked(MouseEvent evt) {
        int op0 = 0, op1 = 0, op2;
        if (jComboBox1.getSelectedItem().equals("Time")) {
            op0 = 0;
        } else if (jComboBox1.getSelectedItem().equals("Length")) {
            op0 = 1;
        }
        if (jComboBox2.getSelectedItem().equals("Density")) {
            op1 = 0;
        } else if (jComboBox2.getSelectedItem().equals("Velocity")) {
            op1 = 1;
        } else if (jComboBox2.getSelectedItem().equals("Temperature")) {
            op1 = 2;
        }
        op2 = Integer.valueOf(ntry_jtf.getText());
        panel3(op0, op1, op2);
        frame1.getContentPane().repaint();
    }

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
        if (jComboBox1.getSelectedItem().toString().equals("Time")) {
            time_jl.setVisible(false);
            node_jl.setVisible(true);
        } else if (jComboBox1.getSelectedItem().toString().equals("Length")) {
            time_jl.setVisible(true);
            node_jl.setVisible(false);
        }
    }
// Declarations
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double dw = screenSize.getWidth();
    double dh = screenSize.getHeight();
    int xf = (int) dw / 4, yf = (int) dh / 8;
    int fdx = 800, fdy = 550;
    private JFrame frame1;
    private JLabel maintitle_jl;
    private JLabel nozzleLeng_jl;
    private JLabel numofNodes_jl;
    private JLabel gamma_jl;
    private JLabel gasConstant_jl;
    private JLabel maxSteps_jl;
    private JLabel maxTime_jl;
    private JLabel courantNum_jl;
    private JTextField nozzleLeng_jtf;
    private JTextField numofNodes_jtf;
    private JTextField gamma_jtf;
    private JTextField gasConstant_jtf;
    private JTextField maxSteps_jtf;
    private JTextField maxTime_jtf;
    private JTextField courantNum_jtf;
    private JButton run_jb;
    Varstore store[] = new Varstore[3];
    JLabel xaxis_jl, yaxis_jl, node_jl, time_jl;
    JButton plot_jb;
    JTextField ntry_jtf;
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private plot2d graph = new plot2d();
    double[] x1, y1;
;
}
