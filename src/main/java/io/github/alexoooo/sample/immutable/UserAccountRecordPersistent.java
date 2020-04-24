package io.github.alexoooo.sample.immutable;


import com.google.common.collect.ImmutableList;

import java.util.List;


public record UserAccountRecordPersistent(
        int id,
        String name,
        io.lacuna.bifurcan.List<String> aliases
) {
    public static UserAccountRecordPersistent create(int id, String name, List<String> aliases) {
        return new UserAccountRecordPersistent(id, name, io.lacuna.bifurcan.List.from(aliases));
    }


    public UserAccountRecordPersistent addAlias(String alias) {
//        ImmutableList.Builder<String> builder = ImmutableList.builder();
//        builder.addAll(aliases);
//        builder.add(alias);
//        return UserAccountRecordPersistent.create(id, name, builder.build());
        return new UserAccountRecordPersistent(
                id, name, aliases.addLast(alias));
    }
}
