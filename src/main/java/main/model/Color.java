package main.model;

public enum Color {
    red,
    green,
    blue,
    yellow,
    wild;
    public String toString() {
        if(this == red) return "red";
        if(this == green) return "green";
        if(this == blue) return "blue";
        if(this == yellow) return "yellow";
        else return "wild";
    }
    public int getHash() {
        switch(this){
            case red ->{return 1;}
            case green ->{return 2;}
            case blue ->{return 3;}
            case yellow ->{return 4;}
            case wild ->{return 5;}
            default ->{return -1;}
        }
    }
}
