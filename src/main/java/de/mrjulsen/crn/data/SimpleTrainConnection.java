package de.mrjulsen.crn.data;

import java.util.UUID;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

public record SimpleTrainConnection(String trainName, UUID trainId, ResourceLocation trainIconId, int ticks, String scheduleTitle) {

    private static final String NBT_TRAIN_NAME = "TrainName";
    private static final String NBT_TRAIN_ID = "Id";
    private static final String NBT_TRAIN_ICON = "Icon";
    private static final String NBT_TICKS = "Ticks";
    private static final String NBT_SCHEDULE_TITLE = "Title";

    public CompoundTag toNbt() {
        CompoundTag nbt = new CompoundTag();

        nbt.putString(NBT_TRAIN_NAME, trainName);
        nbt.putUUID(NBT_TRAIN_ID, trainId);
        nbt.putString(NBT_TRAIN_ICON, trainIconId.getPath());
        nbt.putInt(NBT_TICKS, ticks);
        nbt.putString(NBT_SCHEDULE_TITLE, scheduleTitle);

        return nbt;
    }

    public static SimpleTrainConnection fromNbt(CompoundTag nbt) {
        return new SimpleTrainConnection(
            nbt.getString(NBT_TRAIN_NAME),
            nbt.getUUID(NBT_TRAIN_ID),
            new ResourceLocation(nbt.getString(NBT_TRAIN_ICON)),
            nbt.getInt(NBT_TICKS),
            nbt.getString(NBT_SCHEDULE_TITLE)
        );
    }
}
