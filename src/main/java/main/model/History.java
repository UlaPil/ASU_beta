package main.model;

import javafx.util.Pair;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class History implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public ArrayList<Pair<String, Boolean>> history;
    public History() {
        history = new ArrayList<>();
    }
    public void add(String date, boolean ifWin) {

        history.add(new Pair<>(date, ifWin));
    }
    public ArrayList<Pair<String, Boolean>> getHistory() {
        return this.history;
    }
}
