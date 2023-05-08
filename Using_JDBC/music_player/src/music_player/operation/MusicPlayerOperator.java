package music_player.operation;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import music_player.song.Songs;

public class MusicPlayerOperator {

	public Connection geConnection() throws IOException, ClassNotFoundException, SQLException {

		FileInputStream fileInputStream = new FileInputStream("config.properties");

		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));

		return connection;

	}

	public void getSongsId(Songs songs) throws SQLException, ClassNotFoundException, IOException {

		Connection connection = geConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SONGS WHERE ID = ?");
		preparedStatement.setInt(1, songs.getId());

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println("ID : " + resultSet.getInt(1));
			System.out.println("Song Name : " + resultSet.getString(2) + " is Now Playing..!!");
			System.out.println("\n");
		}
		connection.close();
	}

	public void addSong(Songs songs) throws SQLException, ClassNotFoundException, IOException {

		Connection connection = geConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SONGS VALUES (?,?,?,?)");
		preparedStatement.setInt(1, songs.getId());
		preparedStatement.setString(2, songs.getName());
		preparedStatement.setString(3, songs.getSinger());
		preparedStatement.setString(4, songs.getDuration());

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Song Inserted Successfully..!!\n");
		} else {
			System.out.println("Falied to Insert a Song..!!");
		}

		connection.close();

	}

	public void removeSong(Songs songs) throws ClassNotFoundException, IOException, SQLException {

		Connection connection = geConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM SONGS WHERE ID = ?");
		preparedStatement.setInt(1, songs.getId());

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Song Daleted Successfully..!!\n");
		} else {
			System.out.println("Falied to Delete a Song..!!");
		}

		connection.close();

	}

	public void editSong(Songs songs) throws ClassNotFoundException, IOException, SQLException {

		Connection connection = geConnection();

		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE SONGS SET NAME = ?, SINGER = ?, DURATION = ? WHERE ID = ?");
		preparedStatement.setString(1, songs.getName());
		preparedStatement.setString(2, songs.getSinger());
		preparedStatement.setString(3, songs.getDuration());
		preparedStatement.setInt(4, songs.getId());

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Song Updated Successfully..!!\n");
		} else {
			System.out.println("Falied to Update a Song..!!");
		}

		connection.close();

	}

}
