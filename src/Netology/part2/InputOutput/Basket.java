package Netology.part2.InputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class Basket {

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


    protected void printCart() {
        System.out.println("Basket:");
        int sum = 0;
        for (int i = 0; i < productsCount.length; i++) {
            int allCount = productsCount[i];
            int priceSum = prices[i] * allCount;
            if (allCount > 0) {
                sum += priceSum;
                System.out.println(productsName[i] + " " + allCount +" "+ priceSum);
            }
        }
        System.out.println("Total: " + sum + " rub.");
    }
    public void saveTxt(File textFile) {
        try (PrintWriter writer = new PrintWriter(textFile)) {
            for (int i = 0; i < productsName.length; i++) {
                writer.println(productsName[i] + " " + prices[i] + " " + productsCount[i]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error!");
        }
    }


    public static Basket loadTxtFile(File textFile) throws IOException {
        Path path = textFile.toPath();
        List<String> basketList = Files.readAllLines(path);

        String[] productsNames = new String[basketList.size()];
        int[] prices = new int[basketList.size()];
        int[] productsCount = new int[basketList.size()];

        for (int i = 0; i <= basketList.size() - 1; i++) {
            String[] data = basketList.get(i).split(" ");
            productsNames[i] = data[0];
            prices[i] = Integer.parseInt(data[1]);
            productsCount[i] = Integer.parseInt(data[2]);
        }

        Basket basket = new Basket(prices, productsNames);
        basket.setCount(productsCount);
        System.out.print("Basket return!:" + "\n");
        basket.printCart();
        return basket;
    }
    protected void printForBuy() {
        System.out.println("List of available products: ");
        for (int i = 0; i < productsName.length; i++) {
            System.out.println((i + 1) + ". " + productsName[i] + " " + prices[i] + " rub.");
        }
    }
}