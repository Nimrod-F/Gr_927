package repo;

import exceptions.RepoException;
import model.adts.MyIList;
import model.states.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{

    private List<PrgState> prgStateList;
    private int currentStatePosition;
    private String logFilePath;
    private PrintWriter logFile;

    public Repository(PrgState prgstate, String logFilePath) throws RepoException {
        this.prgStateList = new ArrayList<>();
        this.prgStateList.add(prgstate);
        this.currentStatePosition = 0;
        this.logFilePath = logFilePath;

        try{
            PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath)));
            pr.println("");
            pr.close();
        }catch(IOException e){
            throw new RepoException("File couldn't be created");

        }
    }

    @Override
    public void addPrgState(PrgState prgState) {
        this.prgStateList.add(prgState);
        this.currentStatePosition++;
    }

    @Override
    public PrgState getCurrentPrgState() {

        return this.prgStateList.get(this.currentStatePosition);
    }

    @Override
    public void logPrgStateExec() throws RepoException {
        try{

            this.logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
            logFile.println(this.getCurrentPrgState().toString());
            logFile.close();
        }catch(IOException e){
            throw new RepoException("File couldn't be created");

        }
    }

}
