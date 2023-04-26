package ElevadorMultithread;
import java.util.Random;





public class Predio extends Thread{
	
public static int AndaresTotal = 10;
public static Elevador elevador1;
public static int PassageirosTotais = 5;

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
			
			passageiro.start();
			//System.out.println("----------------------------------------------");
			
		}

	}

	
	
	
	
}
