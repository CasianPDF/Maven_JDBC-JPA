package tudelft.wis.idm_solutions.BoardGameTracker.POJO_Implementation;

import org.junit.jupiter.api.Test;
import org.tinylog.Logger;
import tudelft.wis.idm_tasks.Main_Queries;
import tudelft.wis.idm_tasks.boardGameTracker.BgtException;

import java.sql.SQLException;

public class Main_queries_test {
    @Test
    public void basicTest() throws BgtException, SQLException {
        Main_Queries dataManager = new Main_Queries();
        Logger.info("All movies that start in the year 1999 : \n" + dataManager.getTitlesPerYear(1999)) ;
    }
    @Test
    public void basicTest1() throws BgtException, SQLException {
        Main_Queries dataManager = new Main_Queries();
        Logger.info("All the job categories for titles that have 'war' in their name : \n" + dataManager.getJobCategoriesFromTitles("war")) ;
    }
    @Test
    public void basicTest2() throws BgtException, SQLException {
        Main_Queries dataManager = new Main_Queries();
        Logger.info("Average Runtime of the Action genre : \n" + dataManager.getAverageRuntimeOfGenre("Action")) ;
    }
    @Test
    public void basicTest3() throws BgtException, SQLException {
        Main_Queries dataManager = new Main_Queries();
        Logger.info("Characters played by Chris Evans : \n" + dataManager.getPlayedCharacters("Chris Evans")) ;
    }
}