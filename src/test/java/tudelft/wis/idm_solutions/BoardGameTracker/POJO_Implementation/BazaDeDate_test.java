package tudelft.wis.idm_solutions.BoardGameTracker.POJO_Implementation;

import org.junit.jupiter.api.Test;
import org.tinylog.Logger;
import tudelft.wis.idm_tasks.Queries_BazaDeDate;
import tudelft.wis.idm_tasks.boardGameTracker.BgtException;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.BoardGame;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.Player;

import java.sql.SQLException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

public class BazaDeDate_test {
    @Test
    public void testAllPlayer() throws BgtException, SQLException {
        Queries_BazaDeDate dataManager = new Queries_BazaDeDate();
        Logger.info("All players :  \n" + dataManager.getAllPlayers()) ;
    }
    @Test
    public void insertJucatorDb() throws SQLException, BgtException {
        Queries_BazaDeDate dataManager = new Queries_BazaDeDate();
        String name = "gica" ;
        String nickname = "colemn" ;
        Logger.info(dataManager.createNewPlayer(name, nickname));
    }
    @Test
    public void testPlayerByName() throws BgtException, SQLException {
        Queries_BazaDeDate dataManager = new Queries_BazaDeDate();
        Collection<Player> rez = dataManager.findPlayersByName("ica") ;
        AtomicReference<String> fin = new AtomicReference<>("");
        rez.forEach(x -> fin.set(fin + "\n" + x.toVerboseString()));
        Logger.info("Players containting ica in name : \n" + fin) ;
    }
    @Test
    public void insertBoardGame() throws SQLException, BgtException {
        Queries_BazaDeDate dataManager = new Queries_BazaDeDate();
        String name = "monopoly2" ;
        String url = "monoply2.ro" ;
        Logger.info(dataManager.createNewBoardgame(name, url).toVerboseString());
    }
    @Test
    public void testBoardGameByName() throws BgtException, SQLException {
        Queries_BazaDeDate dataManager = new Queries_BazaDeDate();
        Collection<BoardGame> rez = dataManager.findGamesByName("poly") ;
        AtomicReference<String> fin = new AtomicReference<>("");
        rez.forEach(x -> fin.set(fin + "\n" + x.toVerboseString()));
        Logger.info("Board games containing poly in name :  \n" + fin) ;
    }
}
