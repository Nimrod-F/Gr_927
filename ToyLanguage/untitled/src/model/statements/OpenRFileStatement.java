package model.statements;

import exceptions.ExpressionException;
import exceptions.KeyNotFoundException;
import exceptions.StatementException;
import model.expressions.IExpression;
import model.states.PrgState;
import model.types.StringType;
import model.values.IValue;
import model.values.StringValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class OpenRFileStatement implements IStatement {

    private IExpression expression;

    public OpenRFileStatement(IExpression expression) {
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState prgState) throws StatementException, KeyNotFoundException, ExpressionException {

        IValue value = this.expression.evaluate(prgState.getSymTable());
        if (!value.getType().equals(new StringType()))
            throw new StatementException("The result of the expression is not a StringType");

        StringValue fileName = (StringValue) value;
        if (prgState.getFileTable().contains(fileName))
            throw new StatementException("The file is already open");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName.getValue()));
            prgState.getFileTable().insert(fileName, reader);
            return prgState;
        } catch (IOException e) {
            throw new StatementException("Problem at opening the file");
        }

    }

    @Override
    public IStatement deepCopy() {
        return new OpenRFileStatement(this.expression.deepCopy());
    }

    @Override
    public String toString() {
        return "openRFile(" + this.expression.toString() + ");";
    }
}
