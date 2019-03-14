package br.com.empresa.domain;
import java.util.HashMap;
import java.util.Map;

public enum NaturezaServico {
	DEPOSITO_DE_PEDIDO(1), PEDIDO_DIVIDIDO(2);
	
	private int codigo;
	
	private static Map<Integer, NaturezaServico> map;
	static {
		map = new HashMap<>();
		for(NaturezaServico natureza : NaturezaServico.values()) {
			map.put(natureza.getCodigo(), natureza);	
		}
	}
	
	NaturezaServico(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public static NaturezaServico getByCodigo(int codigo) {
		return map.get(codigo);
	}
}
