package l3;

import java.util.Arrays;

public class e6 {
    
    /**
     * Вариант 3. Задача 6.
     * Создать объект класса Дерево, используя классы Лист.
     * Методы: зацвести, опасть листьям, покрыться инеем, пожелтеть листьям. 
     * Аргументировать принадлежность классу каждого создаваемого метода
     * и корректно переопределить для каждого класса методы equals(), hashCode(), toString().
     */

    public static void main(String[] args) {
        // Example of using Tree class with array of leaves using Tree constructor
        Leaf[] leaves = new Leaf[5];
        for (int i = 0; i < leaves.length; i++) {
            leaves[i] = new Leaf(false, false, false, false);
        }
        Tree tree = new Tree(leaves);
        System.out.println(tree);
        System.out.println();
        // Example of using Tree methods
        tree.bloom();
        System.out.println(tree);
        System.out.println();
        tree.fall();
        System.out.println(tree);
        System.out.println();
        tree.coverWithIce();
        System.out.println(tree);
        System.out.println();
        tree.yellow();
        System.out.println(tree);
        System.out.println();

        // Example of trees comparison
        Tree tree1 = new Tree(leaves);
        Tree tree2 = new Tree(leaves);
        System.out.println(tree1.equals(tree2));
        
    }
}

class Leaf {
    private boolean isWithered;
    private boolean isFallen;
    private boolean isYellowed;
    private boolean isCoveredWithIce;

    public Leaf(boolean isWithered, boolean isFallen, boolean isYellowed, boolean isCoveredWithIce) {
        this.isWithered = isWithered;
        this.isFallen = isFallen;
        this.isYellowed = isYellowed;
        this.isCoveredWithIce = isCoveredWithIce;
    }

    public boolean isWithered() {
        return isWithered;
    }

    public void setWithered(boolean withered) {
        isWithered = withered;
    }

    public boolean isFallen() {
        return isFallen;
    }

    public void setFallen(boolean fallen) {
        isFallen = fallen;
    }

    public boolean isYellowed() {
        return isYellowed;
    }

    public void setYellowed(boolean yellowed) {
        isYellowed = yellowed;
    }

    public boolean isCoveredWithIce() {
        return isCoveredWithIce;
    }

    public void setCoveredWithIce(boolean coveredWithIce) {
        isCoveredWithIce = coveredWithIce;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "isWithered=" + isWithered +
                ", isFallen=" + isFallen +
                ", isYellowed=" + isYellowed +
                ", isCoveredWithIce=" + isCoveredWithIce +
                '}';
    }

    @Override
    public int hashCode() {
        int result = (isWithered ? 1 : 0);
        result = 31 * result + (isFallen ? 1 : 0);
        result = 31 * result + (isYellowed ? 1 : 0);
        result = 31 * result + (isCoveredWithIce ? 1 : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Leaf leaf = (Leaf) o;

        return hashCode() == leaf.hashCode();
    }
}

class Tree {
    private Leaf[] leaves;

    public Tree(Leaf[] leaves) {
        this.leaves = leaves;
    }

    public Leaf[] getLeaves() {
        return leaves;
    }

    public void setLeaves(Leaf[] leaves) {
        this.leaves = leaves;
    }
    
    public void bloom() {
        for (Leaf leaf : leaves) {
            leaf.setWithered(false);
        }
    }

    public void fall() {
        for (Leaf leaf : leaves) {
            leaf.setFallen(true);
        }
    }

    public void coverWithIce() {
        for (Leaf leaf : leaves) {
            leaf.setCoveredWithIce(true);
        }
    }

    public void yellow() {
        for (Leaf leaf : leaves) {
            leaf.setYellowed(true);
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "leaves=" + Arrays.toString(leaves) +
                '}';
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(leaves);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tree tree = (Tree) o;

        return hashCode() == tree.hashCode();
    }
}