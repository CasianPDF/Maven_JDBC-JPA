package tudelft.wis.idm_solutions.BoardGameTracker.POJO_Implementation;

import oracle.jdbc.driver.json.tree.JsonpPrimitive;
import org.junit.jupiter.api.Test;
import org.tinylog.Logger;
import tudelft.wis.idm_tasks.Main_Queries;
import tudelft.wis.idm_tasks.Queries_BazaDeDate;
import tudelft.wis.idm_tasks.basicJDBC.interfaces.JDBCTask2Interface;
import tudelft.wis.idm_tasks.boardGameTracker.BgtException;

import java.sql.SQLException;

public class BazaDeDate_test {
    @Test
    public void basicTes() throws BgtException, SQLException {
        Queries_BazaDeDate dataManager = new Queries_BazaDeDate();
        Logger.info("THIS IS THE RESULT \n" + dataManager.getAllPlayers()) ;
    }
    @Test
    public void insertJucatorDb() throws SQLException, BgtException {
        Queries_BazaDeDate dataManager = new Queries_BazaDeDate();
        String name = "gica" ;
        String nickname = "colemn" ;
        Logger.info(dataManager.createNewPlayer(name, nickname));
    }
}
