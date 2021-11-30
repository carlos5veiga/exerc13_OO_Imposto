package entities;

public class PessoaJuridica extends Pessoa{

	private Integer numFuncionarios;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, Integer numFuncionarios) {
		super(nome, rendaAnual);
		this.numFuncionarios = numFuncionarios;
	}

	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	@Override
	public Double impostoDevido() {
		double imposto = 0.0;
		
		if (numFuncionarios>10) {
			imposto = (super.getRendaAnual() * 0.14);
		}
		else {
			imposto = (super.getRendaAnual() * 0.16);
		}
		
		return imposto;
	}

}
