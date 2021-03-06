/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveperson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.scene.control.RadioButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author teacher
 */
public class SavePerson extends javax.swing.JFrame {

    /**
     * Creates new form SavePerson
     */
    public SavePerson() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgGender = new javax.swing.ButtonGroup();
        fileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        rbNA = new javax.swing.JRadioButton();
        cmbAge = new javax.swing.JComboBox<>();
        cbDogs = new javax.swing.JCheckBox();
        cbCats = new javax.swing.JCheckBox();
        cbOther = new javax.swing.JCheckBox();
        tfPostalCode = new javax.swing.JTextField();
        btVerifyAndSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Age");

        jLabel3.setText("Gender");

        jLabel4.setText("Pets");

        jLabel5.setText("Postal code");

        rbgGender.add(rbMale);
        rbMale.setText("Male");

        rbgGender.add(rbFemale);
        rbFemale.setText("Female");

        rbgGender.add(rbNA);
        rbNA.setSelected(true);
        rbNA.setText("N/A");

        cmbAge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<=18", "19=25", "26-39", "40+" }));

        cbDogs.setText("Dogs");

        cbCats.setText("Cats");

        cbOther.setText("Other");

        btVerifyAndSave.setText("Verify and save");
        btVerifyAndSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerifyAndSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfName)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbMale)
                        .addGap(10, 10, 10)
                        .addComponent(rbFemale)
                        .addGap(10, 10, 10)
                        .addComponent(rbNA))
                    .addComponent(cmbAge, 0, 288, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbDogs)
                        .addGap(18, 18, 18)
                        .addComponent(cbCats)
                        .addGap(18, 18, 18)
                        .addComponent(cbOther))
                    .addComponent(tfPostalCode))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(btVerifyAndSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbMale)
                    .addComponent(rbFemale)
                    .addComponent(rbNA))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbDogs)
                    .addComponent(cbCats)
                    .addComponent(cbOther))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btVerifyAndSave)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVerifyAndSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerifyAndSaveActionPerformed
        // 1. Extract data from User Interface
        String name = tfName.getText();
        String age = (String) cmbAge.getSelectedItem();
        // gender
        String gender = "N/A";
        if (rbFemale.isSelected()) {
            gender = "Female";
        }
        if (rbMale.isSelected()) {
            gender = "Male";
        }
        // pets
        ArrayList<String> petList = new ArrayList<>();
        if (cbDogs.isSelected()) {
            petList.add("Dogs");
        }
        if (cbCats.isSelected()) {
            petList.add("Cats");
        }
        if (cbOther.isSelected()) {
            petList.add("Other");
        }
        // postal code
        String postalCode = tfPostalCode.getText();
        // 2. Verify
        if (name.length() < 2 || name.length() > 30) {
            JOptionPane.showMessageDialog(this,
                    "Name must be between 2 and 30 characters long",
                    "Input error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!postalCode.toUpperCase().matches("[A-Z][0-9][A-Z] ?[0-9][A-Z][0-9]")) {
            JOptionPane.showMessageDialog(this,
                    "Postal code must be in A1A 1A1 format",
                    "Input error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Ask user for file to save to using a dialog
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String pathToFile = file.getAbsolutePath();
            // 3. Save
            System.out.println("Verification passed, saving");
            String line = String.format("%s;%s;%s;%s;%s", name, age, gender,
                    join(petList, ","), postalCode);
            System.out.println(line);
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(pathToFile, true)));
                out.println(line);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Error saving file " + e.getMessage(),
                        "File saving error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        // reset the UI
        tfName.setText("");
        tfPostalCode.setText("");
        cbCats.setSelected(false);
        cbDogs.setSelected(false);
        cbOther.setSelected(false);
        rbNA.setSelected(true);
        cmbAge.setSelectedIndex(0);
    }//GEN-LAST:event_btVerifyAndSaveActionPerformed

    public static String join(ArrayList<String> list, String separator) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result += (i == 0) ? "" : separator;
            result += list.get(i);
        }
        return result;
    }

    /**
     * @param args the command line arguments
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SavePerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SavePerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SavePerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SavePerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SavePerson().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVerifyAndSave;
    private javax.swing.JCheckBox cbCats;
    private javax.swing.JCheckBox cbDogs;
    private javax.swing.JCheckBox cbOther;
    private javax.swing.JComboBox<String> cmbAge;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JRadioButton rbNA;
    private javax.swing.ButtonGroup rbgGender;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPostalCode;
    // End of variables declaration//GEN-END:variables
}
