package repo;

import exceptions.RepoException;
import model.states.PrgState;
import model.adts.MyIList;

import java.util.List;

//////////////////////////////////////////////////////////////////////

public interface IRepository {


    void addPrgState(PrgState prgState);

    PrgState getCurrentPrgState();

    void logPrgStateExec() throws RepoException;
    //List<PrgState> getStates(); // shouldn't be MyIList????
}
