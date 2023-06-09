package view;

import common.InOutUtils;
import entity.Fruit;

import java.util.ArrayList;

public class FruitView {

    private boolean checkId(String id, ArrayList<Fruit> fruitList){
        for(Fruit fruit: fruitList){
            if(fruit.getId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }
    public Fruit inputFruit(ArrayList<Fruit> fruitList){
        Fruit fruit = new Fruit();
        while(true){
            String id = InOutUtils.inputString("Enter ID: ", 10);
            if(checkId(id,fruitList)){
                InOutUtils.printMsg("ID is duplicate. Please enter again!\n");
            }else{
                fruit.setId(id.toUpperCase().trim());
                break;
            }
        }
        fruit.setName(InOutUtils.inputString("Enter Name: ",10).trim());
        fruit.setPrice(InOutUtils.inputDouble("Enter Price: ", 0,Integer.MAX_VALUE));
        fruit.setQuantity(InOutUtils.inputInt("Enter Quantity: ",0,Integer.MAX_VALUE));
        fruit.setOrigin(InOutUtils.inputString("Enter Origin: ",20).trim());
        return fruit;
    }

    public void displayFruitList(ArrayList<Fruit> fruitList){
        int count = 1;
        System.out.printf("%-10s%-20s%-20s%-10s\n","Item", "Fruit Name", "Origin", "Price");
        for(Fruit fruit: fruitList){
            if(fruit.getQuantity()!=0){
                System.out.printf("%-10d%-20s%-20s%-10.0f$\n",count++, fruit.getName(),fruit.getOrigin(),fruit.getPrice());
            }
        }
    }

}
