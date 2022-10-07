package Netology.part2.InputOutput;

import java.io.*;
public class Basket implements Serializable {

    private int[] prices;
    private String[] productsName;
    private int[] productsCount;

    public Basket(int[] prices, String[] productsName) {
        this.prices = prices;
        this.productsName = productsName;
        this.productsCount = new int[prices.length];
    }

    public void setCount(int[] productsCount) {
        this.productsCount = productsCount;
    }

    protected void addToCart(int productNum, int amount) {
        productsCount[productNum] += amount;
    }

    public void printForBuy() {
        System.out.println("List of available products: ");
        for (int i = 0; i < productsName.length; i++) {
            System.out.println((i + 1) + ". " + productsName[i] + " " + prices[i] + " rub.");
        }
    }


    protected void printCart() {
        System.out.println("Basket:");
        int sum = 0;
        for (int i = 0; i < productsCount.length; i++) {
            int allCount = productsCount[i];
            int priceSum = prices[i] * allCount;
            if (allCount > 0) {
                sum += priceSum;
                System.out.println(productsName[i] + " " + allCount + " " + priceSum);
            }
        }
        System.out.println("Total: " + sum + " rub.");
    }

    public void saveBin(File file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Basket loadBinFile(File binFile) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(binFile))) {
            Basket basket = (Basket) objectInputStream.readObject();
            System.out.print("Basket return!:" + "\n");
            basket.printCart();
            return basket;
        }

    }
}