package model.expresions;

import exceptions.ADTException;
import exceptions.ExpressionException;
import model.adt.MyIDictionary;
import model.types.IntType;
import model.value.IValue;
import model.value.IntValue;

public class AritmeticalExpression implements IExpression {
    private IExpression left;
    private IExpression right;
    private AritmeticalOperator operator;

    public AritmeticalExpression(IExpression left, AritmeticalOperator operator, IExpression right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public IValue eval(MyIDictionary<String, IValue> symTbl) throws ADTException, ExpressionException {
        IValue value1 = left.eval(symTbl);
        IValue value2 = right.eval(symTbl);
        if (!value1.getType().equals(new IntType())) {
            throw new ExpressionException("First value is not int");
        }
        if (!value2.getType().equals(new IntType())) {
            throw new ExpressionException("Second value is not int");
        }

        IntValue int1 = (IntValue) value1;
        IntValue int2 = (IntValue) value2;

        switch (operator) {
            case ADD:
                return new IntValue(int1.getValue() + int2.getValue());
            case SUBTRACT:
                return new IntValue(int1.getValue() - int2.getValue());
            case MULTIPLY:
                return new IntValue(int1.getValue() * int2.getValue());
            case DIVIDE:
            {
                if(int2.getValue() == 0)
                    throw new ExpressionException("Divide by zero");
                return new IntValue(int1.getValue() / int2.getValue());
            }
            default:
                throw new ExpressionException("Unknown operator");

        }

    }
}
