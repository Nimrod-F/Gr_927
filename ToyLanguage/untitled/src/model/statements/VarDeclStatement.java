package model.statements;

import exceptions.KeyNotFoundException;
import exceptions.StatementException;
import model.states.PrgState;
import model.types.IType;

public class VarDeclStatement implements IStatement {


    private String variableName;
    private IType type;

    public VarDeclStatement(String variableName, IType type) {
        this.variableName = variableName;
        this.type = type;
    }


    @Override
    public PrgState execute(PrgState prgState) throws StatementException, KeyNotFoundException {

        if (prgState.getSymTable().contains(this.variableName))
            throw new StatementException("A variable with the same name already exists");
        prgState.getSymTable().insert(this.variableName, this.type.getDefaultValue());
        return prgState;
    }


    @Override
    public IStatement deepCopy() {
        return new VarDeclStatement(new String(this.variableName), this.type);
    }

    @Override
    public String toString() {
        return this.type.toString() + " " + this.variableName + ';';
    }

}
