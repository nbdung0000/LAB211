package controller;

import common.InOutUtils;
import entity.Order;
import model.FruitModel;
import model.OrderModel;
import view.FruitView;
import view.OrdersView;

import java.util.ArrayList;

public class FruitShopController {
    private static FruitModel fruitModel = new FruitModel();
    private static OrderModel orderModel = new OrderModel();
    private  static FruitView fruitView = new FruitView();
    private static OrdersView ordersView = new OrdersView();

    public int getChoice(){
        InOutUtils.printMsg("FRUIT SHOP SYSTEM\n" +
                "1.\tCreate Fruit\n" +
                "2.\tView orders\n" +
                "3.\tShopping (for buyer)\n" +
                "4.\tExit\n" +
                " (Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).\n");
        return InOutUtils.inputInt("Enter Your Choice: ",1,4);
    }
    public void createFruit(){
        while(true){
            fruitModel.createFruit(fruitView.inputFruit(fruitModel.getFruitList()));
            String chooseContinue = InOutUtils.inputString("Do you want to continue (Y/N): ",1);
            if(!chooseContinue.equalsIgnoreCase("Y")){
                break;
            }
        }
    }

    public void viewOrder(){
        ordersView.viewOrders(orderModel.getOrders());
    }

    public void shopping(){
        if(fruitModel.getFruitList().isEmpty()){
            InOutUtils.printMsg("No have item.\n");
            return;
        }
        ArrayList<Order> orderList = new ArrayList<>();
        while(true) {
            fruitView.displayFruitList(fruitModel.getFruitList());
            orderList.add(ordersView.inputOrdersList(fruitModel.getFruitList()));
            String chooseContinue = InOutUtils.inputString("Do you want to order now (Y/N): ",1);
            if(chooseContinue.equalsIgnoreCase("Y")){
                break;
            }
        }
        ordersView.displayOrdersList(orderList);
        String name = InOutUtils.inputString("Input Your Name: ", 20);
        orderModel.add(name,orderList);
    }
}
