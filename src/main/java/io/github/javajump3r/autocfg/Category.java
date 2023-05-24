package io.github.javajump3r.autocfg;


import io.github.javajump3r.autocfg.valuetypes.MenuValue;

import java.util.List;

class Category {
    public String categoryTranslationKey;
    public List<MenuValue> fields;
    public Category(String categoryTranslationKey,List<MenuValue> values)
    {
        this.categoryTranslationKey = categoryTranslationKey;
        this.fields = values;
    }
}
