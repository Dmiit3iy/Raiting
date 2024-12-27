import model.Player;
import util.ExcelUtil;
import util.Util;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Player> playerList = Util.playersList(15000);
            ExcelUtil.writeXlxs(ExcelUtil.createXlxs(Util.sortByScoreDesc(playerList)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
