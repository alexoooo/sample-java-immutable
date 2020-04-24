package io.github.alexoooo.sample.immutable;


import com.google.common.collect.ImmutableList;
import java.util.List;


public record UserAccountRecordGuava(
        int id,
        String name,
        ImmutableList<String> aliases
) {
    public static UserAccountRecordGuava create(int id, String name, List<String> aliases) {
        return new UserAccountRecordGuava(id, name, ImmutableList.copyOf(aliases));
    }


    public UserAccountRecordGuava addAlias(String alias) {
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        builder.addAll(aliases);
        builder.add(alias);
        return UserAccountRecordGuava.create(id, name, builder.build());
    }
}
