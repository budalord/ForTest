package test;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Fu t=new Zi();
        Calculate calculate=new Calculate();
        Scanner s=new Scanner(System.in);
        System.out.println("请输入第一个数");
        int a=s.nextInt();
        System.out.println("请输入第二个数");
        int b=s.nextInt();
        System.out.println("请输入运算符");
        String c=s.next();


        calculate.show(a,b,c,t);
        }

    private  void show(int a, int b, String c, Fu t) {
        if("+".equals(c)){
            System.out.println(t.add(a,b));;
        } else  if("-".equals(c)){
            System.out.println(t.mins(a,b));
        } else  if("*".equals(c)){
            System.out.println(t.multiply(a,b));
        }else  if("/".equals(c)){
            System.out.println(t.divide(a,b));
        }else{
            System.out.println("您输入的运算符有误！");
        }
    }
}

    class Zi implements Fu{
        private Class type;

        private void getType(Object o){
            this.type=o.getClass();
        }

        @Override
        public Object add(Object a, Object b) {
            getType(a);
            if(!check1(a)&&!check2(b))throw new RuntimeException("越界");
            if(a.getClass()!=b.getClass()){
                throw new RuntimeException("类型不匹配");
            } else if (type == Integer.class) {
                return ((Integer) a) + ((Integer) b);
            } else if (type == Double.class) {
                return ((Double) a) + ((Double) b);
            } else if (type == Long.class) {
                return ((Long) a) + ((Long) b);
            }
            return null;
        }

        @Override
        public Object mins(Object a, Object b) {
            getType(a);
            if(!check1(a)&&!check2(b))throw new RuntimeException("越界");
            if(a.getClass()!=b.getClass()){
                throw new RuntimeException("类型不匹配");
            } else if (type == Integer.class) {
                return ((Integer) a) - ((Integer) b);
            } else if (type == Double.class) {
                return ((Double) a) - ((Double) b);
            } else if (type == Long.class) {
                return ((Long) a) - ((Long) b);
            }
            return null;
        }

        @Override
        public Object multiply(Object a, Object b) {
            getType(a);
            if(!check1(a)&&!check2(b))throw new RuntimeException("越界");
            if(a.getClass()!=b.getClass()){
                throw new RuntimeException("类型不匹配");
            } else if (type == Integer.class) {
                return ((Integer) a) * ((Integer) b);
            } else if (type == Double.class) {
                return ((Double) a) * ((Double) b);
            } else if (type == Long.class) {
                return ((Long) a) * ((Long) b);
            }
            return null;
        }

        @Override
        public Object divide(Object a, Object b) {
            getType(a);
            if(!check1(a)&&!check2(b))throw new RuntimeException("越界");
            if(a.getClass()!=b.getClass()){
                throw new RuntimeException("类型不匹配");
            } else if (type == Integer.class) {
                return ((Integer) a) / ((Integer) b);
            } else if (type == Double.class) {
                return ((Double) a) / ((Double) b);
            } else if (type == Long.class) {
                return ((Long) a) / ((Long) b);
            }
            return null;
        }
    }

    interface Fu{
        Object add(Object a,Object b);
        Object mins(Object a,Object b);
        Object multiply(Object a,Object b);
        Object divide(Object a,Object b);

        //判断数据是否超出基本数据类型的界限
        default boolean check1(Object a){
            Class type=a.getClass();
            if(type==Integer.class){
                return(Integer)a<=Integer.MAX_VALUE;
            }else if(type==Double.class){
                return(Double)a<=Double.MAX_VALUE;
            }else if(type==Long.class){
                return (Long)a<=Long.MAX_VALUE;
            }
            return false;
        }
        default boolean check2(Object b){
            Class type=b.getClass();
            if(type==Integer.class){
                return(Integer)b<=Integer.MAX_VALUE;
            }else if(type==Double.class){
                return(Double)b<=Double.MAX_VALUE;
            }else if(type==Long.class){
                return (Long)b<=Long.MAX_VALUE;
            }
            return false;
        }
    }



