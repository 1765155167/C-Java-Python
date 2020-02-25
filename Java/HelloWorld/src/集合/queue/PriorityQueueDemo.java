package 集合.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<User> userPriorityQueue =
                new PriorityQueue<>(new UserComparable());
        userPriorityQueue.add(new User("MING", "A"));
        userPriorityQueue.add(new User("UZI", "A"));
        userPriorityQueue.add(new User("HQF", "V"));
        userPriorityQueue.add(new User("XIAO", "V"));
        userPriorityQueue.add(new User("HHH", "V"));

        while (!userPriorityQueue.isEmpty()) {
            System.out.println(userPriorityQueue.poll());
        }
    }
}

class UserComparable implements Comparator<User> {

    @Override
    public int compare(User u1, User u2) {
        if (u1.getNumber().charAt(0) == u2.getNumber().charAt(0)) {
            return u1.getNumber().compareTo(u2.getNumber());
        } else {
            if (u1.getNumber().charAt(0) == 'V') {
                return -1;//小的放前面
            } else {
                return 1;
            }
        }
    }
}

class User {
    private final String name;
    private final String number;
    static private int vNum = 0;
    private static int aNum = 0;

    public User(String name, String number) {
        this.name = name;
        if (number.charAt(0) == 'V') {
            this.number = number+vNum++;
        }else {
            this.number = number+aNum++;
        }
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
