package br.com.jogodavelha.view;

import br.com.jogodavelha.entity.Log;
import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class UltimaRodada extends AbstractForm {

    private static final long serialVersionUID = 1L;

    private Image image;
    private List<Log> lista;
    public DefaultListModel model;

    public UltimaRodada() {
        initComponents();
    }
    
    public UltimaRodada(List<Log> lista) {
        initComponents();
        this.lista = lista;
        model = new DefaultListModel();
        criarImagemX();
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        setarJogada();
                    }
                },
                500
        );        
        
    }
    
    private void criarImagemX() {
        try {
            image = ImageIO.read(getClass().getResource("/imagens/x.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    private void setarJogada() {
        int contador = 1;
        for (Log item : lista) {
            int linha = item.getLinha();
            int coluna = item.getColuna();
            
            if (linha == 0 && coluna == 0) {
                l0c0.setText(null);
                l0c0.setIcon(new ImageIcon(image));
            } else if (linha == 0 && coluna == 1) {
                l0c1.setText(null);
                l0c1.setIcon(new ImageIcon(image));
            } else if (linha == 0 && coluna == 2) {
                l0c2.setText(null);
                l0c2.setIcon(new ImageIcon(image));
            } else if (linha == 1 && coluna == 0) {
                l1c0.setText(null);
                l1c0.setIcon(new ImageIcon(image));
            } else if (linha == 1 && coluna == 1) {
                l1c1.setText(null);
                l1c1.setIcon(new ImageIcon(image));
            } else if (linha == 1 && coluna == 2) {
                l1c2.setText(null);
                l1c2.setIcon(new ImageIcon(image));
            } else if (linha == 2 && coluna == 0) {
                l2c0.setText(null);
                l2c0.setIcon(new ImageIcon(image));
            } else if (linha == 2 && coluna == 1) {
                l2c1.setText(null);
                l2c1.setIcon(new ImageIcon(image));
            } else if (linha == 2 && coluna == 2) {
                l2c2.setText(null);
                l2c2.setIcon(new ImageIcon(image));
            }
            
            model.addElement("Jogada "+contador+": "
                    +converterDataParaFormatoBrasileiroComHorario(item.getData()));
            jList1.setModel(model);
            contador++;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(UltimaRodada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static String converterDataParaFormatoBrasileiroComHorario(Date data) {
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return mdyFormat.format(data);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        l0c1 = new javax.swing.JButton();
        l0c2 = new javax.swing.JButton();
        l1c0 = new javax.swing.JButton();
        l1c1 = new javax.swing.JButton();
        l1c2 = new javax.swing.JButton();
        l2c0 = new javax.swing.JButton();
        l2c1 = new javax.swing.JButton();
        l0c0 = new javax.swing.JButton();
        l2c2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jogo da Velha - By Matrix");
        setIconImage(icon);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        l0c1.setText("-");
        l0c1.setBorder(null);
        l0c1.setBorderPainted(false);
        l0c1.setContentAreaFilled(false);
        l0c1.setDefaultCapable(false);
        l0c1.setFocusPainted(false);
        l0c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l0c1ActionPerformed(evt);
            }
        });

        l0c2.setText("-");
        l0c2.setBorder(null);
        l0c2.setBorderPainted(false);
        l0c2.setContentAreaFilled(false);
        l0c2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        l0c2.setDefaultCapable(false);
        l0c2.setFocusPainted(false);
        l0c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l0c2ActionPerformed(evt);
            }
        });

        l1c0.setText("-");
        l1c0.setBorder(null);
        l1c0.setBorderPainted(false);
        l1c0.setContentAreaFilled(false);
        l1c0.setDefaultCapable(false);
        l1c0.setFocusPainted(false);
        l1c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l1c0ActionPerformed(evt);
            }
        });

        l1c1.setText("-");
        l1c1.setBorder(null);
        l1c1.setBorderPainted(false);
        l1c1.setContentAreaFilled(false);
        l1c1.setDefaultCapable(false);
        l1c1.setFocusPainted(false);
        l1c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l1c1ActionPerformed(evt);
            }
        });

        l1c2.setText("-");
        l1c2.setBorder(null);
        l1c2.setBorderPainted(false);
        l1c2.setContentAreaFilled(false);
        l1c2.setDefaultCapable(false);
        l1c2.setFocusPainted(false);
        l1c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l1c2ActionPerformed(evt);
            }
        });

        l2c0.setText("-");
        l2c0.setBorder(null);
        l2c0.setBorderPainted(false);
        l2c0.setContentAreaFilled(false);
        l2c0.setDefaultCapable(false);
        l2c0.setFocusPainted(false);
        l2c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l2c0ActionPerformed(evt);
            }
        });

        l2c1.setText("-");
        l2c1.setBorder(null);
        l2c1.setBorderPainted(false);
        l2c1.setContentAreaFilled(false);
        l2c1.setDefaultCapable(false);
        l2c1.setFocusPainted(false);
        l2c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l2c1ActionPerformed(evt);
            }
        });

        l0c0.setText("-");
        l0c0.setBorder(null);
        l0c0.setBorderPainted(false);
        l0c0.setContentAreaFilled(false);
        l0c0.setDefaultCapable(false);
        l0c0.setFocusPainted(false);
        l0c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l0c0ActionPerformed(evt);
            }
        });

        l2c2.setText("-");
        l2c2.setBorder(null);
        l2c2.setBorderPainted(false);
        l2c2.setContentAreaFilled(false);
        l2c2.setDefaultCapable(false);
        l2c2.setFocusPainted(false);
        l2c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l2c2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(l1c0, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l1c1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(l0c0, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l0c1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l0c2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(l2c0, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l2c1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l2c2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l0c1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l0c2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l0c0, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l1c0, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l1c1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l2c0, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l2c1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l2c2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(498, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(229, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(13, 13, 13)))
        );

        setSize(new java.awt.Dimension(736, 338));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void l0c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l0c1ActionPerformed

    }//GEN-LAST:event_l0c1ActionPerformed

    private void l0c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l0c2ActionPerformed

    }//GEN-LAST:event_l0c2ActionPerformed

    private void l1c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1c0ActionPerformed

    }//GEN-LAST:event_l1c0ActionPerformed

    private void l1c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1c1ActionPerformed

    }//GEN-LAST:event_l1c1ActionPerformed

    private void l1c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1c2ActionPerformed

    }//GEN-LAST:event_l1c2ActionPerformed

    private void l2c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l2c0ActionPerformed

    }//GEN-LAST:event_l2c0ActionPerformed

    private void l2c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l2c1ActionPerformed

    }//GEN-LAST:event_l2c1ActionPerformed

    private void l0c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l0c0ActionPerformed

    }//GEN-LAST:event_l0c0ActionPerformed

    private void l2c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l2c2ActionPerformed

    }//GEN-LAST:event_l2c2ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UltimaRodada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new UltimaRodada().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton l0c0;
    private javax.swing.JButton l0c1;
    private javax.swing.JButton l0c2;
    private javax.swing.JButton l1c0;
    private javax.swing.JButton l1c1;
    private javax.swing.JButton l1c2;
    private javax.swing.JButton l2c0;
    private javax.swing.JButton l2c1;
    private javax.swing.JButton l2c2;
    // End of variables declaration//GEN-END:variables
}
