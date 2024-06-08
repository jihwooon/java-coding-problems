package org.example.basic;

import java.util.HashMap;

public class MapIfAbsent {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.putIfAbsent("postgresql", "2");
        hashMap.put("postgresql", "172.0.0.1:5432");

        System.out.println(hashMap.get("postgresql"));
    }
}
