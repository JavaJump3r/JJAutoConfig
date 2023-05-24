package io.github.javajump3r.autocfg.valuetypes;

import io.github.javajump3r.autocfg.SerializerContainer;
import io.github.javajump3r.autocfg.Configurable;
import io.github.javajump3r.autocfg.FieldValue;
public abstract class RangeMenuValue extends MenuValue {
    public double maxValue;
    public double minValue;
    public double interval;
    public RangeMenuValue(String translationKey, String path, FieldValue value, Configurable metadata, SerializerContainer classDataContainer)
    {
        super(translationKey, path, value, metadata, classDataContainer);

        this.minValue = metadata.minValue();
        this.maxValue = metadata.maxValue();
        this.interval = metadata.interval();
    }
}
