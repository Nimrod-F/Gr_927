package model.values;

import model.types.IType;
import model.types.StringType;

public class StringValue implements IValue {

    String value;

    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public IType getType() {
        return new StringType();
    }

//    @Override
//    public boolean equals(IValue other) {
//        return other.getType().equals(new StringType()) && ((StringValue) other).getValue().equals(this.value);
//    }
//

    public String getValue() {
        return this.value;
    }


    @Override
    public boolean equals(Object other) {
        if (!(other instanceof StringValue)) {
            return false;
        }
        return ((StringValue) other).getValue().equals(this.value);
    }

    @Override
    public String toString() {
        return this.value;
    }


    @Override
    public int hashCode() {
        return this.value.hashCode(); // Delegate to the hashCode of the underlying String
    }
}
