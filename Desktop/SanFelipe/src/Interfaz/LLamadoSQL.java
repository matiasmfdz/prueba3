
package Interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class LLamadoSQL {
     Connection conexion = null;
    String Url = "jdbc:sqlserver://192.168.50.190;databaseName=Mmolina_SBD;user=Mmolina_SQL;password=f5B=Tumc;";
    
     public static Connection getConexion(){
        Connection cin = null;
        try {            
                    String connectionUrl = "jdbc:sqlserver://192.168.50.190;databaseName=Mmolina_SBD;user=Mmolina_SQL;password=f5B=Tumc;";
                    cin= DriverManager.getConnection(connectionUrl);
        }catch (Exception e){
                        System.out.println("Error."+ e.getMessage());
                    } 
        return cin;
    }
    
    
    
    
    
    public void conectar(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(Url);   
    }catch(Exception e){
     System.out.println("Error."+ e.getMessage()); 
     JOptionPane.showMessageDialog(null,"error al conectar " + e.getMessage(),e.getMessage(),JOptionPane.ERROR_MESSAGE);
     
    }}
    
    public int InicioSesion(String nombre,String contraseña){
        int resultado = 0;
        try{
            
            Statement ejecutor = conexion.createStatement();
            ResultSet rs = ejecutor.executeQuery("Select * from Usuario Where Nombre_usuario = '"+nombre+"' and Contraseña = '"+contraseña+"'");
            
            
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "BIENVENIDO A EMPRESAS SAN FELIPE ");
                resultado = 1;
            } else {
                JOptionPane.showMessageDialog(null, "ERROR DE IDENTIFICACION");
                resultado = 0;
                
            }
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, " ERROR DE IDENTIFICACION ");
        }
        
        
       return resultado; 
    }
    
}
