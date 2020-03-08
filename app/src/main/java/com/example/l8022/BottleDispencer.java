package com.example.l8022;

import java.util.ArrayList;
class BottleDispencer {
    public double raha = 0;
    private ArrayList<Bottle> bottle;
    private static BottleDispencer bd = new BottleDispencer();

    public BottleDispencer() {
    }

    public void lisaaPullot() {
        ArrayList<Bottle> bottle = new ArrayList<Bottle>();
        Bottle nimi1 = new Bottle("Pepsi Max", "Pepsi", 0.3, 1.8, 0.5);
        bottle.add(nimi1);
        Bottle nimi2 = new Bottle("Pepsi Max", "Pepsi", 0.3, 2.2, 1.5);
        bottle.add(nimi2);
        Bottle nimi3 = new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 2.0, 0.5);
        bottle.add(nimi3);
        Bottle nimi4 = new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 2.5, 1.5);
        bottle.add(nimi4);
        Bottle nimi5 = new Bottle("Fanta Zero", "Coca-Cola", 0.3, 1.95, 0.5);
        bottle.add(nimi5);
        setList(bottle);
    }

    public static BottleDispencer getInstance() {
        return bd;

    }

    public ArrayList<Bottle> getList() {
        return bottle;
    }

    public void setList(ArrayList<Bottle> l) {
        bottle = l;
    }

    //Rahan tallennus on tehty tyhjästi sillä alunperin oli loopin sisällä new BottleDispenser() joten se aina nollas rahat
    public void addMoney(double x) {
        raha = raha + x;
        System.out.println("Klink! Added more money!");
        //return money;
    }

    public void buyBottle(int valinta) {
        try {
            if (bottle.size() == 0) {
                System.out.println("No more bottles!");
            }
            if (valinta > bottle.size()) {
                System.out.println("Wrong choice");

            } else {
                if (bottle.get(valinta - 1) == null) {
                    System.out.println("Out of drinks");
                } else if ((bottle.size() > 0) && (raha >= bottle.get(valinta - 1).getPrice())) {
                    raha = raha - bottle.get(valinta - 1).getPrice();
                    System.out.println("KACHUNK! " + bottle.get(valinta - 1).getName() + " came out of the dispenser!");
                    bottle.remove(valinta - 1);
                } else {
                    System.out.println("Add money first!");
                }
            }
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Wrong choice");
        }

            /*switch (valinta) {
                case 1:
                    if (bottle.get(0) == null){
                        System.out.println("Out of drinks");
                    }
                    else if ((bottle.size() > 0) && (raha >= bottle.get(0).getPrice())) {
                        raha =  raha - 1.8;
                        //Bottle bottl = new Bottle();
                        System.out.println("KACHUNK! " + bottle.get(0).getName() + " came out of the dispenser!");
                        bottle.remove(0);
                    }
                    else {
                        System.out.println("Add money first!");
                    }
                    break;
                case 2:
                    if (bottle.get(1) == null) {
                        System.out.println("Out of drinks");
                    }
                    else if ((bottle.size() > 0) && (raha >= 2.20)) {
                        raha =  raha - 2.2;
                        System.out.println("KACHUNK! " + bottle.get(1).getName() + " came out of the dispenser!");
                        bottle.remove(1);
                    }
                    else {
                        System.out.println("Add money first!");
                    }
                    break;
                case 3:
                    if (bottle.get(2) == null) {
                        System.out.println("Out of drinks");
                    }
                    else if ((bottle.size() > 0) && (raha >= 2.0)) {
                        raha =  raha - 2.0;
                        System.out.println("KACHUNK! " + bottle.get(2).getName() + " came out of the dispenser!");
                        bottle.remove(2);
                    }
                    else {
                        System.out.println("Add money first!");
                    }
                    break;
                case 4:
                    if (bottle.get(3) == null) {
                        System.out.println("Out of drinks");
                    }
                    else if ((bottle.size() > 0) && (raha >= 2.50)) {
                        raha =  raha - 2.5;

                        System.out.println("KACHUNK! " + bottle.get(3).getName() + " came out of the dispenser!");
                        bottle.remove(3);
                    }
                    else {
                        System.out.println("Add money first!");
                    }
                    break;
                case 5:
                    if (bottle.get(4) == null) {
                        System.out.println("Out of drinks");
                    }
                    else if ((bottle.size() > 0) && (raha >= 1.95)) {
                        raha =  raha - 1.95;

                        System.out.println("KACHUNK! " + bottle.get(4).getName() + " came out of the dispenser!");
                        bottle.remove(4);
                    }
                    else {
                        System.out.println("Add money first!");
                    }
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }*/
    }

        //return money;

    public void showBottles() {
        int n = 0;
        for (Bottle i : bottle)
        {
            System.out.println((n+1) +". Name: " + i.getName());
            System.out.println("	Size: " + i.getSize() + "	Price: " + i.getPrice());
            n++;
        }
    }

    public double returnMoney() {
        System.out.printf("Klink klink. Money came out! You got %.2f€ back\n", raha);
        raha = 0;
        return raha;
    }
}


