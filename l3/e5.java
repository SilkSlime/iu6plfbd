package l3;

import java.util.Arrays;

public class e5 {
    
    /**
     * Вариант 3. Задача 5.
     * Создать объект класса Роза, используя классы Лепесток, Бутон.
     * Методы: расцвести, завять, вывести на консоль цвет бутона.
     * Аргументировать принадлежность классу каждого создаваемого метода
     * и корректно переопределить для каждого класса методы equals(), hashCode(), toString().
     */

    public static void main(String[] args) {
        // Example of using Rose class
        Rose rose = new Rose("red", 5);
        System.out.println(rose);
        System.out.println();

        rose.bloom();
        System.out.println(rose);
        System.out.println();
        rose.wither();
        System.out.println(rose);
        System.out.println();

        // Example of roses comparison
        Rose rose1 = new Rose("red", 5);
        Rose rose2 = new Rose("red", 5);
        System.out.println(rose1.equals(rose2));
    }
}

class Petal {
    private boolean isWithered;

    public Petal(boolean isWithered) {
        this.isWithered = isWithered;
    }

    public boolean isWithered() {
        return isWithered;
    }

    public void setWithered(boolean withered) {
        isWithered = withered;
    }

    @Override
    public String toString() {
        return "Petal{" +
                "isWithered=" + isWithered +
                '}';
    }

    @Override
    public int hashCode() {
        return (isWithered ? 1 : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Petal petal = (Petal) obj;
        return hashCode() == petal.hashCode();
    }
}

class Bud {
    private String color;
    private int petalCount;
    private Petal[] petals;

    public Bud(String color, int petalCount) {
        this.color = color;
        this.petalCount = petalCount;
        this.petals = new Petal[petalCount];
        for (int i = 0; i < petalCount; i++) {
            petals[i] = new Petal(false);
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPetalCount() {
        return petalCount;
    }

    public void setPetalCount(int petalCount) {
        this.petalCount = petalCount;
    }

    public Petal[] getPetals() {
        return petals;
    }

    public void setPetals(Petal[] petals) {
        this.petals = petals;
    }

    public void bloom() {
        for (Petal petal : petals) {
            petal.setWithered(false);
        }
    }

    public void wither() {
        for (Petal petal : petals) {
            petal.setWithered(true);
        }
    }

    @Override
    public String toString() {
        return "Bud{" +
                "color='" + color + '\'' +
                ", petalCount=" + petalCount +
                ", petals=" + Arrays.toString(petals) +
                '}';
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + petalCount;
        result = 31 * result + Arrays.hashCode(petals);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bud bud = (Bud) obj;
        return hashCode() == bud.hashCode();
    }
}

class Rose {
    private String color;
    private int budCount;
    private Bud[] buds;

    public Rose(String color, int budCount) {
        this.color = color;
        this.budCount = budCount;
        this.buds = new Bud[budCount];
        for (int i = 0; i < budCount; i++) {
            buds[i] = new Bud(color, 5);
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBudCount() {
        return budCount;
    }

    public void setBudCount(int budCount) {
        this.budCount = budCount;
    }

    public Bud[] getBuds() {
        return buds;
    }

    public void setBuds(Bud[] buds) {
        this.buds = buds;
    }

    public void bloom() {
        for (Bud bud : buds) {
            bud.bloom();
        }
    }

    public void wither() {
        for (Bud bud : buds) {
            bud.wither();
        }
    }

    @Override
    public String toString() {
        return "Rose{" +
                "color='" + color + '\'' +
                ", budCount=" + budCount +
                ", buds=" + Arrays.toString(buds) +
                '}';
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + budCount;
        result = 31 * result + Arrays.hashCode(buds);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rose rose = (Rose) obj;
        return hashCode() == rose.hashCode();
    }
}