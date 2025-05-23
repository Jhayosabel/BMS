/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


import static bakerysystem.regForms.dbemail;
import static bakerysystem.regForms.dbusername;
import config.dbConnector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author mypc
 */
public class createUserForm extends javax.swing.JFrame {

    /**
     * Creates new form createUserForm
     */
    public createUserForm() {
        initComponents();
    }
    
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
     public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
    
    public boolean duplicateCheck(){
        dbConnector dbc = new dbConnector();
        
        try{
            String query="SELECT*FROM tbl_user  WHERE u_user ='"+regUser.getText()+"'OR u_email = '"+regEmail.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                dbemail = resultSet.getString("u_email");
                if(dbemail.equals(regEmail.getText())){
                    JOptionPane.showMessageDialog(null, "Email is already Used!");
                    regEmail.setText("");
                }
                
               
                dbusername = resultSet.getString("u_user");
                if(dbusername.equals(regUser.getText())){
                    JOptionPane.showMessageDialog(null, "Username is already Used!");
                    regUser.setText("");
                    
                 }  
                return true;  
            }else{
                return false;
            }
            
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    public boolean updateCheck(){
        dbConnector dbc = new dbConnector();
        try{
            String query="SELECT*FROM tbl_user  WHERE (u_user ='"+regUser.getText()+"'OR u_email = '"+regEmail.getText()+"')AND u_id != '"+UId.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                dbemail = resultSet.getString("u_email");
                if(dbemail.equals(regEmail.getText())){
                    JOptionPane.showMessageDialog(null, "Email is already Used!");
                    regEmail.setText("");
                }
                dbusername = resultSet.getString("u_user");
                if(dbusername.equals(regUser.getText())){
                    JOptionPane.showMessageDialog(null, "Username is already Used!");
                    regUser.setText("");   
                 }  
                return true;  
            }else{
                return false;
            }   
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        regName = new javax.swing.JTextField();
        regEmail = new javax.swing.JTextField();
        regUser = new javax.swing.JTextField();
        regPass = new javax.swing.JTextField();
        registrationButton = new javax.swing.JButton();
        regUserType = new javax.swing.JComboBox<>();
        fn4 = new javax.swing.JLabel();
        fn = new javax.swing.JLabel();
        fn1 = new javax.swing.JLabel();
        fn2 = new javax.swing.JLabel();
        fn3 = new javax.swing.JLabel();
        regUserStatus = new javax.swing.JComboBox<>();
        fn5 = new javax.swing.JLabel();
        UId = new javax.swing.JTextField();
        fn6 = new javax.swing.JLabel();
        DeleteB = new javax.swing.JButton();
        UpdateB = new javax.swing.JButton();
        Clearb = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        Cancelbutton = new javax.swing.JButton();
        daddd = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        regName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(regName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 210, 30));

        regEmail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        regEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        regEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regEmailActionPerformed(evt);
            }
        });
        jPanel3.add(regEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 210, 30));

        regUser.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        regUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(regUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 210, 30));

        regPass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        regPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(regPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 210, 30));

        registrationButton.setText("ADD");
        registrationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrationButtonMouseClicked(evt);
            }
        });
        registrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationButtonActionPerformed(evt);
            }
        });
        jPanel3.add(registrationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 80, 40));

        regUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user ", " " }));
        regUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regUserTypeActionPerformed(evt);
            }
        });
        jPanel3.add(regUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 210, 30));

        fn4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        fn4.setText("Acc Status:");
        jPanel3.add(fn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 70, 30));

        fn.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        fn.setText("Name:");
        jPanel3.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 50, 10));

        fn1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        fn1.setText("Email:");
        jPanel3.add(fn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 50, 10));

        fn2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        fn2.setText("User:");
        jPanel3.add(fn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 40, 10));

        fn3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        fn3.setText("Password:");
        jPanel3.add(fn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 70, 10));

        regUserStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "active", "pending" }));
        regUserStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regUserStatusActionPerformed(evt);
            }
        });
        jPanel3.add(regUserStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 210, 30));

        fn5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        fn5.setText("AccType:");
        jPanel3.add(fn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 30));

        UId.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        UId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(UId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 60, 30));

        fn6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        fn6.setText("ID:");
        jPanel3.add(fn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 20, 10));

        DeleteB.setText("Delete");
        DeleteB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteBMouseExited(evt);
            }
        });
        DeleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBActionPerformed(evt);
            }
        });
        jPanel3.add(DeleteB, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 80, 40));

        UpdateB.setText("Update");
        UpdateB.setEnabled(false);
        UpdateB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateBMouseExited(evt);
            }
        });
        UpdateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBActionPerformed(evt);
            }
        });
        jPanel3.add(UpdateB, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 80, 40));

        Clearb.setText("Clear");
        Clearb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClearbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClearbMouseExited(evt);
            }
        });
        Clearb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearbActionPerformed(evt);
            }
        });
        jPanel3.add(Clearb, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 80, 40));

        Refresh.setText("Refresh");
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RefreshMouseExited(evt);
            }
        });
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });
        jPanel3.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 80, 40));

        Cancelbutton.setText("Cancel");
        Cancelbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelbuttonMouseExited(evt);
            }
        });
        Cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbuttonActionPerformed(evt);
            }
        });
        jPanel3.add(Cancelbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 80, 40));

        daddd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        daddd.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 150));

        jPanel3.add(daddd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 190, 170));

        select.setText("SELECT");
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
        });
        jPanel3.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, -1, -1));

        remove.setText("REMOVE");
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
        });
        jPanel3.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 700, 424));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("WELCOME TO BAKERY SYSTEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 870, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/11.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 10, 910, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regEmailActionPerformed

    private void registrationButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_registrationButtonMouseClicked

    private void registrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationButtonActionPerformed
        
        
        if(regName.getText().isEmpty()||regEmail.getText().isEmpty()||regUser.getText().isEmpty()||regPass.getText().isEmpty())

        {
            JOptionPane.showMessageDialog(null, "Fill apa ang wa na fill apan duh!");
        }else if(regPass.getText().length()< 8){
            JOptionPane.showMessageDialog(null, "Password character should be 8 above");
            regPass.setText("");

        }else if(duplicateCheck()){
            System.out.println("Duplicate Exist");

        }

        else{

            dbConnector dbc=new dbConnector();
            if(dbc.insertData("INSERT INTO tbl_user(u_name, u_email, u_user, u_password, u_image, u_status, u_type) "
                + "VALUES('"+regName.getText()+"','"+regEmail.getText()+"','"+regUser.getText()+"','"+regPass.getText()+"','"+destination+"','"+regUserStatus.getSelectedItem()+"','"+regUserType.getSelectedItem()+"')"))
        {
            JOptionPane.showMessageDialog(null, "Inserted Successfully");
            usersForm uf = new usersForm();
            uf.setVisible(true);
            this.dispose();

        }else{
            JOptionPane.showMessageDialog(null, "Connection Error!");

        }

        }
    }//GEN-LAST:event_registrationButtonActionPerformed

    private void regUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regUserTypeActionPerformed

    private void regUserStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regUserStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regUserStatusActionPerformed

    private void DeleteBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteBMouseEntered

    private void DeleteBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteBMouseExited

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteBActionPerformed

    private void UpdateBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBMouseEntered

    private void UpdateBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBMouseExited

    private void UpdateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBActionPerformed
        if(regName.getText().isEmpty()||regEmail.getText().isEmpty()
            ||regUser.getText().isEmpty()||regPass.getText().isEmpty())

        {
            JOptionPane.showMessageDialog(null, "Fill apa ang wa na fill apan duh!");
        }else if(regPass.getText().length()< 8){
            JOptionPane.showMessageDialog(null, "Password character should be 8 above");
            regPass.setText("");

        }else if(updateCheck()){

        }

        else{

            dbConnector dbc = new dbConnector();
            dbc.updateData("UPDATE tbl_user SET u_name = '"+regName.getText()+"',"
                + "u_email ='"+regEmail.getText()+"',"
                + "u_user = '"+regUser.getText()+"', "
                + "u_password = '"+regPass.getText()+"',"
                + "u_image = '"+destination+"',"
                + "u_status = '"+regUserStatus.getSelectedItem()+"',"
                + "u_type = '"+regUserType.getSelectedItem()+"'WHERE u_id = '"+UId.getText()+"'");
            
            if(destination.isEmpty()){
            File existingFile = new File(oldpath);
            if(existingFile.exists()){
                existingFile.delete();
            }
        }else{
            if(!(oldpath.equals(path))){
                imageUpdater(oldpath, path);
            }
        }
            
            
            usersForm uf=new usersForm();
            uf.setVisible(true);
            this.dispose();

        }

    }//GEN-LAST:event_UpdateBActionPerformed

    private void ClearbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearbMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearbMouseEntered

    private void ClearbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearbMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearbMouseExited

    private void ClearbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearbActionPerformed

    private void RefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshMouseEntered

    private void RefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshMouseExited

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshActionPerformed

    private void CancelbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelbuttonMouseEntered
        
    }//GEN-LAST:event_CancelbuttonMouseEntered

    private void CancelbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelbuttonMouseExited
        
    }//GEN-LAST:event_CancelbuttonMouseExited

    private void CancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbuttonActionPerformed
        usersForm uf =new usersForm();
        uf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelbuttonActionPerformed

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        remove.setEnabled(false);
        select.setEnabled(true);
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeMouseClicked

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
        JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/userimage/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            select.setEnabled(false);
                            remove.setEnabled(true);
                         
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }
    }//GEN-LAST:event_selectMouseClicked

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
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelbutton;
    private javax.swing.JButton Clearb;
    private javax.swing.JButton DeleteB;
    private javax.swing.JButton Refresh;
    public javax.swing.JTextField UId;
    public javax.swing.JButton UpdateB;
    private javax.swing.JPanel daddd;
    private javax.swing.JLabel fn;
    private javax.swing.JLabel fn1;
    private javax.swing.JLabel fn2;
    private javax.swing.JLabel fn3;
    private javax.swing.JLabel fn4;
    private javax.swing.JLabel fn5;
    private javax.swing.JLabel fn6;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField regEmail;
    public javax.swing.JTextField regName;
    public javax.swing.JTextField regPass;
    public javax.swing.JTextField regUser;
    public javax.swing.JComboBox<String> regUserStatus;
    public javax.swing.JComboBox<String> regUserType;
    public javax.swing.JButton registrationButton;
    private javax.swing.JButton remove;
    private javax.swing.JButton select;
    // End of variables declaration//GEN-END:variables
}
