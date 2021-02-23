package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainApplications {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> productList = new ArrayList<Product>();
		
		System.out.print("Enter the number of products: ");
		Integer numberOfProducts = sc.nextInt();
		
		for (int i = 1; i <= numberOfProducts; i++) {
			
			System.out.println("Product #" + i + " data: ");
			
			System.out.print("Common, user or imported (c/u/i)? ");
			Character opt = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			Product product;
			
			if(opt.equals('i')) {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				product = new ImportedProduct(name,price,customsFee);
			} else if(opt.equals('u')) {
				System.out.print("Manufacture date (DD/MM/YYYY)");
				String stringDate = sc.next();
				Date date = sdf.parse(stringDate);
				product = new UsedProduct(name, price, date);
			}else {
				product = new Product(name,price);
			}
			
			productList.add(product);
		}
		
		System.out.println("\nPRICE TAGS:");
		for (Product product : productList) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
