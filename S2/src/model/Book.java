package model;

public class Book implements Item{
    protected double weight;
    protected String name;
    protected String type;
    public Book(double weight, String name, String type){
        this.weight = weight;
        this.name = name;
        this.type = type;
    }
    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Book " + this.type + " " + this.weight;
    }
}
