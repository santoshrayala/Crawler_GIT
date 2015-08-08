/**
 * 
 */
package crawler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author santoshrayala
 * contains all the lists the crawler program uses
 */
public class ParsedURLLists {
	
	List<String> parsedURLS = new ArrayList<String>();

	public List<String> getParsedURLS() {
		return parsedURLS;
	}

	/*public void setParsedURLS(List<String> parsedURLS) {
		this.parsedURLS = parsedURLS;
	}*/
	public void addtoparsedURLS(String link){
		parsedURLS.add(link);
	}
	public boolean contains(String link){
		if(parsedURLS.contains(link))
			return true;
		else return false;
	}
	public int size()
	{
		return parsedURLS.size();
	}
	

}
