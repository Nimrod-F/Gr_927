package controller;

import exceptions.*;
import model.adts.MyIList;
import model.adts.MyList;
import model.statements.IStatement;
import model.states.PrgState;

public interface IController {

    MyIList<String> allSteps() throws EmptyStackException, StatementException, ControllerException, KeyNotFoundException, ExpressionException, RepoException;

}