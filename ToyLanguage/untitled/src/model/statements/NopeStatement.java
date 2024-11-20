package model.statements;

import model.states.PrgState;

public class NopeStatement implements IStatement {

    @Override
    public PrgState execute(PrgState prgState) {
        return null;
    }

    @Override
    public IStatement deepCopy() {
        return new NopeStatement();
    }


    @Override
    public String toString() {
        return "NopeStatement";
    }
}
