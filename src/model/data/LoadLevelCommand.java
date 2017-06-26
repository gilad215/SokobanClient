package model.data;

import model.Model;

public class LoadLevelCommand extends Command {
    private Model model;

    public LoadLevelCommand(Model model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.load(params.get(0));
    }
}


