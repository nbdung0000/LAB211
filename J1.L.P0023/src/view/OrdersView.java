package view;

import common.InOutUtils;
import entity.Fruit;
import entity.Order;

import java.util.ArrayList;
import java.util.HashMap;

public class OrdersView {
    public void displayOrdersList(ArrayList<Order> ordersList) {
        double total = 0;
        System.out.printf("%-20s%-15s%-15s%-15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : ordersList) {
            System.out.printf("%-20s%-15d%-15.0f$%-15.0f$\n",
                    order.getName(), order.getQuantity(), order.getPrice(), order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        InOutUtils.printMsg("Total: " + total + "$\n");
    }

    public void viewOrders(HashMap<String, ArrayList<Order>> orders) {
        for (String name : orders.keySet()) {
            InOutUtils.printMsg("Customer: " + name + "\n");
            displayOrdersList(orders.get(name));
        }
    }

    public static boolean checkItemExist(ArrayList<Order> lo, String id) {
        for (Order order : lo) {
            if (order.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    private Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int countItem = 1;
        for (Fruit fruit : lf) {
            //check shop have item or not
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    public Order inputOrdersList(ArrayList<Fruit> fruitList) {
        Order order = new Order();
        int item = InOutUtils.inputInt("You Selected: ", 1, fruitList.size());
        Fruit fruit = getFruitByItem(fruitList, item);
        int quantity = InOutUtils.inputInt("Enter Quantity: ", 1, fruit.getQuantity());
        fruit.setQuantity(fruit.getQuantity() - quantity);
        order.setId(fruit.getId());
        order.setName(fruit.getName());
        order.setPrice(fruit.getPrice());
        order.setQuantity(quantity);
        return order;
    }
}
