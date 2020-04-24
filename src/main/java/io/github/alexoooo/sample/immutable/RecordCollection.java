package io.github.alexoooo.sample.immutable;


public record RecordCollection(
        UserAccountRecordPersistent userA,
        UserAccountRecordPersistent userB
) {
    public RecordCollection withUserB(UserAccountRecordPersistent userB) {
        return new RecordCollection(userA, userB);
    }
}
