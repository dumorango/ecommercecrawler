package crawler;

import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;

public class WalmartParser extends SearchParser{
	
	public List<Product> parse(String html){
		Document doc = Jsoup.parse(html);		
		Element productsElements = doc.select("#category-products > section > ul").first();
		List<Product> products = new ArrayList<Product>();
		for(Element productEl:productsElements.select("li.shelf-item")){			
				String productName = productEl.select(".product-title").html();
				String price = productEl.select(".int").html() + productEl.select(".dec").html().replace(",",""); 
				if(productName!=""){
					products.add(new Product(productName,price));
				}			
		}
		return products;
	}	
}
