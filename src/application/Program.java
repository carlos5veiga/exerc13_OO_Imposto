package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		List<Pessoa> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String nome = sc.nextLine();
			System.out.print("Anual income: ");
			double rendaAnual = sc.nextDouble();
			if (ch=='i') {
				System.out.print("Health expenditures: ");
				double gastoSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastoSaude));
			}
			else {
				System.out.print("Number of employees: ");
				int numFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numFuncionarios));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		double impostoTotal = 0.0;
		for (Pessoa p : list) {
			System.out.println(p.getNome() + ": $ " + String.format("%.2f", p.impostoDevido()));
			impostoTotal += p.impostoDevido();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", impostoTotal));
		sc.close();
	}

}
