package model.expressions;

import exceptions.ExpressionException;
import exceptions.KeyNotFoundException;
import model.adts.MyIMap;
import model.types.IntType;
import model.values.BoolValue;
import model.values.IValue;
import model.values.IntValue;

public class RelationalExpression implements IExpression {

    private IExpression leftExpression;
    private IExpression rightExpression;
    private RelationalOperator operator;

    public RelationalExpression(IExpression lefExpression, IExpression rightExpression, RelationalOperator operator) {
        this.leftExpression = lefExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public IValue evaluate(MyIMap<String, IValue> symTable) throws ExpressionException, KeyNotFoundException {

        IValue value1 = this.leftExpression.evaluate(symTable);
        IValue value2 = this.rightExpression.evaluate(symTable);
        if (!value1.getType().equals(new IntType()))
            throw new ExpressionException("First value must be int");
        if (!value2.getType().equals(new IntType()))
            throw new ExpressionException("Second value must be int");

        int intValue1 = ((IntValue) value1).getValue();
        int intValue2 = ((IntValue) value2).getValue();

        switch (this.operator) {
            case LessOrEqual -> {
                return new BoolValue(intValue1 <= intValue2);
            }
            case LessThan -> {
                return new BoolValue(intValue1 < intValue2);
            }
            case Equal -> {
                return new BoolValue(intValue1 == intValue2);
            }
            case GreaterThan -> {
                return new BoolValue(intValue1 > intValue2);
            }
            case GreaterOrEqual -> {
                return new BoolValue(intValue1 >= intValue2);
            }
            case Different -> {
                return new BoolValue(intValue1 != intValue2);
            }
            default -> {
                throw new ExpressionException("Invalid operator");
            }
        }
    }

    @Override
    public IExpression deepCopy() {
        return new RelationalExpression(this.leftExpression.deepCopy(), this.rightExpression.deepCopy(), this.operator);
    }

    @Override
    public String toString() {
        return this.leftExpression.toString() + " " + this.operator + " " + this.rightExpression.toString();
    }

}
