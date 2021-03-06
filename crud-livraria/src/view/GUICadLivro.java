/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.AutorVO;
import model.LivroVO;
import service.AutorService;
import service.LivroService;
import service.ServiceFactory;

/**
 *
 * @author windows
 */
public class GUICadLivro extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUICadLivro
     */
    public GUICadLivro() {
        initComponents();
        preencherCombo();
    }
    
    public void limpar(){
        jtTitulo.setText(null);
        jtSubtitulo.setText(null);
        jtEdicao.setText(null);
        jtISBN.setText(null);
        jtEitora.setText(null);
        jtAnoLancamento.setText(null);
        jtValorVenda.setText(null);
    }
    
    public void cadastrar(){
        try{
            
            LivroVO lVO = new LivroVO();
            
            if(!jtTitulo.getText().isEmpty()){
                lVO.setTitulo(jtTitulo.getText());
            }else{
                throw new NumberFormatException("Preencha o campo TITULO");
            }
            
            if(!jtSubtitulo.getText().isEmpty()){
                lVO.setSubtitulo(jtSubtitulo.getText());
            }else{
                throw new NumberFormatException("Preencha o campo SUBTITULO");
            }
            
            if(!jtEdicao.getText().isEmpty()){
                lVO.setEdicao(Integer.parseInt(jtEdicao.getText()));
            }else{
                throw new NumberFormatException("Preencha o campo EDICAO");
            }
            
            if(!jtEitora.getText().isEmpty()){
                lVO.setEditora(jtEitora.getText());
            }else{
                throw new NumberFormatException("Preencha o campo EDITORA");
            }
            
            if(jComboAutor.getSelectedItem() != null){
                //Associacao entre clases
                lVO.setS((AutorVO)jComboAutor.getSelectedItem());
            }else{
                throw new NumberFormatException("Escolha um AUTOR");
            }
            
            if(!jtISBN.getText().isEmpty()){
               lVO.setISBN(Long.parseLong(jtISBN.getText()));
            }else{
                throw new NumberFormatException("Preencha o campo ISBN");
            }
            
            if(!jtAnoLancamento.getText().isEmpty()){
               lVO.setData_lancamento(jtAnoLancamento.getText());
            }else{
                throw new NumberFormatException("Preencha o campo ANO LANÇAMENTO");
            }
            
            if(!jtValorVenda.getText().isEmpty()){
               lVO.setValor_venda(Double.parseDouble(jtValorVenda.getText()));
            }else{
                throw new NumberFormatException("Preencha o campo VALOR VENDA");
            }

            //Enviar o objeto LivroVO para a base de dados
            LivroService ls = service.ServiceFactory.getLivroService();
            //Chamando o método
            ls.cadastrarLivro(lVO);
            
            JOptionPane.showMessageDialog(this,
                    "Livro castrado com sucesso !!");

        }catch(Exception e){
            JOptionPane.showMessageDialog(this,
                    "Erro!" + e.getMessage());
        }
    }

    public void preencherCombo(){
        try {
          
            AutorService as = ServiceFactory.getAutorService();
            ArrayList<AutorVO> a = as.buscarAutores();
            
            for(int i= 0; i < a.size(); i++){
                jComboAutor.addItem(a.get(i));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro! "+e.getMessage());
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

        jlTitulo = new javax.swing.JLabel();
        jtTitulo = new javax.swing.JTextField();
        jlSubTitulo = new javax.swing.JLabel();
        jtSubtitulo = new javax.swing.JTextField();
        jtEdicao = new javax.swing.JTextField();
        jlEdicao = new javax.swing.JLabel();
        jlEditora = new javax.swing.JLabel();
        jbLimpar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jtEitora = new javax.swing.JTextField();
        jlDataLancamento = new javax.swing.JLabel();
        jlISBN = new javax.swing.JLabel();
        jtISBN = new javax.swing.JTextField();
        jlAutor = new javax.swing.JLabel();
        jlPreco = new javax.swing.JLabel();
        jtValorVenda = new javax.swing.JTextField();
        jComboAutor = new javax.swing.JComboBox();
        jtAnoLancamento = new javax.swing.JTextField();

        setClosable(true);

        jlTitulo.setText("TITULO");

        jtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtTituloKeyPressed(evt);
            }
        });

        jlSubTitulo.setText("SUBTITULO");

        jtSubtitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtSubtituloKeyPressed(evt);
            }
        });

        jtEdicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtEdicaoKeyPressed(evt);
            }
        });

        jlEdicao.setText("EDIÇÃO");

        jlEditora.setText("EDITORA");

        jbLimpar.setText("LIMPAR");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });
        jbLimpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbLimparKeyPressed(evt);
            }
        });

        jbCadastrar.setText("CADASTRAR");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });
        jbCadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbCadastrarKeyPressed(evt);
            }
        });

        jtEitora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtEitoraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtEitoraKeyReleased(evt);
            }
        });

        jlDataLancamento.setText("ANO DE LANÇAMENTO");

        jlISBN.setText("ISBN");
        jlISBN.setToolTipText("");

        jtISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtISBNKeyPressed(evt);
            }
        });

        jlAutor.setText("AUTOR");

        jlPreco.setText("VALOR VENDA");

        jtValorVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtValorVendaKeyPressed(evt);
            }
        });

        jComboAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboAutorKeyPressed(evt);
            }
        });

        jtAnoLancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtAnoLancamentoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtTitulo)
                    .addComponent(jtSubtitulo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 297, Short.MAX_VALUE)
                        .addComponent(jbLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCadastrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTitulo)
                            .addComponent(jlSubTitulo)
                            .addComponent(jlDataLancamento)
                            .addComponent(jlAutor))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboAutor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlEdicao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtEdicao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(jtAnoLancamento, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jlEditora)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtValorVenda, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtISBN, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtEitora)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlPreco)
                                            .addComponent(jlISBN))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlSubTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEdicao)
                    .addComponent(jlEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtEitora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDataLancamento)
                    .addComponent(jlISBN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtAnoLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAutor)
                    .addComponent(jlPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbLimpar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        // TODO add your handling code here:
        cadastrar();
        limpar();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jtTituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTituloKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jtSubtitulo.grabFocus();
        }
    }//GEN-LAST:event_jtTituloKeyPressed

    private void jtSubtituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtSubtituloKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jtEdicao.grabFocus();
        }
    }//GEN-LAST:event_jtSubtituloKeyPressed

    private void jtEdicaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEdicaoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jtEitora.grabFocus();
        }
    }//GEN-LAST:event_jtEdicaoKeyPressed

    private void jtEitoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEitoraKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEitoraKeyReleased

    private void jtEitoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEitoraKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jtAnoLancamento.grabFocus();
        }
    }//GEN-LAST:event_jtEitoraKeyPressed

    private void jtAnoLancamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtAnoLancamentoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jtISBN.grabFocus();
        }
    }//GEN-LAST:event_jtAnoLancamentoKeyPressed

    private void jtISBNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtISBNKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jComboAutor.grabFocus();
        }
    }//GEN-LAST:event_jtISBNKeyPressed

    private void jComboAutorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboAutorKeyPressed
        // TODO add your handling code here
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jtValorVenda.grabFocus();
        };
    }//GEN-LAST:event_jComboAutorKeyPressed

    private void jtValorVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtValorVendaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            cadastrar();
        }
    }//GEN-LAST:event_jtValorVendaKeyPressed

    private void jbLimparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbLimparKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            limpar();
        }
    }//GEN-LAST:event_jbLimparKeyPressed

    private void jbCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbCadastrarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            cadastrar();
        }
    }//GEN-LAST:event_jbCadastrarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboAutor;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JLabel jlAutor;
    private javax.swing.JLabel jlDataLancamento;
    private javax.swing.JLabel jlEdicao;
    private javax.swing.JLabel jlEditora;
    private javax.swing.JLabel jlISBN;
    private javax.swing.JLabel jlPreco;
    private javax.swing.JLabel jlSubTitulo;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtAnoLancamento;
    private javax.swing.JTextField jtEdicao;
    private javax.swing.JTextField jtEitora;
    private javax.swing.JTextField jtISBN;
    private javax.swing.JTextField jtSubtitulo;
    private javax.swing.JTextField jtTitulo;
    private javax.swing.JTextField jtValorVenda;
    // End of variables declaration//GEN-END:variables
}
