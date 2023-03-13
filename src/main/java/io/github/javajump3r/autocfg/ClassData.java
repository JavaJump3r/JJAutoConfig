package io.github.javajump3r.autocfg;

import com.mojang.datafixers.util.Function4;
import com.mojang.datafixers.util.Function5;
import io.github.javajump3r.autocfg.valuetypes.MenuValue;

import java.util.function.Function;

public class ClassData<T> {
    public final Class<T> targetClass;
    public final Function<String,T> parseFromString;
    public final Function5<String, String, FieldValue, Configurable, ClassDataContainer, MenuValue> constructor;
    public ClassData(
            Class<T> targetClass,
            Function<String,T> parseFromStringFunction,
            Function5<String, String, FieldValue, Configurable, ClassDataContainer, MenuValue> constructor)
    {
        this.targetClass = targetClass;
        this.parseFromString = parseFromStringFunction;
        this.constructor = constructor;
    }

}
