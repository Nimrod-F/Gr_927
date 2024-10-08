package model.types;

public class BoolType implements IType{

    @Override
    public boolean equals(IType obj) {
        return obj instanceof BoolType;
    }

    public String toString() {
        return "bool";
    }
}
