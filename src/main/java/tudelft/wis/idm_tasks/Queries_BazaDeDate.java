package tudelft.wis.idm_tasks;

import tudelft.wis.idm_solutions.BoardGameTracker.POJO_Implementation.Player_POJO;
import tudelft.wis.idm_tasks.boardGameTracker.BgtException;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.BgtDataManager;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.BoardGame;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.PlaySession;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.Player;

import java.sql.*;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Queries_BazaDeDate implements BgtDataManager {
    private static Connection connection;
    private List<Title> titles = new LinkedList<Title>() ;
    /**
     * Establishes the connection to the PostgreSQL database.
     *
     * @return The connection object. If a connection couldn't be established, returns null
     */
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/bazaDeDate";
            String user = "postgres";
            String password = "12345rita";
            Connection conn = DriverManager.getConnection(url, user, password);
            connection = conn ;
        };
        return connection;
    }

    public Collection<String> getAllPlayers() throws SQLException {
        Collection<String> result = new LinkedList<String>();
        Connection conn = getConnection() ;
        String query = "Select * from playertable" ;
        PreparedStatement preparredStatement = conn.prepareStatement(query);
        ResultSet results = preparredStatement.executeQuery() ;
        while(results.next()){
            result.add(results.getString("name") + "\n") ;
        }
        return result;
    }

    /**
     * Creates a new player and stores it in the DB.
     *
     * @param name     the player name
     * @param nickname the player nickname
     * @return the new player
     * @throws SQLException DB trouble
     */
//    @Override
//    public Player createNewPlayer(String name, String nickname) throws BgtException, SQLException {
//        Connection conn = getConnection() ;
//        String query = "INSERT INTO playertable (pid, name, nickname) VALUES (?, ?, ?)" ;
//        PreparedStatement preparredStatement = conn.prepareStatement(query);
//        preparredStatement.setInt(1, (int) (name.length()*Math.random() * 1000)) ;
//        preparredStatement.setString(2, name) ;
//        preparredStatement.setString(3, nickname) ;
//        ResultSet result = preparredStatement.executeQuery() ;
//        return new Player_POJO(name, nickname) ;
//    }

    public Player createNewPlayer(String name, String nickname) throws BgtException, SQLException {
        Connection conn = getConnection();
        String query = "INSERT INTO playertable (pid, name, nickname) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, (int) (name.length() * Math.random() * 1000));
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, nickname);
        int affectedRows = preparedStatement.executeUpdate(); // Correct method to use

        // Check if the insert was successful
        if (affectedRows > 0) {
            return new Player_POJO(name, nickname);
        } else {
            // Handle the case where the player was not inserted
            throw new SQLException("Creating player failed, no rows affected.");
        }
    }


    // documentation : POGO = Player_Old_Jdbc_Object
    /**
     * Searches for player in the database by a substring of their name.
     *
     * @param name the name substring to use, e.g., searching for "hris" will find "Christoph"
     * @return collection of all players containing the param substring in their names
     * @throws BgtException the bgt exception
     */
    @Override
    public Collection<Player> findPlayersByName(String name) throws BgtException {
        return null;
    }

    /**
     * Creates a new board game and stores it in the DB.
     * <p>
     * Note: These "create" methods are somewhat unnecessary. However, I put
     * them here to make the task test a bit easier. You can call an appropriate
     * persist method for this.
     *
     * @param name   the name of the game
     * @param bggURL the URL of the game at BoardGameGeek.com
     * @return the new game
     * @throws SQLException DB trouble
     */
    @Override
    public BoardGame createNewBoardgame(String name, String bggURL) throws BgtException {
        return null;
    }

    /**
     * Searches for game in the database by a substring of their name.
     *
     * @param name the name substring to use, e.g., searching for "clips" will
     *             find "Eclipse: Second Dawn of the Galaxy""
     * @return collection of all boardgames containing the param substring in their names
     */
    @Override
    public Collection<BoardGame> findGamesByName(String name) throws BgtException {
        return null;
    }

    /**
     * Creates a new play session and stores it in the DB.
     *
     * @param date     the date of the session
     * @param host     the session host
     * @param game     the game which was played
     * @param playtime the approximate playtime in minutes
     * @param players  all players
     * @param winner   the one player who won (NULL in case of no winner; multiple
     *                 winners not supported)
     * @return the new play session
     */
    @Override
    public PlaySession createNewPlaySession(Date date, Player host, BoardGame game, int playtime, Collection<Player> players, Player winner) throws BgtException {
        return null;
    }

    /**
     * Finds all play sessions from a specific date
     *
     * @param date the date to search from
     * @return collection of all play sessions from the param date
     * @throws BgtException the bgt exception
     */
    @Override
    public Collection<PlaySession> findSessionByDate(Date date) throws BgtException {
        return null;
    }


    /**
     * Persists a given player to the DB. Note that this player might already eexist and only needs an updat :-)
     *
     * @param player the player
     */
    @Override
    public void persistPlayer(Player player) throws SQLException, BgtException {
        createNewPlayer(player.getPlayerName(), player.getPlayerNickName()) ;
    }

    /**
     * Persists a given session to the DB. Note that this session might already exist and only needs an update :-)
     *
     * @param session the session
     */
    @Override
    public void persistPlaySession(PlaySession session) {

    }

    /**
     * Persists a given game to the DB. Note that this game might already exist and only needs an update :-)
     *
     * @param game the game
     */
    @Override
    public void persistBoardGame(BoardGame game) {

    }
}
