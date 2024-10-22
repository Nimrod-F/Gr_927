package model.statements;

import model.state.PrgState;
import model.expresions.IExpression;
import model.value.IValue;

public class PrintStatement implements IStatement{
    private IExpression expression;
    public PrintStatement(IExpression expression) {
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState prgState) {
        IValue result = this.expression.eval(prgState.getSymTable());
        prgState.getOutput().add(result.toString());
        return prgState;
    }
    public String toString(){
        return "print(" + expression.toString() + ")";
    }
}
