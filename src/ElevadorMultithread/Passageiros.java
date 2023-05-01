package ElevadorMultithread;
import java.util.concurrent.Semaphore;
public class Passageiros extends Thread{
public int AndarPresente, AndarDestino;
public int IDP;
public boolean ChegouNoAndar = false;
public void run()
{
	
	System.out.println("O passageiro: " + IDP + " e está no andar: " + AndarPresente + " E vai pro andar: " + AndarDestino );
	Semaphore semaforo = new Semaphore(1);

	
		while(ChegouNoAndar == false)
		{
			try {
				semaforo.acquire();
			} catch (Exception e) {
				// TODO: handle exception
			}
		if(Elevador.AndarAtual == this.AndarPresente && Elevador.PortaAberta && Elevador.PassageiroPresente == false )
		{
			EntrarElevador();
		}
		if(Elevador.AndarAtual == this.AndarDestino && Elevador.PortaAberta)
		{
			SairElevador();
			
		}
		semaforo.release();
	}
}


private void EntrarElevador() {
Elevador.PassageiroPresente = true;
Elevador.VisitarAndar(AndarDestino);
Elevador.EmProgresso = true;
}

public void SairElevador()
{
	ChegouNoAndar = true;
	Elevador.PassageiroPresente = false;
	System.out.println("Bigado moço");
	//Elevador.listaPassageirosRecebida.remove(this.IDP);
	Elevador.variavelauxiliar++;
	Elevador.FecharPortas();
	Elevador.EmProgresso = false;
	Elevador.PassageirosRecebidos --;
}

public Passageiros(int ID, int AndarPRT, int AndarDst)
{
	IDP = ID;
	AndarPresente = AndarPRT;
	AndarDestino = AndarDst;
}


}
