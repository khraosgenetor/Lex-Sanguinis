package in.khraos.lexsanguinis;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.Minecraft;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import in.khraos.lexsanguinis.ItemsDir.Items;

@Mod(LexSanguinis.MODID)
public class LexSanguinis { // Working on lore rn, will update classes (DnD style) and items to fit the lore asap.
                            // Also, will be adding more items, and maybe some blocks, entities, etc. in the future.
                            // For now, just want to get the basic structure of the mod set up and then will start adding content. (11th Feb n 12th Feb n 15th Feb)

    // I'm going insane

    // Mod ID for reference
    public static final String MODID = "lexsanguinis";

    // Logger
    public static final Logger LOGGER = LogUtils.getLogger();

    /* Method for creating Deferred Registers. If you have multiple Deferred Registers, you can create them all here. For example
        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    */

    /* Example of creating a block, item, and creative tab. You can delete this when you start adding your own content. 
        public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
        public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);
        public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
                .alwaysEdible().nutrition(1).saturationModifier(2f).build()));
    */

    /* Example creative tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.lexsanguinis"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get());
            }).build());

        */

    // Mod constructor
    public LexSanguinis(IEventBus modEventBus, ModContainer modContainer) {

        // Register common setup
        modEventBus.addListener(this::commonSetup);

        /* Method for registering Deferred Registers. If you have multiple Deferred Registers, you can register them all here. For example
            BLOCKS.register(modEventBus); //This for a register of blocks, and then you would do the same for items, entities, etc.
            ITEMS.register(modEventBus);
            CREATIVE_MODE_TABS.register(modEventBus);
        */

        Items.LSItemsBloodGod.register(modEventBus); // This is the General LS Items, ie, which fall into a general category.
        //  You can create more Deferred Registers for specific categories, such as Weapons, Armor, etc. and then register those as well.

        // Register mod to NeoForge event bus
        NeoForge.EVENT_BUS.register(this);

        // Add items to creative tab
        // modEventBus.addListener(this::addCreative);

        // Register config
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    // Common setup
    private void commonSetup(FMLCommonSetupEvent event) {

    }

    /* Add example block item to building tab
        private void addCreative(BuildCreativeModeTabContentsEvent event) {
            if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
                event.accept(EXAMPLE_BLOCK_ITEM);
            }
        }
    */

    // Server start event
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // Client events
    @EventBusSubscriber(modid = LexSanguinis.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    static class ClientModEvents {

        // Client setup
        @SubscribeEvent
        static void onClientSetup(FMLClientSetupEvent event) {

            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
