package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.tabelas.Reserva;

public class ProgramaExcecao {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("N�mero do Quarto: ");
		int nQuarto = sc.nextInt();
		System.out.print("Data de Check-In: ");
		Date dCheckIn = sdf.parse(sc.next());
		System.out.print("Data de Check-Out: ");
		Date dCheckOut = sdf.parse(sc.next());

		if (!dCheckOut.after(dCheckIn)) {
			System.out.println("Erro na reserva! Data de Check-Out superior a data de Check-In");
		} else {
			Reserva reserva = new Reserva(nQuarto, dCheckIn, dCheckOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva:");

			System.out.print("Data de Check-In: ");
			dCheckIn = sdf.parse(sc.next());

			System.out.print("Data de Check-Out: ");
			dCheckOut = sdf.parse(sc.next());

			Date data = new Date();

			if (dCheckIn.before(data) || dCheckOut.before(data)) {
				System.out.println("Erro na reserva! As datas devem ser futuras");
			}
			else if (!dCheckOut.after(dCheckIn)) {
				System.out.println("Erro na reserva! Data de Check-Out superior a data de Check-In");
			}
			else {
				reserva.atualizaDatas(dCheckIn, dCheckOut);
				System.out.println("Atualiza��o da Reserva: " + reserva);
			}
		}

		sc.close();
	}

}
