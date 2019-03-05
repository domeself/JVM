package com.jvm.datatype;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/3/5 11:54
 * @Version
 **/
public class DateBoolean {
    public static boolean boolValue = true;
    public static void main(String[] args) throws Exception{

        /**
         * java虚拟机规范中，规定boolean类型  true=1  false=0
         **/

        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        Date o = (Date)unsafe.allocateInstance(Date.class);


        Field boolFiled = o.getClass().getDeclaredField("aBoolean");

        boolFiled.setAccessible(true);
        long fieldOffset = unsafe.objectFieldOffset(boolFiled);
        System.out.println(unsafe.getByte(o, fieldOffset));
        unsafe.putByte(o,fieldOffset,(byte) 2);  //2  0010
        System.out.println(o.getAboolean());
        if (o.getAboolean()){
            System.out.println("hello,java!");
        }
        if (o.getAboolean()==true){
            System.out.println("Hello,jvm");
        }
        unsafe.freeMemory(fieldOffset);
    }
}

class  Date{
    public  boolean  aBoolean = false;
    public boolean getAboolean(){
        return  aBoolean;
    }
}
