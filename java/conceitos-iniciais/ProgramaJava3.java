public class ProgramaJava3{

	public static void main(String [] args){
	
		String parametro = args[0];
		String texto = "O parâmetro recebido foi: " + parametro;
		
		int a;
		a = 20;
		int b = 12;
		int c = ( a * b ) / 3;
		int d = a / b / c;		
	
		System.out.println("O valor digitado foi: " + parametro);
		
		System.out.println("O resultado do calculo 1 foi: " + c);
		
		System.out.println("O resultado do calculo 2 foi: " + d);
		
		if( c == 0){
			System.out.println("C eh igual a zero");
		}
		
		if( c > 0){
			System.out.println("C eh maior que zero");		
		}
		
		if( c < 0){
			System.out.println("C eh menor que zero");
		}
	
	}
}
