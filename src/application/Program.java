package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		/*
		 * Fazer um programa para ler os dados de N produtos (N fornecido pelo usuário).
		 * Ao final, mostrar a etiqueta de preço de cada produto na mesma ordem em que
		 * foram digitados.
		 */
		Scanner sc = new Scanner(System.in);
		// para trabalhar com datas
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// Lista para adição dos produtos .
		List<Product> list = new ArrayList<Product>();
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char opt = sc.next().charAt(0);

			System.out.println("Name: ");
			String name = sc.next();

			System.out.println("Price: ");
			Double price = sc.nextDouble();

			if (opt == 'c') {
				list.add(new Product(name, price));

			} else if (opt == 'u') {
				System.out.println("Manufacture Date: DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());

				list.add(new UsedProduct(name, price, date));

			} else if (opt == 'i') {
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();

				list.add(new ImportedProduct(name, price, customsFee));
			}

		}
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println("Price Tags: ");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}
		sc.close();

	}

}
