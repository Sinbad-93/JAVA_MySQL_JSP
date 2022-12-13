package com.fullstackjee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	  private String url;
	    private String username;
	    private String password;

	    DaoFactory(String url, String username, String password) {
	        this.url = url;
	        this.username = username;
	        this.password = password;
	    }

	    public static DaoFactory getInstance() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {

	        }

	        DaoFactory instance = new DaoFactory(
	                "jdbc:mysql://localhost:3306/javaee", "hiddenforgithub", "hiddenforgithub");
	        return instance;
	    }
	    
	    /*class MysqlCon{  
	    	public static void main(String args[]){  
	    	try{  
	    	Class.forName("com.mysql.jdbc.Driver");  
	    	Connection con=DriverManager.getConnection(  
	    	"jdbc:mysql://localhost:3306/sonoo","root","root");  
	    	//here sonoo is database name, root is username and password  
	    	Statement stmt=con.createStatement();  
	    	ResultSet rs=stmt.executeQuery("select * from emp");  
	    	while(rs.next())  
	    	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	    	con.close();  
	    	}catch(Exception e){ System.out.println(e);}  
	    	}  
	    	}  */

	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, username, password);
	    }

	    // Récupération du Dao
	    public UtilisateurDao getUtilisateurDao() {
	        return new UtilisateurDaoImpl(this);
	    }
}
