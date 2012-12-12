package uk.ac.ox.its.damaro.data.reporter;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@SessionScoped
@Named
public class DataReporterController implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8218694594503967153L;
	private String statsType = "getPageUrls";
	private String dialogHeader = "Unknown";
	private String mainPageInclude = "welcomeHome.xhtml";
	
	public DataReporterController(){
		
	}
	
	public String getMainPageInclude() {
		return mainPageInclude;
	}

	public void setMainPageInclude(String mainPageInclude) {
		this.mainPageInclude = mainPageInclude;
	}

	public String getStatsType() {
		return statsType;
	}

	public void setStatsType(String statsType) {
		System.out.println(statsType);
		
		this.statsType = statsType;
	}

	public String getDialogHeader() {
		return dialogHeader;
	}

	public void setDialogHeader(String dialogHeader) {
		this.dialogHeader = dialogHeader;
	}
	
	public void setWelcomePage(){
		mainPageInclude = "welcomeHome.xhtml";
	}
	
	public void setBrowsePage(){
		System.out.println("setBrowsePage");
		mainPageInclude = "dataBankBrowse.xhtml";
	}
	
	public void setActionStatsPage(){
		System.out.println("setActionStatsPage");
		mainPageInclude = "actionStats.xhtml";
	}
	
	public void setRefererStatsPage(){
		System.out.println("setRefererStatsPage");
		mainPageInclude = "refererStats.xhtml";
	}
	
	public void setCustomStatsPage(){
		System.out.println("setCustomStatsPage");
		mainPageInclude = "customStats.xhtml";
	}
	
	public void setSearchPage(){
		System.out.println("setSearchPage");
		mainPageInclude = "search.xhtml";
	}
}
