package repository;

import exceptions.RepoException;
import model.state.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Repository implements IRepository {
    private List<PrgState> prgStateList;
    private String filename;
    private int currentIndex;

    public Repository(String filename) {
        this.filename = filename;
        this.prgStateList = new ArrayList<PrgState>();
        this.currentIndex = 0;
    }

    @Override
    public List<PrgState> getStates() {
        return this.prgStateList;
    }

    @Override
    public PrgState getCurrentPrg() {
        return this.prgStateList.get(this.currentIndex);
    }

    @Override
    public void addPrgState(PrgState state) {
        this.prgStateList.add(state);
    }

    @Override
    public void logPrgStateExec() throws RepoException {
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(this.filename, true)));
            logFile.println(this.getCurrentPrg().toString());
            logFile.close();
        } catch(IOException err) {
            throw new RepoException("File not exists");
        }
    }
}
