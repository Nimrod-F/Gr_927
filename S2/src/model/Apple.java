package model;

public class Apple implements Item {
    protected double weight;
    protected String name;
    protected String color;

    public Apple(double weight, String name, String color) {
        this.weight = weight;
        this.name = name;
        this.color = color;
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
    public String toString() {
        return "Apple " +  this.color + " " + this.weight;
    }
}
