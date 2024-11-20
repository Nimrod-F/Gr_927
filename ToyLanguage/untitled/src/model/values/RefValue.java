package model.values;

import model.types.IType;
import model.types.RefType;

public class RefValue implements IValue{
    int address;
    IType locationType;

    public RefValue(int address, IType locationType){
        this.address = address;
        this.locationType = locationType;
    }

    public int getAddress() {
        return address;
    }

    public IType getLocationType() {
        return locationType;
    }

    public boolean equals(Object obj){
        return obj instanceof RefValue && ((RefValue)obj).getLocationType().equals(this.locationType) && ((RefValue)obj).getAddress() == this.address;
    }

    @Override
    public IType getType() {
        return new RefType(locationType);
    }

    @Override
    public String toString(){
        return this.locationType.toString();
    }
}
