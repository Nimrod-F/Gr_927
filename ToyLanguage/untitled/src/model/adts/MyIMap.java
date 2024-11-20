package model.adts;

import exceptions.KeyNotFoundException;

import java.util.Map;
import java.util.Set;

public interface MyIMap<K, V> {
    void insert(K key, V value);

    void remove(K key) throws KeyNotFoundException;

    V getValue(K key) throws KeyNotFoundException;

    boolean contains(K key);

    Set<K> getKeys();

    Map<K,V> getMap();
}
