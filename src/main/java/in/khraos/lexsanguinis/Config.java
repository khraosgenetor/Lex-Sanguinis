package in.khraos.lexsanguinis;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    private static final ModConfigSpec.Builder BUILDER =
            new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue DUMMY =
            BUILDER
                .comment("Lex Sanguinis mod config. Placeholder entry.")
                .define("dummy", true);

    public static final ModConfigSpec SPEC = BUILDER.build();
}
