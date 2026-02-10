package in.khraos.lexsanguinis.ItemsDir.CustomItems;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

import java.util.List;

public class EchoOfAeterniSanguinis extends Item {

    public EchoOfAeterniSanguinis(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("null")
    @Override
    public void appendHoverText(
        ItemStack stack,
        Item.TooltipContext context,
        List<Component> tooltip,
        TooltipFlag flag
    ) {
        tooltip.add(Component.literal("A god is dead."));
        tooltip.add(Component.literal("The world has not received the body."));

        tooltip.add(Component.empty());

        tooltip.add(
            Component.literal("Absence has weight.")
            .withStyle(Style.EMPTY.withItalic(true))
        );

        tooltip.add(
            Component.literal("This should not exist.")
                .withStyle(
                    Style.EMPTY.withColor(0xAA0000)
                )
        );

    }

    @SuppressWarnings("null")
    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.modid.echo_of_aeterni_sanguinis")
            .withStyle(style -> style.withColor(0xAA0000)); // Not in good health rn, will make changes tom. I js need github streak
    } 
}
