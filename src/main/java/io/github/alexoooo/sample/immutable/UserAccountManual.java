package io.github.alexoooo.sample.immutable;

import java.util.List;


public class UserAccountManual {
    private final int id;
    private final String name;


    public UserAccountManual(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
