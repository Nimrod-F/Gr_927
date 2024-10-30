package model.statements;

import exceptions.ADTException;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.expresions.IExpression;
import model.state.PrgState;
import model.types.IntType;
import model.types.StringType;
import model.value.IntValue;
import model.value.StringValue;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileStatement implements IStatement{

    private IExpression exp;
    private String varName;

    public ReadFileStatement(IExpression exp, String varName){
        this.exp = exp;
        this.varName = varName;
    }

    @Override
    public PrgState execute(PrgState prgState) throws StatementException, ADTException, ExpressionException, IOException {
        var table = prgState.getSymTable();

        if(!table.contains(varName)){
            throw new StatementException("The variable was not defined");
        }

        if(!table.getValue(varName).getType().equals(new IntType())){
            throw new StatementException("The type is incorrect");
        }

        var res = exp.eval(table);

        if(!res.getType().equals(new StringType())){
            throw new StatementException("The result is not a String Type!");
        }

        BufferedReader reader = prgState.getFileTable().getValue((StringValue)res);

        String read = reader.readLine();

        if(read.equals("")){
            read = "0";
        }

        int parser = Integer.parseInt(read);

        table.insert(varName, new IntValue(parser));

        return prgState;

    }

    @Override
    public IStatement deepCopy() {
        return null;
    }
}
