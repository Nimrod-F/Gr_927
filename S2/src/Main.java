import controller.Controller;
import exception.RepoException;
import repo.IRepo;
import repo.Repo;
import view.View;

public class Main {
    public static void main(String[] args) {
        IRepo repo = new Repo();
        Controller controller = new Controller(repo);
        View view = new View(controller);
        try {
            view.run();
        } catch (RepoException e) {
            System.out.println("Repo exception: " + e.getMessage());
        }
    }
}