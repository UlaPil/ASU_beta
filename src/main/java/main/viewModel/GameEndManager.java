package main.viewModel;

import main.view.GameEndObserver;

import java.time.LocalDateTime;

public class GameEndManager {
    GameEndObserver gameEndObserver;
    public GameEndManager() {
        gameEndObserver = new GameEndObserver();
    }
    public void notify(int index) {
        HistorySerializer.addMatch(LocalDateTime.now().toString(), index == 0 );
        gameEndObserver.notify(index);
    }
}
