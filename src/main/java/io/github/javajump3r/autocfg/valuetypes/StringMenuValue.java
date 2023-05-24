package io.github.javajump3r.autocfg.valuetypes;

import dev.isxander.yacl.api.Controller;
import dev.isxander.yacl.api.Option;
import dev.isxander.yacl.gui.controllers.string.StringController;
import io.github.javajump3r.autocfg.SerializerContainer;
import io.github.javajump3r.autocfg.Configurable;
import io.github.javajump3r.autocfg.FieldValue;

import java.util.function.Function;

public class StringMenuValue extends MenuValue{
    public Function<String,String> formatter;

    @Override
    public Class getTarget() {
        return String.class;
    }

    public StringMenuValue(String translationKey, String path, FieldValue value, Configurable metadata, SerializerContainer classDataContainer) {
        super(translationKey,path, value, metadata, classDataContainer);
        formatter = s -> s;
    }

    @Override
    public Controller getController(Option<?> option) {
        return new StringController((Option<String>) option);
    }
}
