package model.adts;

import java.util.List;
import java.util.ArrayList;


public class MyList<T> implements MyIList<T> {

    private List<T> list;

    public MyList() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(T elem) {
        this.list.add(elem);
    }

    @Override
    public List<T> getAll() {
        return this.list;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T elem : this.list) {
            str.append(elem).append("\n");
        }

        return "MyList contains:\n" + str;
    }
}
