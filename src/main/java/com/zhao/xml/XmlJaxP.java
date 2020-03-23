package com.zhao.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlJaxP {

	
	private Document doc;
	private String uri;
	
	
	private void init(String uri) {
		
		this.uri=uri;
		
		try{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =factory.newDocumentBuilder();
		doc = builder.parse(this.uri);
		
		}
		
		catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void read(){
		
		NodeList list =doc.getElementsByTagName("书");
		Node book =list.item(1);
		System.out.println(book.getTextContent());
	}
	
	public void traverse(){
		
		Node root = doc.getElementsByTagName("书架").item(0);
		
		list(root);
		
		
	}
	
	
	
	
	private void list(Node node) {
		if(node instanceof Element){
		System.out.println(node.getNodeName());
		}
		
		NodeList list =node.getChildNodes();
		for(int i=0;i<list.getLength();i++){
			list(list.item(i));
		}
	}
	
	public void readAttribute(){
		
		Element book =(Element)doc.getElementsByTagName("书").item(0);    // 转为子类型
		System.out.println(book.getAttribute("建议"));
		
	}
	
	
	
	
	public void create() {
		
		Element price =doc.createElement("售价");
		price.setTextContent("88.8元");
		Node book =doc.getElementsByTagName("书").item(0);
		
		book.appendChild(price);
		
		
		TransformerFactory tfFactory=TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tfFactory.newTransformer();
		    transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(uri)));
		    //Document ,Element 都是Node 的子接口
		} catch (FileNotFoundException | TransformerException e) {
			e.printStackTrace();
		}
	
	}



	public static void main(String[] args)  {
		
		XmlJaxP xmlParser= new XmlJaxP();
		xmlParser.init("WebContent\\test1.xml");
		xmlParser.create();
		
		
	}

}
