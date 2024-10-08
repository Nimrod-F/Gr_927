package controller;

import exception.RepoException;
import model.Item;
import repo.IRepo;
import repo.Repo;

public class Controller {

    IRepo repo;

    public Controller(IRepo repo) {
        this.repo = repo;
    }

    public Item[] filterByWeight(double weight) {
        Item[] items = this.repo.getAll();
        Item[] itemsFiltered = new Item[Repo.SIZE];
        int actualPos = 0;
        for (int pos = 0; pos < repo.getLength(); pos++) {
            if (items[pos].getWeight() >= weight) {
                itemsFiltered[actualPos++] = items[pos];
            }
        }
        return itemsFiltered;
    }

    public void add(Item item) throws RepoException {
        repo.add(item);
    }
}
