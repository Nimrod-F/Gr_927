package model.expressions;

import exceptions.ExpressionException;
import exceptions.KeyNotFoundException;
import model.adts.MyIMap;
import model.values.IValue;

public class VariableExpression implements IExpression {

    private String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }


    @Override
    public IValue evaluate(MyIMap<String, IValue> symTable) throws ExpressionException, KeyNotFoundException {

        return symTable.getValue(this.variableName);
    }

    @Override
    public IExpression deepCopy() {
        return new VariableExpression(new String(this.variableName));
    }

    @Override
    public String toString() {
        return this.variableName;
    }
}
