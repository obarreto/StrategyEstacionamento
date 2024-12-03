
public class TarifaEstacionamento {
	private int qtdHoras;
	private Calculo calculo;
	public TarifaEstacionamento(int qtdHoras, Calculo calculo) {
		// TODO Auto-generated constructor stub
		this.qtdHoras = qtdHoras;
		this.calculo = calculo;
	}

	public int valor() {
		// TODO Auto-generated method stub
		return calculo.calcularTarifa(qtdHoras);
	}
}
