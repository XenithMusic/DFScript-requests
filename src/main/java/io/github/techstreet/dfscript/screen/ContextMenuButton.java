package io.github.techstreet.dfscript.screen;

import io.github.techstreet.dfscript.DFScript;
import io.github.techstreet.dfscript.screen.script.ScriptEditScreen;

public class ContextMenuButton {
    String name;
    Runnable onClick;

    boolean reloadOnClick;

    public ContextMenuButton(String name, Runnable onClick) {
        this.name = name;
        this.onClick = onClick;
        this.reloadOnClick = true;
    }

    public ContextMenuButton(String name, Runnable onClick, boolean reloadOnClick) {
        this.name = name;
        this.onClick = onClick;
        this.reloadOnClick = reloadOnClick;
    }

    public Runnable getOnClick() {
        if(reloadOnClick) {
            return () -> {
                onClick.run();
                if(DFScript.MC.currentScreen instanceof ScriptEditScreen editScreen)
                {
                    editScreen.reload();
                }
            };
        }

        return onClick;
    }

    public String getName() {
        return name;
    }
}
