package model;

import entity.Fruit;

import java.util.ArrayList;

public class FruitModel {
    private ArrayList<Fruit> fruitList;

    public FruitModel() {
        fruitList = new ArrayList<>();
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public void createFruit(Fruit fruit){
        fruitList.add(fruit);
    }


}
