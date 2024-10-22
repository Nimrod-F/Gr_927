package model.expresions;

import exceptions.ADTException;
import model.adt.MyIDictionary;
import model.value.IValue;

public class VariableExpression implements IExpression {

    private String variable;

    public VariableExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public IValue eval(MyIDictionary<String, IValue> symTbl) throws ADTException {
        return symTbl.getValue(variable);
    }

    public String toString(){
        return variable;
    }
}
