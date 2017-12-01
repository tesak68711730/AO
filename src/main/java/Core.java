
import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Core {

    public static void main(String[] args) {

        File file = new File("D:\\data.xml");

        readAndShowDataFromFile(file);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            Users users = (Users) jaxbUnMarshaller.unmarshal(file);

//            Users users = (Users) jaxbUnMarshaller.unmarshal(new StringReader(
//                    "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
//                    "<users>\n" +
//                    "    <user>\n" +
//                    "        <name>alina</name>\n" +
//                    "        <age>18</age>\n" +
//                    "        <active>true</active>\n" +
//                    "    </user>\n" +
//                    "    <user>\n" +
//                    "        <name>just</name>\n" +
//                    "        <age>21</age>\n" +
//                    "        <active>false</active>\n" +
//                    "    </user>\n" +
//                    "</users>"));

            System.out.println(users.getUsers().get(0).getName());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void readAndShowDataFromFile(File file) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
//
//
//    private static Employee jaxbXMLToObject() {
//        try {
//            JAXBContext context = JAXBContext.newInstance(Employee.class);
//            Unmarshaller un = context.createUnmarshaller();
//            return (Employee) un.unmarshal(new File(FILE_NAME));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    private static void jaxbObjectToXML(Employee emp) {
//
//        try {
//            JAXBContext context = JAXBContext.newInstance(Employee.class);
//            Marshaller m = context.createMarshaller();
//            //for pretty-print XML in JAXB
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//            // Write to System.out for debugging
//            // m.marshal(emp, System.out);
//
//            // Write to File
//            m.marshal(emp, new File(FILE_NAME));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
}
