package lab4.defaultValues;

import java.util.ArrayList;
import java.util.Random;

public class VegetableValues {

    private static final ArrayList<String> names = new ArrayList<>();
    private static final ArrayList<Double> values = new ArrayList<>();

    private static final Random rand = new Random();

    static {

        names.add("carrot");
        names.add("potato");
        names.add("onion");
        names.add("cucumber");
        names.add("garlic");
        names.add("celery");

        for (int i = 0; i < names.size(); i++) {
            values.add((rand.nextDouble() % 20) + 1);
        }
    }

    public static double getCaloriesPerGram(String name) {

        return values.get(names.indexOf(name));
    }

    public static ArrayList<String> getNames() {

        return names;
    }
}
