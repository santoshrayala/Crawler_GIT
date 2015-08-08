/**
 * 
 */
package crawler;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author santoshrayala
 * takes in a url in form of string and checks if it belongs to unt.edu domain or not
 */
public class CheckDomain {
	
	public boolean validDomain(String link)
	{
		URL url;
		try {
			url =new URL(link);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		String domain=url.getHost();
		if(domain.contains("unt.edu"))
		return true;
		else return false;
	}
	
	public String urlwithoutquery(String link)
	{
		URL url = null;
		try {
			url =new URL(link);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		link=url.getProtocol()+"://"+url.getHost()+url.getPath();
		return link;
		
	}
	
	public String urlforfilename(String link)
	{
		URL url = null;
		try {
			url =new URL(link);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		link=url.getHost()+url.getPath();
		return link;
		
	}

}
