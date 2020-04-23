package io.github.alexoooo.sample.immutable;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SanityTest {
    @Test
    public void recordTest() {
        var rec = new MyRecord("foo", 42);
        assertThat(rec.age()).isEqualTo(42);
    }

    @Test
    public void beanTest() {
        var bean = new MyBean("foo", 55);
        assertThat(bean.getAge()).isEqualTo(55);
    }
}
