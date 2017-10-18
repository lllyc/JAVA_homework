
public class SimplePizzaFactory {
	public Pizza createPizza(String type){
		Pizza p;
		if(type.equals("cheese")){
			p=new CheesePizza();
		}
		else{
			if(type.equals("pepperoni")){
				p=new PepperoniPizza();
			}
			else{
				if(type.equals("pepperoni")){
					p=new PepperoniPizza();
				}
				else{
					p=new Pizza();
				}
			}
		}
		return p;
	}

}
