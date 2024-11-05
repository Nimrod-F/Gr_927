package view.commands;

import controller.Controller;

public class RunExempleCommand extends Command {


    private Controller controller;

    public RunExempleCommand(String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        this.controller.allSteps();
    }


}
