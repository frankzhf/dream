package net.frank.corejava1.ch12;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

public class GenericReflectionTest {
    public static void main(String[] args){
        String name;
        if(args.length>0){
            name = args[0];
        }else{
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Collections):");
            name = in.next();
        }
        try{
            Class<?> cl = Class.forName(name);
            printClass(cl);
            for(Method m : cl.getDeclaredMethods()){
                printMethod(m);
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void printClass(Class<?> cl){
        System.out.print(cl);
        printTypes(cl.getTypeParameters(),"<",",",">",true);
        Type sc = cl.getGenericSuperclass();
        if(sc!=null){
            System.out.print(" extends ");
            printType(sc,false);
        }
        printTypes(cl.getGenericInterfaces(), " Implements ", "," ,"",false);
        System.out.println();
    }

    public static void printMethod(Method m){
        String name = m.getName();
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print(" ");
        printTypes(m.getTypeParameters(),"<",",",">",true);
        printType(m.getGenericReturnType(),false);
        System.out.print(" ");
        System.out.print(name);
        System.out.print("(");
        printTypes(m.getGenericParameterTypes(),"",",","",false);
        System.out.println(")");
    }


    public static void printTypes(Type[] types, String pre, String sep,
                                  String suf, boolean isDefinition){
        if(pre.equals(" extneds ") && Arrays.equals(types,new Type[]{Object.class})){
            return;
        }
        if(types.length >0 ){
            System.out.print(pre);
        }
        for(int i=0;i<types.length;i++){
            if(i>0){
                System.out.print(sep);
            }
            printType(types[i],isDefinition);
        }
        if(types.length >0 ){
            System.out.print(sep);
        }
    }

    public static void printType(Type type, boolean isDefinition){
        if(type instanceof Class){
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        }else if(type instanceof TypeVariable){
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if(isDefinition){
                printTypes(t.getBounds(), " extends ","&", "",false);
            }
        }else if(type instanceof WildcardType){
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            printTypes(t.getUpperBounds()," extends ", "&","",false);
            printTypes(t.getLowerBounds()," super ", "&","",false);
        }else if(type instanceof ParameterizedType){
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if(owner != null){
                printType(owner,false);
                System.out.print(".");
            }
            printType(t.getRawType(), false);
            printTypes(t.getActualTypeArguments(),"<",",",">",false);
        }else if(type instanceof GenericArrayType){
            GenericArrayType t = (GenericArrayType) type;
            System.out.print("");
            printType(t.getGenericComponentType(),isDefinition);
            System.out.print("[]");
        }
    }


    /****
     *  java.lang.Class
     *  TypeVariable[] getTypeParameters()
     *  如果这个类型被声明为泛型，则获取泛型类型变量，否则获得一个长度为零的数组
     *
     *  Type getGenericSupperclass()
     *  获取被申明为这一类型的超类的泛型类型；如果这个类是Object或不是一个类类型，则返回null
     *
     *  Type[] getGenericInterfaces()
     *  获得被声明为这个类型的接口的泛型类型是，如果这个类没有实现接口，返团成员一个长度为零的数组
     *
     *  java.lang.reflect.Method
     *  TypeVariable[] getTypeParameters()
     *  如果这个方法被声明为泛型方法，则获取泛型变量，否则返回长度为零的数组
     *
     *  Type getGenericReturnType()
     *  获取这个方法被声明的泛型返回类型
     *
     *  Type[] getGenericParameterTypes()
     *  获取这个方法被声明的泛型参数类型，如果这个方法没有参数，返回长度为零的数组
     *
     *  java.lang.reflect.TypeVariable
     *  String getName()
     *  获取类型变量的名字
     *
     *  Type[] getBounds()
     *  获取类型变量的子类限定，无限定，则返回长度为零的数组
     *
     *  java.lang.reflect.WildcardType
     *  Type getUpperBounds()
     *  获取子类限定
     *
     *  Type getLowerBounds()
     *  获取父类限定
     *
     *  java.lang.reflect.ParameterizedType
     *  Type getRawType()
     *  获取这个参数化类型的原始类型
     *
     *  Type[] getActualTypeArguments()
     *  获取这个参数化类型声明时所使用的类型参数
     *
     *  Type getOwnerType()
     *  如果是内部类型，则返回其外部类型，如果是顶级类型，则返回null
     *
     *  java.lang.reflect.GenericArrayType
     *  Type getGenericComponentType()
     *  获取声明该数组的泛型组合类型
     *
     *
     */

}