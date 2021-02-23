package entities;

public final class ImportedProduct extends Product{

	private Double customsFee;
	
	public ImportedProduct() {}
	
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	public Double totalPrice() {
		return 0.0;
	}
	
	public Double getCustomsFee() {
		return customsFee;
	}

	@Override
	public String priceTag() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.getName() + " $ ");
		sb.append(String.format("%.2f", (this.getPrice() + this.getCustomsFee())));
		sb.append(" (Customs fee: $ ");
		sb.append(String.format("%.2f", this.getCustomsFee()) + ")");
		
		return sb.toString();
	}
}
