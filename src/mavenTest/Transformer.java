package mavenTest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The class Transformer allows transform a set of defined tokens into by predefined text.
 * 
 * @author Genius
 *
 */
public class Transformer {
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
	 * Replace the phrase with tokens by text(user's real info)
	 * 
	 * Each token should be between brakets, for ex:
	 * Hello, {name}.
	 * 
	 * @param template	phrase template with tokens defined
	 * @return 
	 * @return	template phrase with tokens replaced.
	 */
//	public String transformTemplate(String template, Map<String, String> tokenStored) {
		
//		This is a naive way to do:
//		String transformText = template;
//		for (Entry<String, String> entry: tokenStored.entrySet()) {
//			transformText = transformText.replace(entry.getKey(), entry.getValue())l
//		}
//		return transformText;
		
//		for (Entry<String, String> entry : tokenStored.entrySet()) {
//			String token = entry.getKey();
//			String text1 = entry.getValue();
//			if (template.contains(token)) {
//				template = template.replace(token, text1);
//			}
//		}
//		return template;
//	}
	
		
//		optimisation:
//		int capacity = (int) (template.length() *1.2f);
//		StringBuilder stringbuilder = new StringBuilder(capacity); 
//		Pattern pattern = Pattern.compile("\\{(.+?)\\}");
//		Matcher matcher = pattern.matcher(template);
//		
//		//for each token in the template
//		while (matcher.find()) {
//			//String token = matcher.group(1);
//			String value = tokenStored.get(matcher.group(1));
//			
//			//replace the token by text
//			if (value != null) {
//				matcher.appendReplacement(stringbuilder, "");
//				stringbuilder.append(value);
//			} else {
//				stringbuilder.append("{" + token + "}");
//			}
//			matcher.appendTail(stringbuilder);
//			
//		}
//		return stringbuilder.toString();
		
//	}
		
		public String replaceTokens(String text, Map<String, String> tokenStored) {
			Pattern pattern = Pattern.compile("\\{(.+?)\\}");
			Matcher matcher = pattern.matcher(text);
			StringBuffer buffer = new StringBuffer();
			
			while (matcher.find()) {
				String replacement = tokenStored.get(matcher.group(1));
				if (replacement != null) {
				// matcher.appendReplacement(buffer, replacement);
				// see comment 
					matcher.appendReplacement(buffer, replacement);
//					buffer.append();
				}else {
					System.out.println("No this token");
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
