package model.statements;

import exceptions.ExpressionException;
import exceptions.KeyNotFoundException;
import exceptions.StatementException;
import model.expressions.IExpression;
import model.states.PrgState;
import model.values.IValue;


public class AssignStatement implements IStatement {


    private String variableName;
    private IExpression expression;

    public AssignStatement(String variableName, IExpression expression) {
        this.variableName = variableName;
        this.expression = expression;
    }


    @Override
    public PrgState execute(PrgState prgState) throws StatementException, KeyNotFoundException, ExpressionException {

        if (!prgState.getSymTable().contains(this.variableName))
            throw new StatementException("Variable not found");

        IValue prevValue = prgState.getSymTable().getValue(this.variableName);
        IValue newValue = this.expression.evaluate(prgState.getSymTable());
        if (!prevValue.getType().equals(newValue.getType()))
            throw new StatementException("Value type does not match");

        prgState.getSymTable().insert(this.variableName, newValue);
        return prgState;
    }

    @Override
    public IStatement deepCopy() {
        return new AssignStatement(new String(this.variableName), this.expression.deepCopy());
    }


    @Override
    public String toString() {
        return this.variableName + " = " + this.expression.toString() + ';';
    }
}

