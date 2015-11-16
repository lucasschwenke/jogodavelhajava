package br.com.jogodavelha.view;

import br.com.jogodavelha.common.Mensagens;
import br.com.jogodavelha.controller.LogController;
import br.com.jogodavelha.controller.RankingController;
import br.com.jogodavelha.entity.Jogador;
import br.com.jogodavelha.entity.Log;
import br.com.jogodavelha.entity.Ranking;
import java.awt.Image;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Jogo extends AbstractForm {

    private static final long serialVersionUID = 1L;
    private static final int JOGADOR_X = 1;
    private static final int JOGADOR_O = 2;
    private int vez;
    private int rodada;

    private static int tabuleiro[][];

    private Jogador jogador;
    private int vitoriasSeguidas;

    private Media track;
    private MediaPlayer mediaPlayer;
    private String song;
    private ImageIcon iconeVitoria;
    private ImageIcon iconeVelha;
    private ImageIcon iconeDerrota;
    
    private LogController logController;

    public Jogo() {
        initComponents();
    }

    public Jogo(Jogador jogador) {
        JFXPanel fxPanel = new JFXPanel();
        logController = new LogController();
        this.jogador = jogador;
        rodada = 0;
        vitoriasSeguidas = 0;
        tabuleiro = new int[3][3];
        vez = JOGADOR_X;
        iconeVitoria = new ImageIcon(getClass().getResource("/imagens/thuglife1.png"));
        iconeVelha = new ImageIcon(getClass().getResource("/imagens/velha.png"));
        iconeDerrota = new ImageIcon(getClass().getResource("/imagens/hue.png"));
        initComponents();
        zerarTabuleiro();
        setarNomeDoJogador();
        setarVitoriasSeguidas();
        setarRodada();

    }
    
    private void deletarHistorico() {
        logController.limparHistorico(jogador);
    }

    private void zerarTabuleiro() {
        reiniciarBotoes();
        if (rodada != 0) {
            rodada = 0;
            setarRodada();
        }
        vez = JOGADOR_X;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = 0;
            }
        }
        musicaFundo();
        mediaPlayer.play();
        deletarHistorico();
    }

    private void reiniciarBotoes() {
        l0c0.setText("-");
        l0c0.setIcon(null);
        l0c0.setEnabled(true);
        l0c1.setText("-");
        l0c1.setIcon(null);
        l0c1.setEnabled(true);
        l0c2.setText("-");
        l0c2.setIcon(null);
        l0c2.setEnabled(true);
        l1c0.setText("-");
        l1c0.setIcon(null);
        l1c0.setEnabled(true);
        l1c1.setText("-");
        l1c1.setIcon(null);
        l1c1.setEnabled(true);
        l1c2.setText("-");
        l1c2.setIcon(null);
        l1c2.setEnabled(true);
        l2c0.setText("-");
        l2c0.setIcon(null);
        l2c0.setEnabled(true);
        l2c1.setText("-");
        l2c1.setIcon(null);
        l2c1.setEnabled(true);
        l2c2.setText("-");
        l2c2.setIcon(null);
        l2c2.setEnabled(true);
    }

    private void setarNomeDoJogador() {
        txtJogador.setText(jogador.getApelido());
    }

    private void setarVitoriasSeguidas() {
        jLabel3.setText(String.valueOf(vitoriasSeguidas));
    }
    
    private void setarRodada() {
        jLabel5.setText(String.valueOf(rodada + 1));
    }

    private void vezDoComputador() {
        String botao = "";
        if (tabuleiro[0][0] == JOGADOR_X && tabuleiro[0][1] == JOGADOR_X && tabuleiro[0][2] == 0) {
            tabuleiro[0][2] = JOGADOR_O;
            botao = "l0c2";
        } else if (tabuleiro[0][0] == JOGADOR_X && tabuleiro[0][2] == JOGADOR_X && tabuleiro[0][1] == 0) {
            tabuleiro[0][1] = JOGADOR_O;
            botao = "l0c1";
        } else if (tabuleiro[0][1] == JOGADOR_X && tabuleiro[0][2] == JOGADOR_X && tabuleiro[0][0] == 0) {
            tabuleiro[0][0] = JOGADOR_O;
            botao = "l0c0";
        } else if (tabuleiro[1][0] == JOGADOR_X && tabuleiro[1][1] == JOGADOR_X && tabuleiro[1][2] == 0) {
            tabuleiro[1][2] = JOGADOR_O;
            botao = "l1c2";
        } else if (tabuleiro[1][0] == JOGADOR_X && tabuleiro[1][2] == JOGADOR_X && tabuleiro[1][1] == 0) {
            tabuleiro[1][1] = JOGADOR_O;
            botao = "l1c1";
        } else if (tabuleiro[1][1] == JOGADOR_X && tabuleiro[1][2] == JOGADOR_X && tabuleiro[1][0] == 0) {
            tabuleiro[1][0] = JOGADOR_O;
            botao = "l1c0";
        } else if (tabuleiro[2][0] == JOGADOR_X && tabuleiro[2][1] == JOGADOR_X && tabuleiro[2][2] == 0) {
            tabuleiro[2][2] = JOGADOR_O;
            botao = "l2c2";
        } else if (tabuleiro[2][0] == JOGADOR_X && tabuleiro[2][2] == JOGADOR_X && tabuleiro[2][1] == 0) {
            tabuleiro[2][1] = JOGADOR_O;
            botao = "l2c1";
        } else if (tabuleiro[2][1] == JOGADOR_X && tabuleiro[2][2] == JOGADOR_X && tabuleiro[2][0] == 0) {
            tabuleiro[2][0] = JOGADOR_O;
            botao = "l2c0";
        } else if (tabuleiro[0][0] == JOGADOR_X && tabuleiro[1][0] == JOGADOR_X && tabuleiro[2][0] == 0) {
            tabuleiro[2][0] = JOGADOR_O;
            botao = "l2c0";
        } else if (tabuleiro[0][0] == JOGADOR_X && tabuleiro[2][0] == JOGADOR_X && tabuleiro[1][0] == 0) {
            tabuleiro[1][0] = JOGADOR_O;
            botao = "l1c0";
        } else if (tabuleiro[1][0] == JOGADOR_X && tabuleiro[2][0] == JOGADOR_X && tabuleiro[0][0] == 0) {
            tabuleiro[0][0] = JOGADOR_O;
            botao = "l0c0";
        } else if (tabuleiro[0][1] == JOGADOR_X && tabuleiro[1][1] == JOGADOR_X && tabuleiro[2][1] == 0) {
            tabuleiro[2][1] = JOGADOR_O;
            botao = "l2c1";
        } else if (tabuleiro[1][1] == JOGADOR_X && tabuleiro[2][1] == JOGADOR_X && tabuleiro[0][1] == 0) {
            tabuleiro[0][1] = JOGADOR_O;
            botao = "l0c1";
        } else if (tabuleiro[0][1] == JOGADOR_X && tabuleiro[2][1] == JOGADOR_X && tabuleiro[1][1] == 0) {
            tabuleiro[1][1] = JOGADOR_O;
            botao = "l1c1";
        } else if (tabuleiro[0][2] == JOGADOR_X && tabuleiro[1][2] == JOGADOR_X && tabuleiro[2][2] == 0) {
            tabuleiro[2][2] = JOGADOR_O;
            botao = "l2c2";
        } else if (tabuleiro[1][2] == JOGADOR_X && tabuleiro[2][2] == JOGADOR_X && tabuleiro[0][2] == 0) {
            tabuleiro[0][2] = JOGADOR_O;
            botao = "l0c2";
        } else if (tabuleiro[0][2] == JOGADOR_X && tabuleiro[2][2] == JOGADOR_X && tabuleiro[1][2] == 0) {
            tabuleiro[1][2] = JOGADOR_O;
            botao = "l1c2";
        } else if (tabuleiro[0][0] == JOGADOR_X && tabuleiro[1][1] == JOGADOR_X && tabuleiro[2][2] == 0) {
            tabuleiro[2][2] = JOGADOR_O;
            botao = "l2c2";
        } else if (tabuleiro[0][0] == JOGADOR_X && tabuleiro[2][2] == JOGADOR_X && tabuleiro[1][1] == 0) {
            tabuleiro[1][1] = JOGADOR_O;
            botao = "l1c1";
        } else if (tabuleiro[1][1] == JOGADOR_X && tabuleiro[2][2] == JOGADOR_X && tabuleiro[0][0] == 0) {
            tabuleiro[0][0] = JOGADOR_O;
            botao = "l0c0";
        } else if (tabuleiro[0][2] == JOGADOR_X && tabuleiro[1][1] == JOGADOR_X && tabuleiro[2][0] == 0) {
            tabuleiro[2][0] = JOGADOR_O;
            botao = "l2c0";
        } else if (tabuleiro[0][2] == JOGADOR_X && tabuleiro[2][0] == JOGADOR_X && tabuleiro[1][1] == 0) {
            tabuleiro[1][1] = JOGADOR_O;
            botao = "l1c1";
        } else if (tabuleiro[1][1] == JOGADOR_X && tabuleiro[2][0] == JOGADOR_X && tabuleiro[0][2] == 0) {
            tabuleiro[0][2] = JOGADOR_O;
            botao = "l0c2";
        } else if (tabuleiro[0][0] == 0) {
            tabuleiro[0][0] = JOGADOR_O;
            botao = "l0c0";
        } else if (tabuleiro[0][1] == 0) {
            tabuleiro[0][1] = JOGADOR_O;
            botao = "l0c1";
        } else if (tabuleiro[0][2] == 0) {
            tabuleiro[0][2] = JOGADOR_O;
            botao = "l0c2";
        } else if (tabuleiro[1][0] == 0) {
            tabuleiro[1][0] = JOGADOR_O;
            botao = "l1c0";
        } else if (tabuleiro[1][1] == 0) {
            tabuleiro[1][1] = JOGADOR_O;
            botao = "l1c1";
        } else if (tabuleiro[1][2] == 0) {
            tabuleiro[1][2] = JOGADOR_O;
            botao = "l1c2";
        } else if (tabuleiro[2][0] == 0) {
            tabuleiro[2][0] = JOGADOR_O;
            botao = "l2c0";
        } else if (tabuleiro[2][1] == 0) {
            tabuleiro[2][1] = JOGADOR_O;
            botao = "l2c1";
        } else if (tabuleiro[2][2] == 0) {
            tabuleiro[2][2] = JOGADOR_O;
            botao = "l2c2";
        }

        Field field;
        JButton btn;
        try {
            field = Jogo.class.getDeclaredField(botao);
            btn = (JButton) field.get(this);
            Image img = setarImagemO();
            btn.setIcon(new ImageIcon(img));
            btn.setText("");
            btn.setEnabled(false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (ganhou(JOGADOR_O)) {
            mediaPlayer.stop();
            musicaDerrota();
            mediaPlayer.play();
            JOptionPane.showMessageDialog(null, "QUE PENA, VOCÊ PERDEU!!!", Mensagens.NOME_DO_PROGRAMA, JOptionPane.INFORMATION_MESSAGE, iconeDerrota);
            mediaPlayer.stop();
            salvarRank();
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?",
                    Mensagens.NOME_DO_PROGRAMA, JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                vitoriasSeguidas = 0;
                setarVitoriasSeguidas();
                zerarTabuleiro();
            } else {
                Main main = new Main();
                main.setVisible(true);
                this.dispose();
            }
        } else if (verificaSeDeuVelha()) {
            mediaPlayer.stop();
            musicaVelha();
            mediaPlayer.play();
            JOptionPane.showMessageDialog(null, "DEU VELHA!!!", Mensagens.NOME_DO_PROGRAMA, JOptionPane.INFORMATION_MESSAGE, iconeVelha);
            mediaPlayer.stop();
            salvarRank();
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?",
                    Mensagens.NOME_DO_PROGRAMA, JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                vitoriasSeguidas = 0;
                setarVitoriasSeguidas();
                zerarTabuleiro();
            } else {
                Main main = new Main();
                main.setVisible(true);
                this.dispose();
            }
        } else {
            rodada++;
            setarRodada();            
        }

    }

    private void fazerJogada(int linha, int coluna, JButton botao) {
        tabuleiro[linha][coluna] = vez;
        Log log = new Log();
        log.setLinha(linha);
        log.setColuna(coluna);
        log.setData(new Date());
        log.setJogador(jogador);
        salvarLog(log);
        Image img = setarImagemX();
        botao.setIcon(new ImageIcon(img));
        botao.setText("");
        botao.setEnabled(false);

        if (ganhou(JOGADOR_X)) {
            vitoriasSeguidas++;
            setarVitoriasSeguidas();
            mediaPlayer.stop();
            musicaVitoria();
            mediaPlayer.play();
            JOptionPane.showMessageDialog(null, "PARABÉNS VOCÊ GANHOU!!! #THUGLIFE", Mensagens.NOME_DO_PROGRAMA, JOptionPane.INFORMATION_MESSAGE, iconeVitoria);
            mediaPlayer.stop();
            zerarTabuleiro();
        } else if (verificaSeDeuVelha()) {
            mediaPlayer.stop();
            musicaVelha();
            mediaPlayer.play();
            JOptionPane.showMessageDialog(null, "DEU VELHA!!!", Mensagens.NOME_DO_PROGRAMA, JOptionPane.INFORMATION_MESSAGE, iconeVelha);
            mediaPlayer.stop();
            salvarRank();
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?",
                    Mensagens.NOME_DO_PROGRAMA, JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                vitoriasSeguidas = 0;
                setarVitoriasSeguidas();
                zerarTabuleiro();
            } else {
                Main main = new Main();
                main.setVisible(true);
                this.dispose();
            }
        } else {
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            vezDoComputador();
                        }
                    },
                    500
            );
            rodada++;
            setarRodada();
        }

    }
    
    private void salvarLog(Log log) {
        logController.salvarLog(log);
    }
    
    private void salvarRank() {
        Ranking ranking = new Ranking();
        ranking.setJogos(vitoriasSeguidas);
        ranking.setJogador(jogador);
        RankingController controller = new RankingController();
        if (controller.salvarRanking(ranking)) {
            JOptionPane.showMessageDialog(null, "Ranking atualizado!!!", Mensagens.NOME_DO_PROGRAMA, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean verificaSeDeuVelha() {
        return rodada >= 8;
    }

    private void musicaVitoria() {
        song = getClass().getResource("/sons/turn_corte.mp3").toString();
        track = new Media(song);
        mediaPlayer = new MediaPlayer(track);
    }

    private void musicaDerrota() {
        song = getClass().getResource("/sons/gargalhada.mp3").toString();
        track = new Media(song);
        mediaPlayer = new MediaPlayer(track);
    }

    private void musicaVelha() {
        song = getClass().getResource("/sons/BruxaRiso1.mp3").toString();
        track = new Media(song);
        mediaPlayer = new MediaPlayer(track);
    }

    private void musicaFundo() {
        song = getClass().getResource("/sons/fundo.mp3").toString();
        track = new Media(song);
        mediaPlayer = new MediaPlayer(track);
    }

    private boolean ganhou(int jogador) {
        boolean ganhou = false;

        if (tabuleiro[0][0] == jogador && tabuleiro[0][1] == jogador && tabuleiro[0][2] == jogador) {
            ganhou = true;
        } else if (tabuleiro[1][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[1][2] == jogador) {
            ganhou = true;
        } else if (tabuleiro[2][0] == jogador && tabuleiro[2][1] == jogador && tabuleiro[2][2] == jogador) {
            ganhou = true;
        } else if (tabuleiro[0][0] == jogador && tabuleiro[1][0] == jogador && tabuleiro[2][0] == jogador) {
            ganhou = true;
        } else if (tabuleiro[0][1] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][1] == jogador) {
            ganhou = true;
        } else if (tabuleiro[0][2] == jogador && tabuleiro[1][2] == jogador && tabuleiro[2][2] == jogador) {
            ganhou = true;
        } else if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            ganhou = true;
        } else if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            ganhou = true;
        }

        return ganhou;
    }

    private Image setarImagemX() {
        vez = JOGADOR_O;

        try {
            return ImageIO.read(getClass().getResource("/imagens/x.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Image setarImagemO() {
        vez = JOGADOR_X;

        try {
            return ImageIO.read(getClass().getResource("/imagens/circulo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtJogador = new javax.swing.JLabel("jLabel2", SwingConstants.CENTER);
        jLabel2 = new javax.swing.JLabel("VITORIAS SEGUIDAS", SwingConstants.CENTER);
        jLabel3 = new javax.swing.JLabel("jLabel3", SwingConstants.CENTER);
        jLabel4 = new javax.swing.JLabel("RODADA ATUAL", SwingConstants.CENTER);
        jLabel5 = new javax.swing.JLabel("jLabel5", SwingConstants.CENTER);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha - By Matrix");
        setIconImage(icon);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("JOGADOR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        txtJogador.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtJogador.setForeground(new java.awt.Color(255, 0, 0));
        txtJogador.setText("jLabel2");
        txtJogador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txtJogador, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 30, 140, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("VITORIAS SEGUIDAS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 110, 140, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("RODADA ATUAL");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 150, -1));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(674, 334));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void l0c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l0c2ActionPerformed
        fazerJogada(0, 2, l0c2);
    }//GEN-LAST:event_l0c2ActionPerformed

    private void l0c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l0c0ActionPerformed
        fazerJogada(0, 0, l0c0);
    }//GEN-LAST:event_l0c0ActionPerformed

    private void l0c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l0c1ActionPerformed
        fazerJogada(0, 1, l0c1);
    }//GEN-LAST:event_l0c1ActionPerformed

    private void l1c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1c0ActionPerformed
        fazerJogada(1, 0, l1c0);
    }//GEN-LAST:event_l1c0ActionPerformed

    private void l1c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1c1ActionPerformed
        fazerJogada(1, 1, l1c1);
    }//GEN-LAST:event_l1c1ActionPerformed

    private void l1c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1c2ActionPerformed
        fazerJogada(1, 2, l1c2);
    }//GEN-LAST:event_l1c2ActionPerformed

    private void l2c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l2c0ActionPerformed
        fazerJogada(2, 0, l2c0);
    }//GEN-LAST:event_l2c0ActionPerformed

    private void l2c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l2c1ActionPerformed
        fazerJogada(2, 1, l2c1);
    }//GEN-LAST:event_l2c1ActionPerformed

    private void l2c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l2c2ActionPerformed
        fazerJogada(2, 2, l2c2);
    }//GEN-LAST:event_l2c2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Jogo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton l0c0;
    private javax.swing.JButton l0c1;
    private javax.swing.JButton l0c2;
    private javax.swing.JButton l1c0;
    private javax.swing.JButton l1c1;
    private javax.swing.JButton l1c2;
    private javax.swing.JButton l2c0;
    private javax.swing.JButton l2c1;
    private javax.swing.JButton l2c2;
    private javax.swing.JLabel txtJogador;
    // End of variables declaration//GEN-END:variables
}
