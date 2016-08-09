
package formulario;

import conexion.conexion;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Java_MySQL extends javax.swing.JFrame {

    String Insertar = "CALL InsertarDatos(?,?,?,?,?)";
    String Modificar = "CALL ModificarDatos(?,?,?,?,?)";
    String Eliminar = "CALL BorrarDatos(?)";
    DefaultTableModel modelo;

    public Java_MySQL() {
        initComponents();
        CargarDatos();
    }

   public String IngresarDatos(int codigo, String nombres, String cargo, String dpto, String jefe){
            Connection cnn;    
            String resultado;
        try{
           cnn=conexion.Conectar();
           CallableStatement cmst= cnn.prepareCall(Insertar);
           cmst.setInt(1,codigo);
           cmst.setString(2,nombres);
           cmst.setString(3,cargo);
           cmst.setString(4, dpto);
           cmst.setString(5, jefe);
           cmst.execute();    
           resultado="Los datos se ingresaron exitosamente !!!";
           cnn.close();        
        }catch(SQLException sqlex){
           resultado="No se realizo la operacion" +sqlex.getMessage();
        }catch(Exception ex){System.out.println(ex.getMessage());
           resultado="No se realizo la operacion" +ex.getMessage();
        }return resultado;
    }
   public String ModificarDatos(int codigo, String nombres, String cargo, String dpto, String jefe){
           Connection cnn;
           String resultado;
        try{
           cnn=conexion.Conectar();
           CallableStatement cmst= cnn.prepareCall(Modificar);
           cmst.setInt(1,codigo);
           cmst.setString(2,nombres);
           cmst.setString(3,cargo);
           cmst.setString(4, dpto);
           cmst.setString(5, jefe);
           cmst.execute();            
           resultado="Los datos se modificaron correctamente !!!";
           cnn.close();
        }catch(SQLException sqlex){System.out.println(sqlex.getMessage());
           resultado="No se realizo la operacion" +sqlex.getMessage();
        }catch(Exception ex){System.out.println(ex.getMessage());
           resultado="No se realizo la operacion" +ex.getMessage();
        }return resultado;
    }
   public String EliminarDatos(int codigo){
          Connection cnn;
          String resultado;
      try{
        cnn=conexion.Conectar();
        CallableStatement cmst=cnn.prepareCall(Eliminar);
        cmst.setInt(1, codigo);
        cmst.execute();
        resultado="Los datos se eliminaron correctamente !!!";
        cnn.close();
      }catch(SQLException sqlex){System.out.println(sqlex.getMessage());
        resultado="No se realizo la operacion" +sqlex.getMessage();
      }catch(Exception ex){System.out.println(ex.getMessage());
        resultado="No se realizo la operacion" +ex.getMessage();
      }return resultado;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        txtDepartamento = new javax.swing.JTextField();
        txtJefe = new javax.swing.JTextField();
        BIngresar = new javax.swing.JButton();
        BModificar = new javax.swing.JButton();
        BEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setName("NAME"); // NOI18N
        label1.setText("MANTENIMIENTO DE DATOS EMPLEADOS");

        jLabel1.setText("ID_EMPLEADO");

        jLabel2.setText("NOMBRES");

        jLabel3.setText("CARGO");

        jLabel4.setText("DEPARTAMENTO");

        jLabel5.setText("JEFE ASIGNADO");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });

        txtDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartamentoActionPerformed(evt);
            }
        });

        txtJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJefeActionPerformed(evt);
            }
        });

        BIngresar.setText("Ingresar Datos");
        BIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIngresarActionPerformed(evt);
            }
        });

        BModificar.setText("Modificar");
        BModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModificarActionPerformed(evt);
            }
        });

        BEliminar.setText("Eliminar");
        BEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminarActionPerformed(evt);
            }
        });

        tablita.setAutoCreateRowSorter(true);
        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id_empleado", "Nombres", "Cargo", "Departamento", "Jefe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablita.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablita.setFocusable(false);
        jScrollPane1.setViewportView(tablita);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BIngresar)
                                    .addComponent(jLabel5))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BEliminar)))))
                .addContainerGap(147, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BIngresar)
                    .addComponent(BModificar)
                    .addComponent(BEliminar))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void txtDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartamentoActionPerformed

    private void txtJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJefeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJefeActionPerformed

    private void BIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BIngresarActionPerformed
       String resultado;
        int codigo= Integer.parseInt(txtCodigo.getText());
        String nombres=txtNombres.getText();
        String cargo=txtCargo.getText();
        String departamento=txtDepartamento.getText();
        String jefe=txtJefe.getText();
        resultado=IngresarDatos(codigo, nombres, cargo, departamento, jefe);
        setTitle(resultado);
        CargarDatos();
    }

    private void CargarDatos() {
        Connection cnn;    
            modelo= new DefaultTableModel();  
        try{
            cnn=conexion.Conectar();
            Statement smt=cnn.createStatement();
            ResultSet rs= smt.executeQuery("select * from seleccionardatos");
            ResultSetMetaData md=rs.getMetaData();
            int columnas= md.getColumnCount();
            for (int i = 1; i <= columnas; i++) {
            modelo.addColumn(md.getColumnLabel(i));}
            while(rs.next()){
            Object[] fila = new Object[columnas];
            for (int i = 0; i < columnas; i++) {fila[i]=rs.getObject(i+1);}
            modelo.addRow(fila);
         //   fila=null;
            }
            tablita.setModel(modelo);
            cnn.close();
        }catch(SQLException sqlex){
            setTitle("Problema CargarDatos" +sqlex.getMessage());
        }
    
    }//GEN-LAST:event_BIngresarActionPerformed

    private void BModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModificarActionPerformed
        String resultado;
        int codigo= Integer.parseInt(txtCodigo.getText());
        String nombres=txtNombres.getText();
        String cargo=txtCargo.getText();
        String departamento=txtDepartamento.getText();
        String jefe=txtJefe.getText();
        resultado=ModificarDatos(codigo, nombres, cargo, departamento, jefe);
        setTitle(resultado);
        CargarDatos();
    
    }//GEN-LAST:event_BModificarActionPerformed

    private void BEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminarActionPerformed
        String resultado;
        int codigo=Integer.parseInt(txtCodigo.getText());
       resultado=EliminarDatos(codigo);
       setTitle(resultado);
       CargarDatos();
    
    }//GEN-LAST:event_BEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Java_MySQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Java_MySQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Java_MySQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Java_MySQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Java_MySQL().setVisible(true);
            }
        });
    }

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BEliminar;
    public javax.swing.JButton BIngresar;
    public javax.swing.JButton BModificar;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public java.awt.Label label1;
    public javax.swing.JTable tablita;
    public javax.swing.JTextField txtCargo;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDepartamento;
    public javax.swing.JTextField txtJefe;
    public javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

    

