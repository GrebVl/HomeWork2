package Menu;

import PlushToy.*;
import WorkingFiles.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final Scanner scn;
    ArrayList<PlushToy> playableToys;
    ArrayList<PlushToy> playedToys;
    ArrayList<PlushToy> issuedToys;

    public Menu() throws IOException, ParseException {
        scn = new Scanner(System.in);
        this.playableToys = FileWorke.ReadFile("Toys.json");
        this.playedToys = FileWorke.ReadFile("ToysPlayed.json");
        this.issuedToys = FileWorke.ReadFile("ToysIssued.json");
    }

    public void mainMenu() {

        boolean ex = true;
        while (ex) {
            System.out.println("1 Добавление и редоктирование игрушки \n2 Просмотр списка игрушек в розыгреше\n" +
                    "3 Просмотр списка игрушек выйгранных \n4 Просмотр списка игрушек выданных\n" +
                    "5 Розыгрыш игрушек \n6 выход\nВведите число");
            int number = scn.nextInt();
            switch (number) {
                case 1:
                    menuAddEditingToy();
                    break;
                case 2:
                    viewListToys(this.playableToys);
                    break;
                case 3:
                    viewListToys(this.playedToys);
                    break;
                case 4:
                    viewListToys(this.issuedToys);
                    break;
                case 5:
                    toysDraw();
                    break;
                case 6:
                    FileWorke.WreatFile(this.playableToys, "Toys.json");
                    FileWorke.WreatFile(this.playedToys, "ToysPlayed.json");
                    FileWorke.WreatFile(this.issuedToys, "ToysIssued.json");
                    ex = false;
                    scn.close();
                    break;
                default:
                    System.out.println("Введено не верное значение");
            }
        }
    }

    public void menuAddEditingToy(){
        boolean ex = true;
        while (ex) {
            System.out.println("1 Добавление новой игрушки \n2 Редактирование имеющейся\n" +
                    "3 выход\nВведите число");
            int number = scn.nextInt();
            switch (number) {
                case 1:
                    AddToy();
                    break;
                case 2:
                    viewListToys(this.playableToys);
                    editingToy();
                    break;
                case 3:
                    ex = false;
                    break;
                default:
                    System.out.println("Введено не верное значение");
            }
        }
    }

    public void AddToy() {
        Scanner newScn = new Scanner(System.in);
        System.out.print("Введите имя игрушки: ");
        String nameToy = newScn.nextLine();
        System.out.print("Введите цвет игрушки: ");
        String colorToy = newScn.nextLine();
        System.out.print("Введите количество игрушек: ");
        int amount = newScn.nextInt();
        System.out.print("Введите вес игрушки: ");
        int weight = newScn.nextInt();
        playableToys.add(new NewToy(nameToy, colorToy, weight, amount));
    }

public void editingToy(){
    Scanner newScan = new Scanner(System.in);
    System.out.print("Введите номер игрушки: ");
    int index = scn.nextInt() - 1;
    boolean ex = true;
    while (ex) {
        System.out.println("Изменение\n1 имени\n2 цвета\n3 веса\n4 количества\n" +
                "5 выход\nВведите число");
        int number = scn.nextInt();
        switch (number) {
            case 1:
                System.out.print("Введите имя игрушки: ");
                String nameToy = newScan.nextLine();
                this.playableToys.get(index).setNameToy(nameToy);
                break;
            case 2:
                System.out.print("Введите цвет игрушки: ");
                String colorToy = newScan.nextLine();
                this.playableToys.get(index).setColorToy(colorToy);
                break;
            case 3:
                System.out.print("Введите вес игрушки: ");
                int weight = newScan.nextInt();
                this.playableToys.get(index).setWeight(weight);
                break;
            case 4:
                System.out.print("Введите количество игрушек: ");
                int amount = newScan.nextInt();
                this.playableToys.get(index).setAmount(amount);
                break;
            case 5:
                ex = false;
                break;
            default:
                System.out.println("Введено не верное значение");
        }
    }
}

    public void viewListToys(ArrayList<PlushToy> toys) {
        for (int i = 0; i < toys.size(); i++) {
            System.out.print(i + 1 + " ");
            toys.get(i).getInfo();
        }
    }

    public void toysDraw() {
        boolean ex = true;
        while (ex) {
            System.out.println("1 Рулетка на выпадение игрушки \n2 Получение игрушки\n" +
                    "3 выход\nВведите число");
            int number = scn.nextInt();
            switch (number) {
                case 1:
                    rouletteToy();
                    break;
                case 2:
                    gettingToy();
                    break;
                case 3:
                    ex = false;
                    break;
                default:
                    System.out.println("Введено не верное значение");
            }
        }
    }

    public void rouletteToy() {
        int index = 0;
        index = RandomIndexToy.randomIndex(this.playableToys);
        this.playableToys.get(index).getInfoPrize();
        String nameToy = this.playableToys.get(index).getNameToy();
        String colorToy = this.playableToys.get(index).getColorToy();
        int amount = 1;
        int weight = this.playableToys.get(index).getWeight();
        this.playedToys.add(new NewToy(nameToy, colorToy, weight, amount));
        this.playableToys.get(index).setAmount(this.playableToys.get(index).getAmount() - 1);
    }

    public void gettingToy() {
        viewListToys(this.playedToys);
        System.out.println("Введите номер игрушки");
        int index = scn.nextInt() - 1;
        if (index < this.playedToys.size()) {
            this.playedToys.get(index).getInfoPrize();
            String nameToy = this.playedToys.get(index).getNameToy();
            String colorToy = this.playedToys.get(index).getColorToy();
            int amount = 1;
            int weight = playedToys.get(index).getWeight();
            this.issuedToys.add(new NewToy(nameToy, colorToy, weight, amount));
            this.playedToys.remove(index);
        } else {
            System.out.println("Такой игрушки нет");
        }
    }
}
