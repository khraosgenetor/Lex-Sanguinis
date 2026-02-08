package in.khraos.lexsanguinis.ItemsDir;

import in.khraos.lexsanguinis.LexSanguinis;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import in.khraos.lexsanguinis.ItemsDir.CustomItems.EchoOfAeterniSanguinis;

public class Items {
        public static final String ID = LexSanguinis.MODID;

        public static final DeferredRegister<Item> LSItemsBloodGod = DeferredRegister.createItems(ID);

        public static final DeferredHolder<Item, Item> EchoOfAeterniSanguinis = LSItemsBloodGod.register("echo_of_aeterni_sanguinis", 
            () -> new EchoOfAeterniSanguinis(new Item.Properties()
        ));
}
