package model.statements;

import exceptions.ExpressionException;
import exceptions.KeyNotFoundException;
import exceptions.StatementException;
import model.expressions.IExpression;
import model.states.PrgState;
import model.types.StringType;
import model.values.IValue;
import model.values.StringValue;

import java.io.IOException;

public class CloseRFileStatement implements IStatement {

    private IExpression expression;

    public CloseRFileStatement(IExpression expression) {
        this.expression = expression;
    }


    @Override
    public PrgState execute(PrgState prgState) throws StatementException, KeyNotFoundException, ExpressionException {
        IValue value = this.expression.evaluate(prgState.getSymTable());
        if (!value.getType().equals(new StringType()))
            throw new StatementException("The result of the expression is not a StringType");

        StringValue fileName = (StringValue) value;
        if (!prgState.getFileTable().contains(fileName))
            throw new StatementException("The file was not found");

        try {
            prgState.getFileTable().getValue(fileName).close();
            prgState.getFileTable().remove(fileName);
            return prgState;
        } catch (IOException e) {
            throw new StatementException("Problem at closing the BufferedReader");
        }


    }

    @Override
    public IStatement deepCopy() {
        return new CloseRFileStatement(this.expression.deepCopy());
    }

    @Override
    public String toString() {
        return "closeRFile(" + this.expression.toString() + ");";
    }
}
