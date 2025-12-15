package com.gestortes.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de utilidad para gestionar la conexión a la base de datos.
 */
public class ConexionDB {
    
    // --- Configuración de la Conexión ---
    // Asegúrate de que la base de datos "gestion_tesis_db" exista
    // y que el usuario y contraseña sean correctos.
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestion_tesis_db";
    private static final String JDBC_USER = "root"; // Cambia esto por tu usuario de MySQL
    private static final String JDBC_PASS = "Universidad123"; // Cambia esto por tu contraseña de MySQL
    
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * Establece y retorna la conexión a la base de datos.
     * @return Objeto Connection
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Cargar el driver
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver JDBC: " + e.getMessage());
            throw new SQLException("Error al cargar el driver", e);
        }
        
        // Establecer la conexión
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    /**
     * Cierra la conexión.
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
    System.out.println("╔════════════════════════════════════════════╗");
    System.out.println("║  PRUEBA DE CONEXIÓN A LA BASE DE DATOS    ║");
    System.out.println("╚════════════════════════════════════════════╝");
    
    Connection conn = null;
    try {
        System.out.println("\n🔄 Intentando conectar...");
        conn = getConnection();
        
        if (conn != null && !conn.isClosed()) {
            System.out.println("\n✅ ¡CONEXION EXITOSA!");
            System.out.println("═══════════════════════════════════════════");
            System.out.println("📊 Base de datos: gestion_tesis_db");
            System.out.println("🖥️  Servidor: localhost:3306");
            System.out.println("👤 Usuario: root");
            System.out.println("═══════════════════════════════════════════\n");
        }
    } catch (SQLException e) {
        System.err.println("\n❌ ERROR DE CONEXIÓN:");
        System.err.println("═══════════════════════════════════════════");
        System.err.println("📝 Mensaje: " + e.getMessage());
        System.err.println("🔢 Código de error: " + e.getErrorCode());
        System.err.println("\n🔍 Posibles causas:");
        System.err.println("  1. MySQL no está corriendo (verifica XAMPP o Servicios)");
        System.err.println("  2. La contraseña es incorrecta");
        System.err.println("  3. La base de datos 'gestion_tesis_db' no existe");
        System.err.println("  4. El puerto 3306 está ocupado o es incorrecto");
        System.err.println("═══════════════════════════════════════════\n");
        e.printStackTrace();
    } finally {
        close(conn);
        System.out.println("🔒 Conexión cerrada correctamente");
    }
}
}