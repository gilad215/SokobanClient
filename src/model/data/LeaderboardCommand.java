package model.data;

import model.Model;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LeaderboardCommand extends Command {
    private Model model;

    public LeaderboardCommand(Model m) {
        this.model =m;
    }


    @Override
    public void execute() {

            try {
                model.showLeaderboard();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    }
