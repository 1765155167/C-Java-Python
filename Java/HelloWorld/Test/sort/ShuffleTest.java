package sort;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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