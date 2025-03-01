package ilias.uniapp.Forms;

import ilias.uniapp.db.Connector;
import ilias.uniapp.db.University;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;


//forma emfanisis stixion panepistimiou
public class UniversityForm extends javax.swing.JDialog {

    //global metablites pou h mia tha periexei ta stoixeia tou panepisthmiou apo to API kai h allh ta stoixeia apo th DB
    private University universityInDB;
    private final University universityApi;
    //xrhsimopoiw th boolean metavliti gia na energopoihsw/apenergopoihsw ta koubia
    private boolean universityExistsInDB = false;


    //Constructor opou pernaw sa parametro to panepistimio gia na mporei na emfanisei ta stoixeia tou
    public UniversityForm(University universityParam) {
        initComponents(); //dieuthetisi ton GUI stixion

        //perno ta stixia pou perasan apo alli forma se auti topika kai sta duo panepistimia
        universityInDB = universityParam;
        universityApi = universityParam;

        //topotheto tin forma
        pack();
        setLocationRelativeTo(null);
        setModal(true);

        //An to panepistimio uparxei sth DB tha paroousiasw to panepistimio ths vashs
        try {
            University dbUniversity = Connector.getUniversityByName(universityParam.getName());
            if (dbUniversity != null){
                universityExistsInDB = true;
                this.universityInDB = dbUniversity;
                displayUniversityData(universityInDB);
            }
        }//an to panepistimio den uparxei sth db tha parousiasw to panepistimio tou API
        catch (NoResultException e){
            displayUniversityData(universityApi);
        }
        checkButtonsEnabled();
    }

    //methodos gia na emfanizei ta stoixeia geumatos stin forma, iparxoun idi gemata stin metabliti m
    private void displayUniversityData(University u) {
        jLabelUniversityId.setText(String.valueOf(u.getId()));
        txtUniversityName.setText(u.getName());
        txtUniversityDomain.setText(u.getDomain());
        txtUniversityWebPage.setText(u.getWebpage());
        txtUniversityAlphaCode.setText(u.getAlphatwocode());
        txtUniversityCountry.setText(u.getCountry());
        txtUniversityStateProvince.setText(u.getStateprovince());
        txtUniversityContactInfos.setText(u.getContact());
        txtUniversityDescription.setText(u.getDescription());
        u.addViews();
        Connector.insertUniversityViews(u);
        checkButtonsEnabled();
    }

    //analoga tou an ipirxe stin basi to panepistimio anoigokleinw ta katallila plhktra
    private void checkButtonsEnabled() {
        cmdInsert.setEnabled(true);
        cmdUpdate.setEnabled(universityExistsInDB);
        cmdDelete.setEnabled(universityExistsInDB);
        AddComments.setEnabled(universityExistsInDB);
    }


    //Methodos gia tin eisagwgi panepistimiou stin vasi dedomenwn
    private void cmdInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdInsertActionPerformed
        //apothikeui stin basi ta stoixeia tou geumatos
        updateUniversityFromFields();

