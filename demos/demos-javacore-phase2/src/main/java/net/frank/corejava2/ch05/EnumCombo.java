package net.frank.corejava2.ch05;

import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public class EnumCombo extends JComboBox {

    private Map<String, Integer> table = new TreeMap<>();

    public EnumCombo(Class<?> cl, String[] labels){
        for(String label:labels){
            String name = label.toUpperCase().replace(' ','_');
            int value = 0;
            try{
                java.lang.reflect.Field f = cl.getField(name);
                value = f.getInt(cl);
            }catch(Exception e){
                label = "(" + label +")";
            }
            table.put(label,value);
            addItem(label);
        }
        setSelectedItem(labels[0]);
    }

    public int getValue(){
        return table.get(getSelectedItem());
    }
}
