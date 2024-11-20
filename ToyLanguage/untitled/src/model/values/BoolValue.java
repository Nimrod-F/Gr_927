package model.values;

import model.types.IType;
import model.types.BoolType;


public class BoolValue implements IValue {

    private boolean value;

    public BoolValue(boolean value) {
        this.value = value;
    }


    @Override
    public IType getType() {
        return new BoolType();
    }

//    @Override
//    public boolean equals(IValue other) {
//        return (other instanceof BoolValue) && (((BoolValue) other).getValue() == this.value);
//    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof BoolValue))
            return false;
        return ((BoolValue) other).getValue() == this.value;
    }

    public boolean getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.value);
    }
}
