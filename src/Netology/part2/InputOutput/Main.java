package Netology.part2.InputOutput;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        int[] prices = {100, 200, 300};
        String[] products = {"Apples", "Bread", "Potatoes"};

        Scanner scanner = new Scanner(System.in);
        File txtFile = new File("basket.txt");
        Basket basket = new Basket(prices, products);

        if (txtFile.exists()) {
            Basket.loadTxtFile(txtFile);
        } else {
            basket.printForBuy();

            while (true) {
                System.out.println("Enter the product number and quantity, or 'end' to exit.");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("end")) {
                    break;
                }
                String[] parts = input.split(" ");
                if (parts.length != 2) {
                    continue;
                }

                int productNumber;
                try {
                    productNumber = Integer.parseInt(parts[0]) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Error!");
                    continue;
                }

                int productCount;
                try {
                    productCount = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Error!");
                    continue;
                }
                if (productCount > 50 || productCount <= 0) {
                    System.out.println("Error!");
                    continue;
                }
                basket.addToCart(productNumber, productCount);
            }
            basket.saveTxt(txtFile);
            basket.printCart();
        }
    }
}