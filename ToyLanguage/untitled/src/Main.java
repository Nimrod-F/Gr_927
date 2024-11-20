import controller.Controller;
import exceptions.*;
import model.adts.MyIMap;
import model.adts.MyList;
import model.adts.MyMap;
import model.adts.MyStack;
import model.expressions.ArithmeticalExpression;
import model.expressions.ArithmeticalOperator;
import model.expressions.ValueExpression;
import model.expressions.VariableExpression;
import model.statements.*;
import model.states.PrgState;
import model.types.BoolType;
import model.types.IntType;
import model.types.StringType;
import model.values.BoolValue;
import model.values.IValue;
import model.values.IntValue;
import model.values.StringValue;
import repo.IRepository;
import controller.IController;
import repo.Repository;
import view.TextMenu;
import view.commands.ExitCommand;
import view.commands.RunExempleCommand;

import java.io.BufferedReader;


public class Main {


    public static void main(String[] args) throws EmptyStackException, StatementException, ControllerException, KeyNotFoundException, ExpressionException, RepoException {


        IStatement st1 = new CompStatement(new VarDeclStatement("v", new IntType()),
                new CompStatement(new AssignStatement("v",
                        new ValueExpression(new IntValue(2))), new PrintStatement(new VariableExpression("v"))));
        PrgState prg1 = new PrgState(st1, new MyStack<IStatement>(), new MyMap<String, IValue>(), new MyList<String>());

        IRepository repo1 = new Repository(prg1, "log1.txt");
        IController controller1 = new Controller(repo1);


        IStatement st2 = new CompStatement(new VarDeclStatement("a", new IntType()),
                new CompStatement(new VarDeclStatement("b", new IntType()), new CompStatement(new AssignStatement("a",
                        new ArithmeticalExpression(new ValueExpression(new IntValue(2)), new ArithmeticalExpression(new ValueExpression(new IntValue(3)), new ValueExpression(new IntValue(5)), ArithmeticalOperator.MULTIPLY), ArithmeticalOperator.ADD)
                ), new CompStatement(new AssignStatement("b", new ArithmeticalExpression(new VariableExpression("a"), new ValueExpression(new IntValue(1)), ArithmeticalOperator.ADD)),
                        new PrintStatement(new VariableExpression("b"))))
                ));

        PrgState prg2 = new PrgState(st2, new MyStack<IStatement>(), new MyMap<String, IValue>(), new MyList<String>());

        IRepository repo2 = new Repository(prg2, "log2.txt");
        IController controller2 = new Controller(repo2);


        PrintStatement st35 = new PrintStatement(new VariableExpression("v"));
        CompStatement st34 = new CompStatement(new IfStatement(new VariableExpression("a"), new AssignStatement("v", new ValueExpression(new IntValue(2))), new AssignStatement("v", new ValueExpression(new IntValue(3)))), st35);
        CompStatement st33 = new CompStatement(new AssignStatement("a", new ValueExpression(new BoolValue(true))), st34);
        CompStatement st32 = new CompStatement(new VarDeclStatement("v", new IntType()), st33);
        IStatement st3 = new CompStatement(new VarDeclStatement("a", new BoolType()), st32);
        PrgState prg3 = new PrgState(st3, new MyStack<IStatement>(), new MyMap<String, IValue>(), new MyList<String>());

        IRepository repo3 = new Repository(prg3, "log3.txt");
        IController controller3 = new Controller(repo3);


        CloseRFileStatement st49 = new CloseRFileStatement(new VariableExpression("varf"));
        CompStatement st48 = new CompStatement(new PrintStatement(new VariableExpression("varc")), st49);
        CompStatement st47 = new CompStatement(new ReadFileStatement(new VariableExpression("varf"), "varc"), st48);
        CompStatement st46 = new CompStatement(new PrintStatement(new VariableExpression("varc")), st47);
        CompStatement st45 = new CompStatement(new ReadFileStatement(new VariableExpression("varf"), "varc"), st46);
        CompStatement st44 = new CompStatement(new VarDeclStatement("varc", new IntType()), st45);
        //CompStatement st43 = new CompStatement(new OpenRFileStatement(new VariableExpression("varf")), st44);
        CompStatement st43 = new CompStatement(new OpenRFileStatement(new ValueExpression(new StringValue("test.in"))), st44);

        CompStatement st42 = new CompStatement(new AssignStatement("varf", new ValueExpression(new StringValue("test.in"))), st43);
        IStatement st4 = new CompStatement(new VarDeclStatement("varf", new StringType()), st42);
        PrgState prg4 = new PrgState(st4, new MyStack<IStatement>(), new MyMap<String, IValue>(), new MyList<String>());

        IRepository repo4 = new Repository(prg4, "log4.txt");
        IController controller4 = new Controller(repo4);


        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExempleCommand("1", st1.toString(), controller1));
        menu.addCommand(new RunExempleCommand("2", st2.toString(), controller2));
        menu.addCommand(new RunExempleCommand("3", st3.toString(), controller3));
        menu.addCommand(new RunExempleCommand("4", st4.toString(), controller4));
        menu.show();


//        StringValue elem1 = new StringValue("a");
//        StringValue elem2 = new StringValue("b");
//        MyIMap<StringValue, Integer> map = new MyMap<>();
//        map.insert(elem1, 1);
//        map.insert(elem2, 2);
//        StringValue elem3 = new StringValue("b");
//        System.out.println(map.contains(elem3));

//        IntValue elem1 = new IntValue(5);
//        IntValue elem2 = new IntValue(6);
//        MyIMap<IntValue,String> map = new MyMap<>();
//        map.insert(elem1, "Da");
//        map.insert(elem2, "NU");
//        IntValue elem3 = new IntValue(6);
//        System.out.println(map.contains(elem3));

//        IntType it = new IntType();
//        MyIMap<IntType, String> map = new MyMap<>();   // is this ok???


    }
}