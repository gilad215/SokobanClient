package model;

import model.data.Level;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Model {
    void load(String input);
    void save(String input);
    void move(String direction);
    void showLeaderboard() throws FileNotFoundException;
    void solve() throws IOException;
    void addUser(String fn, String ln, int steps, int time);
    public Level getLvl();


}
