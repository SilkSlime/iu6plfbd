package l3;



public class e2 {
    
    /**
     * Вариант 1. Задача 6.
     * Определить класс Цепная дробь. Определить методы сложения, вычитания,
     * умножения, деления. Вычислить значение для заданного n, x, a[n].
     */

    public static void main(String[] args) {
        ChainFraction cf1 = new ChainFraction(3, 2, new int[] {1, 2, 3});
        cf1.print();
        System.out.println(cf1.value());

        ChainFraction cf2 = new ChainFraction(1.75, 3, 2);
        cf2.print();
        System.out.println(cf2.value());

        cf1.add(cf2);
        cf1.print();
        System.out.println(cf1.value());


    }
}

class ChainFraction {
    private int n;
    private int x;
    private int[] a;
    
    public ChainFraction(int n, int x, int[] a) {
        this.n = n;
        this.x = x;
        this.a = a;
    }

    public ChainFraction(double value, int n, int x) {
        this.n = n;
        this.x = x;
        this.a = calculateA(value, n, x);
    }

    private int[] calculateA(double value, int n, int x) {
        this.a = new int[n];
        a[0] = (int) value;
        for (int i = 1; i < n; i++) {
            value = x / (value - a[i-1]);
            a[i] = (int) value;
        }
        return a;
    }
    
    public ChainFraction add(ChainFraction cf) {
        this.a = calculateA(this.value() + cf.value(), this.n, this.x);
        return null;
    }
    
    public ChainFraction subtract(ChainFraction cf) {
        this.a = calculateA(this.value() - cf.value(), this.n, this.x);
        return null;
    }
    
    public ChainFraction multiply(ChainFraction cf) {
        this.a = calculateA(this.value() * cf.value(), this.n, this.x);
        return null;
    }
    
    public ChainFraction divide(ChainFraction cf) {
        this.a = calculateA(this.value() / cf.value(), this.n, this.x);
        return null;
    }
    
    public double value() {
        double res = a[n-1];
        for (int i = n-2; i >= 0; i--) {
            res = a[i] + x / res;
        }
        return res;
    }

    public void print() {
        System.out.printf("n = %d, x = %d, a = ", this.n, this.x);
        for (int i = 0; i < this.n; i++) {
            System.out.printf("%d ", this.a[i]);
        }
        System.out.println();
    }
}
