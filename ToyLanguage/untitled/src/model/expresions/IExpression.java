package model.expresions;

import exceptions.ADTException;
import exceptions.ExpressionException;
import model.value.IValue;
import model.state.PrgState;
import model.adt.MyIDictionary;

public interface IExpression {
    IValue eval(MyIDictionary<String, IValue> symTbl) throws ADTException, ExpressionException;
    IExpression deepCopy();
}
