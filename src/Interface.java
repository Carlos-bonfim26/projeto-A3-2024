/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.util.Random;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Cassi
 */

public class Interface extends javax.swing.JFrame {
    private final Heroi heroi;
    private final Inimigo inimigo;
    private boolean turno;
    private int acaoinimigo;
    private int turnonumero = 1;
    private int exalta;
    private boolean defesa = false;
    Random random = new Random();

    
    
    ///////////////////////////////////String nome, int vida, int mana, int limitemana, int ataque, int defesa, int especial, int esquiva
    
    public Interface() {
        heroi = new Heroi("Cássio", 1000, 0,200, 20,10,100,10);
        inimigo = new Inimigo("Carioca", 1000,0,200, 40, 50,100,20);
        initComponents();
        barravida.setMaximum(heroi.getVida());
        barramana.setMaximum(heroi.getLimitemana());
        barrarocklee.setMaximum(4);
        barrainimigovida.setMaximum(inimigo.getVida());
        barrainimigomana.setMaximum(inimigo.getLimitemana());
        textovidainimigo.setText("Vida: " + inimigo.getVida());
        textomanainimigo.setText("Mana: " + inimigo.getMana());
        textoturno.setText("Turno: " + turnonumero);
        atualizarstatus();
        turno = true;
}
   
    
    private void atualizarstatus() {
        textovida.setText("Vida: " + heroi.getVida());
        textomana.setText("Mana: " + heroi.getMana());
        barrainimigovida.setValue(inimigo.getVida());
        barrainimigomana.setValue(inimigo.getMana());
        textovidainimigo.setText("Vida: " + inimigo.getVida());
        textomanainimigo.setText("Mana: " + inimigo.getMana());
        if (heroi.getRocklee() == 4){
        textoataque.setText("Ataque: 10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");}
        else{textoataque.setText("Ataque: " + heroi.getAtaque());}
        textodefesa.setText("Defesa: " + heroi.getDefesa());
        textoesquiva.setText("Esquiva: " + heroi.getEsquiva()+ "%");
        barravida.setValue(heroi.getVida());
        barramana.setValue(heroi.getMana());
        barrarocklee.setValue(heroi.rocklee);
        heroi.AtualizarStatus();
        inimigo.AtualizarStatus();
        verificarEstadoJogo();
    }
        
