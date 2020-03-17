/*
 * Created by JFormDesigner on Tue Dec 24 15:44:36 EET 2019
 */

package com.company;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author hafsa
 */
public class GUII extends JFrame {
    public GUII() {
        initComponents();
    }
    public static void main(String[] args) throws IOException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUII().setVisible(true);
            }
        });
    }

    private void button1ActionPerformed(ActionEvent e) throws IOException {
        String data = Main.read_from_file();
        String[] separate = data.split(",");
        ArrayList<String> returnn = Main.zeros(separate);

        Main.getFrequency(returnn);
        StandardCompression standard = new StandardCompression(Main.listdata);
        standard.sortNodes();
        Node root = standard.createTree();
        Main.writeinFile1(standard.createTableCodes(root, ""));
        Main.Codes_symbol= standard.Codes_symbol;
        Main.Codes_code = standard.Codes_code;

        Main.writeinFile(Main.compress());
    }

    private void button2ActionPerformed(ActionEvent e) throws IOException {
        Main.writeinFile2(Main.decompress());

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - hafsa
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        // to close the gui when press the exit button
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("compress");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    button1ActionPerformed(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        contentPane.add(button1);
        button1.setBounds(95, 140, button1.getPreferredSize().width, 35);

        //---- button2 ----
        button2.setText("decompress");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    button2ActionPerformed(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        contentPane.add(button2);
        button2.setBounds(225, 140, button2.getPreferredSize().width, 35);

        //---- label1 ----
        label1.setText("                JPEG ASSIGNMENT");
        contentPane.add(label1);
        label1.setBounds(100, 50, 215, 40);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - hafsa
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
