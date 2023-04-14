package l5;

public class e4 {
    
    /**
     * Из 3й лабы. Вариант 2. Задача 6.
     * Создать класс
     * House: id, Номер квартиры, Площадь, Этаж, Количество комнат, Улица, Тип здания, Срок эксплуатации.
     * Создать массив объектов. Вывести:
     * a) список квартир, имеющих заданное число комнат;
     * b) список квартир, имеющих заданное число комнат и расположенных на этаже, который находится в заданном промежутке;
     * c) список квартир, имеющих площадь, превосходящую заданную.
     * Определить конструкторы и методы setТип(), getТип(), toString().
     * Определить дополнительно методы в классе, создающем массив объектов.
     * Задать критерий выбора данных и вывести эти данные на консоль. 
     * 
     * Выполнить задание, реализуя собственные обработчики исключений и исключения ввода/вывода
     */

    public static void main(String[] args) {
        // Create array of houses with random data
        House[] houses = null;

        try {
            houses = House.createHouses(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        // Print all houses with 3 rooms
        System.out.println("All houses with 3 rooms:");
        for (House house : houses) {
            if (house.getRooms() == 3) {
                System.out.println(house);
            }
        }

        // Print all houses with 3 rooms and floor between 10 and 20
        System.out.println("All houses with 3 rooms and floor between 10 and 20:");
        for (House house : houses) {
            if (house.getRooms() == 3 && house.getFloor() >= 10 && house.getFloor() <= 20) {
                System.out.println(house);
            }
        }

        // Print all houses with area more than 50
        System.out.println("All houses with area more than 50:");
        for (House house : houses) {
            if (house.getArea() > 90) {
                System.out.println(house);
            }
        }
    

    }
}

class House {
    private int id;
    private int apartmentNumber;
    private double area;
    private int floor;
    private int rooms;
    private String street;
    private String buildingType;
    private int exploitationTerm;

    public House(int id, int apartmentNumber, double area, int floor, int rooms, String street, String buildingType, int exploitationTerm) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.rooms = rooms;
        this.street = street;
        this.buildingType = buildingType;
        this.exploitationTerm = exploitationTerm;
    }

    // Create array of houses with random data
    public static House[] createHouses(int count) {
        // Выкидывает исключение, если count < 0
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be more than 0");
        }
        House[] houses = new House[count];
        for (int i = 0; i < count; i++) {
            houses[i] = new House(i, (int) (Math.random() * 100), Math.random() * 100, (int) (Math.random() * 100), (int) (Math.random() * 10), "Street " + (int) (Math.random() * 100), "Type " + (int) (Math.random() * 10), (int) (Math.random() * 100));
        }
        return houses;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public int getExploitationTerm() {
        return exploitationTerm;
    }

    public void setExploitationTerm(int exploitationTerm) {
        this.exploitationTerm = exploitationTerm;
    }

    @Override
    public String toString() {
        return "House [id=" + id + ", apartmentNumber=" + apartmentNumber + ", area=" + area + ", floor=" + floor
                + ", rooms=" + rooms + ", street=" + street + ", buildingType=" + buildingType + ", exploitationTerm="
                + exploitationTerm + "]";
    }
}
