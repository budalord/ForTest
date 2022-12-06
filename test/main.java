package test;

public class main {
    public static void main(String[] args) {
        op c = new cal();
        System.out.println(c.add(10, 20));
        System.out.println(c.add(20.5, 1.5));
        System.out.println(c.add(1l, 3l));
        System.out.println(c.add(1l, "asd"));
    }
}

class cal implements op {
    private Class type;

    /**
     * 得到超类的类型
     *
     * @param o o
     */
    private void getType(Object o) {
        this.type = o.getClass();
    }

    @Override
    public Object add(Object v1, Object v2) {
        getType(v1);
        if (!check(v1, v2)) throw new RuntimeException("越界");
        if (v1.getClass() != v2.getClass()) {
            throw new RuntimeException("类型不匹配");
        } else if (type == Integer.class) {
            return ((Integer) v1) + ((Integer) v2);
        } else if (type == Double.class) {
            return ((Double) v1) + ((Double) v2);
        } else if (type == Long.class) {
            return ((Long) v1) + ((Long) v2);
        }
        return null;
    }

    @Override
    public Object mins(Object v1, Object v2) {
        return null;
    }

    @Override
    public Object multiply(Object v1, Object v2) {
        return null;
    }

    @Override
    public Object divide(Object v1, Object v2) {
        return null;
    }
}

interface op {
    Object add(Object v1, Object v2);

    Object mins(Object v1, Object v2);

    Object multiply(Object v1, Object v2);

    Object divide(Object v1, Object v2);

    default boolean check(Object v1, Object v2) {
        Class type = v1.getClass();
        if (type == Integer.class) {
            return (Integer) v1 <= Integer.MAX_VALUE;
        } else if (type == Double.class) {
            return (Double) v1 <= Double.MAX_VALUE;
        } else if (type == Long.class) {
            return (Long) v1 <= Long.MAX_VALUE;
        }
        return false;
    }
}
