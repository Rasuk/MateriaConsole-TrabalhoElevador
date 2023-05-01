package ElevadorMultithread;
import java.util.concurrent.Semaphore;
public class Passageiros extends Thread{
public int AndarPresente, AndarDestino;
public int IDP;
public boolean ChegouNoAndar = false;
public void run()
{
	
	System.out.println("O passageiro: " + IDP + " e está no andar: " + AndarPresente + " E vai pro andar: " + AndarDestino );
	Semaphore semaforo = new Semaphore(5);

	
		while(ChegouNoAndar == false)

		if(Elevador.AndarAtual == this.AndarPresente && Elevador.PortaAberta && Elevador.PassageiroPresente == false )
		{
			EntrarElevador();
		}
		if(Elevador.AndarAtual == this.AndarDestino && Elevador.PortaAberta)
		{
			this.ChegouNoAndar= true;
			SairElevador();
		}
	}
	


private void EntrarElevador() {
Elevador.PassageiroPresente = true;
Elevador.VisitarAndar(AndarDestino);
Elevador.EmProgresso = true;
}

public void SairElevador()
{
	Elevador.PassageiroPresente = false;
	System.out.println("Bigado moço");
	//Elevador.variavelauxiliar++;
}

public Passageiros(int ID, int AndarPRT, int AndarDst)
{
	IDP = ID;
	AndarPresente = AndarPRT;
	AndarDestino = AndarDst;
}


}
