package controller;

import repository.IRepository;
import repository.Repository;
import view.commands.Command;

public class Controller {

    private IRepository repo;

    public Controller(IRepository repo){
        this.repo = repo;

    }

    public void allSteps(){

    }
}
