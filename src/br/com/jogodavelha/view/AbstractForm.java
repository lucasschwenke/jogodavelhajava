package br.com.jogodavelha.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public abstract class AbstractForm extends javax.swing.JFrame {
    
    private static final long serialVersionUID = 1L;
    
    protected Image icon;
    
    protected AbstractForm() {
        super();
        URL url = this.getClass().getResource("/imagens/icon.png");
        icon = Toolkit.getDefaultToolkit().getImage(url); //troca o icone.
    }
    
}
