package exceptions;

import repo.Repository;

public class RepoException extends Exception {
    public RepoException(String msg) {
        super(msg);
    }
}
