package main.model;

public enum Color {
    red,
    green,
    blue,
    yellow,
    black;
    public String toString() {
        if(this == red) return "red";
        if(this == green) return "green";
        if(this == blue) return "blue";
        if(this == yellow) return "yellow";
        else return "black";
    }
}
