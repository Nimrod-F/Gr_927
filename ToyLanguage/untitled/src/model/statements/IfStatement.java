package model.statements;


import exceptions.StatementException;
import model.expresions.IExpression;
import model.state.PrgState;
import model.types.BoolType;
import model.value.BoolValue;
import model.value.IValue;

public class IfStatement implements IStatement {
    private IStatement statementThan;
    private IStatement statementElse;
    private IExpression expression;

    public IfStatement(IStatement statementThan, IStatement statementElse, IExpression expression) {
        this.statementThan = statementThan;
        this.statementElse = statementElse;
        this.expression = expression;
    }

    public PrgState execute(PrgState state) throws StatementException{
        IValue value = expression.eval(state.getSymTable());
        if(!value.getType().equals(new BoolType())){
            throw new StatementException("Expression is not boolean");
        }
        if(((BoolValue) value).getValue()){
            state.getExeStack().push(statementThan);
        }
        else {
            state.getExeStack().push(statementElse);
        }

        return state;
    }

    @Override
    public String toString() {
        return "if(" + expression + "){" + statementThan + "}else{" + statementElse + "}\n";
    }

}
