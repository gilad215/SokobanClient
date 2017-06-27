package model.data;

import model.Model;

import java.io.IOException;

public class SolveCommand extends Command {
    private Model model;

    public SolveCommand(Model m){this.model=m;}
    @Override
    public void execute() throws IOException {
        try {
			this.model.solve();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
