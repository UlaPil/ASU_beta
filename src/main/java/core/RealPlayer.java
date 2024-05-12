package core;

public class RealPlayer implements Player{
    public RealPlayer(String name) {
        this.name = name;
        myHand = new Hand();
    }
    private String name;
    private Hand myHand;
    public String getName() {
        return name;
    }

    @Override
    public boolean didIWin() {
        if(myHand.getSize()==0) return true;
        return false;
    }

    @Override
    public boolean draw() {
        return false;
    }

    public String toString() {
        return myHand.toString();
    }
}
