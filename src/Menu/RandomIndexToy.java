package Menu;

import PlushToy.PlushToy;

import java.util.ArrayList;
import java.util.Random;

public class RandomIndexToy {
    public static int randomIndex(ArrayList<PlushToy> toys) {
        ArrayList<Integer> number = new ArrayList<>();
        ArrayList<Integer> chance = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < toys.size(); i++) {
            number.add(i);
            chance.add(toys.get(i).getWeight());
            count += toys.get(i).getWeight();
        }
        Random random = new Random();
        for (int randomNumsCount = 0; randomNumsCount < 10; randomNumsCount++) {
            int index = random.nextInt(count);
            for (int i = 0; i < chance.size(); i++) {
                index -= chance.get(i);
                if (index < 0) {
                    return number.get(i);
                }
            }
        }
        return 0;
    }
}
