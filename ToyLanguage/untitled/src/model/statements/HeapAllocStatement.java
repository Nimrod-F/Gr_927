package model.statements;

import exceptions.ExpressionException;
import exceptions.KeyNotFoundException;
import exceptions.StatementException;
import model.expressions.IExpression;
import model.states.PrgState;
import model.types.IType;
import model.types.RefType;
import model.values.IValue;
import model.values.RefValue;

public class HeapAllocStatement implements IStatement {
    String var;
    IExpression expr;

    public HeapAllocStatement(String var, IExpression expr) {
        this.var = var;
        this.expr = expr;
    }

    @Override
    public PrgState execute(PrgState prgState) throws StatementException, KeyNotFoundException, ExpressionException {
        if (!prgState.getSymTable().contains(var)) {
            throw new StatementException("Variable name not in symtable.");
        }
        IValue variableValue = prgState.getSymTable().getValue(var);
        if (!(variableValue instanceof RefType)) {
            throw new StatementException("Variable must be RefType");
        }
        IValue evalExpr = expr.evaluate(prgState.getSymTable(), prgState.getHeap());
        if (!variableValue.getType().equals(evalExpr.getType())) {
            throw new StatementException("Wrong type");
        }
        int addr = prgState.getHeap().allocate(evalExpr);
        prgState.getSymTable().insert(var, new RefValue(addr, variableValue.getType()));
        return prgState;
    }

    @Override
    public IStatement deepCopy() {
        return new HeapAllocStatement(var, expr);
    }
}
