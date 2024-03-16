package tudelft.wis.idm_solutions.BoardGameTracker;

import java.util.Collection;
import java.util.LinkedList;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.BoardGame;
import tudelft.wis.idm_tasks.boardGameTracker.interfaces.Player;

public class PlayerClass implements Player {

    private String name;
    private String nickName;
    private Collection<BoardGame> gameCollection = new LinkedList<BoardGame>();

    /**
     * new Player.
     *
     * @param name     name
     * @param nickName nickname
     */
    public PlayerClass(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }
    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public String getPlayerNickName() {
        return nickName;
    }

    @Override
    public Collection<BoardGame> getGameCollection() {
        return gameCollection;
    }


    @Override
    public String toVerboseString() {
        String result = name;
        if (nickName != null) {
            result = result + " (" + nickName + ")";
        }
        return result;
    }

}


