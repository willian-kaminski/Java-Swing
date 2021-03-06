
package view;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.UsuarioVO;
import service.ServiceFactory;
import service.UsuarioService;

/**
 *
 * @author Willian Kaminski
 * @since 08/07/2018 10:49
 * @version 1.0
 */
public class GUILogin extends javax.swing.JFrame {
    
    //Contador
    private int cont = 0;

    /**
     * Creates new form GUILogin
     */
    public GUILogin() {
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

        jlIcon = new javax.swing.JLabel();
        jlLogin = new javax.swing.JLabel();
        jtLogin = new javax.swing.JTextField();
        jlSenha = new javax.swing.JLabel();
        jbLogar = new javax.swing.JButton();
        jpfSenha = new javax.swing.JPasswordField();
        jlAviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/books (1).png"))); // NOI18N

        jlLogin.setText("Login");

        jtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtLoginKeyPressed(evt);
            }
        });

        jlSenha.setText("Senha");

        jbLogar.setText("Logar");
        jbLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLogarActionPerformed(evt);
            }
        });

        jpfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpfSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLogin, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtLogin, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlAviso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jbLogar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jlIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbLogar)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLogarActionPerformed
        // TODO add your handling code here:
        logar();
    }//GEN-LAST:event_jbLogarActionPerformed

    private void jtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtLoginKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jpfSenha.grabFocus();
        }
    }//GEN-LAST:event_jtLoginKeyPressed

    private void jpfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfSenhaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            logar();
        }
    }//GEN-LAST:event_jpfSenhaKeyPressed

    private void logar(){
        try {
            
            UsuarioService us = ServiceFactory.getUsuarioService();
            UsuarioVO uVO = new UsuarioVO();
            
            if(!jtLogin.getText().isEmpty()){
                uVO.setLogin(jtLogin.getText());
            }else{
                throw new NumberFormatException("Preencha o campo LOGIN");
            }
            
            if(!jpfSenha.getText().isEmpty()){
                uVO.setSenha(String.valueOf(jpfSenha.getPassword()));
            }else{
                throw new NumberFormatException("Preencha o campo SENHA");
            }

            if(us.validarSenha(uVO)){  
                abrirMenuPrincipal();
                this.setVisible(false);
            }else{
                cont++;
                jlAviso.setText(cont + "° tentativa!! Login/Senha inválido(s)!");
                
                if(cont==3){
                    System.exit(EXIT_ON_CLOSE);
                }
            }   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro!" + e.getMessage());
        }
    }
    
    private void abrirMenuPrincipal(){
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
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
            /*for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green", "INSERT YOUR LICENSE KEY HERE", "my company");
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUILogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbLogar;
    private javax.swing.JLabel jlAviso;
    private javax.swing.JLabel jlIcon;
    private javax.swing.JLabel jlLogin;
    private javax.swing.JLabel jlSenha;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtLogin;
    // End of variables declaration//GEN-END:variables
}
