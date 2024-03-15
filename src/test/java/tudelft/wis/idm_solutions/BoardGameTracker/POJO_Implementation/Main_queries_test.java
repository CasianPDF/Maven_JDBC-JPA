/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tudelft.wis.idm_solutions.BoardGameTracker.POJO_Implementation;

import org.junit.jupiter.api.Test;
import org.tinylog.Logger;
import tudelft.wis.idm_tasks.Main_queries;
import tudelft.wis.idm_tasks.boardGameTracker.BgtException;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.BgtDataManager;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.BoardGame;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.PlaySession;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.Player;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type POJO test.
 *
 * @author Christoph Lofi, Alexandra Neagu
 */
public class Main_queries_test {
    public Main_queries_test(){

    }
    private Main_queries dataManager = new Main_queries();

    public Main_queries getMain_queries() {
        return dataManager;
    }
    @Test
    public void basicTest() throws BgtException {
        Logger.info("THIS IS THE RESULT \n" + dataManager.getTitlesPerYear(1999)) ;
    }
}