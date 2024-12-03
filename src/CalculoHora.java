
public class CalculoHora implements Calculo {
	
	private int valorHora;
	
	public CalculoHora(int valorHora) {
		// TODO Auto-generated constructor stub
		this.valorHora = valorHora;
	}

	@Override
	public int calcularTarifa(int qtdHoras) {
		// TODO Auto-generated method stub
		return qtdHoras * valorHora;
	}

}
