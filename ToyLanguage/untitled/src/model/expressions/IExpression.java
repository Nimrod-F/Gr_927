package model.expressions;

import exceptions.ExpressionException;
import exceptions.KeyNotFoundException;
import model.adts.MyIHeap;
import model.adts.MyIMap;
import model.values.IValue;

public interface IExpression {
    IValue evaluate(MyIMap<String, IValue> symTable, MyIHeap heap) throws ExpressionException, KeyNotFoundException;
    IExpression deepCopy();

}
