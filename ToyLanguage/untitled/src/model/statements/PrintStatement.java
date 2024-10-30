package model.statements;

import exceptions.ADTException;
import exceptions.ExpressionException;
import model.state.PrgState;
import model.expresions.IExpression;
import model.value.IValue;

public class PrintStatement implements IStatement{
    private IExpression expression;
    public PrintStatement(IExpression expression) {
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState prgState) throws ADTException, ExpressionException {
        IValue result = this.expression.eval(prgState.getSymTable());
        prgState.getOutput().add(result.toString());
        return prgState;
    }

    @Override
    public IStatement deepCopy() {
        return new PrintStatement(this.expression);
    }

    public String toString(){
        return "print(" + expression.toString() + ")";
    }
}
