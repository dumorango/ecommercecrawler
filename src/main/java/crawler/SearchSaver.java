package crawler;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchSaver implements Callable {
	
	@Autowired
	private SearchRepository searchRepostory;
		
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {		
		searchRepostory.save((String) eventContext.getSession().getProperty("query"),eventContext.getMessageAsString());
		return eventContext.getMessageAsString();
	}

}
