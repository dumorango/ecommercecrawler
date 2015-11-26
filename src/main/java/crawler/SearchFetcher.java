package crawler;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleSession;
import org.mule.api.lifecycle.Callable;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchFetcher implements Callable {
	
	@Autowired
	private SearchRepository searchRepostory;
		
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleSession session = eventContext.getSession();
		String products =  searchRepostory.get((String) session.getProperty("query"));
		if(products!=null) eventContext.getMessage().setOutboundProperty("products",products);
		return eventContext.getMessage();
		
	}

}
