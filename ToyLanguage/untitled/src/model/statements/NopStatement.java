package model.statements;

import model.state.PrgState;

public class NopStatement implements IStatement {

    @Override
    public PrgState execute(PrgState state) {
        return null;
    }

    @Override
    public String toString() {
        return "NopStatement";
    }
}
