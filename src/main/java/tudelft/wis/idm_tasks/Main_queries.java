package tudelft.wis.idm_tasks;

import tudelft.wis.idm_tasks.basicJDBC.interfaces.JDBCManager;
import tudelft.wis.idm_tasks.basicJDBC.interfaces.JDBCTask2Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

import static tudelft.wis.idm_tasks.DuckDB_JDBCManager.connection;

public class Main_queries implements JDBCTask2Interface {

    private static Connection connection;
    /**
     * Establishes the connection to the PostgreSQL database.
     *
     * @return The connection object. If a connection couldn't be established, returns null
     */
    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            Connection conn = DriverManager.getConnection("jdbc:duckdb:./DB/bggt.duckdb");

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
        return null;
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
