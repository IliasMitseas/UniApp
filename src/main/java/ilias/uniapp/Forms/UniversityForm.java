package ilias.uniapp.Forms;

import ilias.uniapp.db.Connector;
import ilias.uniapp.db.University;
import ilias.uniapp.json.JsonHttpRequester;

import javax.persistence.NoResultException;
import javax.swing.JOptionPane;


//forma emfanisis stixion panepistimiou
public class UniversityForm extends javax.swing.JDialog {

    //global metablites pou h mia tha periexei ta stoixeia tou panepisthmioy apo to API kai h allh ta stoixeia apo th DB
    private University universityInDB;
    private University uniApi;

    //pernaw sa parametro to panepistimio gia na mporei na emfanisei ta stoixeia tou
    public UniversityForm(University universityParam) {
        //dieuthetisi ton GUI stixion
        initComponents();

        //perno ta stixia pou perasan apo alli forma se auti topika
        universityInDB = universityParam;
        uniApi = universityParam;

        //topotheto tin forma
        pack();
        setLocationRelativeTo(null);
        setModal(true);


        try {
            University dbUniversity = Connector.getUniversityByName(universityParam.getName());
            if (dbUniversity != null){
                this.universityInDB = dbUniversity;
                displayUniversityData(universityInDB);
            }
        }
        //Αν πάρω Exception οτι δε βρέθηκε πανεπιστήμιο με αυτό το όνομα το γράφω στη βάση. Θεώρω ότι το όνομα είναι μοναδικό για κάθε πανεπιστήμιο
        catch (NoResultException e){
            displayUniversityData(uniApi);
        }

        checkButtonsEnabled();
    }

    //methodos gia na emfanizei ta stoixeia geumatos stin forma
    //iparxoun idi gemata stin metabliti m
    private void displayUniversityData(University u) {
        jLabelUniversityId.setText(String.valueOf(u.getId()));
        txtUniversityName.setText(u.getName());
        txtUniversityDomain.setText(u.getDomain());
        txtUniversityWebPage.setText(u.getWebpage());
        txtUniversityAlphaCode.setText(u.getAlphatwocode());
        txtUniversityCountry.setText(u.getCountry());
        txtUniversityStateProvince.setText(u.getStateprovince());
    }

    //analoga tou an ipirxe stin basia naoigoklin ta katallila plhktra gia
    //dieukolinsi xristi se energeies
    private void checkButtonsEnabled() {
        cmdInsert.setEnabled(true);
        //cmdUpdate.setEnabled(universityExistsInDB);
        cmdDelete.setEnabled(true);
    }

