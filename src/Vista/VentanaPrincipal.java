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
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        botonInicioSesionCompañia = new javax.swing.JMenuItem();
        botonVisualizarMedicos = new javax.swing.JMenuItem();
        botonAltaMedico = new javax.swing.JMenuItem();
        botonAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("BASE DE DATOS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("HOSPITAL");

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
        jMenu1.add(botonAltaMedico);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(140, 140, 140))
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
        
        codComp = objeto.devolverCodigo();
        
    }//GEN-LAST:event_botonInicioSesionCompañiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem botonAcercaDe;
    private javax.swing.JMenuItem botonAltaMedico;
    private javax.swing.JMenuItem botonInicioSesionCompañia;
    private javax.swing.JMenuItem botonVisualizarMedicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
