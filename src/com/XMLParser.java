package com;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public final class XMLParser {

    private static XPath xpath = XPathFactory.newInstance().newXPath();
    private static Document doc;
    private static String fileName = "src/data/Tasks.xml";
    private static File file = new File(fileName);

    static {
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private XMLParser() {
    }

    public static void main(String[] args) throws XPathExpressionException, TransformerException {
        func("//Tasks/Task");
    }

    public static void func(String expr) throws XPathExpressionException, TransformerException {
        Node root = ((NodeList) xpath.compile("//Tasks").evaluate(doc,XPathConstants.NODESET)).item(0);
        NodeList tasksList = (NodeList) xpath.compile("//Tasks/Task").evaluate(doc,XPathConstants.NODESET);

        for (int i = 0; i < tasksList.getLength(); i++) {
            Element task = (Element) tasksList.item(i);
            System.out.println(task.getAttribute("name"));
        }

        tasksList.item(0).getAttributes().getNamedItem("name").setTextContent("New name");
        Element newTask = doc.createElement("Task");

        root.appendChild(newTask);
        newTask.setAttribute("name","New Task2");

        for (int i = 0; i < tasksList.getLength(); i++) {
            Element task = (Element) tasksList.item(i);
            System.out.println(task.getAttribute("name"));
        }



//        System.out.println(task.getTagName());

//        System.out.println(task.getAttributes().item(0));
//        Node nodeAttr = task.getAttributes().getNamedItem("abs");
//        System.out.println(nodeAttr.getLocalName());
//        nodeAttr.setTextContent("3");
    }


    public static void save() throws TransformerException {
        doc.normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(file);
        transformer.transform(domSource, streamResult);
    }

    public static boolean addList(TaskList list) {
        if (list == null || list.size() <= 0) {
            Element taskList = doc.createElement("TaskList");
            taskList.setAttribute("project", list.getProject());

        }
        return false;
    }


}