    private void setButtonsDisabled() {
        cmdInsert.setEnabled(false);
        //cmdUpdate.setEnabled(false);
        cmdDelete.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUniversityName = new javax.swing.JLabel();
        txtUniversityAlphaCode = new javax.swing.JTextField();
        lblUniversityDomain = new javax.swing.JLabel();
        txtUniversityDomain = new javax.swing.JTextField();
        lblUniversityWebPage = new javax.swing.JLabel();
        cmdInsert = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jLabelUniversityId = new javax.swing.JLabel();
        javax.swing.JLabel lblUniversityAlphaTwoCode = new javax.swing.JLabel();
        txtUniversityWebPage = new javax.swing.JTextField();
        lblUniversityCountry = new javax.swing.JLabel();
        lblUniversityStateProvince = new javax.swing.JLabel();
        txtUniversityName = new javax.swing.JTextField();
        txtUniversityCountry = new javax.swing.JTextField();
        txtUniversityStateProvince = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Προβολή Πανεπιστημίου");
        setBackground(new java.awt.Color(255, 102, 102));
        setModal(true);

        lblUniversityName.setText("Όνομα Πανεπιστημίου:");

        txtUniversityAlphaCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUniversityAlphaCodeActionPerformed(evt);
            }
        });

        lblUniversityDomain.setText("Domain:");

        txtUniversityDomain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUniversityDomainActionPerformed(evt);
            }
        });

        lblUniversityWebPage.setText("Web_Page:");

        cmdInsert.setText("Αποθήκευση δεδομένων Πανεπιστημίου στη βάση");
        cmdInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdInsertActionPerformed(evt);
            }
        });

        cmdUpdate.setText("Επεξεργασία δεδομένων πανεπιστημίου");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //cmdUpdateActionPerformed(evt);
            }
        });

        cmdDelete.setText("Διαγραφή δεδομένων πανεπιστημίου");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        jLabelUniversityId.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelUniversityId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUniversityId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblUniversityAlphaTwoCode.setText("Alpha_two_code:");

        lblUniversityCountry.setText("Country:");

        lblUniversityStateProvince.setText("State-province:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUniversityId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUniversityName)
                                    .addComponent(lblUniversityDomain)
                                    .addComponent(lblUniversityWebPage)
                                    .addComponent(lblUniversityAlphaTwoCode)
                                    .addComponent(lblUniversityCountry))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtUniversityName, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                                    .addComponent(txtUniversityDomain, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUniversityWebPage, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUniversityAlphaCode, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUniversityCountry, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUniversityStateProvince, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(lblUniversityStateProvince))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmdDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdInsert, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelUniversityId, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUniversityName)
                    .addComponent(txtUniversityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUniversityDomain)
                    .addComponent(txtUniversityDomain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUniversityWebPage)
                    .addComponent(txtUniversityWebPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUniversityAlphaTwoCode)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUniversityAlphaCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUniversityCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUniversityCountry))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUniversityStateProvince)
                    .addComponent(txtUniversityStateProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addComponent(cmdInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdDelete)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtUniversityDomainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUniversityDomainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUniversityDomainActionPerformed

    private void txtUniversityAlphaCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUniversityAlphaCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUniversityAlphaCodeActionPerformed

    //prosthesi neon stoixeion stin basi geumaton
    private void cmdInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdInsertActionPerformed
        //apothikeui stin basi ta stoixeia tou geumatos
        universityInDB.setName(txtUniversityName.getText());
        universityInDB.setDomain(txtUniversityDomain.getText());
        universityInDB.setWebpage(txtUniversityWebPage.getText());
        universityInDB.setAlphatwocode(txtUniversityAlphaCode.getText());
        universityInDB.setCountry(txtUniversityCountry.getText());
        universityInDB.setStateprovince(txtUniversityStateProvince.getText());


        //Αν βρει το πανεπιστήμιο στη βάση τότε σημαίνει ότι ήδη υπάρχει.
        try {
            University dbUniversity = Connector.getUniversityByName(universityInDB.getName());
            if (dbUniversity != null){
                this.universityInDB = dbUniversity;
                displayUniversityData(universityInDB);
            }
            JOptionPane.showMessageDialog(this, "Τα πανεπιστήμιο είναι ήδη αποθηκευμένο στη βάση δεδομένων", "Αποτυχία", JOptionPane.INFORMATION_MESSAGE);
        }
        //Αν πάρω Exception οτι δε βρέθηκε πανεπιστήμιο με αυτό το όνομα το γράφω στη βάση. Θεώρω ότι το όνομα είναι μοναδικό για κάθε πανεπιστήμιο
        catch (NoResultException e){
            Connector.insertUniversity(universityInDB);
            University dbUniversity = Connector.getUniversityByName(universityInDB.getName());
            displayUniversityData(dbUniversity);
            JOptionPane.showMessageDialog(this, "Τα πανεπιστήμιο αποθηκεύτηκε στη βάση δεδομένων", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_cmdInsertActionPerformed



    //diagrafi geumatos apo tin basi
    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed

        int answer = JOptionPane.showConfirmDialog(this, "Να διαγραφεί το γεύμα;", "Απαιτείται επιβεβαίωση", JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.YES_OPTION) {
            //diegrapse apo tin basi
            try {
                University dbUniversity = Connector.getUniversityByName(universityInDB.getName());
                if (dbUniversity != null){
                    Connector.deleteUniversity(dbUniversity);
                    displayUniversityData(uniApi);
                }
                JOptionPane.showMessageDialog(this, "Το γεύμα διαγράφηκε από τη βάση επιτυχώς!\n"
                                + "Για να συνεχίσετε σε νέα αναζήτηση γεύματος\n"
                                + "   κλείστε την οθόνη «Προβολή γεύματος»", "Επιτυχής διαγραφή γεύματος",
                        JOptionPane.INFORMATION_MESSAGE);            }
            //Αν πάρω Exception οτι δε βρέθηκε πανεπιστήμιο με αυτό το όνομα στη βάση δεν υπάρχει κάτι για να διαγράψω
            catch (NoResultException e){
                JOptionPane.showMessageDialog(this, "Τα πανεπιστήμιο δεν υπάρχει στη βάση δεδομένων για να διαγραφεί", "Αποτυχία", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        if (answer == JOptionPane.NO_OPTION) {
            displayUniversityData(universityInDB);
            JOptionPane.showMessageDialog(this,
                    "Το γεύμα δεν διαγράφηκε!", "Διατήρηση γεύματος στη βάση δεδομένων",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_cmdDeleteActionPerformed



    //methodos gia emfanisi tis formas stin othoni
    public static void showUniversityForm(University university) {
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
            java.util.logging.Logger.getLogger(UniversityForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UniversityForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UniversityForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UniversityForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UniversityForm(university).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdInsert;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JLabel jLabelUniversityId;
    private javax.swing.JLabel lblUniversityCountry;
    private javax.swing.JLabel lblUniversityDomain;
    private javax.swing.JLabel lblUniversityName;
    private javax.swing.JLabel lblUniversityStateProvince;
    private javax.swing.JLabel lblUniversityWebPage;
    private javax.swing.JTextField txtUniversityAlphaCode;
    private javax.swing.JTextField txtUniversityCountry;
    private javax.swing.JTextField txtUniversityDomain;
    private javax.swing.JTextField txtUniversityName;
    private javax.swing.JTextField txtUniversityStateProvince;
    private javax.swing.JTextField txtUniversityWebPage;
    // End of variables declaration//GEN-END:variables
}

//    //enimerosi tisbasis me tis allages pou eginan apo ton xristi
//    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
//
//        int answer
//                = JOptionPane.showConfirmDialog(this, "Να αποθηκευθούν οι αλλαγές;",
//                        "Απαιτείται επιβεβαίωση", JOptionPane.YES_NO_OPTION);
//
//        if (answer == JOptionPane.YES_OPTION) {
//
//            m.setName(txtUniversityAlphaCode.getText());
//            m.setCategory(txtUniversityDomain.getText());
//            m.setArea(txtMealArea.getText());
//            m.setInstructions(txtMealInstructions.getText());
//
//            Connector.saveMeal(m);
//            JOptionPane.showMessageDialog(this,
//                    "Οι αλλαγές σας\n"
//                    +"αποθηκεύτηκαν στη βάση επιτυχώς!\n", "Επιτυχής αλλαγή δεδομένων γεύματος",
//                    JOptionPane.INFORMATION_MESSAGE);
//        }
//        if (answer == JOptionPane.NO_OPTION) {
//            displayMealData();
//        }
//        checkButtonsEnabled();
//    }