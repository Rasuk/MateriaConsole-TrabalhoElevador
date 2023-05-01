package ElevadorMultithread;
import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class Elevador extends Thread {
public static int AndarAtual = 0;
public static int AndarDestino;
public static int PassageirosRecebidos;
public static int variavelauxiliar = 0;
public static boolean PassageiroPresente;
public static boolean PortaAberta = false;
public static boolean EmProgresso = false;
public static ArrayList<Passageiros> listaPassageirosRecebida = new ArrayList<Passageiros>();
Semaphore semaforo = new Semaphore(1);

public Elevador(int PassageirosTotais)
{
	PassageirosRecebidos = PassageirosTotais;


}

public void run()
{
	
	while( PassageirosRecebidos > 0)
	{
		/*
		try {
		semaforo.acquire();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		*/
		if(PassageiroPresente== false && EmProgresso==false && PortaAberta ==false)
		{
			try {
			
				int A =listaPassageirosRecebida.get(variavelauxiliar).AndarPresente;
				VisitarAndar(A);
				
			}
			catch(IndexOutOfBoundsException e){
				System.out.println("Não há passageiros");
			}
		}
		
		else {	
			
			
		}
		/*
		semaforo.release();
		*/
	}
}

public static void AbrirPortas()
{
	if(AndarAtual == AndarDestino && PortaAberta==false)
	{
		PortaAberta = true;
		System.out.println("Porta Aberta");
		System.out.println("Elevador está no andar: " +AndarAtual);
	}
	
}

public static void FecharPortas()
{
	if(AndarAtual == AndarDestino)
	{
		PortaAberta = false;
		System.out.println("Porta Fechada");
	}
	
	
	
}

public static void VisitarAndar(int AndarDst) 
{	
	
	FecharPortas();
	if(PortaAberta == false)
	{
	
		AndarAtual = AndarDst;
		AndarDestino = AndarDst;
		System.out.println("O elevador vai para o andar " + AndarDestino);
		if(AndarAtual == AndarDestino)
		{
			System.out.println("O elevador chegou ao seu destino, o andar: " + AndarDestino);
			AbrirPortas();
			
		}
		
	}
}























}
