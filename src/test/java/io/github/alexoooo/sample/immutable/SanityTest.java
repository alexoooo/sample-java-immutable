package io.github.alexoooo.sample.immutable;


import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SanityTest {
    @Test
    public void manual() {
        UserAccountManual foo = new UserAccountManual(42, "foo");
        assertThat(foo.getName()).isEqualTo("foo");
    }

    @Test
    public void lombok() {
        var foo = new UserAccountLombok(42, "foo");
        assertThat(foo.getName()).isEqualTo("foo");
    }

    @Test
    public void record() {
        var builder = ImmutableList.<String>builder();
        builder.add("foo");
        var foo = UserAccountRecordGuava.create(42, "foo", builder.build());
        builder.add("fff");

        assertThat(foo.name()).isEqualTo("foo");
        assertThat(foo.aliases().size()).isEqualTo(1);
    }


    @Test
    public void addAlias() {
        var foo = UserAccountRecordGuava.create(42, "foo", List.of());
        var withAlias = foo.addAlias("bar");
        assertThat(foo.aliases().size()).isEqualTo(0);
        assertThat(withAlias.aliases().size()).isEqualTo(1);
    }


    @Test
    public void addAliasPersistent() {
        var foo = UserAccountRecordPersistent.create(42, "foo", List.of());
        var withAlias = foo.addAlias("bar");
        assertThat(foo.aliases().size()).isEqualTo(0);
        assertThat(withAlias.aliases().size()).isEqualTo(1);
    }


    @Test
    public void addAliasPersistentBoth() {
        var userA = UserAccountRecordPersistent.create(42, "foo", List.of());
        var userB = UserAccountRecordPersistent.create(42, "bar", List.of());

        var both = new RecordCollection(userA, userB);
        var newVersion = both.withUserB(userB.addAlias("foo"));

//        var newVersionX = both.userB.aliasses.add("foo");

//        var newVersion = new RecordCollection(userA, userB.addAlias("foo"));
    }
}
