package ElevadorMultithread;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;





public class Predio extends Thread{
	
public static int AndaresTotal = 10;
public static Elevador elevador1;
public static int PassageirosTotais = 5;
//public static Passageiros passageirin;
public static ArrayList<Passageiros> Passageirolist = new ArrayList<Passageiros>();
	public static void main(String[] args) {
		
		Random gerador = new Random();
		Elevador elevador = new Elevador(PassageirosTotais);
		elevador1 = elevador;
		elevador.start();
		
		for(int a = 0; a < 5; a++)
		{
			int A = gerador.nextInt(AndaresTotal -1);
			int B = gerador.nextInt(AndaresTotal);
			if(A == B)
			{
				B= B+1;
			}
			Passageiros passageiro = new Passageiros(a, A, B);			
			Passageirolist.add(passageiro);
			Elevador.listaPassageirosRecebida = Passageirolist;
			passageiro.start();
			//System.out.println("----------------------------------------------");
			

		}
	}

	
	
	
	
}
