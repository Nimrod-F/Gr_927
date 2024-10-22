package model.expresions;


import exceptions.ADTException;
import exceptions.ExpressionException;
import model.adt.MyIDictionary;
import model.types.BoolType;
import model.value.BoolValue;
import model.value.IValue;

public class LogicalExpression implements IExpression {
    private IExpression left;
    private IExpression right;
    private LogicalOperator operator;

    public LogicalExpression(IExpression left, LogicalOperator operator, IExpression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public IValue eval(MyIDictionary<String, IValue> symTbl) throws ADTException, ExpressionException {
        IValue evaluatedExpressionLeft = left.eval(symTbl);
        IValue evaluatedExpressionRight = right.eval(symTbl);
        if (!evaluatedExpressionLeft.getType().equals(new BoolType())) {
            throw new ExpressionException("Left expression is not of type BoolType");
        }
        if (!evaluatedExpressionRight.getType().equals(new BoolType())) {
            throw new ExpressionException("Right expression is not of type BoolType");
        }
        switch (operator) {
            case AND:
                return new BoolValue(((BoolValue) evaluatedExpressionLeft).getValue() &&
                        ((BoolValue) evaluatedExpressionRight).getValue());
            case OR:
                return new BoolValue(((BoolValue) evaluatedExpressionLeft).getValue() ||
                        ((BoolValue) evaluatedExpressionRight).getValue());
            default:
                throw new ExpressionException("Unknown operator");
        }
    }

    @Override
    public String toString() {
        return left.toString() + " " + operator + " " + right.toString();
    }
}
