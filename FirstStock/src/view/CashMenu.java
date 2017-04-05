/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author kieffersarah
 */
public class CashMenu extends JPanel{
    
    public CashMenu(){
        this.setLayout(new BorderLayout());     
        this.setVisible(true);
    }

    /**
     * @return the stock
     */
    /*public JButton getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    /*public void setStock(JButton stock) {
        this.stock = stock;
    }

    /**
     * @return the back
     */
    /*public JButton getBack() {
        return back;
    }

    /**
     * @param back the back to set
     */
    /**public void setBack(JButton back) {
        this.back = back;
    }
    */
    
    private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = align;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    }
}
