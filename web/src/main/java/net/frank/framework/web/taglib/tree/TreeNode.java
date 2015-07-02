package net.frank.framework.web.taglib.tree;

import java.util.ArrayList;
import java.util.Iterator;

import net.frank.framework.bo.Resource;

public class TreeNode implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6561627039059869078L;
	private  String id;
	private  String name;
	protected TreeNode parent;
	protected ArrayList<TreeNode> children;
	protected Resource resource;
	private Long typeId = Resource.RESOURCE_TYPE_ID;
	
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public void addChild2(TreeNode node){
		if(children == null){
			children = new ArrayList<TreeNode>();
		}
		if(node != null)
			children.add(node);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<TreeNode> children) {
		this.children = children;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	public boolean isRoot(){
		if(parent == null){
			return true;
		}
		return false;
	}
	
	public boolean isLeaf(){
		
		if(children == null){
			return true;
		}
		if(children.size() == 0){
			return true;
		}
		return false;
	}
	
	public void addChild(TreeNode child){
		if (children==null){
			children = new ArrayList<TreeNode>();
		}
		
		TreeNode node = this;
		while(!node.isRoot()){
			if(node.equals(child)){
				throw new IllegalStateException("The tree can't be cycled");
			}
			node = node.getParent();
		}
		children.add(child);
		child.setParent(this);
	}
	
	public TreeNode getChildAt(int childIndex){
		if(children == null)
			return null;
		return (TreeNode)children.get(childIndex);
	}
	
	public void insertChild(TreeNode child,int childIndex){
		if (children==null){
			children = new ArrayList<TreeNode>();
		}
		TreeNode node = this;
		while(!node.isRoot()){
			
			if(node.equals(child)){
				throw new IllegalStateException();
			}
			node = node.getParent();
		}
		children.add(childIndex,child);
		child.setParent(this);
	}
	
	public void remove(int childIndex){
		children.remove(childIndex);
	}
	
	public void remove(TreeNode child){
		if(!child.getParent().equals(this) ){
			throw new IllegalStateException("This isn't my child");
		}
		children.remove(child);
	}
	
	public int getLevel(){
		int level = 1;
		TreeNode node = this.getParent();
		if (node==null){
			return 0;
		}
		while(!node.isRoot()){
			node = node.getParent();
			level++;
		}
		return level;
	}
	
	public int getDepth(){
		int depth = 0;
		int childDepth = 0;
		TreeNode node;
		if(isLeaf())
			return depth;
		Iterator<TreeNode> it = getChildren().iterator();
		while(it.hasNext()){
			node = (TreeNode)it.next();
			childDepth = node.getDepth()>childDepth?node.getDepth():childDepth;
		}
		return childDepth;
	}
	
	/***
	public TreeNode getRoot(){
		TreeNode node;
		if(isRoot())
			return this;
		node = getParent();
		while(!node.isRoot()){
			node = node.getParent();
		}
		return node;
	}
	***/
	public int getCount(){
		int count  = 1;
		if(children==null || children.isEmpty()){
			return count;
		}else{
			for(Iterator<TreeNode> it=children.iterator();it.hasNext();){
				TreeNode child = it.next();
				count += child.getCount();
			}
			return count;
		}
	}
	
}
