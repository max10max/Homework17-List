import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> shopingList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Список операций: \n 1. Добавить покупку \n 2. Показать покупки \n 3. Удалить покупку \n 4. Поиск покупки");
        while (true){
            System.out.println("Выберите операцию:");
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }

            switch (Integer.parseInt(input)){
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String productBuy = scanner.nextLine();
                    shopingList.add(productBuy);
                    System.out.println("Итого в списке покупок: " + shopingList.size());
                    break;

                case 2:
                    buyedProduct(shopingList);
                    break;

                case 3:
                    buyedProduct(shopingList);
                    System.out.println("Какой товар хотите удалить? Введите номер или название");
                    String productDelete = scanner.nextLine();
                    boolean catcher = false;

                    try {
                        System.out.println("Покупка " + shopingList.get(Integer.parseInt(productDelete)-1) + " удалена");
                        shopingList.remove(Integer.parseInt(productDelete)-1);
                        buyedProduct(shopingList);
                    }
                    catch (NumberFormatException e){
                        catcher = true;
                    }
                    if(catcher == true){
                        shopingList.remove(productDelete);
                        System.out.println("Покупка " + productDelete + " удалена");
                        buyedProduct(shopingList);
                    }
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    String productSearch = scanner.nextLine();
                    for(int i =0; i < shopingList.size(); i++){
                        String itemLower = shopingList.get(i).toLowerCase();
                        String queryLower = productSearch.toLowerCase();
                        if (itemLower.contains(queryLower)){
                            System.out.println((shopingList.indexOf(shopingList.get(i)) +1) +" " + shopingList.get(i));
                        }
                    }
                    break;
            }
        }


    }

    public static void buyedProduct(ArrayList<String> list){
        Iterator<String> iterator =list.iterator();
        System.out.println("Список покупок: ");
        while (iterator.hasNext()){
            String product = iterator.next();
            System.out.println((list.indexOf(product) +1 )+ " " + product);
        }
    }
}
