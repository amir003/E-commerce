import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;



public class Panier {
 
	private Hashtable<Product, Integer> paniers;
	private boolean panierValid;
	
	
	public Panier(){
		paniers = new  Hashtable<Product, Integer>();
		setPanierValid(false);
	}
	
	
	public void ajouterProduitDansPanier(Product p, int quant) {
		paniers.put(p, quant);		
		}
	
		public void modifierQuantiteProduitDansPanier(Product p, int quant) {
			if (paniers.containsKey(p)){
					paniers.put(p, quant);
			}
	
		}
		
		public void supprimerProduitDansPanier(Product p) {
			if (paniers.containsKey(p)){
			paniers.remove(p);	
			}			
			}
		
		public double calculerPrixPanier() {
		double res = 0;
		Set<Product> set = paniers.keySet();
		Iterator<Product> itr = set.iterator();
		while(itr.hasNext()) {
			Product str= itr.next();
			res += paniers.get(str)*str.getPrix();

		}
		return res;
		}
		


		public boolean isPanierValid() {
			return panierValid;
		}


		public void setPanierValid(boolean panierValid) {
			this.panierValid = panierValid;
		}
		


	public Hashtable<Product, Integer> getPan() {
	return this.paniers;
	}
	
	
}
