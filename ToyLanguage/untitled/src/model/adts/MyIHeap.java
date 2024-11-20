package model.adts;

import model.values.IValue;

public interface MyIHeap {
    public int allocate(IValue val);
    public IValue getValue(int key);
    public void set(int key, IValue val);
    public MyIMap<Integer,IValue> getMap();
    public boolean containsKey(int key);
}
