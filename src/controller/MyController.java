package controller;

import model.Model;
import model.data.*;
import sun.awt.image.ImageWatched;
import view.View;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

public class MyController implements Observer {
    private View ui;
    private Model model;
    private Controller controller;
    private HashMap<String, Command> commands;

    public MyController(View v, Model m) {
        ui = v;
        model = m;
        controller = new Controller();
        controller.start();
        initCommands();

    }

    protected void initCommands() {
        commands = new HashMap<String, Command>();
        commands.put("MOVE", new MoveLevelCommand(model));
        commands.put("DISPLAY", new DisplayLevelCommand(model, ui));
        commands.put("LOAD", new LoadLevelCommand(model));
        commands.put("SAVE", new SaveLevelCommand(model));
        commands.put("LEADERBOARD", new LeaderboardCommand(model));
        commands.put("ADDUSER", new AddUserCommand(model));
        commands.put("SOLVE", new SolveCommand(model));


    }

    @Override
    public void update(Observable o, Object arg) {
        LinkedList<String> params = (LinkedList<String>) arg;
            String commandKey = params.removeFirst();
            Command c = commands.get(commandKey.toUpperCase());
            if (c == null) {
                ui.displayMessage(c);
                return;
            }
            System.out.println("sending: " + commandKey + "," + params + " params size:" + params.size());
            c.setParams(params);
            controller.insertCommand(c);

        }
    }

