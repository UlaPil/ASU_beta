package core;

public class RealPlayer implements Player{

    private Hand myHand = new Hand();


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
