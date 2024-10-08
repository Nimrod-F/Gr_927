package repo;
import exception.RepoException;
import model.Item;


public class Repo implements IRepo{
    private Item[] items;
    private int length;
    public final static int SIZE = 10;

    public Repo() {
        items = new Item[
                ];
        length = 0;
    }

    @Override
    public void add(Item i) throws RepoException{
        if(this.length >= SIZE)
            throw new RepoException("Item is out of bounds");
        this.items[this.length++] = i;
    }

    @Override
    public Item[] getAll() {
        return this.items;
    }

    @Override
    public int getLength() {
        return this.length;
    }
}

