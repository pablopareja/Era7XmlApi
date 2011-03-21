package com.era7.lib.era7xmlapi.model;

import org.jdom.Namespace;

import com.era7.lib.era7xmlapi.interfaces.INameSpace;

/**
 * 
 * @author Pablo Pareja Tobes 
 *
 */
public class NameSpace implements INameSpace {

	
	protected Namespace nameSpace = null;
	
	/**
	 * 
	 * @param prefix
	 * @param uri
	 */
	public NameSpace(String prefix,String uri){
		nameSpace = Namespace.getNamespace(prefix, uri);
	}
	/**
	 * 
	 * @param ns
	 */
	public NameSpace(Namespace ns){
		nameSpace = ns;
	}
	
	public org.jdom.Namespace getNamespace(){
		return this.nameSpace;
	}
	
	@Override
	public String getPrefix() {
		return nameSpace.getPrefix();
	}

	@Override
	public String getUri() {
		return nameSpace.getURI();
	}

	@Override
	public void setPrefix(String newValue) {
		nameSpace = Namespace.getNamespace(newValue, nameSpace.getURI());
	}

	@Override
	public void setUri(String newValue) {
		nameSpace = Namespace.getNamespace(nameSpace.getPrefix(), newValue);
	}
	@Override
	public Namespace asJdomNamespace() {
		return org.jdom.Namespace.getNamespace(nameSpace.getPrefix(), nameSpace.getURI());
	}

}
