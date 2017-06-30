package model.data;

import view.View;

import java.io.IOException;

public class DisplayHintCommand extends Command{
    private View view;

    public DisplayHintCommand(View view)
    {
        this.view=view;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        if(!params.isEmpty())
        {
            System.out.println("Sending display hint command with"+params.get(0));
            view.displayHint(params.get(0));
        }
    }
}
