package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import net.minecraft.class_5134;

public class FlyModule extends Module {
    private double prevGravity;

    public FlyModule() {
        super("Fly", "Disables gravity to allow flight", Module.Category.MOVEMENT);
    }

    @Override
    public void onEnable() {
        if (FlyModule.nullCheck()) {
            this.prevGravity = 0.08; // Default Minecraft player gravity
            return;
        }
        // Save the current gravity attribute value before changing it
        this.prevGravity = FlyModule.mc.field_1724.method_5996(class_5134.field_47761).method_6194();
    }

    @Override
    public void onDisable() {
        if (FlyModule.nullCheck()) {
            return;
        }
        // Restore gravity back to its original value when toggled off
        FlyModule.mc.field_1724.method_5996(class_5134.field_47761).method_6192(this.prevGravity);
    }

    @Override
    public void onTick() {
        if (FlyModule.nullCheck()) {
            return;
        }
        // Continuously set player gravity to 0 while enabled
        FlyModule.mc.field_1724.method_5996(class_5134.field_47761).method_6192(0.0);
    }
}