
public class CalculoHoraValorInicial implements Calculo {
	
	private int valorInicial;
	private int limiteHorasInicial;
	private int valorHoraExcedente;
	
	public CalculoHoraValorInicial(int valorInicial, 
			int limiteHorasInicial, int valorHoraExcedente) {
		// TODO Auto-generated constructor stub
		this.valorInicial = valorInicial;
		this.limiteHorasInicial = limiteHorasInicial;
		this.valorHoraExcedente = valorHoraExcedente;
	}

	@Override
	public int calcularTarifa(int qtdHoras) {
		//TODO Auto-generated method stub
		int valor = this.valorInicial;
		if(qtdHoras > limiteHorasInicial) 
			valor += (qtdHoras - limiteHorasInicial) * valorHoraExcedente;
		return valor;
	}

}
