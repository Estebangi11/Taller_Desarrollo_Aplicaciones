/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package modulos.usuario;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import modulos.BienestarEmocional.BienestarView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author WindowsPC
 */
public class RegistroView extends javax.swing.JPanel {

    /**
     * Creates new form RegistroView
     */
    public RegistroView() {
        initComponents();
        configurarPanelRegistro();
    }

    private void configurarPanelRegistro() {
     setLayout(null);
        setBackground(new Color(245, 247, 250));

        // --- Título principal ---
        JLabel lblTitulo = new JLabel("Registro de Usuario", JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(52, 73, 94));
        lblTitulo.setBounds(0, 20, 800, 40);
        add(lblTitulo);

        // --- Campos de usuario ---
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblUsuario.setBounds(220, 100, 150, 25);
        add(lblUsuario);

        txtNomUsuario = new JTextField();
        txtNomUsuario.setBounds(380, 100, 250, 30);
        add(txtNomUsuario);

        lblErrorUsuario = new JLabel(" ");
        lblErrorUsuario.setForeground(Color.RED);
        lblErrorUsuario.setBounds(380, 130, 250, 20);
        add(lblErrorUsuario);

        // --- Campo correo ---
        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblCorreo.setBounds(220, 160, 150, 25);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(380, 160, 250, 30);
        add(txtCorreo);

        lblErrorCorreo = new JLabel(" ");
        lblErrorCorreo.setForeground(Color.RED);
        lblErrorCorreo.setBounds(380, 190, 250, 20);
        add(lblErrorCorreo);

        // --- Campo contraseña ---
        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblContraseña.setBounds(220, 220, 150, 25);
        add(lblContraseña);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(380, 220, 250, 30);
        add(txtContraseña);

        lblErrorContraseña = new JLabel(" ");
        lblErrorContraseña.setForeground(Color.RED);
        lblErrorContraseña.setBounds(380, 250, 250, 20);
        add(lblErrorContraseña);

        // --- Confirmar contraseña ---
        JLabel lblComContraseña = new JLabel("Confirmar contraseña:");
        lblComContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblComContraseña.setBounds(220, 280, 150, 25);
        add(lblComContraseña);

        txtComContraseña = new JPasswordField();
        txtComContraseña.setBounds(380, 280, 250, 30);
        add(txtComContraseña);

        lblErrorComContraseña = new JLabel(" ");
        lblErrorComContraseña.setForeground(Color.RED);
        lblErrorComContraseña.setBounds(380, 310, 250, 20);
        add(lblErrorComContraseña);

        // --- Botón Confirmar ---
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnConfirmar.setBackground(new Color(46, 204, 113));
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setBounds(280, 360, 120, 40);
        add(btnConfirmar);

        // --- Botón Cancelar ---
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnCancelar.setBackground(new Color(241, 196, 15));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBounds(440, 360, 120, 40);
        add(btnCancelar);

        // --- Botón Volver ---
        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnVolver.setBackground(new Color(231, 76, 60));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.setBounds(600, 360, 120, 40);
        add(btnVolver);

        // --- Acción botones ---
        btnConfirmar.addActionListener(e -> validarRegistro());
        btnCancelar.addActionListener(e -> limpiarCampos());
        btnVolver.addActionListener(e -> {
            JFrame ventanaPadre = (JFrame) SwingUtilities.getWindowAncestor(this);
            ventanaPadre.getContentPane().removeAll();
            ventanaPadre.getContentPane().add(new LoginView().getContentPane());
            ventanaPadre.revalidate();
            ventanaPadre.repaint();
        });
    }
    public class SesionUsuario {
    private static int idUsuario;
    private static String nombre;
    private static int rol;
    
    public static int getIdUsuario() { return idUsuario; }
    public static void setIdUsuario(int id) { idUsuario = id; }
    
    public static String getNombre() { return nombre; }
    public static void setNombre(String nom) { nombre = nom; }
    
    public static int getRol() { return rol; }
    public static void setRol(int r) { rol = r; }
}
    
