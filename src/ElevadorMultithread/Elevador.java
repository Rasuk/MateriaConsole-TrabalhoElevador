package ElevadorMultithread;

public class Elevador extends Thread {
public int AndarAtual = 0;
public int AndarDestino;
public int PassageirosRecebidos;
public boolean PassageiroPresente;
public boolean PortaAberta = false;



public Elevador(int PassageirosTotais)
{
	PassageirosRecebidos = PassageirosTotais;
}

public void run()
{
	//while( PassageirosRecebidos > 0)
	//{
		//System.out.println(PassageirosRecebidos);
		//PassageirosRecebidos --;
	//}
}

public void AbrirPortas()
{
	if(AndarAtual == AndarDestino && PortaAberta==false)
	{
		PortaAberta = true;
		System.out.println("Porta Aberta");
		System.out.println("Elevador está no andar: " +AndarAtual);
	}
	
}

public void FecharPortas()
{
	if(AndarAtual == AndarDestino)
	{
		PortaAberta = false;
		System.out.println("Porta Fechada");
	}
	
	
	
}

public void VisitarAndar(int AndarDst) 
{
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
