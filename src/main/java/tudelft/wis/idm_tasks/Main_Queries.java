package tudelft.wis.idm_tasks;

import tudelft.wis.idm_tasks.basicJDBC.interfaces.JDBCTask2Interface;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

public class Main_Queries implements JDBCTask2Interface {

    private static Connection connection;
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
    public Collection<String> getTitlesPerYear(int year) throws SQLException {
        Collection<String> result = new LinkedList<String>();
        Connection conn = getConnection() ;
        String query = "Select primary_title from titles where start_year = ? limit 20" ;
        PreparedStatement preparredStatement = conn.prepareStatement(query);
        preparredStatement.setInt(1, year) ;
        ResultSet results = preparredStatement.executeQuery() ;
        while(results.next()){
            result.add(results.getString("primary_title") + "\n") ;
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
    public Collection<String> getJobCategoriesFromTitles(String searchString) throws SQLException {
        Collection<String> result = new LinkedList<String>();
        Connection conn = getConnection() ;
        searchString = "%" + searchString + "%" ;
        String query = "select distinct profession from titles t join title_person_character tpc on tpc.title_id = t.title_id " +
                "join persons_professions pp on pp.person_id = tpc.person_id where t.primary_title like ? limit 20 ";
        PreparedStatement preparredStatement = conn.prepareStatement(query);
        preparredStatement.setString(1, searchString); ;
        ResultSet results = preparredStatement.executeQuery() ;
        while(results.next()){
            result.add(results.getString("profession") + "\n") ;
        }
        return result;
    }

    /**
     * Lists the average runtime of a specified genre.
     *
     * @param genre A string that specifies the genre to be queried on
     * @return A double corresponding to the average runtime of the specified genre
     */
    @Override
    public double getAverageRuntimeOfGenre(String genre) throws SQLException {
        double result = -1 ;
        Connection conn = getConnection() ;
        String query = "select avg(t.runtime) as rez " +
                "from titles t " +
                "join titles_genres tg on tg.title_id = t.title_id " +
                "where genre = ? " +
                "group by tg.genre " +
                "limit 20 ";
        PreparedStatement preparredStatement = conn.prepareStatement(query);
        preparredStatement.setString(1, genre); ;
        ResultSet results = preparredStatement.executeQuery() ;
        results.next() ;
        String aux = results.getString("rez") ;
        result = Double.parseDouble(aux) ;
        return result;
    }

    /**
     * Given a person's full name, lists all the characters they have played.
     *
     * @param actorFullname A string of the person's full name
     * @return A collection of strings corresponding to the character names the provided person has played
     */
    @Override
    public Collection<String> getPlayedCharacters(String actorFullname) throws SQLException {
        Collection<String> result = new LinkedList<String>();
        Connection conn = getConnection() ;
        String query = "select distinct character_name \n" +
                "from persons p \n" +
                "join title_person_character tpc on tpc.person_id = p.person_id\n" +
                "where p.full_name = ? \n" +
                "limit 20 ";
        PreparedStatement preparredStatement = conn.prepareStatement(query);
        preparredStatement.setString(1, actorFullname); ;
        ResultSet results = preparredStatement.executeQuery() ;
        while(results.next()){
            result.add(results.getString("character_name") + "\n") ;
        }
        return result;
    }
}
