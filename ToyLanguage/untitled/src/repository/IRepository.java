package repository;

import exceptions.RepoException;
import model.state.PrgState;

import java.util.List;

public interface IRepository {
    List<PrgState> getStates();
    PrgState getCurrentPrg();
    void addPrgState(PrgState state);
    void logPrgStateExec() throws RepoException;
}
