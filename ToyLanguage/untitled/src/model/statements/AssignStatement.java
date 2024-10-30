package model.statements;

import exceptions.ADTException;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.expresions.IExpression;
import model.state.PrgState;
import model.value.IValue;

public class AssignStatement implements IStatement{
    private String variableName;
    private IExpression expression;
    public AssignStatement(String variableName, IExpression expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState prgState) throws StatementException, ADTException, ExpressionException {
        if (!prgState.getSymTable().contains(this.variableName)) {
            throw new StatementException("Variable was not found");
        }
        IValue value = prgState.getSymTable().getValue(this.variableName);
        IValue evalValue = this.expression.eval(prgState.getSymTable());
        if (!value.getType().equals(evalValue.getType())){
            throw new StatementException("Value type mismatch");
        }
        prgState.getSymTable().insert(this.variableName, evalValue);
        return prgState;
    }

    @Override
    public IStatement deepCopy() {
        return new AssignStatement( new String(this.variableName),  this.expression.deepCopy());
    }

    @Override
    public String toString(){
        return this.variableName + " = " + this.expression.toString();
    }
}
