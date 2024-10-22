package model.statements;
import exceptions.ADTException;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.state.PrgState;

public interface IStatement {
    PrgState execute(PrgState prgState) throws StatementException, ADTException;
}
