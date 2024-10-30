package model.statements;
import exceptions.ADTException;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.state.PrgState;

import java.io.IOException;

public interface IStatement {
    PrgState execute(PrgState prgState) throws StatementException, ADTException, ExpressionException, IOException;
    IStatement deepCopy();
}
