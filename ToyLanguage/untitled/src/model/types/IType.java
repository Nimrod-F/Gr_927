package model.types;
import model.value.IValue;

public interface IType {
    boolean equals(IType obj);
    IValue defaultValue();
}
