

abstract class Role {
	public abstract boolean isSatisfied(Product prod, double price);
}

class Buyer extends Role {

	private double limit;
	
	Buyer(double limit){
		this.limit = limit;
	}
	
	/**
	 * The Buyer is happy if he can afford the product and the price is less than 200% over cost.
	 */
	public boolean isSatisfied(Product prod, double price) {
		if(price < limit && price < prod.getCost() * 2){
			return true;
		}else{
			return false;
		}		
	}

}

class Person1 {

	private String name;
	private Role role;
	
	public Person1(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Role getRole(){
		return role;
	}
	
	public void setRole(Role role){
		this.role = role;
	}
	
	public boolean satisfied(Product product, double offer){
		return role.isSatisfied(product, offer);
	}
}

class Product {

	private String name;
	private String description;
	private double cost;
	
	public Product(String name, String description, double cost){
		this.name = name;
		this.description = description;
		this.cost = cost;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}	
}

class Seller extends Role {

	/**
	 * Seller will be happy if they make 20% profit on whatever they sell.
	 */
	public boolean isSatisfied(Product prod, double price) {
		if(price - prod.getCost() > prod.getCost() * 0.2){
			return true;
		}else{
			return false;
		}		
	}

}

public class StrategyPatternExample {

	public static void main(String[] args){
		
		Product threeBhkDuplex = new Product("3-BHK DUPLEX APT", "3 Bedroom Duplex, DLF, Gurgaon"  , 20000000);
		Product twoBhkFlat = new Product("2-BHK FLAT", "2 Bedroom Flat, DLF, Gurgaon"  , 5000000);
		
		Person1 tim = new Person1("Tim");
		Person1 allison = new Person1("Allison");
		
		tim.setRole(new Buyer(5000000));
		allison.setRole(new Seller());
		
		if(!allison.satisfied(twoBhkFlat, 4000000)){
			System.out.println("Offer of 4000000 is not good for the seller");
		}
		
		if(tim.satisfied(twoBhkFlat, 5000000)){
			System.out.println("Offer of 5000000 is good for the buyer");
		}
		
		if(tim.satisfied(twoBhkFlat, 5000000) && allison.satisfied(twoBhkFlat, 5000000)){
			System.out.println("They both agree with 5000000");
		}
				
		/* To further demonstrate the capabilities of the strategy pattern, switch the initial
		 * Seller to the Buyer by calling setRole() on the Person object. It is possible to switch
		 * to a Buyer without modifying the Person object.
		 */
		
		allison.setRole(new Buyer(30000000));
		if(allison.satisfied(threeBhkDuplex, 20000000)){
			System.out.println("As a buyer Allison can afford the 3-BHK-DUPLEX Apartment");
		}		
	}
}
