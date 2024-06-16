package main.viewModel;

import main.view.Game.GameEndObserver;

import java.time.LocalDateTime;

public class GameEndManager {
    private final GameEndObserver gameEndObserver;
    public GameEndManager() {
        gameEndObserver = new GameEndObserver();
    }
    public void notify(int index) {
        LocalDateTime now = LocalDateTime.now();
        HistorySerializer.addMatch(now.getYear() + "." + now.getMonthValue() + "." + now.getDayOfMonth() + " " + now.getHour() + ":" + now.getMinute(), index == 0 );
        gameEndObserver.notify(index);
    }
}
