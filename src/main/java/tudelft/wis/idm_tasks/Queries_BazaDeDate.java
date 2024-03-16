package tudelft.wis.idm_tasks;

import tudelft.wis.idm_solutions.BoardGameTracker.POJO_Implementation.BoardGame_POJO;
import tudelft.wis.idm_solutions.BoardGameTracker.PlayerClass;
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

    /**
     * get all players in the db
     * @return all players
     * @throws SQLException
     */
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
    public Player createNewPlayer(String name, String nickname) throws BgtException, SQLException {
        Connection conn = getConnection();
        String query = "INSERT INTO playertable (pid, name, nickname) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, (int) (name.length() * Math.random() * 1000));
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, nickname);
        int affectedRows = preparedStatement.executeUpdate(); // Correct method to use

        if (affectedRows > 0) {
            return new PlayerClass(name, nickname);
        } else {
            throw new SQLException("Creating player failed, no rows affected.");
        }
    }
    /**
     * Searches for player in the database by a substring of their name.
     *
     * @param name the name substring to use, e.g., searching for "hris" will find "Christoph"
     * @return collection of all players containing the param substring in their names
     * @throws BgtException the bgt exception
     */
    @Override
    public Collection<Player> findPlayersByName(String name) throws BgtException, SQLException {
        Collection<Player> result = new LinkedList<Player>();
        Connection conn = getConnection() ;
        name = "%" + name + "%" ;
        String query = "select name, nickname \n" +
                "from playertable p\n" +
                "where p.name like ?" ;
        PreparedStatement preparredStatement = conn.prepareStatement(query);
        preparredStatement.setString(1, name);
        ResultSet results = preparredStatement.executeQuery() ;
        while(results.next()){
            String nm = results.getString("name") ;
            String nck = results.getString("nickname" );
            result.add(new PlayerClass(nm, nck)) ;
        }
        return result;
    }

    /**
     * Creates a new board game and stores it in the DB.
     *
     * @param name   the name of the game
     * @param url the URL of the game at BoardGameGeek.com
     * @return the new game
     * @throws SQLException DB trouble
     */
    @Override
    public BoardGame createNewBoardgame(String name, String url) throws BgtException, SQLException {
        Connection conn = getConnection();
        String query = "INSERT INTO boardgametable (bid, name, url) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, (int) (name.length() * Math.random() * 1000));
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, url);
        int affectedRows = preparedStatement.executeUpdate(); // Correct method to use

        // Check if the insert was successful
        if (affectedRows > 0) {
            return new BoardGame_POJO(name, url) ;
        } else {
            // Handle the case where the player was not inserted
            throw new SQLException("Creating boardgame failed, no rows affected.");
        }
    }

    /**
     * Searches for game in the database by a substring of their name.
     *
     * @param name the name substring to use, e.g., searching for "clips" will
     *             find "Eclipse: Second Dawn of the Galaxy""
     * @return collection of all boardgames containing the param substring in their names
     */
    @Override
    public Collection<BoardGame> findGamesByName(String name) throws BgtException, SQLException {
        Collection<BoardGame> result = new LinkedList<BoardGame>();
        Connection conn = getConnection() ;
        name = "%" + name + "%" ;
        String query = "select name, url \n" +
                "from boardgametable b\n" +
                "where b.name like ?" ;
        PreparedStatement preparredStatement = conn.prepareStatement(query);
        preparredStatement.setString(1, name);
        ResultSet results = preparredStatement.executeQuery() ;
        while(results.next()){
            String nm = results.getString("name") ;
            String url = results.getString("url" );
            result.add(new BoardGame_POJO(nm, url)) ;
        }
        return result;
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
     * Persists a given player to the DB.
     *
     * @param player the player
     */
    @Override
    public void persistPlayer(Player player) throws SQLException, BgtException {
        createNewPlayer(player.getPlayerName(), player.getPlayerNickName()) ;
    }

    /**
     * Persists a given session to the DB.
     *
     * @param session the session
     */
    @Override
    public void persistPlaySession(PlaySession session) {

    }

    /**
     * Persists a given game to the DB.
     *
     * @param game the game
     */
    @Override
    public void persistBoardGame(BoardGame game) throws SQLException, BgtException {
        createNewBoardgame(game.getName(), game.getBGG_URL()) ;
    }
}
