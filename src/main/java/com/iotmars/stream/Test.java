package com.iotmars.stream;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xsh
 * @date 2020-08-14 14:04
 **/
public class Test {

    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 25);
        User u3 = new User(4, "c", 27);

        List<User> list = Arrays.asList(u1, u2, u3);

        list.stream()
                .filter(user -> user.getId()%2==0)
                .filter(user -> user.getAge()>23)
                .map(user -> user.getName().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);





    }

}
