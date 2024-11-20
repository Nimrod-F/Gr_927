package model.statements;

import exceptions.ExpressionException;
import exceptions.KeyNotFoundException;
import exceptions.StatementException;
import model.states.PrgState;

public interface IStatement {
    PrgState execute(PrgState prgState) throws StatementException, KeyNotFoundException, ExpressionException;

    IStatement deepCopy();
}
