package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.exception.DomainException;
import model.tabelas.Reserva;

public class ProgramaExcecao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do Quarto: ");
			int nQuarto = sc.nextInt();
			System.out.print("Data de Check-In: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-Out: ");
			Date checkOut = sdf.parse(sc.next());
	
			Reserva reserva = new Reserva(nQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
	
			System.out.println();
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva:");
	
			System.out.print("Data de Check-In: ");
			checkIn = sdf.parse(sc.next());
	
			System.out.print("Data de Check-Out: ");
			checkOut = sdf.parse(sc.next());
	
			reserva.atualizaDatas(checkIn, checkOut);
			System.out.println("Atualização da Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Data inválida!");
		}
		catch (DomainException e) {
			System.out.println("Erro em reserva:" + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inexperado!");
		}

		sc.close();
	}

}
