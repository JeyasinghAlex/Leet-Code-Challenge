import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLParser {

    public static void main(String[] argv)
    {
        int count = 0;
        try
        {
            File file = new File("/home/jeya-zt501/AlexSparrow/security-api.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
//            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("url");
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
//                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    if (eElement.getAttribute("org-oauthscope").isEmpty() && eElement.getAttribute("oauthscope").isEmpty()) {
                        ++count;
                        System.out.println(eElement.getAttribute("path"));
//                        String argOauthScope = eElement.getAttribute("org-oauthscope");
//                        String userOauthScope = eElement.getAttribute("oauthscope");
//                        eElement.setAttribute("org-oauthscope", argOauthScope + "," + userOauthScope);
//                        System.out.println(eElement.getAttribute("org-oauthscope") + " -> " + eElement.getAttribute("oauthscope"));;
                    }
                }
            }

            System.out.println(count);
            /*Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/home/jeya-zt501/AlexSparrow/alex-api.xml"));
            transformer.transform(source, result);*/
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
