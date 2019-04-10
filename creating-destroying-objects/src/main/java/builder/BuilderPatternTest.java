package builder;

import builder.hierarchy.Calzone;
import builder.hierarchy.NyPizza;

import static builder.hierarchy.NyPizza.Size.SMALL;
import static builder.hierarchy.Pizza.Topping.*;

public class BuilderPatternTest {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        //hierarchy builder pattern
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
    }
}
