package uk.ac.ox.its.damaro.data.reporter.web.databank.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

@Named
public class AutoComplete {
	
	private String silo;
	private String dataSet;
	
	List<String> silos = new ArrayList<String>();
	List<String> dataSets = new ArrayList<String>();
	
	public AutoComplete(){
		String[] tempSilos = {"BehaviouralEcology", "admiral", "admiral-test", "Development", 
				"digital.bodleian", "digitalbooks", "misccoll", "eidcsr", "eurotest", "general", 
				"sandbox", "Silk", "ww1archives", "yongledadian", "fihrist", "serica"};
		silos = Arrays.asList(tempSilos);
		
		String[] tempDataSets = {"TESTDATAFLOW2", "TESTDATAFLOW1","David_ID2","TestUser1","SebShimeld","SebShimeld-packed","David_ID2-packed","demo_images","odl_plasci012_aaa","og-300001083","og-300002074","og-300000815","og-300001518",
				"og-300001519","og-300000597","og-300000418","og-300001513","og-300000312","og-300001515","og-300000487","og-300001530","og-300002083","og-300001528","og-300001938","og-300001522","og-300001936",
				"og-300001831","og-300001527","og-300001830","og-300002091","og-300000837","og-300000838","og-300000969","og-300000836","og-300001970","og-300000839","og-300001826","og-300001965","og-300000435",
				"og-300001828","og-300001827","og-300001961","og-300001829","og-300001581","og-300001960","og-300000434","og-300001962","og-300001272","og-300001271","og-300001275","og-300001897","og-300001899",
				"og-300001587","og-300000563","og-300001954","og-300000422","og-300001403","og-300000420","og-300001959","og-300001606","og-300001702","300081007-test4","og-300001793","og-300001794","og-300000956",
				"og-300002171","og-300002215","og-300000463","og-300001191","og-300000841","og-300000840","og-300000951","og-300001193","og-300002172","og-300000952","og-300000842","og-300002174","og-300001904",
				"og-300001384","og-300001878","og-300001431","og-300000850","og-300000851","og-300000944","og-300001538","og-300001725","og-300001917","og-300001918","og-300000297","og-300001539","og-300002058",
				"og-300002057","og-300000937","og-300000932","og-300001540","og-300000933","og-300001668","og-300001546","og-300000017","og-300000464","og-300000929","og-300002065","og-300000924","og-300002164",
				"og-300000875","og-300002163","og-300002162","og-300001551","og-300000071","SumCatV1","QuartoAshmole","QuartoDigby","SumCatV2P2","QuartoRawlinsonDIndex","QuartoGreek","SumCatV2P1","RawlinsonAB",
				"SumCatV7Index","SumCatV5","SumCatV6","SumCatV3","SumCatV4","ManoscrittiItaliani","CodicumMan","QuartoLaudian","QuartoLyell","QuartoRawlinsonC","QuartoRawlinsonDPart1","CodicumManTanner","QuartoRawlinsonDPart2",
				"DemoDataSet_4","AsifDataSet_3","led_zip_unpack_test","AsifDataSet_asdf","led_zip_unpack","dopOSCCI","Freezefoot","packed_files","OSCCIVideos","cito","digitalThesis","RobertDarnton","MostynBrown",
				"Tick1AudioCorpus","DataVisualisationWidgets","GeoMashup","PlosPapers","alexs-desktop","digital-1543192866","jt^20test","dataox7","dataox8","dataox9","dataox3","devdsdd","dataox4","test100",
				"dataox6","digital-1318422803","fhdsjkl","g-300000422","g-300000420","digital-216620829","blockbooks","devd","databanksrc2","g-300000563","dataoxtemplates","digital-416297507","dataoxt",
				"dataset1-TestScanFilesSubDir","dataox","dataset1-testdir","test-dataset","master","alex-everything","devds","dataset1","alex-test","digital--48169613","dataset2","jt","digital--481696132",
				"big-file","bha-1","bh1","django-conneg","test1","dataflow123","evil-test","digital-1209306034","alex-test40","digital-489428852","django-conneg-dist","alex-test44","dataset1-testrdf","dataox10",
				"g-300000464","g-300000463","test-simple","test4","alex-test-april","test2","databank-poster-OR2012","test3","ggggggg","test22","dataset2-test1","big-file3","english","blockbooks2","digital-1074298561",
				"big-file2","alex-test3","test-907365275","alex-test4","alex-test4445","digital-32781659","evilevil","alex-test2","djc","alex-test8","alex-test5","alex-test6","g-300000418","digital-1414567038",
				"sally-test","test200","databanksrc","alex-test444","test300","jtTestingNeilsStuff","g-300000597","dataset1-test6","dataset1-test7","dataox2","digital-675529846","book1","g-300000017","g-300000487",
				"g-300000297","dataset1-test3","dataset1-test5","dataset1-test4","digital-837801908","digital-2062376911","joetest-2011-12-08-1","gwa-2173","gwa-2172","gwa-2171","gwa-2170","gwa-2179","gwa-2178",
				"gwa-2177","gwa-2176","gwa-2175","gwa-2174","gwa-2203","gwa-2202","gwa-2201","gwa-2200","gwa-2204","gwa-2160","gwa-2205","gwa-2206","gwa-2162","gwa-2207","gwa-2161","gwa-2208","gwa-2209","gwa-2156",
				"gwa-2168","gwa-2157","gwa-2167","gwa-2158","gwa-2159","gwa-2169","gwa-2164","gwa-2163","gwa-2166","gwa-2165","gwa-2210","gwa-2212","gwa-2211","gwa-2214","gwa-2213","gwa-2191","gwa-2190","gwa-2219",
				"gwa-2217","gwa-2195","gwa-2218","gwa-2194","gwa-2193","gwa-2215","gwa-2192","gwa-2216","gwa-2199","gwa-2198","gwa-2197","gwa-2196","gwa-2225","gwa-2224","gwa-2223","gwa-2222","gwa","gwa-2221","gwa-2220",
				"gwa-2180","gwa-2226","gwa-2182","gwa-2227","gwa-2181","gwa-2228","gwa-2184","gwa-2229","gwa-2183","gwa-2186","gwa-2185","gwa-2188","gwa-2187","gwa-2189","gwa-2234","gwa-2233","gwa-2236","gwa-2235","gwa-2230",
				"gwa-2232","gwa-2231","gwa-2239","gwa-2238","gwa-2237","gwa-2242","gwa-2243","gwa-2240","gwa-2241","gwa-2246","gwa-2247","gwa-2244","gwa-2245","gwa-2249","gwa-2248","gwa-2251","gwa-2252","gwa-2253","gwa-2254",
				"gwa-2250","Mats_temp_silo","test_upload_times","mats_test","test-package","19940109-13:08:29-dh","19940111-19:51:17-dh","19940110-19:14:18-dh","19940112-19:36:48-dh","19940113-20:12:22-dh",
				"19940112-19:42:38-dh","19950628-13:02:39-dh","19950404-14:06:47-dh","19940113-17:11:46-dh","19940111-22:03:24-dh","19940131-18:03:30-dh","19940108-19:15:39-dh","19940111-22:07:51-dh","19940109-12:58:36-dh",
				"19940110-19:16:10-dh","19940110-19:23:18-dh","19940110-19:27:45-dh","19950404-16:06:18-dh","19951010-16:38:30-dh","19940113-13:02:23-dh","19931004-16:59:02-dh","19950404-14:29:58-dh","19940109-14:32:12-dh",
				"19950404-16:31:24-dh","19931004-18:06:56-dh","19940111-19:42:08-dh","19940109-14:37:23-dh","19940109-12:45:08-dh","19961017-17:35:07-dh","19940108-19:03:07-dh","19961203-13:28:11-dh","19940419-12:08:44-dh",
				"19940110-19:51:24-dh","19940108-19:08:00-dh","19950404-17:26:19-dh","19941124-18:37:55-dh","19940131-17:19:22-dh","19931103-14:04:50-dh","19961120-11:41:06-dh","19940108-19:13:32-dh","19940110-19:55:01-dh",
				"19940110-19:38:04-dh","19940109-14:29:29-dh","19940321-10:54:32-dh","19930924-15:44:48-dh","19940110-19:42:46-dh","19940113-20:31:54-dh","19940109-14:41:36-dh","19940111-22:33:49-dh","19961214-12:42:10-dh",
				"19970102-17:18:43-dh","19940111-19:34:06-dh","19940109-13:05:05-dh","19940109-14:47:22-dh","19940113-19:43:02-dh","19930924-15:14:06-dh","19940113-19:44:09-dh","19940111-22:20:23-dh","19970114-15:53:07-dh",
				"19961017-17:47:51-dh","19940110-19:20:21-dh","19940113-20:47:16-dh","19930806-09:27:59-dh","19940114-12:10:26-dh","19940109-12:42:18-dh","19950404-14:21:03-dh","19940113-21:13:22-dh","19950405-16:51:51-dh",
				"19941127-19:17:36-dh","19941124-19:12:11-dh","19940109-14:52:22-dh","19931004-18:18:22-dh","19940108-18:56:21-dh","19931004-16:34:07-dh","19940111-19:42:47-dh","19940422-10:44:46-dh","19940131-17:56:22-dh",
				"19940131-17:27:44-dh","19940110-19:11:02-dh","19940113-19:48:24-dh","19950404-17:09:02-dh","19931004-17:42:08-dh","19940419-12:19:16-dh","19940112-19:47:56-dh","19931013-13:08:26-dh","19940131-17:51:55-dh",
				"19941126-18:01:25-dh","19961220-16:47:21-dh","19940113-21:19:35-dh","19950429-12:49:25-dh","19970114-10:28:13-dh","19940113-21:15:33-dh","19931004-16:19:48-dh","19961017-17:43:34-dh","19970114-15:58:45-dh",
				"19940108-19:23:56-dh","19940112-19:20:12-dh","19950404-16:19:04-dh","19940419-16:35:46-dh","19940109-12:38:14-dh" };
		dataSets = Arrays.asList(tempDataSets);
	}
	
	
	public String getSilo() {
		return silo;
	}


	public void setSilo(String silo) {
		this.silo = silo;
	}


	public String getDataSet() {
		return dataSet;
	}


	public void setDataSet(String dataSet) {
		this.dataSet = dataSet;
	}


	public List<String> completeSilos(String query) {  
        List<String> results = new ArrayList<String>();  
          
        for(String silo : silos) {  
            if(silo.startsWith(query))  
            	results.add(silo);  
        }       
        return results;  
    }  
	
	public List<String> completeDataSets(String query) {  
        List<String> results = new ArrayList<String>();  
          
        for(String dataSet : dataSets) {  
            if(dataSet.startsWith(query))  
            	results.add(dataSet);  
        }       
        return results;  
    }  

}
