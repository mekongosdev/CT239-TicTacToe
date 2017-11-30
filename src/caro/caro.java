
package caro;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class caro extends javax.swing.JFrame {
    Banco bc = new Banco();
    JButton btn[][] = new JButton[3][3];
    ImageIcon X = new ImageIcon("src\\images\\X.png");
    ImageIcon O = new ImageIcon("src\\images\\O.png");
    ImageIcon X1 = new ImageIcon("src\\images\\X1.png");
    ImageIcon O1 = new ImageIcon("src\\images\\O1.png");
    int kq;
    public caro() {
        initComponents();
        setLocationRelativeTo(null);
        jButton1.setText("New Game");
        jPanel1.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                btn[i][j] = new JButton();
               // btn[i][j].setFont(new Font("Tahoma", 1, 16));
                bc.banco[i][j] = 0;
                jPanel1.add(btn[i][j]);
                btn[i][j].addActionListener(new MyButtonActionListener());  
            }
        }
    }
 
    private class MyButtonActionListener implements ActionListener {
        

        @Override
        public void actionPerformed(ActionEvent e) {
            bc.best = 20;
            Point point = null;
            JButton btnx = (JButton) e.getSource();
            if (bc.banco[btnx.getY() / 88][btnx.getX() / 97] == 0) {
                // btnx.setText("X");
                btnx.setIcon(X);
                System.out.println("X: p[" + btnx.getY() / 88 + "][" + btnx.getX() / 97 + "]");
                //btnx.setEnabled(false);
                bc.banco[btnx.getY() / 88][btnx.getX() / 97] = bc.player_X;
                kq();
                if (kq == 0) {
                    bc.cat_tia(bc.player_O, 3, -20);
                    point = bc.point_pc;
                    System.out.println("O: p[" + point.x + "][" + point.y + "]");
                    //btn[point.x][point.y].setText("O");
                    btn[point.x][point.y].setIcon(O);
                    bc.banco[point.x][point.y] = bc.player_O;
                   // btn[point.x][point.y].setEnabled(false);
                    kq();
                }
            }
        }
    }
    
    public void kq(){
        List ds = bc.dscon();
        kq = bc.nutLa();
        if( kq == 0){
            if(ds.isEmpty()){
                kq = 1;
                int option = JOptionPane.showConfirmDialog(null,"Player vs PC hòa nhau\nNew Game?","",JOptionPane.YES_NO_OPTION);
                if( option == JOptionPane.YES_OPTION){
                    this.dispose();
                    new caro().setVisible(true);
                }
                else System.exit(0);
            }
        }
        else{
            if( kq == 10){
                for(int i = 0; i < 3; i++){
                   if( (bc.banco[i][0] == 10) && (bc.banco[i][1] == 10) && (bc.banco[i][2] == 10)) {
                        btn[i][0].setIcon(X1);
                        btn[i][1].setIcon(X1);
                        btn[i][2].setIcon(X1);
                        break;
                    }
                    if((bc.banco[0][i] == 10) && (bc.banco[1][i] == 10) && (bc.banco[2][i] == 10)) {
                        btn[0][i].setIcon(X1);
                        btn[1][i].setIcon(X1);
                        btn[2][i].setIcon(X1);
                        break;
                    }
                } 
                if ((bc.banco[0][0] == 10) && (bc.banco[1][1] == 10) && (bc.banco[2][2] == 10)) {
                    btn[0][0].setIcon(X1);
                    btn[1][1].setIcon(X1);
                    btn[2][2].setIcon(X1);
                }
                if ((bc.banco[2][0] == 10) && (bc.banco[1][1] == 10) && (bc.banco[0][2] == 10)) {
                    btn[2][0].setIcon(X1);
                    btn[1][1].setIcon(X1);
                    btn[0][2].setIcon(X1);
                }
                int option = JOptionPane.showConfirmDialog(null,"Player thắng\nNew Game?","",JOptionPane.YES_NO_OPTION);
                if( option == JOptionPane.YES_OPTION){
                    this.dispose();
                    new caro().setVisible(true);
                }
                else System.exit(0);
            }
            else{
               for(int i = 0; i < 3; i++){
                   if( (bc.banco[i][0] == -10) && (bc.banco[i][1] == -10) && (bc.banco[i][2] == -10)) {
                        btn[i][0].setIcon(O1);
                        btn[i][1].setIcon(O1);
                        btn[i][2].setIcon(O1);
                        break;
                    }
                    if((bc.banco[0][i] == -10) && (bc.banco[1][i] == -10) && (bc.banco[2][i] == -10)) {
                        btn[0][i].setIcon(O1);
                        btn[1][i].setIcon(O1);
                        btn[2][i].setIcon(O1);
                        break;
                    }
                } 
                if ((bc.banco[0][0] == -10) && (bc.banco[1][1] == -10) && (bc.banco[2][2] == -10)) {
                    btn[0][0].setIcon(O1);
                    btn[1][1].setIcon(O1);
                    btn[2][2].setIcon(O1);
                }
                if ((bc.banco[2][0] == -10) && (bc.banco[1][1] == -10) && (bc.banco[0][2] == -10)) {
                    btn[2][0].setIcon(O1);
                    btn[1][1].setIcon(O1);
                    btn[0][2].setIcon(O1);
                }
                int option = JOptionPane.showConfirmDialog(null,"PC thắng\nNew Game?","",JOptionPane.YES_NO_OPTION);
                if( option == JOptionPane.YES_OPTION){
                    this.dispose();
                    new caro().setVisible(true);
                }
                else System.exit(0);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
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
                        .addComponent(jButton1)
                        .addGap(0, 227, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
        new caro().setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

   
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
            java.util.logging.Logger.getLogger(caro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(caro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(caro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(caro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new caro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
