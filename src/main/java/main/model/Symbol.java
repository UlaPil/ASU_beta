package main.model;

public enum Symbol {
    block(true),
    reverse(true),
    plusTwo(true),
    plusFour(true),
    changeColor(true),
    zero(false),
    one(false),
    two(false),
    three(false),
    four(false),
    five(false),
    six(false),
    seven(false),
    eight(false),
    nine(false);

    boolean special;

    Symbol(boolean spec) {
        special = spec;
    }

    public boolean isSpecial() {
        return special;
    }
    public int getHash() {
        switch (this) {
            case zero -> {return 1;}
            case one -> {return 2;}
            case two -> {return 3;}
            case three -> {return 4;}
            case four -> {return 5;}
            case five -> {return 6;}
            case six -> {return 7;}
            case seven -> {return 8;}
            case eight -> {return 9;}
            case nine -> {return 10;}
            case block -> {return 11;}
            case plusTwo -> {return 12;}
            case plusFour -> {return 13;}
            case changeColor -> {return 14;}
            case reverse -> {return 15;}
            default -> {return -1;}
        }

    }
    public Symbol getSymbolOfNumber(int i) {
        if(i == 0) return zero;
        if(i == 1) return one;
        if(i == 2) return two;
        if(i == 3) return three;
        if(i == 4) return four;
        if(i == 5) return five;
        if(i == 6) return six;
        if(i == 7) return seven;
        if(i == 8) return eight;
        else return nine;
    }

    public String toString() {
        if(this == block) return "block";
        if(this == reverse) return "reverse";
        if(this == changeColor) return "changeColor";
        if(this == plusTwo) return "plusTwo";
        if(this == plusFour) return "plusFour";
        if(this == zero) return "zero";
        if(this == one) return "one";
        if(this == two) return "two";
        if(this == three) return "three";
        if(this == four) return "four";
        if(this == five) return "five";
        if(this == six) return "six";
        if(this == seven) return "seven";
        if(this == eight) return "eight";
        else return "nine";
    }
}
