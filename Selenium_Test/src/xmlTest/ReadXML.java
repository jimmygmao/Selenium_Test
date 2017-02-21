package xmlTest;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {

	public static void main(String[] args) {
		try {
			File xmiFile=new File("TestDate/info.xml");
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse(xmiFile);
			NodeList n1=doc.getElementsByTagName("caption");
			NodeList n2=doc.getElementsByTagName("login");
			System.out.println(n1.item(0).getNodeName());
			System.out.println(n1.item(0).getNodeType());
			System.out.println(n1.item(0).getNodeValue());
			System.out.println("----------------------");
			System.out.println(n2.item(0).getNodeName());
			System.out.println(n2.item(0).getAttributes().getNamedItem("username"));
			System.out.println(n2.item(0).getAttributes().getNamedItem("passwd"));
			System.out.println("----------------------");
			System.out.println(n1.item(0).getTextContent());
			System.out.println(n1.item(1).getTextContent());
			System.out.println(n1.item(2).getTextContent());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
