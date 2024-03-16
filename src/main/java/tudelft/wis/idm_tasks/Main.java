package tudelft.wis.idm_tasks;

import org.tinylog.Logger;
import tudelft.wis.idm_tasks.boardGameTracker.BgtException;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, BgtException {
        Queries_BazaDeDate dataManager = new Queries_BazaDeDate();
        String name = "gica" ;
        String nickname = "colemn" ;
        Logger.info(dataManager.createNewPlayer(name, nickname).toVerboseString());
    }
}
