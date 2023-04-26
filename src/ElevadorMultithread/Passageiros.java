package ElevadorMultithread;

public class Passageiros extends Thread{
public int AndarPresente, AndarDestino;
public int IDP;

public void run()
{
	
	System.out.println("O passageiro: " + IDP + " e está no andar: " + AndarPresente + " E vai pro andar: " + AndarDestino );
	ChamarElevador();
}

public Passageiros(int ID, int AndarPRT, int AndarDst)
{
	IDP = ID;
	AndarPresente = AndarPRT;
	AndarDestino = AndarDst;
}
public void ChamarElevador()
{
	Predio.elevador1.VisitarAndar(AndarDestino);
}

}
