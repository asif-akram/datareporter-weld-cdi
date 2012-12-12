package uk.ac.ox.its.damaro.data.reporter.web.databank.client;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import uk.ac.ox.its.databank.ws.restful.client.Datasets;
import uk.ac.ox.its.databank.ws.restful.client.Silos;
import uk.ac.ox.its.databank.ws.restful.client.WebResourceBuilder;

import org.primefaces.model.TreeNode;
import org.primefaces.model.DefaultTreeNode;

import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;

import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import org.primefaces.event.NodeSelectEvent;

@SessionScoped
@Named
public class DatabankClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TreeNode silosRoot;
	private TreeNode selectedSiloNode;
	private String selectedSiloNodeName;
	
	private TreeNode dataPackageNodeRoot;	
	private TreeNode selectedDataPackageNode;
	private String selectedDataPackageNodeName;
	
	private TreeNode itemNodeRoot;

	public void getSilos() {

		System.out.println("DatabankClient.getSilos()");
		WebResource webResource = WebResourceBuilder.getInstance(
				"http://163.1.127.173/", "username", "password").getWebResource();

		System.out.println("Silos().getAllSilosAsJSON()");
		String[] silosName = new Silos().getAllSilosAsJSON(webResource);

		silosRoot = new DefaultTreeNode("Root", null);
		//TreeNode nodeSilo = new DefaultTreeNode("Silos", root);
		TreeNode nodeTemp;
		for (int i = 0; i < silosName.length; i++) {
			nodeTemp = new DefaultTreeNode(silosName[i], silosRoot);
		}
	}

	public void onSiloNodeSelect(NodeSelectEvent event) {  
		itemNodeRoot = new DefaultTreeNode("Root", null);
		TreeNode nodeItem = new DefaultTreeNode("....", itemNodeRoot);
		
		selectedDataPackageNode = null;
		
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());  
  
        this.selectedSiloNode = event.getTreeNode();
		System.out.println(selectedSiloNode.getData().toString());
		updateDataPackageNodeRoot();
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
	
	public void onDataPackageNodeSelect(NodeSelectEvent event){
		this.selectedDataPackageNode = event.getTreeNode();
		System.out.println(selectedDataPackageNode);
		
		updateItemNodeRoot();
	}
	
	public void clearSilos() {
		silosRoot = new DefaultTreeNode("Root", null);
		TreeNode nodeSilo = new DefaultTreeNode("....", silosRoot);
		
		dataPackageNodeRoot = new DefaultTreeNode("Root", null);
		TreeNode nodeDataPackage = new DefaultTreeNode("....", dataPackageNodeRoot);
		
		itemNodeRoot = new DefaultTreeNode("Root", null);
		TreeNode nodeItem = new DefaultTreeNode("....", itemNodeRoot);
		
		selectedSiloNode = null;
		selectedDataPackageNode = null;
	}

	public TreeNode getSelectedSiloNode() {
		return selectedSiloNode;
	}
	
	public String getSelectedSiloNodeName(){
		if(selectedSiloNode != null){
			if(selectedSiloNode.getData().toString().trim().length() > 0){
				selectedSiloNodeName =  selectedSiloNode.getData().toString();
			} else {
				selectedSiloNodeName = "NA";
			}
		} else {
			selectedSiloNodeName = "NA";
		}
		
		return selectedSiloNodeName;
	}
	
	

	public String getSelectedDataPackageNodeName() {
		if(selectedDataPackageNode != null){
			if(selectedDataPackageNode.getData().toString().trim().length() > 0){
				selectedDataPackageNodeName =  selectedDataPackageNode.getData().toString();
			} else {
				selectedDataPackageNodeName = "NA";
			}
		} else {
			selectedDataPackageNodeName = "NA";
		}
		return selectedDataPackageNodeName;
	}

	public void setSelectedNode(TreeNode selectedSiloNode) {
		this.selectedSiloNode = selectedSiloNode;
		System.out.println(selectedSiloNode.getData().toString());
	}

	public TreeNode getSilosRoot() {
		return silosRoot;
	}

	public TreeNode getDataPackageNodeRoot() {
		return dataPackageNodeRoot;
	}

	public TreeNode getItemNodeRoot() {
		return itemNodeRoot;
	}

	private void updateDataPackageNodeRoot(){
		WebResource webResource = WebResourceBuilder.getInstance(
				"http://163.1.127.173/", "username", "password").getWebResource();
		
		System.out.println("Silos().getSiloAsJSON(webResource, " + selectedSiloNode.getData().toString() + " )");
		String[] dataPackagesName = new Silos().getSiloAsJSON(webResource, selectedSiloNode.getData().toString());
		
		dataPackageNodeRoot = new DefaultTreeNode("Root", null);
		
		TreeNode nodeTemp;
		for (int i = 0; i < dataPackagesName.length; i++) {
			nodeTemp = new DefaultTreeNode(dataPackagesName[i], dataPackageNodeRoot);
		}
		
	}
	
	private void updateItemNodeRoot(){
		WebResource webResource = WebResourceBuilder.getInstance(
				"http://163.1.127.173/", "username", "password").getWebResource();
		
		webResource = webResource.path(selectedSiloNode.getData().toString());
		String[] itemsName = new Datasets().getDataSetAsXML(webResource, "datasets", selectedDataPackageNode.getData().toString());
		
		itemNodeRoot = new DefaultTreeNode("Root", null);
		
		TreeNode nodeTemp;
		for (int i = 0; i < itemsName.length; i++) {
			nodeTemp = new DefaultTreeNode(itemsName[i], itemNodeRoot);
		}
		
	}
}
