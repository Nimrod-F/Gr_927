package model.types;

import model.value.IValue;
import model.value.IntValue;

public class IntType implements IType{
    @Override
    public IValue defaultValue() {
        return new IntValue(0);
    }

    @Override
    public boolean equals(IType obj) {
        return obj instanceof IntType;
    }

    public String toString(){
        return "int";
    }
}
