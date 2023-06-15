package mavenTest;

public class Main {
	public static void main(String[] args) throws Exception {
		String phrase;
		Transformer georgeTransformer = new Transformer();
		
		georgeTransformer.addToken("name", "George");
		georgeTransformer.addToken("address", "78 Rue Will Smith");
		
	
		
		phrase= georgeTransformer.replaceTokens("{company} Hello, {name}, how are you {name} and your address is {address} ?", georgeTransformer.getTokenStored());
		System.out.println(phrase);
		georgeTransformer.removeToken("name");
				
		
		
	}
}

