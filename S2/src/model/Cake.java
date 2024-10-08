package model;

public class Cake implements Item{
    protected double weight;
    protected String name;
    protected String[] ingredients;
    public Cake(double weight, String name, String[] ingredients) {
        this.weight = weight;
        this.name = name;
        this.ingredients = ingredients;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        String fullIngred="";
        for(String s: this.ingredients){
            fullIngred += s + " ";
        }
        return "Cake " + fullIngred + " " + this.weight;
    }

}
