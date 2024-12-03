
public class CalculoDiaria implements Calculo {

	private int valorDiaria;
	public CalculoDiaria(int valorDiaria) {
		this.valorDiaria = valorDiaria;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcularTarifa(int qtdHoras) {
		// TODO Auto-generated method stub
		return valorDiaria * (int) Math.ceil(qtdHoras / 24.0);
	}

}
