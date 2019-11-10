/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Errores;
import Modelo.Operacion;
import Modelo.ObtenerDatos;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alumno
 */
public class VisualizarMedicosAsociados extends javax.swing.JPanel {

    ObtenerDatos objetoObtenerDatos = new ObtenerDatos();
    private String codigoCompañia;
    private String codigoMedico;
    private int precioHora=0;
    private Boolean fechabien = false;
    int numeroConsultas=0; //Numero de consultas de cada medico
    ArrayList <Operacion> arrayConsulta = new ArrayList();
    
    DefaultTableModel modelo; //Declaracion de los modelos del JTABLE
    
    public VisualizarMedicosAsociados(String codigoComp) {
        
        
        initComponents();
        try {
            objetoObtenerDatos.mostrarDatosMedicos(codigoComp);
            
            modelo = (DefaultTableModel) jTable1.getModel(); //modelo para el JTable1
            codigoCompañia = codigoComp;
            
            objetoObtenerDatos.avanzar();
            
            controlBotones(); //Metodo para controlar botones
            
            campoNif.setEditable(false);
            campoNombre.setEditable(false);
            campoCodigo.setEditable(false);
            campoPrecioHora.setEditable(false);
            
            establecerImagenCompañia(codigoComp);
            
            actualizarDatos();
  
        } catch (Errores ex) {
            ex.queError(2);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    
    private void rellenarTablaConsulta(String codigoMedico)
    {
        modelo.setRowCount(0); //Se resetean los modelos

        try {
            numeroConsultas = objetoObtenerDatos.mostrarConsultaMedico(objetoObtenerDatos.devolverColumna(1));
            
            
            if (numeroConsultas>1)
            {
                arrayConsulta = objetoObtenerDatos.devolverArrayConsultaMedico();

                Object vector[]; //Creamos un vector de tipo objeto

               int i=0; 
               while (i<arrayConsulta.size()) //Mientras no se llegue al final
               {
                   vector = obtenerDatos(arrayConsulta.get(i)); //El vector se rellena
                   modelo.addRow(vector); //Se añade al modelo
                   i++; //Se suma al contador
               }

               jTable1.setModel(modelo); //El modelo se le aplica al JTable
            }
            else
                if (numeroConsultas == 1)
                {
                   Operacion objeto = (Operacion) objetoObtenerDatos.devolverObjetoConsultaMedico();
                   Object vector[]; //Creamos un vector de tipo objeto
                   vector = obtenerDatos(objeto); //El vector se rellena
                   modelo.addRow(vector); //Se añade al modelo
                }
        } catch (Errores ex) {
            ex.queError(1);
        }

         
    }
    
    private Object[] obtenerDatos(Operacion objeto) //Objeto de tipo Supermercado
    {
        Object vector[] = new Object[5]; //Creamos un vector del mismo numero de campos que la tabla
     
        vector[0] = objeto.getMed_con();
        vector[1] = objeto.getPac_con();
        vector[2] = objeto.getCod_consulta();
        vector[3] = objeto.getTiempo();
        vector[4] = (precioHora * objeto.getTiempo());
        
        return vector;
    }
    

    private void establecerImagenCompañia(String codigo)
    {
        String url="src/Imagenes/"+codigo+".png";
        campoLogo.setIcon(new ImageIcon(url)); //La imagen se escoge segun el codigo de director
        
    }

    //Metodo para controlar botones
    private void controlBotones()
    {
        try {
            if (objetoObtenerDatos.isLast() == false) {
                botonAdelante.setEnabled(true);
            } else {
                botonAdelante.setEnabled(false);
            }
            
            if (objetoObtenerDatos.isFirst() == false) {
                botonAtras.setEnabled(true);
            } else {
                botonAtras.setEnabled(false);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            
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

        jFileChooser1 = new javax.swing.JFileChooser();
        botonAtras = new javax.swing.JButton();
        botonAdelante = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoLogo = new javax.swing.JLabel();
        campoFoto = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        campoNif = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoPrecioHora = new javax.swing.JTextField();
        botonEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonNuevaConsulta = new javax.swing.JButton();
        jDatePicker1 = new org.jdatepicker.JDatePicker();

        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        botonAdelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/adelante.png"))); // NOI18N
        botonAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAdelanteActionPerformed(evt);
            }
        });

        jLabel2.setText("CODIGO");

        jLabel3.setText("NIF");

        jLabel4.setText("NOMBRE");

        jLabel5.setText("FECHA");

        jLabel6.setText("PRECIO/HORA");

        botonEditar.setText("EDITAR");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEDICO", "PACIENTE", "CONSULTA", "TIEMPO", "COSTE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        botonNuevaConsulta.setText("CREAR NUEVA CONSULTA");
        botonNuevaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaConsultaActionPerformed(evt);
            }
        });

        jDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDatePicker1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAtras)
                        .addGap(149, 149, 149)
                        .addComponent(botonNuevaConsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(campoLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addComponent(botonAdelante, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(1, 1, 1)))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(campoPrecioHora)
                            .addComponent(campoNombre)
                            .addComponent(campoNif))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(campoFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(campoPrecioHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(campoFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAdelante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonNuevaConsulta)
                    .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        try {     
            objetoObtenerDatos.retroceder(); //Se retrocede
            
            controlBotones(); //Metodo para controlar botones
            
            actualizarDatos(); //Metodo para actualizar datos
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAdelanteActionPerformed
        
        try {
            objetoObtenerDatos.avanzar(); //Avanzamos
 
            controlBotones(); //Metodo para controlar botones
            
            actualizarDatos(); //Metodo para actualizar datos
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_botonAdelanteActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        
       
 
        FileNameExtensionFilter filter = new FileNameExtensionFilter ("Archivos .png","png");
        jFileChooser1.setFileFilter(filter);
        jFileChooser1.addChoosableFileFilter(filter);

        jFileChooser1.setAcceptAllFileFilterUsed(false);
        
         int seleccion = jFileChooser1.showDialog(this,"Seleccionar imagen");
        
        if (seleccion == JFileChooser.APPROVE_OPTION)
        {
            File archivo = jFileChooser1.getSelectedFile();
            
            String direccion = archivo.getPath();
            String destino = "/src/Imagenes/"+codigoCompañia+".png";
            ImageIcon icon = new ImageIcon (direccion);
            
            try {
                Files.copy(Paths.get(direccion), Paths.get(destino),REPLACE_EXISTING);
                //adaptarImagen(icon);
            } catch (IOException ex) {
           
            }
            
            campoFoto.setIcon(icon);
        }
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonNuevaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaConsultaActionPerformed

        VentanaPrincipal obj = new VentanaPrincipal();
        
        MostrarPacientes objeto = new MostrarPacientes(obj,true, codigoMedico);
        objeto.setTitle("LISTA DE PACIENTES");
        objeto.setVisible(true);
        
        int codigoPaciente = objeto.codigoPaciente;
        String tiempoSeleccionado = objeto.tiempoSeleccionado;
        
        numeroConsultas = numeroConsultas + 1;
        
        try {
            objetoObtenerDatos.nuevaConsulta(codigoMedico, codigoPaciente, tiempoSeleccionado, numeroConsultas);
        } catch (Errores ex) {
            ex.queError(1);
        }
        
        actualizarDatos();
        
        
    }//GEN-LAST:event_botonNuevaConsultaActionPerformed

    private void jDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDatePicker1ActionPerformed
         GregorianCalendar fecha = new GregorianCalendar(jDatePicker1.getModel().getYear(), jDatePicker1.getModel().getMonth(), jDatePicker1.getModel().getDay());
        Date nuevaFecha = fecha.getTime();
        int actualizados;
        try {
            comprobarFecha(fecha);
            actualizados = objetoObtenerDatos.modificarFecha(nuevaFecha,objetoObtenerDatos.devolverColumna(1));
            if (actualizados >= 1)
           {
                objetoObtenerDatos.mostrarDatosMedicos(codigoCompañia);
                objetoObtenerDatos.primero();
                actualizarDatos();
                controlBotones();
                JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente la fecha" ,"Informacion de actualizacion", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Errores ex) {
            ex.queError(2);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jDatePicker1ActionPerformed
    
    
    private void comprobarFecha (GregorianCalendar fecha) throws Errores
    {   
        String f;

         f = objetoObtenerDatos.devolverColumna(5);
            
        String fechaDevuelta[] = f.split("-");
        Date fechaElegida = fecha.getTime();
        
           
        GregorianCalendar fechaMedico = new GregorianCalendar(Integer.parseInt(fechaDevuelta[0]),(Integer.parseInt(fechaDevuelta[1]))-1, Integer.parseInt(fechaDevuelta[2]));
       
        Date fechaActual = fechaMedico.getTime();

        
        if (fechaElegida.before(fechaActual))
            throw new Errores(2);

    }
        
    
    
    
    private void cambiarImagen(ImageIcon icon)
    {   
            
    }
  
    
    //Metodo para actualizar datos
    private void actualizarDatos()
    {
        String f;
        String fecha[];
        try {
            codigoMedico = objetoObtenerDatos.devolverColumna(1);
            //Se llama al metodo pasandole el indice de la columna para que nos devuelva la info
            campoCodigo.setText("" + objetoObtenerDatos.devolverColumna(1));
            campoNif.setText("" + objetoObtenerDatos.devolverColumna(2));
            campoNombre.setText("" + objetoObtenerDatos.devolverColumna(4));
            f = objetoObtenerDatos.devolverColumna(5);
            fecha = f.split("-");
            jDatePicker1.getFormattedTextField().setText(fecha[2]+"-"+fecha[1]+"-"+fecha[0]);
            precioHora = Integer.parseInt(objetoObtenerDatos.devolverColumna(6));
            campoPrecioHora.setText("" + precioHora);
            String url="src/Imagenes/"+objetoObtenerDatos.devolverColumna(1)+".png";
            campoFoto.setIcon(new ImageIcon(url)); //La imagen se escoge segun el codigo de director
            rellenarTablaConsulta(codigoMedico);
            
        } catch (Errores ex) {
            ex.queError(1);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAdelante;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonNuevaConsulta;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JLabel campoFoto;
    private javax.swing.JLabel campoLogo;
    private javax.swing.JTextField campoNif;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecioHora;
    private org.jdatepicker.JDatePicker jDatePicker1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
