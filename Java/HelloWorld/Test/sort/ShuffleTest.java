package sort;

import JavaBase.sort.Shuffle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShuffleTest {

    @Test
    public void shuffle() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            integerList.add(i);
        }
        System.out.println("打乱之前:"+ integerList);
        Shuffle.shuffle(integerList);
        System.out.println("打乱之后:"+ integerList);
    }
}