package model.expressions;

import exceptions.ExpressionException;
import exceptions.KeyNotFoundException;
import model.adts.MyIMap;
import model.types.BoolType;
import model.values.IValue;
import model.values.BoolValue;

public class LogicalExpression implements IExpression {

    private IExpression leftExpression;
    private IExpression rightExpression;
    private LogicalOperator operator;

    public LogicalExpression(IExpression leftExpression, IExpression rightExpression, LogicalOperator operator) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }


    @Override
    public IValue evaluate(MyIMap<String, IValue> symTable) throws ExpressionException, KeyNotFoundException {

        IValue value1 = this.leftExpression.evaluate(symTable);
        IValue value2 = this.rightExpression.evaluate(symTable);

        if (!value1.getType().equals(new BoolType()))
            throw new ExpressionException("First value must be boolean");
        if (!value2.getType().equals(new BoolType()))
            throw new ExpressionException("Second value must be boolean");

        boolean boolValue1 = ((BoolValue) value1).getValue();
        boolean boolValue2 = ((BoolValue) value2).getValue();

        switch (this.operator) {
            case AND -> {
                return new BoolValue(boolValue1 && boolValue2);
            }
            case OR -> {
                return new BoolValue(boolValue1 || boolValue2);
            }
            default -> {
                throw new ExpressionException("Invalid operator");
            }
        }


    }


    @Override
    public IExpression deepCopy() {
        return new LogicalExpression(this.leftExpression.deepCopy(), this.rightExpression.deepCopy(), this.operator);
    }

    @Override
    public String toString() {
        return this.leftExpression.toString() + " " + operator + " " + this.rightExpression.toString();
    }
}
