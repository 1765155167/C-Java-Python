package sort;

import java.security.SecureRandom;
import java.util.List;

public class Shuffle {
    public static void shuffle(List<?> date) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < date.size(); i++) {
            int index = random.nextInt(date.size() - i);
            swap(date, i, index);
        }
    }

    private static boolean swap(List<?> date, int i, int j) {
        final List list = date;
        if (i < 0 || i > date.size() || j < 0 || j > date.size()) {
            return false;
        }
        var l = list.get(i);
        list.set(i, list.get(j));
        list.set(j, l);
        return true;
    }
}
