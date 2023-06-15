package mavenTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) throws Exception {
		String phrase;
		Transformer georgeTransformer = new Transformer();
		
		georgeTransformer.addToken("name", "George");
		georgeTransformer.addToken("address", "78 Rue Will Smith");
		
		phrase= georgeTransformer.replaceTokens("{company} Hello, {name}, how are you {name} and your address is {address} ?", georgeTransformer.getTokenStored());
		logger.info(phrase);
		georgeTransformer.removeToken("name");

	}
}