    private boolean validarLogin(String usuario, String contraseña) {
    Connection conexion = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
        // Obtener conexión a la base de datos (ajusta según tu configuración)
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/studymind_db", "usuario", "password");
        
        // Consulta para verificar usuario y contraseña
        String sql = "SELECT id_usuario, nombre, id_rol FROM usuario WHERE username = ? AND password = ? AND estado = 'activo'";
        stmt = conexion.prepareStatement(sql);
        stmt.setString(1, usuario);
        stmt.setString(2, contraseña);
        
        rs = stmt.executeQuery();
        
        if (rs.next()) {
            // Login exitoso
            int idUsuario = rs.getInt("id_usuario");
            String nombre = rs.getString("nombre");
            int idRol = rs.getInt("id_rol");
            
            // Guardar información del usuario en sesión
            SesionUsuario.setIdUsuario(idUsuario);
            SesionUsuario.setNombre(nombre);
            SesionUsuario.setRol(idRol);
            
            JOptionPane.showMessageDialog(this, "Bienvenido " + nombre, "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error de base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    } finally {
        // Cerrar recursos
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    private void validarRegistro() {
        limpiarMensajes();
        boolean valido = true;

        String usuario = txtNomUsuario.getText().trim();
        String correo = txtCorreo.getText().trim();
        String contraseña = new String(txtContraseña.getText()).trim();
        String comContraseña = new String(txtComContraseña.getText()).trim();

        if (usuario.isEmpty()) {
            lblErrorUsuario.setText("El usuario no puede estar vacío");
            valido = false;
        }
        if (correo.isEmpty()) {
            lblErrorCorreo.setText("El correo no puede estar vacío");
            valido = false;
        } else if (!correo.contains("@") || !correo.contains(".")) {
            lblErrorCorreo.setText("Correo inválido");
            valido = false;
        }
        if (contraseña.isEmpty()) {
            lblErrorContraseña.setText("La contraseña no puede estar vacía");
            valido = false;
        }
        if (comContraseña.isEmpty()) {
            lblErrorComContraseña.setText("Debe confirmar la contraseña");
            valido = false;
        } else if (!contraseña.equals(comContraseña)) {
            lblErrorComContraseña.setText("Las contraseñas no coinciden");
            valido = false;
        }

        if (valido) {
            JOptionPane.showMessageDialog(this, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        }
    }
    
    private void limpiarCampos() {
        txtNomUsuario.setText("");
        txtCorreo.setText("");
        txtContraseña.setText("");
        txtComContraseña.setText("");
        limpiarMensajes();
    }

    private void limpiarMensajes() {
        lblErrorUsuario.setText(" ");
        lblErrorCorreo.setText(" ");
        lblErrorContraseña.setText(" ");
        lblErrorComContraseña.setText(" ");
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        txtNomUsuario = new javax.swing.JTextField();
        txtComContraseña = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblErrorComContraseña = new javax.swing.JLabel();
        lblErrorContraseña = new javax.swing.JLabel();
        lblErrorCorreo = new javax.swing.JLabel();
        lblErrorUsuario = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese un correo electronico");

        jLabel2.setText("Ingrese una contraseña");

        jLabel3.setText("I| un nombre de usuario:");

        jLabel4.setText("Confirne su contraseña :");

        jLabel5.setText("REGISTRARSE");

        btnConfirmar.setText("confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnVolver.setText("volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnCancelar.setText(" cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(693, 693, 693))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrorCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(lblErrorContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblErrorComContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtComContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnConfirmar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtComContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorComContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 553, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        JFrame ventanaPadre = (JFrame) SwingUtilities.getWindowAncestor(this);
            ventanaPadre.getContentPane().removeAll();
            ventanaPadre.getContentPane().add(new LoginView().getContentPane());
            ventanaPadre.revalidate();
            ventanaPadre.repaint();
        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        JFrame ventanaPadre = (JFrame) SwingUtilities.getWindowAncestor(this);
            ventanaPadre.getContentPane().removeAll();
            ventanaPadre.getContentPane().add(new BienestarView().getContentPane());
            ventanaPadre.revalidate();
            ventanaPadre.repaint();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblErrorComContraseña;
    private javax.swing.JLabel lblErrorContraseña;
    private javax.swing.JLabel lblErrorCorreo;
    private javax.swing.JLabel lblErrorUsuario;
    private javax.swing.JTextField txtComContraseña;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNomUsuario;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
