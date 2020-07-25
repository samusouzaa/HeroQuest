package Usaveis;

public abstract class Item{
	
	private String chave;
	
	public Item(String chave) {
		this.setChave(chave);
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	
}
