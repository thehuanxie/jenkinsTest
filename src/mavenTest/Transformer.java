package mavenTest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The class Transformer allows transform a set of defined tokens into by predefined text.
 * 
 * @author Genius
 *
 */
public class Transformer {
	public static Logger Logger = LoggerFactory.getLogger(Main.class);
	
	private String token;
	private String text;
	private String template;
	private HashMap<String,String> tokenStored = new HashMap<>();
	
	/**
	 * Constructor by default.
	 */
	public Transformer() {};
	
	/**
	 * Constructor
	 * @param token
	 * @param text
	 */
	public Transformer(String token, String text) {
		this.token = token;
		this.text = text;
	}
	
	/**
	 * Push token and text to replace the token into hashmap.
	 * 
	 * @param token	token to replace (cannot be null nor empty)
	 * @param text	text to replace the token (cannot be null nor empty)
	 * @throws Exception when token doesn't exist, or token, text is null
	 */
	public void addToken(String token, String text) throws Exception {
		if(this.tokenStored.containsKey(token)) {
			throw new Exception("This token is already exist");
		} 
		if (token == null  || text == null ) {
			throw new Exception("Please verify your input, it is not valid.");
		}
		
		this.tokenStored.put(token,text);
	}
	
	
	/**
	 *Replace the phrase with tokens by text(user's real info)
	 * 
	 * Each token should be between brakets, for ex:
	 * Hello, {name}.
	 * 
	 * @param text			phrase template with tokens defined
	 * @param tokenStored
	 * @return				template phrase with tokens replaced.
	 */
	public String replaceTokens(String text, Map<String, String> tokenStored) {
		Pattern pattern = Pattern.compile("\\{(.+?)\\}");
		Matcher matcher = pattern.matcher(text);
		StringBuffer buffer = new StringBuffer();
		
		while (matcher.find()) {
			String replacement = tokenStored.get(matcher.group(1));
			if (replacement != null) {
				matcher.appendReplacement(buffer, replacement);
			}else {
				System.err.println("No this token");
			}
		}
		matcher.appendTail(buffer);
		return buffer.toString();
	}
	
	/**
	 * removeToken can delete a stored token
	 * @param token
	 */
	public void removeToken(String token) {
		this.tokenStored.remove(token);
	}
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public HashMap<String, String> getTokenStored() {
		return tokenStored;
	}
	public void setTokenStored(HashMap<String, String> tokenStored) {
		this.tokenStored = tokenStored;
	}
	
	
}
