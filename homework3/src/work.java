
public class work {
	public static void main(String[] arge){
		PizzaStore ps=new PizzaStore();
		System.out.println("Please order Pizza ...\n");
		System.out.println("CheesePizza waiting.. :");
		ps.orderPizza("cheese");
		System.out.println("\nPepperoniPizza waiting.. :");
		ps.orderPizza("Pepperoni");
		System.out.println("\nClamPizza waiting.. :");
		ps.orderPizza("Clam");
	}

}
