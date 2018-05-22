import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hsqldb.Server;

public class MiniNetDatabase {
	
	Driver2 useable2 = new Driver2();
	Server hsqlServer = null;
	Connection connection = null;
	ResultSet rs = null;
	
	public void initialiseDatabase() {
		
		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "TestDB");
		hsqlServer.setDatabasePath(0, "file:MYDB");
		
		hsqlServer.start();
		// making a connection
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "123");
			connection.prepareStatement("drop table barcodes if exists;").execute();
			connection.prepareStatement("drop table members if exists;").execute();
			connection.prepareStatement("create table members (userID varchar(50) PRIMARY KEY, fullName varchar(50) not null, age integer not null, gender varchar(50) not null, photo varchar(50), stat varchar(50));").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('BEN1984', 'Benjmain Donnelly', 34, 'M', 'bend.photo', 'I am programming');").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('BELINDA1985', 'Belinda Donnelly', 32, 'F', 'bel.photo', 'I am teaching');").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('KENTUCKYKAT', 'Karl Anthony-Towns', 22, 'M', 'KAT.photo', 'No Status');").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('THEPROCESS', 'Joel Embiid', 24, 'M', 'joel.photo', 'No Status');").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('THEBROW', 'Anthony Davis', 25, 'M', 'ad23.photo', 'No Status');").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('GREEKFREAK', 'Giannis Antetokounmpo', 23, 'M', 'bucks.photo', 'No Status');").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('BECMARIE', 'Rebecca Donnelly', 30, 'F', 'bec.photo', 'No Status');").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('KLSAMUELSON', 'Katie Lou Samuelson', 20, 'F', 'kls.photo', 'I am playing in the NCAA Tournament');").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('KATEBOSWORTH', 'Kate Bosworth', 35, 'F', 'katebos.photo', 'I am on set at the moment');").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('THESIMONA', 'Simona Halep', 26, 'F', 'WTASimona.photo', 'No Status');").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('LDONNELLY', 'Louis Donnelly', 10, 'M', 'louis.photo', 'No Status');").execute();
			connection.prepareStatement("INSERT INTO members (userID, fullName, age, gender, photo, stat)" + "values('LITTLEONE', 'Lucy Donnelly', 1, 'F', 'No Photo', 'No Status');").execute();
			// query from the db
			rs = connection.prepareStatement("select * from members;").executeQuery();
			connection.commit();
			connection.close();
			hsqlServer.shutdown();
		}
		catch (SQLException e2) {
			e2.printStackTrace();
			hsqlServer.shutdown();
		}
		catch (ClassNotFoundException e2) {
			e2.printStackTrace();
			hsqlServer.shutdown();
		}
	}
}
