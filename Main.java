package mulesoft;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
public static void main(String [] args) {
	createtable.createNewTable();
	insert("  SAAMY ","  Vikram  "," Trisha ",2003," Hari ");
	insert("  ASURAN  "," Dhanush "," Manju Warrier ",2019," Vetrimaaran ");
	insert(" INDIAN "," Kamal Haasan "," Kasthuri ",1996," Shankar ");
	insert(" MERSAL "," Vijay "," Samantha ",2017,"Atlee Kumar");
	insert("    KABALI  "," Rajinikanth "," Sai Dhanshika ",2016,"Ranjith");
	select.selectAll();
	select.selectactormovie();
}
private static void insert(String moviename,String leadactor,String actress,Integer yearofrelease,String director) {
	Connection con=Dbconnection.connect();
	PreparedStatement ps=null;
	try {
		String sql="INSERT INTO movies(moviename,leadactor,actress,yearofrelease,director) VALUES(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, moviename);
		ps.setString(2, leadactor);
		ps.setString(3, actress);
		ps.setInt(4,yearofrelease);
		ps.setString(5, director);
		ps.execute();
		System.out.println("Data has been inserted");
	}catch(SQLException e) {
		System.out.println(e.toString());
	}
}
}
