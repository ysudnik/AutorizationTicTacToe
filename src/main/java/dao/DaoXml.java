package dao;

import objects.AllObjects;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.ArrayList;

public class DaoXml<T>
{
    public void add(T t, String PATH, Class<T> tClass, String name) {
        ArrayList<T> xmlObjects = getAll(PATH, tClass);
        xmlObjects.add(t);
        AllObjects alls = new AllObjects(xmlObjects);
        try {

            JAXBContext context = JAXBContext.newInstance(AllObjects.class, tClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            QName qName = new QName(name);
            JAXBElement<AllObjects> jaxbElement = new JAXBElement<>(qName,
                    AllObjects.class, alls);
            marshaller.marshal(jaxbElement, new File(PATH));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<T> getAll(String PATH, Class<T> tClass) {
        try {
            JAXBContext context = JAXBContext.newInstance(AllObjects.class, tClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StreamSource xml = new StreamSource(PATH);
            AllObjects<T> allObjects = (AllObjects<T>) unmarshaller.unmarshal(xml, AllObjects.class).getValue();
            return allObjects.getAllObjects();
        } catch (JAXBException e) {
            return new ArrayList<>();
        }
    }

}