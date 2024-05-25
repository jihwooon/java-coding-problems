package org.example.basic;

public class Counter {

    private final String name;
    private int count;

    public Counter(String name) {
        this.name = name;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    @Override
    public String toString() {
        return "Counter{" +
            "name='" + name + '\'' +
            ", count=" + count +
            '}';
    }

    public static void main(String[] args) {
        Counter heads = new Counter("heads");

        heads.increment();
        heads.increment();
        heads.increment();
        heads.tally();

        System.out.println(heads);
        System.out.println(heads.tally());
    }
}
