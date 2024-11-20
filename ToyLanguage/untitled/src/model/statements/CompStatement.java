package model.statements;

import exceptions.KeyNotFoundException;
import exceptions.StatementException;
import model.states.PrgState;

public class CompStatement implements IStatement {

    private IStatement statement1;
    private IStatement statement2;

    public CompStatement(IStatement statement1, IStatement statement2) {
        this.statement1 = statement1;
        this.statement2 = statement2;
    }


    @Override
    public PrgState execute(PrgState prgState) throws StatementException, KeyNotFoundException {
        prgState.getExecStack().push(this.statement2);
        prgState.getExecStack().push(this.statement1);
        return prgState;
    }

    @Override
    public IStatement deepCopy() {
        return new CompStatement(this.statement1.deepCopy(), this.statement2.deepCopy());
    }

    @Override
    public String toString() {
        return this.statement1.toString() + "\n" + this.statement2.toString();
    }
}
