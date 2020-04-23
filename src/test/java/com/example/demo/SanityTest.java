package com.example.demo;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SanityTest {
    @Test
    public void oneEqualsOne() {
        assertThat(1).isEqualTo(1);
    }


    @Test
    public void recordTest() {
        var rec = new MyRecord("foo", 55);
        assertThat(rec.age()).isEqualTo(42);
    }
}
