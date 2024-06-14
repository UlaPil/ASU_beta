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
