package model.data;

import model.Model;
import view.View;

import java.io.IOException;

public class HintCommand extends Command {
    private Model model;

    public HintCommand(Model v)
    {
        this.model=v;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        model.hint();
    }
}
