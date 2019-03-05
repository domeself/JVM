package com.jvm.datatype;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/3/5 12:33
 * @Version
 **/
public class FLoatType {
    public static void main(String[] args) {
        /**
         * IEEE 754 浮点数格式
         * 浮点类型通常有两个 0，+0.0F(00000..) 以及 -0.0F(10000....),在内存中不等，但是Java 中 +0.0F == -0.0F
         * 正无穷：任意正浮点数除以 0.0F 得到的值   3.4f/ 0.0f= Infinity  ->0x7F800000
         * 负无穷：任意正浮点数除以 -0.0F 得到的值  3.4f/-0.0f=-Infinity  ->0xFF800000
         * NaN（Not-a-Number）[0x7F800001, 0x7FFFFFFF] 和 [0xFF800001, 0xFFFFFFFF]
         *     标准的 NaN(0x7FC00000)，而其他的我们称之为不标准的NaN
         *     除了“!=”始终返回 true 之外，所有其他比较结果都会返false
         **/
        System.out.println(3.4f/0.0f);
        System.out.println(3.4f/-0.0f);


    }
}
