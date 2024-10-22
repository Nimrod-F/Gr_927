package model.expresions;


import model.adt.MyIDictionary;
import model.value.IValue;

public class ValueExpression implements IExpression {

    private IValue value;

    public ValueExpression(IValue value) {
        this.value = value;
    }

    @Override
    public IValue eval(MyIDictionary<String, IValue> symTbl) {
        return value;
    }

    public String toString(){
        return value.toString();
    }
}
