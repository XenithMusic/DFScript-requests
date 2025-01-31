package io.github.techstreet.dfscript.screen.script;

import io.github.techstreet.dfscript.DFScript;
import io.github.techstreet.dfscript.screen.CScreen;
import io.github.techstreet.dfscript.screen.widget.CItem;
import io.github.techstreet.dfscript.script.Script;
import io.github.techstreet.dfscript.script.action.ScriptActionCategory;
import io.github.techstreet.dfscript.script.event.ScriptHeaderCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Style;
import net.minecraft.text.Text;

public class ScriptHeaderCategoryScreen extends CScreen {

    private static final int size;

    static {
        size = (int) (Math.ceil(Math.sqrt(ScriptHeaderCategory.values().length)) * 10)+4;
    }

    private final Script script;

    public ScriptHeaderCategoryScreen(Script script, int insertIndex) {
        super(size, size);
        this.script = script;

        int x = 3;
        int y = 3;

        for (ScriptHeaderCategory category : ScriptHeaderCategory.values()) {
            CItem actionItem = new CItem(x, y, category.getIcon());
            widgets.add(actionItem);

            actionItem.setClickListener(btn -> DFScript.MC.setScreen(new ScriptAddHeaderScreen(script, insertIndex, category)));

            x += 10;
            if (x >= size - 10) {
                x = 3;
                y += 10;
            }
        }
    }

    @Override
    public void close() {
        DFScript.MC.setScreen(new ScriptEditScreen(script));
    }
}
