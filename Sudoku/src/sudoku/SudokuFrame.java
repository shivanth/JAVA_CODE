/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 8 Aug, 2010, 4:57:11 PM
 */
package sudoku;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import sun.awt.HorizBagLayout;
import sun.swing.SwingUtilities2;

/**
 *
 * @author Shivanth
 */
public class SudokuFrame extends javax.swing.JFrame implements ActionListener {

    SudokuTable maintable = null;

    /**
     * Creates new form NewJFrame
     */
    public SudokuFrame() {
        super();
        initComponents();
        panel = new SudokuRow[9];
        for (int i = 0; i < 9; i++) {
            panel[i] = new SudokuRow();
            getContentPane().add(panel[i]);
        }
        action = new JPanel();
        _OK = new JButton("Solve");
        _OK.addActionListener(this);
        action.add(_OK);
        getContentPane().add(action);
    }

    void setdata(SudokuTable t) {
        getContentPane().removeAll();
        for (int i = 0; i < 9; i++) {
            panel[i] = new SudokuRow(t.getrow(i + 1));

            add(getPanel()[i]);
        }

        //getContentPane().add(action);
        _OK.setEnabled(false);



    }

    public int getData(int row, int col) {


        return getPanel()[row].getBoxValue(col);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private SudokuRow panel[];
    JPanel action;
    JButton _OK;
    SudokuTable table;

    public void actionPerformed(ActionEvent e) {

        try {
            //;
            maintable = getdata();
            Thread thread = new Thread(new Runnable() {

                public void run() {
                    Main.main_loop(maintable);
                }
            });
            thread.start();



        } catch (Exception ex) {
            Logger.getLogger(SudokuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void display_results(SudokuTable maintable) {
        if (maintable.issolved()) {
       //     this.setVisible(false);
            setdata(maintable);
            this.pack();
            this.repaint();
         //   this.pack();
       //     this.setVisible(true);
            
            
            JOptionPane.showMessageDialog(new Frame(), "Solved");



            
        } else {
            JOptionPane.showMessageDialog(new Frame(), "The data provided is insufficient");
            this.setVisible(true);
            this.repaint();
            //_OK.addActionListener(this);
        }
    }

    @SuppressWarnings("empty-statement")
    public SudokuTable getdata() {
        SudokuTable t = new SudokuTable();
        try {
        } catch (Exception e) {
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (getData(i, j) == 0) {
                    continue;
                } else {
                    t.setdata(i + 1, j + 1, getData(i, j));
                }
            }
        }

        return t;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    /**
     * @return the panel
     */
    public SudokuRow[] getPanel() {
        return panel;
    }

    public JButton getJButton() {
        return this._OK;
    }
}
