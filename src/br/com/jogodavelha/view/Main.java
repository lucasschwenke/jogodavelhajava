package br.com.jogodavelha.view;

import br.com.jogodavelha.common.Mensagens;
import br.com.jogodavelha.controller.JogadorController;
import br.com.jogodavelha.controller.LogController;
import br.com.jogodavelha.entity.Jogador;
import br.com.jogodavelha.entity.Log;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.List;

public class Main extends AbstractForm {

    private static final long serialVersionUID = 1L;
    private Media track;
    private MediaPlayer mediaPlayer;
    private String song;
    private final Ranking ranking;
    private UltimaRodada rodada;
    private Timer time;

    private ImageIcon iconeXau;
    private ImageIcon iconeLike;

    public Main() {
        initComponents();
        lblThug.setVisible(false);
        lblThug1.setVisible(false);
        ranking = new Ranking();
        iconeXau = new ImageIcon(getClass().getResource("/imagens/xau.png"));
        iconeLike = new ImageIcon(getClass().getResource("/imagens/social16.png"));
        JFXPanel fxPanel = new JFXPanel();
        song = getClass().getResource("/sons/turn.mp3").toString();
        Thread thread = new Thread() {
            @Override
            public void run() {
                track = new Media(song);
                mediaPlayer = new MediaPlayer(track);
                mediaPlayer.play();
            }
        };
        thread.start();

        agendarTempoParaMudarCor();
        mudarImagemThug();
    }

    public final void agendarTempoParaMudarCor() {
        long tempo = (1000 * 1);

        if (time == null) {
            time = new Timer();
            TimerTask tarefa = new TimerTask() {

                @Override
                public void run() {
                    try {
                        trocarCor();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            time.scheduleAtFixedRate(tarefa, tempo, tempo);
        }

    }

    public final void mudarImagemThug() {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        lblThug.setVisible(true);
                        lblThug1.setVisible(true);
                    }
                },
                20100
        );

    }

    public void trocarCor() {
        if (jLabel1.getForeground() == Color.BLACK) {
            jLabel1.setForeground(Color.RED);
        } else if (jLabel1.getForeground() == Color.RED) {
            jLabel1.setForeground(Color.BLUE);
        } else if (jLabel1.getForeground() == Color.BLUE) {
            jLabel1.setForeground(Color.BLACK);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblThug = new javax.swing.JLabel();
        lblThug1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNovoJogo = new javax.swing.JButton();
        btnRanking = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnSobre = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha - By Matrix");
        setIconImage(icon);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("orange juice", 1, 28)); // NOI18N
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setText("JOGO DA VELHA - BY MATRIX");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        lblThug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/thuglife1.png"))); // NOI18N
        getContentPane().add(lblThug, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        lblThug1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/thuglife1.png"))); // NOI18N
        getContentPane().add(lblThug1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNovoJogo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNovoJogo.setText("<html><img src="+getClass().getResource("/imagens/controller.png")+"'><br />"
            + "Novo Jogo</html>");
        btnNovoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoJogoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovoJogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 114, 100));

        btnRanking.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRanking.setText("<html><img src="+getClass().getResource("/imagens/line37.png")+"'><br />"
            + "Ranking</html>");
        btnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingActionPerformed(evt);
            }
        });
        jPanel1.add(btnRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 13, 114, 100));

        btnHistory.setText("<html><img src="+getClass().getResource("/imagens/history.png")+"'><br />"
            + "Última partida</html>");
        btnHistory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });
        jPanel1.add(btnHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 13, 114, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 66, 380, 130));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel2.setText("Desenvolvido por Leonardo Soldan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Player"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/play.png"))); // NOI18N
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        jPanel2.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pause.png"))); // NOI18N
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });
        jPanel2.add(btnPause, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/stop.png"))); // NOI18N
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        jPanel2.add(btnStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 170, 60));

        btnSobre.setText("<html><img src="+getClass().getResource("/imagens/multiple25.png")+"'><br />"
            + "Sobre</html>");
        btnSobre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobreActionPerformed(evt);
            }
        });
        getContentPane().add(btnSobre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 90, 50));

        setSize(new java.awt.Dimension(651, 303));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoJogoActionPerformed
        selecionarJogador();
    }//GEN-LAST:event_btnNovoJogoActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        if (mediaPlayer.isMute()) {
            mudarImagemThug();
        }
        mediaPlayer.play();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        mediaPlayer.pause();
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        mediaPlayer.stop();
        lblThug.setVisible(false);
        lblThug1.setVisible(false);
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        if (!ranking.isVisible()) {
            ranking.setVisible(true);
        } else {
            ranking.requestFocus();
        }
    }//GEN-LAST:event_btnRankingActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        JOptionPane.showMessageDialog(null, "Obrigado por jogar o jogo da velha by Matrix! XAU XAU!",
                Mensagens.NOME_DO_PROGRAMA, JOptionPane.INFORMATION_MESSAGE, iconeXau);
    }//GEN-LAST:event_formWindowClosing

    private void btnSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobreActionPerformed
        JOptionPane.showMessageDialog(null, "Desenvolvido por: Leonardo Soldan (MATRIX)\n"
                + "Com a ajuda de Lucas Schwenke\n\n"
                + "Versão: 1.0\n"
                + "#THUGLIFE", Mensagens.NOME_DO_PROGRAMA, JOptionPane.INFORMATION_MESSAGE, iconeLike);
    }//GEN-LAST:event_btnSobreActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        historico();
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void historico() {
        String jogador;
        do {
            jogador
                    = JOptionPane.showInputDialog(null, "Qual jogador deseja visualizar as suas últimas jogadas?",
                            Mensagens.NOME_DO_PROGRAMA, JOptionPane.QUESTION_MESSAGE);
        } while ("".equals(jogador));

        if (jogador != null) {
            LogController controller = new LogController();
            List<Log> lista = controller.pegarHistorico(jogador);
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Este jogador não possui uma última partida!",
                        Mensagens.NOME_DO_PROGRAMA, JOptionPane.INFORMATION_MESSAGE);
            } else {
                rodada = new UltimaRodada(lista);
                rodada.setVisible(true);
            }
        }
    }

    private void selecionarJogador() {
        String jogador;
        do {
            jogador
                    = JOptionPane.showInputDialog(null, "Digite seu apelido:", Mensagens.NOME_DO_PROGRAMA,
                            JOptionPane.QUESTION_MESSAGE);
        } while ("".equals(jogador));

        if (jogador != null) {
            JogadorController controller = new JogadorController();
            Jogador j = new Jogador();
            j.setApelido(jogador);
            controller.salvarJogador(j);
            Jogo jogo = new Jogo(j);
            jogo.setVisible(true);
            mediaPlayer.dispose();
            this.dispose();
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnNovoJogo;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRanking;
    private javax.swing.JButton btnSobre;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblThug;
    private javax.swing.JLabel lblThug1;
    // End of variables declaration//GEN-END:variables

}
