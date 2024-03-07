package Database;

import java.sql.*; 
import java.io.*; 
import java.util.Objects; 

public class DBconnection {
	
    private static DBconnection instance;
    static Connection conn = null; 
    static String Url = "jdbc:postgresql://localhost:1234/postgres";
	static String user = "postgres"; 
	static String psw = "Saving"; 
	
	public DBconnection() throws SQLException{
		try{
			
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(Url,user,psw);
			
			System.out.println("Connessione avvenuta con successo!");
			
		}
		catch(Exception e) {
			System.out.println("Database Connection Creation Failed : " + e.getMessage());
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		/*try{
			
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(Url, user,psw);
			
			if(conn!= null ) {
				System.out.println("Connessione avvenuta con successo");
			}else { 
				System.out.println("Connection denied");
			}*/
			return conn;  
			/*
		}catch(ClassNotFoundException | SQLException e){ 
			System.err.println("Errore durante la connessione al database: " + e.getMessage());
	        e.printStackTrace();
	        throw new RuntimeException("Impossibile connettersi al database.", e);
		}*/
	}
	
	public static DBconnection getInstance() throws SQLException{
		try{
			if(instance == null) { 
				instance = new DBconnection(); 
			}else if(instance.getConnection().isClosed()){ 
				instance = new DBconnection(); 
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return instance; 
		
		
	}
	
}
