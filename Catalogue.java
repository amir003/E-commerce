import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	
	
	private List<Product> catalogue;
	
	public Catalogue() {
		catalogue = new ArrayList<Product>();
	}

	public List<Product> getCatalogue() {
		return catalogue;
	}
	
	public void addProduitDansCatalogue(Product p) {
		catalogue.add(p);
	}
	
	public void supprimerProduitDansCatalogue(Product p) {
			catalogue.remove(p);
	}
	
}
