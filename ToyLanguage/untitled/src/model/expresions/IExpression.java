package model.expresions;

import model.value.IValue;
import model.state.PrgState;

public interface IExpression {
    IValue eval(PrgState prgState);
}
