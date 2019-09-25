
package interpreter;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Danny
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
		String romano = "XLVIII";
		Context context = new Context(romano);
		
		ArrayList<AbstractExpresion> tree = new ArrayList<AbstractExpresion>();
		
		tree.add(new NonTerminalExpresion());
		tree.add(new TerminalExpresion());
		
		Iterator<AbstractExpresion> it =tree.iterator();
		while (it.hasNext()){
			AbstractExpresion exp =it.next();
			exp.interpreter(context);
		}
		
		System.out.println(context.output);
    }

}
