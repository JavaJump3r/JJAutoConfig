package io.github.javajump3r.autocfg;


import io.github.javajump3r.autocfg.valuetypes.*;

import java.util.HashMap;
import java.util.Map;

public class ClassDataContainer {
    public ClassDataContainer(){
        classData = new HashMap<>();
        registerMenuValueOfClass(new ClassData<>(int.class, b -> Integer.parseInt(b), IntRangeMenuValue::new));
        registerMenuValueOfClass(new ClassData<>(double.class, b -> Double.parseDouble(b), DoubleRangeMenuValue::new));
        //registerMenuValueOfClass(new ClassData<>(float.class, b -> (float)Double.parseDouble(b),DoubleRangeMenuValue::new));
        registerMenuValueOfClass(new ClassData<>(String.class, b -> b, StringMenuValue::new));
        registerMenuValueOfClass(new ClassData<>(boolean.class, b -> b.equals("true"), BooleanMenuValue::new));
    }
    public Object parseObject(Class objectClass, String string)
    {

        if(!objectClass.isEnum())
        {
            try {
                return classData.get(objectClass).parseFromString.apply(string);
            }
            catch (Exception e)
            {
                throw new RuntimeException("Class %s serialization is not supported or other error");
            }
        }
        else
        {
            return Enum.valueOf((Class<Enum>)objectClass, string);
        }
    }

    public MenuValue createMenuValueByClass(Class fieldClass, String translationKey, String path, FieldValue value, Configurable metaData) {
        if(!fieldClass.isEnum()) {
            try {
                return (MenuValue)classData.get(fieldClass).constructor.apply(translationKey,path,value,metaData,this);
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
        else {
            return new EnumMenuValue<>(translationKey,path,value,metaData,this);
        }
    }
    public Map<Class,ClassData> classData;
    public void registerMenuValueOfClass(ClassData data)
    {
        classData.put(data.targetClass,data);
    }
}
