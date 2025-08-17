package DecoratorPattern;

public class Main {
     public static void main(String[] args) {
          BasePizza epicPizza = new ExtraMushroom(new ExtraCheese(new Farmhouse()));
          System.out.println(epicPizza.cost());
     }
}
