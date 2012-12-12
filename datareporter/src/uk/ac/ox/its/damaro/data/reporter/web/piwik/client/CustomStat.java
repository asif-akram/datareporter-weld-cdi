package uk.ac.ox.its.damaro.data.reporter.web.piwik.client;

import java.io.Serializable;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

@Named
@SessionScoped
public class CustomStat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4713436971427042753L;

	private URIBuilder builder;
	
	private HttpClient httpclient = new DefaultHttpClient();
	
	private String apiModule = "";  
	  
    private String apiAction = "";  
    private String statsOutput = "";
    
	private Map<String,String> apiModules = new HashMap<String, String>();  
	  
    private Map<String,Map<String,String>> apiActionsData = new HashMap<String, Map<String,String>>();  
    
    private Map<String,String> apiActions = new HashMap<String, String>();  
    
    private Date fromDate = new Date();
    private Date toDate = new Date();
    private SimpleDateFormat formatter;
    
    public CustomStat(){
        
    	apiModules.put("Actions", "Actions"); 
    	apiModules.put("Referers", "Referers");
    	
    	Map<String,String> actionModuleMethods = new HashMap<String, String>();
    	actionModuleMethods.put("Downloads", "getDownloads");  
    	actionModuleMethods.put("Exit Page Urls", "getExitPageUrls");  
    	actionModuleMethods.put("Entry Page Urls", "getEntryPageUrls");  
    	actionModuleMethods.put("Page Titles", "getPageTitles");
          
        Map<String,String> refererModuleMethods = new HashMap<String, String>();  
        refererModuleMethods.put("Search Engines", "getSearchEngines");  
        refererModuleMethods.put("Keywords", "getKeywords");  
        refererModuleMethods.put("Referer Type", "getRefererType");
        refererModuleMethods.put("Referer Type", "getRefererType");
        
        apiActionsData.put("Actions", actionModuleMethods);
        apiActionsData.put("Referers", refererModuleMethods);    
    }
    
    public String getApiModule() {
		return apiModule;
	}


	public void setApiModule(String apiModule) {
		this.apiModule = apiModule;
	}
	
	public String getApiAction() {
		return apiAction;
	}
	public void setApiAction(String apiAction) {
		this.apiAction = apiAction;
	}
	public Map<String, String> getApiModules() {
		return apiModules;
	}


	public void setApiModules(Map<String, String> apiModules) {
		this.apiModules = apiModules;
	}

	public Map<String, String> getApiActions() {
		return apiActions;
	}
	public void setApiActions(Map<String, String> apiActions) {
		this.apiActions = apiActions;
	}
	
	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
	public String getStatsOutput() {
		return statsOutput;
	}

	public void setStatsOutput(String statsOutput) {
		this.statsOutput = statsOutput;
	}

	public void handleModuleChange() {  
		System.out.println(apiModule + " " + apiAction);
		
        if(apiModule !=null && !apiModule.equals(""))  
        	apiActions = apiActionsData.get(apiModule);  
        else  
        	apiActions = new HashMap<String, String>();  
    } 
	
	public void processForm() {  
		formatter = new SimpleDateFormat("yyyy-mm-dd");
         System.out.println(apiModule + " " + apiAction + " " + formatter.format(this.fromDate) + " " + formatter.format(this.toDate));
         statsOutput = apiModule + " " + apiAction + " " + formatter.format(this.fromDate) + " " + formatter.format(this.toDate);
         
         URIBuilder builder = new URIBuilder();
         builder.setScheme("http").setHost("orastats.bodleian.ox.ac.uk").setPath("/index.php").
         setParameter("token_auth", "6c56e6d07447248e7993706c6aa3dd54").
         setParameter("idSite", "2");
         
         apiTest(builder, "API", apiModule + "." + apiAction, "range", formatter.format(this.fromDate) + "," + formatter.format(this.toDate), null, null);
    }  
	
	private void apiTest(URIBuilder builder, String module, String method, String period, String date, String apiModule, String apiMethod) {
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        builder.setParameter("module", module).
                setParameter("method", method).
                //setParameter("pageUrl", "https://databank.ora.ox.ac.uk/").
                setParameter("period", period).
                setParameter("date", date);
        try {
            URI uri = builder.build();
            HttpGet httpget = new HttpGet(uri);
            System.out.println(httpget.getURI());

            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            System.out.println("----------------------------------------");
            statsOutput = responseBody;
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

}
