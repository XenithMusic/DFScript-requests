package io.github.techstreet.dfscript.config.types.list;

public class StringListSetting extends ListSetting<String> {
    public StringListSetting() {
    }

    public StringListSetting(String key, String... defaultValue) {
        super(key, defaultValue);
    }
}
