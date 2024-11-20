package model.adts;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import exceptions.KeyNotFoundException;


public class MyMap<K, V> implements MyIMap<K, V> {
    private Map<K, V> map;

    public MyMap() {
        map = new HashMap<K, V>();
    }

    @Override
    public void insert(K key, V value) {
        this.map.put(key, value);
    }

    @Override
    public void remove(K key) throws KeyNotFoundException {
        if (!this.map.containsKey(key)) {
            throw new KeyNotFoundException();
        }
        this.map.remove(key);
    }

    @Override
    public V getValue(K key) throws KeyNotFoundException {
        if (!this.map.containsKey(key)) {
            throw new KeyNotFoundException();
        }
        return this.map.get(key);
    }

    @Override
    public boolean contains(K otherKey) {

        return this.map.containsKey(otherKey);
    }

    @Override
    public Set<K> getKeys() {
        return this.map.keySet();
    }

    @Override
    public Map<K, V> getMap() {
        return this.map;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (K key : this.map.keySet()) {
            str.append(key).append(" -> ").append(this.map.get(key)).append("\n");
        }
        return "MyMap contains:\n" + str;
    }
}
