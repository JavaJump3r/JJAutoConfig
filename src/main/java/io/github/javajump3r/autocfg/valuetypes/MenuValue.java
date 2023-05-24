package io.github.javajump3r.autocfg.valuetypes;


import dev.isxander.yacl.api.Controller;
import dev.isxander.yacl.api.Option;
import io.github.javajump3r.autocfg.SerializerContainer;
import io.github.javajump3r.autocfg.Configurable;
import io.github.javajump3r.autocfg.FieldValue;

public abstract class MenuValue{
    private FieldValue value;
    private String translationKey;
    private String fieldPath;
    public abstract Class getTarget();

    public  MenuValue(String translationKey, String fieldPath, FieldValue value, Configurable metadata, SerializerContainer classDataContainer)
    {
        this.value = value;
        this.translationKey = translationKey;
        this.fieldPath = fieldPath;
        this.defaultValue = classDataContainer.parseObject(this.getTarget(), metadata.defaultValue());
    }
    public Object getValue() {return value.get();}
    public void setValue(Object value) {this.value.set(value);}
    public String getTranslationKey(){return translationKey;}
    public String getFieldPath(){return fieldPath;}
    public Object defaultValue;
    public Object getDefaultValue(){return defaultValue;}
    public abstract Controller getController(Option<?> option);

}
