package repo;
import exception.RepoException;
import model.Item;

public interface IRepo {
    public void add(Item i) throws RepoException;
    public Item[] getAll();
    public int getLength();
}
