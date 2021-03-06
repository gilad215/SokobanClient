package model.data;

import model.Model;

public class SaveLevelCommand extends Command {
    private Model model;

    public SaveLevelCommand(Model m) {
        this.model = m;
    }

    @Override
    public void execute() {
        String path = params.get(0);
        model.save(path);
    }
}
