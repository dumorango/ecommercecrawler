package crawler;

import java.util.*;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public abstract class SearchParser implements Callable{
	
	public abstract List<Product> parse(String html);

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		return parse(eventContext.getMessageAsString());		
	}
}
