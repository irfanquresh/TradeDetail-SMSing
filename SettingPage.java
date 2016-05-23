/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.trillit;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author IRFAN
 */
public class SettingPage extends javax.swing.JFrame {

    /**
     * Creates new form SettingPage
     */
    Statement st = null;
    MainPage mainPage;
    Setting setting = null;

    SettingPage(Statement st, MainPage mainPage, Setting setting) {
        super("Settings");
        this.st = st;
        this.mainPage = mainPage;
        this.setting = setting;
        initComponents();
        initValues();

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image image = kit.getImage(ClassLoader.getSystemResource("images/images_025 (7) - Copy.jpg"));
        setIconImage(image);
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMaster = new javax.swing.JPanel();
        pnlHeaderMaster = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        pnlContentSection = new javax.swing.JPanel();
        pnlContentForm = new javax.swing.JPanel();
        pnlUserName = new javax.swing.JPanel();
        lblSenderUserName = new javax.swing.JLabel();
        tfSenderUsername = new javax.swing.JTextField();
        pnlSenderUserId = new javax.swing.JPanel();
        tfSenderUserId = new javax.swing.JTextField();
        lblSenderUserId = new javax.swing.JLabel();
        pnlSenderPassword = new javax.swing.JPanel();
        lblSenderPassword = new javax.swing.JLabel();
        tfSenderPassword = new javax.swing.JTextField();
        pnlSaveSetting = new javax.swing.JPanel();
        btnSaveSetting = new javax.swing.JButton();
        lblStatusMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlMaster.setLayout(new java.awt.BorderLayout());

        pnlHeaderMaster.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblHeader.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblHeader.setText("Setting");
        pnlHeaderMaster.add(lblHeader);

        pnlMaster.add(pnlHeaderMaster, java.awt.BorderLayout.PAGE_START);

        pnlContentForm.setLayout(new java.awt.GridLayout(4, 1));

        pnlUserName.setPreferredSize(new java.awt.Dimension(400, 50));
        pnlUserName.setLayout(new java.awt.BorderLayout());

        lblSenderUserName.setText("Sender User Name");
        pnlUserName.add(lblSenderUserName, java.awt.BorderLayout.CENTER);

        tfSenderUsername.setMinimumSize(new java.awt.Dimension(200, 20));
        tfSenderUsername.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlUserName.add(tfSenderUsername, java.awt.BorderLayout.PAGE_END);

        pnlContentForm.add(pnlUserName);

        pnlSenderUserId.setMinimumSize(new java.awt.Dimension(100, 50));
        pnlSenderUserId.setPreferredSize(new java.awt.Dimension(400, 50));
        pnlSenderUserId.setLayout(new java.awt.BorderLayout());

        tfSenderUserId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfSenderUserId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfSenderUserId.setMinimumSize(new java.awt.Dimension(200, 20));
        tfSenderUserId.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlSenderUserId.add(tfSenderUserId, java.awt.BorderLayout.PAGE_END);

        lblSenderUserId.setText("Sender User Id");
        pnlSenderUserId.add(lblSenderUserId, java.awt.BorderLayout.LINE_START);

        pnlContentForm.add(pnlSenderUserId);

        pnlSenderPassword.setLayout(new java.awt.BorderLayout());

        lblSenderPassword.setText("Sender Password");
        pnlSenderPassword.add(lblSenderPassword, java.awt.BorderLayout.CENTER);

        tfSenderPassword.setMinimumSize(new java.awt.Dimension(200, 20));
        tfSenderPassword.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlSenderPassword.add(tfSenderPassword, java.awt.BorderLayout.PAGE_END);

        pnlContentForm.add(pnlSenderPassword);

        pnlSaveSetting.setMinimumSize(new java.awt.Dimension(83, 100));
        pnlSaveSetting.setPreferredSize(new java.awt.Dimension(83, 50));
        pnlSaveSetting.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        btnSaveSetting.setText("Save");
        btnSaveSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSettingActionPerformed(evt);
            }
        });
        pnlSaveSetting.add(btnSaveSetting);
        pnlSaveSetting.add(lblStatusMessage);

        pnlContentForm.add(pnlSaveSetting);

        pnlContentSection.add(pnlContentForm);

        pnlMaster.add(pnlContentSection, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMaster, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnSaveSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSettingActionPerformed
        try {
            String senderId = tfSenderUserId.getText();
            String senderName = tfSenderUsername.getText();
            String senderPassword = tfSenderPassword.getText();
            updateSetting(senderId, senderName, senderPassword);
            lblStatusMessage.setText("Record Saved Successfully");

            Setting s = this.setting;
            s.setSenderId(senderId);
            s.setUserName(senderName);
            s.setPassword(senderPassword);
            mainPage.setSetting(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveSettingActionPerformed
    private void initValues() {
        try {
            tfSenderUserId.setText(setting.getSenderId());
            tfSenderUsername.setText(setting.getUserName());
            tfSenderPassword.setText(setting.getPassword());
        } catch (Exception e) {
        }
    }

    private void updateSetting(String senderId, String senderName, String senderPassword) {
        try {
            String sql = "UPDATE Setting set senderId ='" + senderId + "',senderName='" + senderName + "',senderPassword='" + senderPassword + "' where id=1 ";
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveSetting;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblSenderPassword;
    private javax.swing.JLabel lblSenderUserId;
    private javax.swing.JLabel lblSenderUserName;
    private javax.swing.JLabel lblStatusMessage;
    private javax.swing.JPanel pnlContentForm;
    private javax.swing.JPanel pnlContentSection;
    private javax.swing.JPanel pnlHeaderMaster;
    private javax.swing.JPanel pnlMaster;
    private javax.swing.JPanel pnlSaveSetting;
    private javax.swing.JPanel pnlSenderPassword;
    private javax.swing.JPanel pnlSenderUserId;
    private javax.swing.JPanel pnlUserName;
    private javax.swing.JTextField tfSenderPassword;
    private javax.swing.JTextField tfSenderUserId;
    private javax.swing.JTextField tfSenderUsername;
    // End of variables declaration//GEN-END:variables

}