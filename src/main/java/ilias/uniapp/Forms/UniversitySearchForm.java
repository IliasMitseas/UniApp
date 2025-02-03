package ilias.uniapp.Forms;
import ilias.uniapp.db.University;
import ilias.uniapp.json.JsonHttpRequester;

import javax.swing.*;

//klasi gia anazitisi geumatos
public class UniversitySearchForm extends javax.swing.JDialog {

    //consturctor
    public UniversitySearchForm() {
        //dhmioyrghse tin forma
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setModal(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUniversity = new javax.swing.JLabel();
        txtUniversity = new javax.swing.JTextField();
        cmdSearch = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Αναζήτηση Πανεπιστημίου");
        setModal(true);

        lblUniversity.setText("Όνομα πανεπιστημίου:");
        lblUniversity.setToolTipText("");
        lblUniversity.setPreferredSize(new java.awt.Dimension(300, 300));

        txtUniversity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUniversityActionPerformed(evt);
            }
        });

        cmdSearch.setText("Αναζήτηση");
        cmdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSearchActionPerformed(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUniversity, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUniversity, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdSearch)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUniversity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUniversity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //methodos gia emfanisi tis formas anazitisis
    public static void showUniversitySearchForm() {
        java.awt.EventQueue.invokeLater(() -> {
            new UniversitySearchForm().setVisible(true);
        });
    }
    
    private void cmdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSearchActionPerformed
        lblError.setText("");  // Clear any previous error

        String universityName = txtUniversity.getText().trim();

        if (universityName.isEmpty()) {
            lblError.setText("Παρακαλώ εισάγετε όνομα πανεπιστημίου.");
            return;
        }

        University university = JsonHttpRequester.getUniversity(universityName);

        if (university != null) {
            UniversityForm.showMealForm(university);

        } else {
            lblError.setText("Το πανεπιστήμιο δεν βρέθηκε.");
        }
    }//GEN-LAST:event_cmdSearchActionPerformed

    private void txtUniversityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUniversityActionPerformed
        cmdSearchActionPerformed(evt);
    }//GEN-LAST:event_txtUniversityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdSearch;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblUniversity;
    private javax.swing.JTextField txtUniversity;
    // End of variables declaration//GEN-END:variables
}
