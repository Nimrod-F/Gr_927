package model.statements;

import com.sun.jdi.BooleanType;
import exceptions.ExpressionException;
import exceptions.KeyNotFoundException;
import exceptions.StatementException;
import model.expressions.IExpression;
import model.states.PrgState;
import model.types.BoolType;
import model.values.BoolValue;
import model.values.IValue;

public class IfStatement implements IStatement {
    private IExpression expression;
    private IStatement thanStatement;
    private IStatement elseStatement;

    public IfStatement(IExpression expression, IStatement thanStatement, IStatement elseIStatement) {
        this.expression = expression;
        this.thanStatement = thanStatement;
        this.elseStatement = elseIStatement;

    }

    @Override
    public PrgState execute(PrgState prgState) throws StatementException, ExpressionException, KeyNotFoundException {
        IValue value = this.expression.evaluate(prgState.getSymTable());
        if (!value.getType().equals(new BoolType())) {
            throw new StatementException("Expression is not boolean");
        }

        if (((BoolValue) value).getValue()) {
            prgState.getExecStack().push(this.thanStatement);
        } else {
            prgState.getExecStack().push(this.elseStatement);
        }

        return prgState;

    }


    @Override
    public IStatement deepCopy() {
        return new IfStatement(this.expression.deepCopy(), this.thanStatement.deepCopy(), this.elseStatement.deepCopy());
    }


    @Override
    public String toString() {
        return "if(" + this.expression.toString() + "){" + this.thanStatement.toString() + "}else{" + this.elseStatement.toString() + "}";

    }
}
