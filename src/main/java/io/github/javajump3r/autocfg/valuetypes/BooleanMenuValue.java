package io.github.javajump3r.autocfg.valuetypes;

import dev.isxander.yacl.api.Controller;
import dev.isxander.yacl.api.Option;
import dev.isxander.yacl.gui.controllers.BooleanController;
import io.github.javajump3r.autocfg.SerializerContainer;
import io.github.javajump3r.autocfg.Configurable;
import io.github.javajump3r.autocfg.FieldValue;

public class BooleanMenuValue extends MenuValue {

    public BooleanMenuValue(String translationKey, String fieldPath, FieldValue value, Configurable metadata, SerializerContainer classDataContainer) {
        super(translationKey, fieldPath, value, metadata, classDataContainer);
    }

    @Override
    public Class getTarget() {
        return boolean.class;
    }
    @Override
    public Controller getController(Option<?> option) {
        return new BooleanController((Option<Boolean>) option);
    }
}
