import controller.FruitShopController;

public class MainApp {
    public static void main(String[] args) {
        FruitShopController fruitShopController = new FruitShopController();
        while(true){
            int choice = fruitShopController.getChoice();
            switch (choice){
                case 1:
                    fruitShopController.createFruit();
                    break;
                case 2:
                    fruitShopController.viewOrder();
                    break;
                case 3:
                    fruitShopController.shopping();
                    break;
                case 4:
                    return;
            }
        }
    }
}
