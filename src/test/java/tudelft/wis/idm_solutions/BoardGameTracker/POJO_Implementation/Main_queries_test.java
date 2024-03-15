/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tudelft.wis.idm_solutions.BoardGameTracker.POJO_Implementation;

import org.junit.jupiter.api.Test;
import org.tinylog.Logger;
import tudelft.wis.idm_tasks.Main_Queries;
import tudelft.wis.idm_tasks.Main_Queries;
import tudelft.wis.idm_tasks.boardGameTracker.BgtException;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.BgtDataManager;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.BoardGame;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.PlaySession;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.Player;

import java.sql.SQLException;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main_queries_test {
    public Main_queries_test(){

    }
    @Test
    public void basicTest() throws BgtException, SQLException {
        Main_Queries dataManager = new Main_Queries();
        Logger.info("THIS IS THE RESULT \n" + dataManager.getTitlesPerYear(1999)) ;
    }
}