        //Elengxw an to panepistimio uparxei idi stin vasi
        try {
            University dbUniversity = Connector.getUniversityByName(universityInDB.getName());
            if (dbUniversity != null){
                displayUniversityData(universityInDB);
            }
            JOptionPane.showMessageDialog(this, "Τα πανεπιστήμιο είναι ήδη αποθηκευμένο στη βάση δεδομένων", "Αποτυχία", JOptionPane.INFORMATION_MESSAGE);
        }
        //An parw exception oti den uparxei to panepistimio stin vasi tote to eisagw.
        catch (NoResultException e){
            Connector.insertUniversity(universityInDB);
            universityExistsInDB = true;
            University dbUniversity = Connector.getUniversityByName(universityInDB.getName());
            universityInDB = dbUniversity;// Ενημέρωση του universityInDB με τα δεδομένα από τη βάση
            displayUniversityData(dbUniversity);// Ενημέρωση του universityInDB με τα δεδομένα από τη βάσ
            JOptionPane.showMessageDialog(this, "Τα πανεπιστήμιο αποθηκεύτηκε στη βάση δεδομένων", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);
            checkButtonsEnabled();
        }

    }//GEN-LAST:event_cmdInsertActionPerformed


    //Methodos gia tin diagrafi panepistimiou apo tin vasi dedomenwn
    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        int answer = JOptionPane.showConfirmDialog(this, "Να διαγραφεί το πανεπιστήμιο;", "Απαιτείται επιβεβαίωση", JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.YES_OPTION) {
            //Diegkrinw an to panepistimio uparxei stin vasi kai an uparxei to diagrafw
            try {
                University dbUniversity = Connector.getUniversityByName(universityInDB.getName());
                if (dbUniversity != null){
                    Connector.deleteUniversity(dbUniversity);
                    universityExistsInDB = false;
                    displayUniversityData(universityApi);
                    checkButtonsEnabled();
                }
                JOptionPane.showMessageDialog(this, "Το πανεπιστήμιο διαγράφηκε από τη βάση επιτυχώς!\n"
                                + "Για να συνεχίσετε σε νέα αναζήτηση πανεπιστημίου\n"
                                + "   κλείστε την οθόνη «Προβολή πανεπιστημίου»", "Επιτυχής διαγραφή πανεπιστημίου",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            //An parw exception oti den uparxei to panepistimio stin vasi tote emfanizw minima sfalmatos
            catch (NoResultException e){
                JOptionPane.showMessageDialog(this, "Σφάλμα κατά τη διαγραφή: ", "Αποτυχία", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (answer == JOptionPane.NO_OPTION) {
            displayUniversityData(universityInDB);
            JOptionPane.showMessageDialog(this,
                    "Το πανεπιστήμιο δεν διαγράφηκε!", "Διατήρηση πανεπιστημίου στη βάση δεδομένων",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_cmdDeleteActionPerformed


    //Methodos gia tin apothikeusi twn allagwn pou egine stin forma
    private void jButtonSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveChangesActionPerformed
        // Ενημερώνουμε το αντικείμενο universityInDB με τα νέα στοιχεία από τα πεδία της φόρμας
        updateUniversityFromFields();

        //Apothikeusi twn allagwn stin vasi
        try {
            Connector.updateUniversity(universityInDB);
            JOptionPane.showMessageDialog(this, "Οι αλλαγές αποθηκεύτηκαν επιτυχώς!", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Αποτυχία αποθήκευσης αλλαγών: " + e.getMessage(), "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }

        //Emfanizoume ta stoixeia tou panepistimiou
        displayUniversityData(universityInDB);
        //Kleinw thn forma
        this.dispose();
    }//GEN-LAST:event_jButtonSaveChangesActionPerformed


    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        txtUniversityName.setEditable(true);
        txtUniversityDomain.setEditable(true);
        txtUniversityCountry.setEditable(true);
        txtUniversityAlphaCode.setEditable(true);
        txtUniversityWebPage.setEditable(true);
        txtUniversityStateProvince.setEditable(true);
        txtUniversityContactInfos.setEditable(true);
        txtUniversityDescription.setEditable(true);

        jButtonSaveChanges.setEnabled(universityExistsInDB);

        JOptionPane.showMessageDialog(this,"Μπορείται να τροποποιήσεται τα δεδομένα του πανεπιστημίου", "",JOptionPane.INFORMATION_MESSAGE);

        checkButtonsEnabled();
    }

    //Methodos gia tin emfanisi tis formas
    public static void showUniversityForm(University university) {
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

    private void AddCommentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCommentsActionPerformed
        CommentsForm.showCommentsForm(this, universityInDB);
    }//GEN-LAST:event_AddCommentsActionPerformed


    private void updateUniversityFromFields() {
        universityInDB.setName(txtUniversityName.getText());
        universityInDB.setDomain(txtUniversityDomain.getText());
        universityInDB.setWebpage(txtUniversityWebPage.getText());
        universityInDB.setAlphatwocode(txtUniversityAlphaCode.getText());
        universityInDB.setCountry(txtUniversityCountry.getText());
        universityInDB.setStateprovince(txtUniversityStateProvince.getText());
        universityInDB.setContact(txtUniversityContactInfos.getText());
        universityInDB.setDescription(txtUniversityDescription.getText());
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
        jButtonSaveChanges = new javax.swing.JButton();
        lblUniversityContactInfos = new javax.swing.JLabel();
        txtUniversityContactInfos = new javax.swing.JTextField();
        lblUniversityDescription = new javax.swing.JLabel();
        txtUniversityDescription = new javax.swing.JTextField();
        AddComments = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Προβολή Πανεπιστημίου");
        setBackground(new java.awt.Color(255, 102, 102));
        setForeground(new java.awt.Color(204, 204, 204));
        setModal(true);

        lblUniversityName.setText("Όνομα Πανεπιστημίου:");

        txtUniversityAlphaCode.setEditable(false);

        lblUniversityDomain.setText("Domain:");

        txtUniversityDomain.setEditable(false);

        lblUniversityWebPage.setText("Web_Page:");

        cmdInsert.setText("Save Uni in DB");
        cmdInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdInsertActionPerformed(evt);
            }
        });

        cmdUpdate.setText("Update Uni");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        cmdDelete.setText("Delete Uni");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        jLabelUniversityId.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelUniversityId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUniversityId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblUniversityAlphaTwoCode.setText("Alpha_two_code:");

        txtUniversityWebPage.setEditable(false);

        lblUniversityCountry.setText("Country:");

        lblUniversityStateProvince.setText("State-province:");

        txtUniversityName.setEditable(false);

        txtUniversityCountry.setEditable(false);

        txtUniversityStateProvince.setEditable(false);

        jButtonSaveChanges.setText("Save changes");
        jButtonSaveChanges.setEnabled(false);
        jButtonSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveChangesActionPerformed(evt);
            }
        });

        lblUniversityContactInfos.setText("Contact infos:");

        txtUniversityContactInfos.setEditable(false);

        lblUniversityDescription.setText("Description:");

        txtUniversityDescription.setEditable(false);

        AddComments.setText("Add comments");
        AddComments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCommentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUniversityName)
                            .addComponent(lblUniversityDomain)
                            .addComponent(lblUniversityWebPage)
                            .addComponent(lblUniversityAlphaTwoCode)
                            .addComponent(lblUniversityCountry))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelUniversityId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUniversityDomain, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                                    .addComponent(txtUniversityWebPage)
                                    .addComponent(txtUniversityName))
                                .addComponent(txtUniversityAlphaCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtUniversityCountry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUniversityStateProvince)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUniversityStateProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblUniversityDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdInsert)
                                .addGap(18, 18, 18)
                                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AddComments))
                            .addComponent(txtUniversityDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUniversityContactInfos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUniversityContactInfos, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUniversityId, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUniversityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUniversityName))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUniversityDomain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUniversityDomain))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUniversityWebPage)
                    .addComponent(txtUniversityWebPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUniversityAlphaCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUniversityAlphaTwoCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUniversityCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUniversityCountry))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUniversityStateProvince)
                    .addComponent(txtUniversityStateProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUniversityContactInfos)
                    .addComponent(txtUniversityContactInfos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUniversityDescription)
                    .addComponent(txtUniversityDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdInsert)
                    .addComponent(cmdDelete)
                    .addComponent(cmdUpdate)
                    .addComponent(jButtonSaveChanges)
                    .addComponent(AddComments))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddComments;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdInsert;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JButton jButtonSaveChanges;
    private javax.swing.JLabel jLabelUniversityId;
    private javax.swing.JLabel lblUniversityContactInfos;
    private javax.swing.JLabel lblUniversityCountry;
    private javax.swing.JLabel lblUniversityDescription;
    private javax.swing.JLabel lblUniversityDomain;
    private javax.swing.JLabel lblUniversityName;
    private javax.swing.JLabel lblUniversityStateProvince;
    private javax.swing.JLabel lblUniversityWebPage;
    private javax.swing.JTextField txtUniversityAlphaCode;
    private javax.swing.JTextField txtUniversityContactInfos;
    private javax.swing.JTextField txtUniversityCountry;
    private javax.swing.JTextField txtUniversityDescription;
    private javax.swing.JTextField txtUniversityDomain;
    private javax.swing.JTextField txtUniversityName;
    private javax.swing.JTextField txtUniversityStateProvince;
    private javax.swing.JTextField txtUniversityWebPage;
    // End of variables declaration//GEN-END:variables
}