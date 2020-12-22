package Lab2;

//Car: id, Модель, Рік випуску, Ціна, Реєстраційний номер.
//
//Скласти масив об`єктів. Вивести:
//a) список автомобілів заданої моделі;-
//b) список автомобілів заданої моделі, які експлуатуються більше n
//років;-
//c) список автомобілів заданого року випуску, ціна яких більше
//вказаної.-

import Lab2.Car.Car;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    private static List<Car> list = new ArrayList<Car>();
    private static String model;
    private static int yrsInUse;
    private static int year;
    private static double price;
    private static final int CAR_NUM = 20;

    public static void main(String[] args) {
        autoFill(list);
        input();
        print();
    }

    public static void autoFill(List<Car> list) {
        for(int i = 0;i<CAR_NUM;i++){
            list.add(Car.getRandom());
        }
    }

    public static void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter wanted model -> ");
        model = in.nextLine();
        System.out.println("Enter wanted number of years in use -> ");
        yrsInUse = in.nextInt();
        System.out.println("Enter wanted build year -> ");
        year = in.nextInt();
        System.out.println("Enter wanted lowest price -> ");
        price = in.nextDouble();
    }

    public static void print(){
        LocalDate curDate = LocalDate.now();

        System.out.println("Cars of given model: "+model+" :\n");
        output(list, (obj) -> obj.getModel().equals(model));

        System.out.println("Cars of given model: "+model+" ,that are in use more than "+yrsInUse+" years :\n");
        output(list, (obj) -> obj.getModel().equals(model) && (curDate.getYear() - obj.getBuildYear() > yrsInUse));

        System.out.println("Cars of given build year : "+year+" ,price of which is greater than "+price+" :\n");
        output(list, (obj) -> obj.getBuildYear() == year && obj.getPrice() > price);
    }

    public static void output(List<Car> list, Predicate<Car> condition) {
        for (Car obj : list) {
            if (condition.test(obj)) {
                System.out.println(obj);
            }
        }
    }
}

