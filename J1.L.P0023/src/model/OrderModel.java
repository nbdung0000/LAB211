package model;

import entity.Order;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderModel {
    HashMap<String, ArrayList<Order>> orders;

    public OrderModel() {
        orders = new HashMap<>();
    }

    public HashMap<String, ArrayList<Order>> getOrders() {
        return orders;
    }

    private boolean checkDuplicateID(String id, ArrayList<Order> orderList){
        for(Order order: orderList){
            if(order.getId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }
    public void add(String id, ArrayList<Order> orderList){
        if(orders.containsKey(id)){
            for(Order order:orderList){
                if(checkDuplicateID(order.getId(), orders.get(id))){
                    for(Order o:  orders.get(id)){
                        if(o.getId().equalsIgnoreCase(order.getId())){
                            o.setQuantity(o.getQuantity() + order.getQuantity());
                        }
                    }
                }else{
                    orders.get(id).add(order);
                }
            }
        }
        else{
            orders.put(id,orderList);
        }
    }
}
