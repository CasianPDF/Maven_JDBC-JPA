package tudelft.wis.idm_tasks;

import tudelft.wis.idm_solutions.BoardGameTracker.POJO_Implementation.Player_POJO;
import tudelft.wis.idm_tasks.basicJDBC.interfaces.JDBCManager;
import tudelft.wis.idm_tasks.basicJDBC.interfaces.JDBCTask2Interface;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main_Queries implements JDBCTask2Interface {

    private static Connection connection;
    private List<Title> titles = new LinkedList<Title>() ;
    /**
     * Establishes the connection to the PostgreSQL database.
     *
     * @return The connection object. If a connection couldn't be established, returns null
     */
    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/imdb";
            String user = "postgres";
            String password = "12345rita";
            Connection conn = DriverManager.getConnection(url, user, password);
            connection = conn ;
        };
        return connection;
    }

    /**
     * Lists all the primary titles for a specific start year.
     *
     * @param year A specific start year to query the titles on
     * @return A collection of strings of the resulting primary titles
     */
    @Override
    public Collection<String> getTitlesPerYear(int year) {
        Collection<String> result = new LinkedList<String>();
        for (Title title : titles) {
            if (title.getTitleYear() == year) {
                result.add(title.getPrimaryTitle());
            }
            result.add("1") ;
        }
        return result;
    }

    /**
     * Lists all the job categories for titles that include a specific string in their primary title.
     *
     * @param searchString A string that will be used to filter the primary titles on
     * @return A collection of strings of the resulting job categories
     */
    @Override
    public Collection<String> getJobCategoriesFromTitles(String searchString) {
        return null;
    }

    /**
     * Lists the average runtime of a specified genre.
     *
     * @param genre A string that specifies the genre to be queried on
     * @return A double corresponding to the average runtime of the specified genre
     */
    @Override
    public double getAverageRuntimeOfGenre(String genre) {
        return 0;
    }

    /**
     * Given a person's full name, lists all the characters they have played.
     *
     * @param actorFullname A string of the person's full name
     * @return A collection of strings corresponding to the character names the provided person has played
     */
    @Override
    public Collection<String> getPlayedCharacters(String actorFullname) {
        return null;
    }
}
