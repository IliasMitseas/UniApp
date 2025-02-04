/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ilias.uniapp.Forms;

import ilias.uniapp.db.University;
import ilias.uniapp.json.JsonHttpRequester;

import javax.swing.*;
import java.util.List;



public class UniversitiesForm extends javax.swing.JDialog {

    private List <String> u;//metabliti pou periexei ta stoixeia kai tis allages otan xrieazetai


    public UniversitiesForm(List universityParam) {
        initComponents();

        List<String> u = universityParam;

        jListUniversities.setEnabled(false);
        jListUniversity.setEnabled(false);

        List<String> universities = u;
        DefaultListModel<String> universitiesList = new DefaultListModel<>();

        for (String universityName : universities) {
            universitiesList.addElement(universityName);
        }
        jListUniversities.setModel(universitiesList);
        jListUniversities.setEnabled(true);

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

        jLabelUniversities = new javax.swing.JLabel();
        jScrollPaneCountry = new javax.swing.JScrollPane();
        jListUniversities = new javax.swing.JList<>();
        jLabelUniversitiesDetails = new javax.swing.JLabel();
        jScrollPaneUniversities = new javax.swing.JScrollPane();
        jListUniversity = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Πανεπιστήμια");

        jLabelUniversities.setText("Πανεπιστήμια");
        jLabelUniversities.setToolTipText("");

        jListUniversities.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Uni1", "Uni2", "Uni3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListUniversities.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListUniversitiesValueChanged(evt);
            }
        });
        jScrollPaneCountry.setViewportView(jListUniversities);

        jLabelUniversitiesDetails.setText("Details");

        jListUniversity.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Uni1" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListUniversity.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListUniversityValueChanged(evt);
            }
        });
        jScrollPaneUniversities.setViewportView(jListUniversity);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUniversities))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUniversitiesDetails)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPaneUniversities, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUniversities)
                    .addComponent(jLabelUniversitiesDetails))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneCountry, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jScrollPaneUniversities))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListUniversitiesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListUniversitiesValueChanged
        if (!evt.getValueIsAdjusting()) {
            jListUniversity.setEnabled(false);
            List<String> universities = JsonHttpRequester.getUniversities(jListUniversities.getSelectedValue());
            DefaultListModel<String> universitiesPerWord = new DefaultListModel<>();

            for (String universityName : universities) {
                universitiesPerWord.addElement(universityName);
            }
            jListUniversity.setModel(universitiesPerWord);
            jListUniversity.setEnabled(true);
        }
    }//GEN-LAST:event_jListUniversitiesValueChanged

    private void jListUniversityValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListUniversityValueChanged
        if (!evt.getValueIsAdjusting() && jListUniversity.isEnabled()) {
            String universityName = jListUniversity.getSelectedValue();
            jListUniversity.setEnabled(false);
            University university = JsonHttpRequester.getUniversity(universityName);
            if (university != null) {
                UniversityForm.showMealForm(university);
            }
            jListUniversity.setEnabled(true);
        }
    }//GEN-LAST:event_jListUniversityValueChanged

    /**
     * @param args the command line arguments
     */
    public static void showCategoriesForm() {
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
            java.util.logging.Logger.getLogger(UniversitiesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UniversitiesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UniversitiesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UniversitiesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    public static void showUniversitiesForm(List <String> u) {
        java.awt.EventQueue.invokeLater(() -> {
            new UniversitiesForm(u).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelUniversities;
    private javax.swing.JLabel jLabelUniversitiesDetails;
    private javax.swing.JList<String> jListUniversities;
    private javax.swing.JList<String> jListUniversity;
    private javax.swing.JScrollPane jScrollPaneCountry;
    private javax.swing.JScrollPane jScrollPaneUniversities;
    // End of variables declaration//GEN-END:variables
}
