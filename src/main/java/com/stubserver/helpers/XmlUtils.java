package com.stubserver.helpers;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

@Slf4j
@UtilityClass
public class XmlUtils {

    public static String evaluateXpath(String xmlString, String xpathString) {
        XPath xpath = XPathFactory.newInstance().newXPath();
        InputSource requestXMLis = new InputSource(new StringReader(xmlString));
        String result = null;
        try {
            result = xpath.evaluate(xpathString, requestXMLis);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static String getStringFromDocumentForCDATA(String xmlPath) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        File fl = new File(xmlPath);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse(fl);
        DOMSource source = new DOMSource(doc);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(source, result);
        writer.flush();
        return writer.toString();
    }

    public static String setElement(String xPathString, String xml, String newValue) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document xmlDoc = builder.parse(new InputSource(new StringReader(xml)));
        if (checkIfNodeExists(xmlDoc, xPathString))
            try {
                XPath xPath = XPathFactory.newInstance().newXPath();
                org.w3c.dom.Node node = (org.w3c.dom.Node) xPath.compile(xPathString).evaluate(xmlDoc, XPathConstants.NODE);
                node.setTextContent(newValue);
            } catch (XPathExpressionException e) {
                log.error(e.toString());
            }
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.transform(new DOMSource(xmlDoc), result);
        writer.flush();
        return writer.toString();
    }

    private static boolean checkIfNodeExists(Document document, String xpathExpression)  {
        boolean matches = false;
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        try {
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            if (nodes != null && nodes.getLength() > 0) {
                matches = true;
            }
        } catch (XPathExpressionException e) {
            log.error(e.toString());
        }
        return matches;
    }

}
