package model.adt;

import exceptions.KeyNotFoundException;

import java.util.Set;

public interface MyIDictionary <K, V>{
    void insert(K key, V value);
    V getValue(K key) throws KeyNotFoundException;
    void remove(K key) throws KeyNotFoundException;
    boolean contains(K key);
    Set<K> getKeys();
}
