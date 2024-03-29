/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Conexion;

/**
 *
 * @author Sergio
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private String codComp;
    public VentanaPrincipal() {
        initComponents();
        
        desactivarBotones();
        botonDesconectar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        botonInicioSesionCompañia = new javax.swing.JMenuItem();
        botonVisualizarMedicos = new javax.swing.JMenuItem();
        botonAltaMedico = new javax.swing.JMenuItem();
        botonDesconectar = new javax.swing.JMenuItem();
        botonAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("MENU PRINCIPAL");

        jMenu1.setText("Menú");

        botonInicioSesionCompañia.setText("Iniciar sesion");
        botonInicioSesionCompañia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicioSesionCompañiaActionPerformed(evt);
            }
        });
        jMenu1.add(botonInicioSesionCompañia);

        botonVisualizarMedicos.setText("Visualizar Medicos");
        botonVisualizarMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVisualizarMedicosActionPerformed(evt);
            }
        });
        jMenu1.add(botonVisualizarMedicos);

        botonAltaMedico.setText("Alta Medico");
        botonAltaMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaMedicoActionPerformed(evt);
            }
        });
        jMenu1.add(botonAltaMedico);

        botonDesconectar.setText("Desconectar");
        botonDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDesconectarActionPerformed(evt);
            }
        });
        jMenu1.add(botonDesconectar);

        botonAcercaDe.setText("Acerca de");
        botonAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAcercaDeActionPerformed(evt);
            }
        });
        jMenu1.add(botonAcercaDe);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVisualizarMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVisualizarMedicosActionPerformed
        
        
        VisualizarMedicosAsociados objeto = new VisualizarMedicosAsociados(codComp);
        this.setContentPane(objeto);
        this.pack();
    }//GEN-LAST:event_botonVisualizarMedicosActionPerformed

    private void botonAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAcercaDeActionPerformed
            AcercaDe obj = new AcercaDe(this,true);
            obj.setTitle("Acerca de");
            obj.setVisible(true);
            
    }//GEN-LAST:event_botonAcercaDeActionPerformed

    private void botonInicioSesionCompañiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInicioSesionCompañiaActionPerformed
                
        pedirContraseña objeto = new pedirContraseña(this, true);
        objeto.setTitle("Iniciar sesión");
        objeto.setVisible(true);
        
        codComp = objeto.devolverCodigo(); //Metodo que devuelve el codigo que ha tecleado el usuario y se le pasa a las otras opciones
        
        activarBotones();
        
        botonInicioSesionCompañia.setEnabled(false);
        botonDesconectar.setEnabled(true);
        
        BienvenidaCompañia obj = new BienvenidaCompañia (codComp);
        this.setContentPane(obj);
        this.pack();
        
    }//GEN-LAST:event_botonInicioSesionCompañiaActionPerformed

    private void botonDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDesconectarActionPerformed
        panelPrincipal obj = new panelPrincipal ();
        this.setContentPane(obj);
        this.pack();
        
        desactivarBotones();
        botonInicioSesionCompañia.setEnabled(true);
        botonDesconectar.setEnabled(false);
        
    }//GEN-LAST:event_botonDesconectarActionPerformed

    private void botonAltaMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaMedicoActionPerformed
       AltaMedico objeto = new AltaMedico(codComp);
       this.setContentPane(objeto);
       this.pack();
    }//GEN-LAST:event_botonAltaMedicoActionPerformed

    private void desactivarBotones()
    {
        botonAcercaDe.setEnabled(false);
        botonVisualizarMedicos.setEnabled(false);
        botonAltaMedico.setEnabled(false);
        botonAcercaDe.setEnabled(false);

    }
    
    private void activarBotones()
    {
        botonAcercaDe.setEnabled(true);
        botonVisualizarMedicos.setEnabled(true);
        botonAltaMedico.setEnabled(true);
        botonAcercaDe.setEnabled(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem botonAcercaDe;
    private javax.swing.JMenuItem botonAltaMedico;
    private javax.swing.JMenuItem botonDesconectar;
    private javax.swing.JMenuItem botonInicioSesionCompañia;
    private javax.swing.JMenuItem botonVisualizarMedicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
