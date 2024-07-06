package org.example.basic;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOf {

    public static void main(String[] args) {
        ArrayList<String> friends = new ArrayList<>(List.of("Peter"));

        friends.add("Bill Joy");
        friends.add("Paul");

        System.out.println(friends);
    }
}
