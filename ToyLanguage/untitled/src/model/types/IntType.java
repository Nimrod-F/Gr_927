package model.types;

public class IntType implements IType{

    @Override
    public boolean equals(IType obj) {
        return obj instanceof IntType;
    }

    public String toString(){
        return "int";
    }
}
