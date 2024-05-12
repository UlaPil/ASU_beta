package core;

public class AutomaticPlayer implements Player {
    RealPlayer player;
    public AutomaticPlayer(String name, Board board) {
        player = new RealPlayer(name, board);
    }
    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public boolean didIWin() {
        return player.didIWin();
    }

    @Override
    public void draw(int count) throws NoMoreCardsInDeck {
        player.draw(count);
    }

    @Override
    public boolean play(int index){
        int i = 1;
        while(true) {
            try {
                if(player.play(i)) {
                    return true;
                }
            } catch(RuntimeException e) {
                return false;
            }
        }
    }
}
