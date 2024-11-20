package model.statements;

import exceptions.ExpressionException;
import exceptions.KeyNotFoundException;
import exceptions.StatementException;
import model.adts.MyIMap;
import model.expressions.IExpression;
import model.states.PrgState;
import model.types.IntType;
import model.types.StringType;
import model.values.IValue;
import model.values.IntValue;
import model.values.StringValue;

import java.io.BufferedReader;
import java.io.IOException;


public class ReadFileStatement implements IStatement {


    private IExpression expression;
    private String variableName;

    public ReadFileStatement(IExpression expression, String variableName) {
        this.expression = expression;
        this.variableName = variableName;
    }


    @Override
    public PrgState execute(PrgState prgState) throws StatementException, KeyNotFoundException, ExpressionException {

        MyIMap<String, IValue> symTable = prgState.getSymTable();
        if (!symTable.contains(this.variableName))
            throw new StatementException("Variable not found");

        IValue value = symTable.getValue(this.variableName);
        if (!value.getType().equals(new IntType()))
            throw new StatementException("The variable is not a Int type");

        IValue result = this.expression.evaluate(symTable);
        if (!result.getType().equals(new StringType()))
            throw new StatementException("The result of the expression is not a StringType");

        StringValue fileName = (StringValue) result;

        if (!prgState.getFileTable().contains(fileName))
            throw new StatementException("There is no BufferedReader for that String in the fileTable");

        BufferedReader reader = prgState.getFileTable().getValue(fileName);

        try {
            String line = reader.readLine();
            if (line.isEmpty())
                line = "0";

            int parser = Integer.parseInt(line);

            symTable.insert(this.variableName, new IntValue(parser));
            return prgState;

        } catch (IOException e) {
            throw new StatementException("Problem at reading from the BufferedReader");
        }

    }

    @Override
    public IStatement deepCopy() {
        return new ReadFileStatement(this.expression.deepCopy(), new String(this.variableName));
    }

    @Override
    public String toString() {
        return "readFile(" + this.expression.toString() + ", " + this.variableName + ");";
    }
}
