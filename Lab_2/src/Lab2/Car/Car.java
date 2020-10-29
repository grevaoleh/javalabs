package Lab2.Car;

import java.util.Random;

public class Car {
private int id;
private String model;
private int buildYear;
private double price;
private String regPlate;

    public Car() {
    }

    public Car(int id, String model, int buildYear, double price, String regPlate) {
        this.id = id;
        this.model = model;
        this.buildYear = buildYear;
        this.price = price;
        this.regPlate = regPlate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRegPlate(String regPlate) {
        this.regPlate = regPlate;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public double getPrice() {
        return price;
    }

    public String getRegPlate() {
        return regPlate;
    }

    public String toString() {
        return "Model: " + this.model + "\n" +
                "ID: " + this.id + "\n" +
                "Registration plate: " + this.regPlate + "\n" +
                "Build year: " + this.buildYear + "\n" +
                "Price: " + this.price + "\n";
    }

    public static Car getRandom(){
        final String[] Models = {"KIA","FORD","CHEVROLET","TOYOTA","MITSUBISHI","SEAT","PEUGEOT","CITROEN","RENAULT","LADA"};
        final int ID_LEN = 1000000;
        Random r = new Random();

        int id = r.nextInt(ID_LEN);
        String model = Models[r.nextInt(10)];
        int buildYear = r.nextInt((2020 - 1991) + 1)+ 1991;
        double price = r.nextInt(1000000) + 10000;
        String regPlate = String.format("%c%c%4d%c%c",(char)(r.nextInt(27)+65),(char)(r.nextInt(27)+65),r.nextInt(8999)+1000,(char)(r.nextInt(27)+65),(char)(r.nextInt(27)+65));
        return new Car(id,model,buildYear,price,regPlate);
    }
}
