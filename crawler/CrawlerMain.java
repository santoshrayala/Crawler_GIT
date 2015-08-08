/**
 * 
 */
package crawler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import filewriter.FileForCorpus;



/**
 * @author santoshrayala
 *
 */
public class CrawlerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParsedURLLists urlList = new ParsedURLLists();
		//ExtractUrls extracturls = new ExtractUrls();
		List<String> urls = new ArrayList<String>();
		int pointer=0;
		String htmlcode;
		FileForCorpus file;
		Map<String, String> webpagetrack = new HashMap<>();
		String startUrl = "http://www.unt.edu";
		
		
		CheckDomain domaincheck = new CheckDomain();
		
		if(domaincheck.validDomain(startUrl) && !urlList.contains(startUrl)){
		HtmlPageGet HPG = new HtmlPageGet();
		htmlcode=HPG.getHTML(startUrl);
		file = new FileForCorpus("C:/Users/santoshrayala/Documents/2015 Spring/IR/project/corpus/www.unt.edu"); 
		file.addString(htmlcode);
		file.close();
		urls = ExtractUrls.extract(htmlcode);
		for(String s: urls)
		System.out.println(s);
	     //System.out.println(htmlcode);
		urlList.addtoparsedURLS(startUrl);
		String url;
		while(urlList.size()<3000 && pointer < urls.size())
		{
			List<String> temp = new ArrayList<>();
			
			for(; pointer<urls.size();pointer++)
			{
				if(urlList.size()>=3000)break;
				if(pointer < urls.size())
					{
					url=urls.get(pointer);
					if (!url.startsWith("http://")) {
					    url = "http://" + url;
					}
					
					//start working on each url in urls 
					url=domaincheck.urlwithoutquery(url);
					if(domaincheck.validDomain(url) && !urlList.contains(url))
					{
						htmlcode=HPG.getHTML(url);
						if(!htmlcode.equals(""))
						{
							//webpagetrack.addString("file"+pointer+"\t\t"+domaincheck.urlforfilename(url));
							webpagetrack.put("file"+pointer, domaincheck.urlforfilename(url));
							file = new FileForCorpus("C:/Users/santoshrayala/Documents/2015 Spring/IR/project/corpus/"+"file"+pointer); 
							file.addString(htmlcode);
							file.close();
							temp.addAll(ExtractUrls.extract(htmlcode));
							
							
							urlList.addtoparsedURLS(url);
						}
						else{ System.out.println("Page Not Found");
						//pointer--;
						}
					}
					//else pointer--;
					
					}
				else
				{
					System.out.println("No more urls to get");
					break;
				}
			}//for ends
			
			urls.addAll(temp); //appending all the urls from the temp list to urls
			
			
			
			
			
			
		}//while ends
	     
		
		}

	}

}
