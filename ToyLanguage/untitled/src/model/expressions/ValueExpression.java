package model.expressions;

import exceptions.ExpressionException;
import model.adts.MyIMap;
import model.types.IType;
import model.values.IValue;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ValueExpression implements IExpression {

    private IValue value;

    public ValueExpression(IValue value) {
        this.value = value;
    }


    @Override
    public IValue evaluate(MyIMap<String, IValue> symTable) throws ExpressionException {
        return this.value;
        ///////////////////////////////////////////////////////////////////////////
        //return this.value.deepcopy();
    }

    @Override
    public IExpression deepCopy() {
        //////////////////////////////////////////////////////////////////////
        return new ValueExpression(this.value);
    }


    @Override
    public String toString() {
        return this.value.toString();
    }
}
