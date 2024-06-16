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
            }catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
        ObjectInputStream oos = new ObjectInputStream(fis);
        return (History) oos.readObject();
    }
    public static void serialize(History history) throws IOException, ClassNotFoundException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
        }
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(history);
    }
    public static void addMatch(String date, boolean ifWin) {
        History history = new History();
        try {
            history = deserialize();
        } catch(Exception e) {
            e.printStackTrace();
        }
        history.add(date, ifWin);
        try {
            serialize(history);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static History getHistory() {
        History history = new History();
        try {
            history = deserialize();
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            serialize(history);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return history;
    }
}
