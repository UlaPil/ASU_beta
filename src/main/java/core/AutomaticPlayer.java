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
    public boolean playCard(int index){
        int i = 1;
        while(true) {
            try {
                if(player.playCard(i)) {
                    return true;
                }
                i++;
            } catch(RuntimeException e) {
                try{draw(1); player.playCard(i);} catch (Exception x) {return false;}
            }
        }
    }
}
