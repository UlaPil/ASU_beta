package main.viewModel;

import main.model.History;

import java.io.*;
public class HistorySerializer {
    private static final String filePath = "src/main/resources/history.txt";
    public static History deserialize() throws IOException, ClassNotFoundException {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            try {
                fis = new FileInputStream(file);
            }catch (FileNotFoundException ignored) {
            }
        }
        ObjectInputStream oos = new ObjectInputStream(fis);
        return (History) oos.readObject();
    }
    public static void serialize(History history) throws IOException {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            fos = new FileOutputStream(file);
        }
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(history);
    }
    public static void addMatch(String date, boolean ifWin) {
        History history = new History();
        try {
            history = deserialize();
        } catch(Exception ignored) {}
        history.add(date, ifWin);
        try {
            serialize(history);
        }catch(Exception ignored) {}
    }
    public static History getHistory() {
        History history = new History();
        try {
            history = deserialize();
        } catch(Exception ignored) {}
        try {
            serialize(history);
        }catch(Exception ignored) {}
        return history;
    }
}
