package formulator;

public class MinusFunctionElement extends FunctionElement{
	
	//constructor that allows two arguments to be added immediately
	public MinusFunctionElement(FormulaElement arg1, FormulaElement arg2){
		addArgument(arg1);
		addArgument(arg2);
	}
	
	//empty constructor; arguments can be added manually
	public MinusFunctionElement(){
	}
	
	//override addArgument method so that you can't add more than 2 arguments
	public void addArguments(FormulaElement arg){
		if(arguments.size()==2)
			System.out.println("The minus function can't have more than 2 arguments");
		else
			arguments.add(arg);
	}
	
	public String toString(){
		FormulaElement arg1 = getArguments().elementAt(0);
		FormulaElement arg2 = getArguments().elementAt(1);
		//generate result if both arguments are constants
		if(arg1 instanceof ConstantElement && arg2 instanceof ConstantElement){
			double retNum = ((ConstantElement) arg1).getValue() - ((ConstantElement) arg2).getValue();
			return ""+retNum;
		}
		//create string with minus symbol if 1+ arguments are variables
		else
			return arg1.toString() + " - " + arg2.toString();
	}
	
	public double evaluate(){
		FormulaElement arg1 = getArguments().elementAt(0);
		FormulaElement arg2 = getArguments().elementAt(1);
		return arg1.evaluate()-arg2.evaluate();
	}

}