    private void verificarEstadoJogo() {
            if (heroi.estaMorto() && inimigo.estaMorto()){
                try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    URI uri = new URI("https://youtu.be/NY_WGenAwYA?si=1bcOzS2bsxuEWY01");
                    desktop.browse(uri);
                }
            }
        } catch (IOException | URISyntaxException e) {
        }
}
            
            else if (heroi.estaMorto()){
                    try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    URI uri = new URI("https://www.youtube.com/shorts/jn17idNcdho");
                    desktop.browse(uri);
                }
            }
        } catch (IOException | URISyntaxException e) {
        }
}
        
                    else if (inimigo.estaMorto()){{
            try {
            // Verifica se o Desktop é suportado no sistema
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                // Verifica se a operação de abrir o navegador é suportada
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    URI uri = new URI("https://youtu.be/xvFZjo5PgG0?si=m3AeudUIffTHcfhH");
                    desktop.browse(uri);
                }
            }
        } catch (IOException | URISyntaxException e) {
        }
        }}}
        
    
    private void turnoinimigo() {
        turnonumero ++;
        textoturno.setText("Turno: " + turnonumero);
        heroi.dejavuTurno();
        acaoinimigo = random.nextInt(10);
        if (inimigo.getMana() >= 200){
            inimigo.atacar(heroi, inimigo.getAtaque()*10);
            inimigo.setMana(inimigo.getMana()-200);
            atualizarstatus();
        }
        else{
        switch (acaoinimigo){
            
            case 0:
                if (inimigo.getMana() >= 50){
                    inimigo.atacar(heroi, inimigo.getAtaque()*5);
                    inimigo.setMana(inimigo.getMana()-50);
                    atualizarstatus();
                }
                else{
            textoacontecimentos.setText("''AAAAAAAAAA!'' - O inimigo ataca com força total! - " + inimigo.getAtaque()*2 + " de dano recebido." );
            inimigo.atacar(heroi, inimigo.getAtaque()*2);
            inimigo.aumentarMana(20);}
            atualizarstatus();
                break;
            case 1:
            textoacontecimentos.setText("''Toma chumbo!'' - O inimigo ataca usando seu revolver! - " + inimigo.getAtaque()*2 + " de dano recebido." );
            inimigo.atacar(heroi, inimigo.getAtaque()*2);
            atualizarstatus();
                break;
            case 2:
            textoacontecimentos.setText("''Olha o tijolinho!'' - O inimigo ataca com um tijolo! - " + inimigo.getAtaque() + " de dano recebido." );
            inimigo.atacar(heroi, inimigo.getAtaque());
            atualizarstatus();
                break;
            case 3:
            textoacontecimentos.setText("''Grito genérico de inimigo'' - O inimigo ataca com um ataque genérico! - " + (inimigo.getAtaque()-5) + " de dano recebido." );
            inimigo.atacar(heroi, inimigo.getAtaque()-5);
            inimigo.aumentarMana(10);
            atualizarstatus();
                break;
            case 4:
            textoacontecimentos.setText("''tá maluco menó!'' - O inimigo desfere um soco! - " + inimigo.getAtaque() + " de dano recebido." );
            inimigo.atacar(heroi, inimigo.getAtaque());
            inimigo.aumentarMana(5);
            atualizarstatus();
                break;
            case 5:
            textoacontecimentos.setText("O inimigo se conecta com a natureza! - Inimigo recupera 50 de mana." );
            inimigo.aumentarMana(50);
            atualizarstatus();
                break;
            case 6:
            textoacontecimentos.setText("O inimigo janta! - Inimigo recupera 30 de mana" );
            inimigo.aumentarMana(30);
            atualizarstatus();
                break;
            case 7:
            textoacontecimentos.setText("O inimigo aprecia a paisagem - Nada acontece" );
            atualizarstatus();
                break;
            case 8:
            textoacontecimentos.setText("O inimigo tropeça - " + inimigo.getAtaque() + " de dano a si mesmo." );
            inimigo.atacar(inimigo, inimigo.getAtaque());
            atualizarstatus();
                break;
            case 9:
            textoacontecimentos.setText("O inimigo ataca com força total! - " + inimigo.getAtaque() + " de dano recebido." );
            inimigo.atacar(heroi, inimigo.getAtaque());
            inimigo.aumentarMana(20);
            atualizarstatus();
                break;
            case 10:
            textoacontecimentos.setText("O inimigo ataca com força total! - " + inimigo.getAtaque() + " de dano recebido." );
            inimigo.atacar(heroi, inimigo.getAtaque());
            inimigo.aumentarMana(20);
            atualizarstatus();
                break;
            default:
                 
                System.out.println("Ação desconhecida do inimigo!");
                atualizarstatus();
                break;   
        }
        }
        
        turno = true;
    }


    ////CAMPOS NÃO EDITÁVEIS
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textomana = new javax.swing.JTextField();
        botaoataque = new javax.swing.JButton();
        botaodefesa = new javax.swing.JButton();
        botaoespecial2 = new javax.swing.JButton();
        barravida = new javax.swing.JProgressBar();
        textovida = new javax.swing.JTextField();
        barramana = new javax.swing.JProgressBar();
        textonomeinimigo = new javax.swing.JTextField();
        barrainimigomana = new javax.swing.JProgressBar();
        textoacontecimentos = new javax.swing.JTextField();
        botaomeditacao = new javax.swing.JButton();
        botaofinin = new javax.swing.JButton();
        botaoexaltasamba = new javax.swing.JButton();
        botaodejavu = new javax.swing.JButton();
        botaorocklee = new javax.swing.JButton();
        textopensamentos = new javax.swing.JTextField();
        botaoespecial1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        barrarocklee = new javax.swing.JProgressBar();
        textoataque = new javax.swing.JLabel();
        textodefesa = new javax.swing.JLabel();
        textoesquiva = new javax.swing.JLabel();
        textoturno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        textomanainimigo = new javax.swing.JLabel();
        barrainimigovida = new javax.swing.JProgressBar();
        textovidainimigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(740, 790));
        setResizable(false);
        getContentPane().setLayout(null);

        textomana.setEditable(false);
        textomana.setText("Mana");
        textomana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textomanaActionPerformed(evt);
            }
        });
        getContentPane().add(textomana);
        textomana.setBounds(40, 660, 86, 43);

        botaoataque.setText("Ataque");
        botaoataque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoataqueActionPerformed(evt);
            }
        });
        getContentPane().add(botaoataque);
        botaoataque.setBounds(610, 580, 72, 23);

        botaodefesa.setText("Defesa");
        botaodefesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaodefesaActionPerformed(evt);
            }
        });
        getContentPane().add(botaodefesa);
        botaodefesa.setBounds(520, 580, 72, 23);

        botaoespecial2.setText("Especial (200 mana)");
        botaoespecial2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoespecial2ActionPerformed(evt);
            }
        });
        getContentPane().add(botaoespecial2);
        botaoespecial2.setBounds(510, 620, 164, 77);

        barravida.setForeground(new java.awt.Color(51, 255, 51));
        getContentPane().add(barravida);
        barravida.setBounds(130, 620, 146, 21);

        textovida.setEditable(false);
        textovida.setText("Vida");
        getContentPane().add(textovida);
        textovida.setBounds(40, 610, 86, 43);
        getContentPane().add(barramana);
        barramana.setBounds(130, 670, 146, 21);

        textonomeinimigo.setEditable(false);
        textonomeinimigo.setText("Inimigo");
        textonomeinimigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textonomeinimigoActionPerformed(evt);
            }
        });
        getContentPane().add(textonomeinimigo);
        textonomeinimigo.setBounds(270, 90, 146, 35);

        barrainimigomana.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(barrainimigomana);
        barrainimigomana.setBounds(360, 70, 146, 18);

        textoacontecimentos.setEditable(false);
        textoacontecimentos.setText("acontecimentos");
        textoacontecimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoacontecimentosActionPerformed(evt);
            }
        });
        getContentPane().add(textoacontecimentos);
        textoacontecimentos.setBounds(40, 10, 644, 35);

        botaomeditacao.setText("Meditação");
        botaomeditacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaomeditacaoActionPerformed(evt);
            }
        });
        getContentPane().add(botaomeditacao);
        botaomeditacao.setBounds(420, 580, 86, 23);

        botaofinin.setText("Apertar o finin");
        botaofinin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaofininActionPerformed(evt);
            }
        });
        getContentPane().add(botaofinin);
        botaofinin.setBounds(40, 470, 106, 23);

        botaoexaltasamba.setText("Tocar exalta samba");
        botaoexaltasamba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoexaltasambaActionPerformed(evt);
            }
        });
        getContentPane().add(botaoexaltasamba);
        botaoexaltasamba.setBounds(160, 470, 150, 23);

        botaodejavu.setText("Ouvir Dejavu");
        botaodejavu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaodejavuActionPerformed(evt);
            }
        });
        getContentPane().add(botaodejavu);
        botaodejavu.setBounds(330, 470, 98, 23);

        botaorocklee.setText("Ver o AMV do Rock lee vs Gaara");
        botaorocklee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaorockleeActionPerformed(evt);
            }
        });
        getContentPane().add(botaorocklee);
        botaorocklee.setBounds(480, 460, 197, 36);

        textopensamentos.setEditable(false);
        textopensamentos.setText("Pensamentos");
        textopensamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textopensamentosActionPerformed(evt);
            }
        });
        getContentPane().add(textopensamentos);
        textopensamentos.setBounds(40, 410, 640, 40);

        botaoespecial1.setText("Especial (50 mana)");
        botaoespecial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoespecial1ActionPerformed(evt);
            }
        });
        getContentPane().add(botaoespecial1);
        botaoespecial1.setBounds(320, 640, 180, 50);

        jLabel1.setText("Passivas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 450, 70, 10);

        jLabel2.setText("Ações");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(510, 560, 37, 16);

        jLabel3.setText("Multiplicador ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(520, 510, 80, 16);

        barrarocklee.setForeground(new java.awt.Color(51, 255, 51));
        getContentPane().add(barrarocklee);
        barrarocklee.setBounds(480, 510, 197, 21);

        textoataque.setText("Ataque");
        getContentPane().add(textoataque);
        textoataque.setBounds(40, 540, 800, 16);

        textodefesa.setText("Defesa");
        getContentPane().add(textodefesa);
        textodefesa.setBounds(40, 560, 110, 16);

        textoesquiva.setText("Esquiva");
        getContentPane().add(textoesquiva);
        textoesquiva.setBounds(40, 580, 110, 16);

        textoturno.setText("Turno: ");
        getContentPane().add(textoturno);
        textoturno.setBounds(640, 50, 70, 16);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣥⣤⣾⠟⡛⠿⠿⣭⣻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⣿⣿⡟⣿⣽⡟⡏⢩⣦⡝⠋⢸⣶⠄⢲⡟⣿⣿⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⣿⣯⣷⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣌⡳⣜⢿⣿⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢀⡛⢌⢿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠄⠙⠌⣸⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⡿⠉⠉⠉⠉⢿⣿⣿⣿⠏⠉⠉⠉⠉⠉⠆⠄⠁⠄⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⡗⠫⠿⠆⠄⠸⢿⣿⣿⠂⠒⠲⡿⠛⠛⠂⠄⠄⢠⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⡛⣧⡔⠢⠴⣃⣠⣼⣿⣧⡀⠘⢢⣀⠄⠄⠄⠄⠄⢈⠁⢿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣿⠄⠄⠄⣸⠆⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣼⢿⣿⣿⣿⣿⡀⠄⠘⡀⢠⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⡌⠿⣫⣿⣦⠬⢭⣥⣶⣬⣾⣿⢿⣿⡟⠄⢀⣿⣶⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣧⠘⣉⠛⢻⣛⣛⣛⣻⡶⠮⠙⠃⣉⠄⠄⢸⣿⣿⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⡆⠸⣿⣶⢾⣿⣯⣤⣄⣀⣾⡟⠄⠄⠄⢸⣿⣿⣿⣿⣿⣿⣿⣿\n⠟⠿⠿⠿⠿⢿⣷⠄⣿⣿⣎⣹⢻⣿⣿⡿⡿⠁⠄⠄⠄⢸⣿⣿⣿⣿⣿⣿⣿⣿\n⠄⠄⠄⠄⠄⠄⠄⣠⠘⣿⣿⣿⣿⣿⣿⡟⠁⣀⣀⣀⠄⠘⠿⣿⣿⣿⣿⣿⣿⣿");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 130, 290, 250);

        textomanainimigo.setText("Mana");
        getContentPane().add(textomanainimigo);
        textomanainimigo.setBounds(400, 50, 100, 16);

        barrainimigovida.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(barrainimigovida);
        barrainimigovida.setBounds(130, 70, 146, 18);

        textovidainimigo.setText("Vida");
        getContentPane().add(textovidainimigo);
        textovidainimigo.setBounds(170, 50, 120, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ////CAMPOS DE AÇÂO
    private void botaoataqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoataqueActionPerformed
        if (turno == true) {
            turno = false;
            textopensamentos.setText("''Argh, tome!'' - Voce ataca o inimigo com " + heroi.getAtaque() + " pontos de força!");
            heroi.atacar(inimigo, heroi.getAtaque());
            heroi.aumentarMana(5);
            atualizarstatus();
            turnoinimigo();
        } else {
        }
    }//GEN-LAST:event_botaoataqueActionPerformed

    private void textomanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textomanaActionPerformed

    }//GEN-LAST:event_textomanaActionPerformed

    private void textonomeinimigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textonomeinimigoActionPerformed

    }//GEN-LAST:event_textonomeinimigoActionPerformed

    private void textoacontecimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoacontecimentosActionPerformed

    }//GEN-LAST:event_textoacontecimentosActionPerformed

    private void botaomeditacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaomeditacaoActionPerformed
        if (turno == true && heroi.mana < heroi.limitemana) {
            turno = false;
            if (heroi.getFinin()) {
                heroi.meditar(60);
                heroi.setFinin(false);
                textopensamentos.setText("Você atingiu o nirvana - +60 de mana.");
            } else {
                heroi.meditar(20);
                textopensamentos.setText("Você se conecta com a natureza - +20 de mana.");
            }
            turnoinimigo();
            atualizarstatus();
        } else if (heroi.mana >= heroi.limitemana) {
            textopensamentos.setText("Sua mana está no máximo, está achando que é fácil fabricar o mel? - Escolha outra opção.");
        }
    }//GEN-LAST:event_botaomeditacaoActionPerformed

    private void botaorockleeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaorockleeActionPerformed
        if (turno == true) {
            if (heroi.getRocklee() == 4){
            textopensamentos.setText("''Eu já assisti o vídeo todo, sinto um poder imenso dentro de mim!'' - Escolha outra opção.");
            }
            else{
            turno = false;
            textopensamentos.setText("''Vou ver um vídeo para me motivar!'' - Ataque multiplicado em 2.");
            heroi.setRocklee();
            atualizarstatus();
            turnoinimigo();}
        } else {
        }
    }//GEN-LAST:event_botaorockleeActionPerformed

    private void botaoespecial2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoespecial2ActionPerformed
        if (turno) {
            if (heroi.getMana() >= 200) {
                turno = false;
                textopensamentos.setText("Você soltou especial máximo! - 420 de dano aplicado ao inimigo. ");
                heroi.setMana(heroi.getMana() - 200);
                heroi.atacar(inimigo, 420);
                atualizarstatus();
                turnoinimigo();
            } else {
            textopensamentos.setText("Você não tem mana o suficiente - escolha outra opção.");
        }
        }
    }//GEN-LAST:event_botaoespecial2ActionPerformed

    private void botaofininActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaofininActionPerformed
        if (turno) {
            if (heroi.getFinin()){
                textopensamentos.setText("Fininho já está prensado, faça outra opção!");
            }
            else{
            turno = false;
            textopensamentos.setText("''Chama, chama!'' - Após acender a chama você sente uma paz incrível - Efeito da próxima meditação triplicada");
            heroi.setFinin(true);
            atualizarstatus();
            turnoinimigo();}
        }
    }//GEN-LAST:event_botaofininActionPerformed

    private void botaoexaltasambaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoexaltasambaActionPerformed
        if (turno == true) {
            turno = false;
            exalta = random.nextInt(99);
            if (exalta == 69 || exalta == 24) {
                heroi.exaltasamba();
                textopensamentos.setText("''Tá vendo aquela Lua que brilha lá no céu?'' - Você foi abençoado pelos deuses que gostaram de sua música - Vida e Mana restaurados");
            } else {
                textopensamentos.setText("''Esqueci a letra...'' - Nada aconteceu - Turno passado");
            }
            atualizarstatus();
            turnoinimigo();
        }
    }//GEN-LAST:event_botaoexaltasambaActionPerformed

    private void textopensamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textopensamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textopensamentosActionPerformed

    private void botaodejavuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaodejavuActionPerformed
        if (turno == true) {
            if (heroi.getDejavu() > 0){
            textopensamentos.setText("''Você já está sob o efeito da banda DEJAVU e DJ juninho Portugal - Escolha outra opção");
            }
            else{
            turno = false;
            heroi.setDejavu();
            textopensamentos.setText("''O que pensa que eu sou?'' - Você se empolga com a música - Chance de esquiva aumentada em 40% pelos próximos 3 turnos.");
            atualizarstatus();
            turnoinimigo();
            }
        }
    }//GEN-LAST:event_botaodejavuActionPerformed

    private void botaodefesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaodefesaActionPerformed
        // TODO add your handling code here:
        if (turno == true) {
            turno = false;
            heroi.setTurnoDefesa();
            textopensamentos.setText("''Dano reduzido em:" + heroi.getDefesa());
            
           atualizarstatus();
            turnoinimigo();
        }
    
    }//GEN-LAST:event_botaodefesaActionPerformed

    private void botaoespecial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoespecial1ActionPerformed
        if (turno) {
            if (heroi.getMana() >= 50) {
                turno = false;
                textopensamentos.setText("Você soltou especial! - Causou 80 de dano");
                heroi.setMana(heroi.getMana() - 50);
                heroi.atacar(inimigo, 80);
                atualizarstatus();
                turnoinimigo();
            } else {
            textopensamentos.setText("Você não tem mana o suficiente - escolha outra opção.");
            }
        }    
    }//GEN-LAST:event_botaoespecial1ActionPerformed


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
        java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Interface().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barrainimigomana;
    private javax.swing.JProgressBar barrainimigovida;
    private javax.swing.JProgressBar barramana;
    private javax.swing.JProgressBar barrarocklee;
    private javax.swing.JProgressBar barravida;
    private javax.swing.JButton botaoataque;
    private javax.swing.JButton botaodefesa;
    private javax.swing.JButton botaodejavu;
    private javax.swing.JButton botaoespecial1;
    private javax.swing.JButton botaoespecial2;
    private javax.swing.JButton botaoexaltasamba;
    private javax.swing.JButton botaofinin;
    private javax.swing.JButton botaomeditacao;
    private javax.swing.JButton botaorocklee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField textoacontecimentos;
    private javax.swing.JLabel textoataque;
    private javax.swing.JLabel textodefesa;
    private javax.swing.JLabel textoesquiva;
    private javax.swing.JTextField textomana;
    private javax.swing.JLabel textomanainimigo;
    private javax.swing.JTextField textonomeinimigo;
    private javax.swing.JTextField textopensamentos;
    private javax.swing.JLabel textoturno;
    private javax.swing.JTextField textovida;
    private javax.swing.JLabel textovidainimigo;
    // End of variables declaration//GEN-END:variables

}