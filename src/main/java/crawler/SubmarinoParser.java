package crawler;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SubmarinoParser extends SearchParser{

	@Override
	public List<Product> parse(String html) { 
		List<Product> products = new ArrayList<Product>();
		Document doc = Jsoup.parse(html);		
		Element productsElements = doc.select("#vitrine").first();
		for(Element productEl:productsElements.select(".productInfo")){		
			String name = productEl.select(".prodTitle").html();
			String price = productEl.select(".sale").html();
			if(name!=""){
				products.add(new Product(name,price));
			}	
		}
		return products;
	}

}
