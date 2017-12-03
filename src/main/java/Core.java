import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Core {

    public static void main(String[] args) {

        try {
            Users users = getUsers();
            System.out.println("Size of users : " + users.getSize());

            getAverageOfAllUsers(users);
            getOldestActiveUser(users);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void getOldestActiveUser(Users users) {
        int oldestAge = 0;
        for (User user: users.getUsers()) {
            if(user.isActive() && user.getAge() > oldestAge)
                oldestAge = user.getAge();
        }

        System.out.println("Name Of Oldest Active User(s) : " );
        for (User user: users.getUsers()) {
            if(user.getAge() == oldestAge)
                System.out.println("\t" + user.getName());
        }
    }

    private static Users getUsers() throws JAXBException {

        File data = new File("D:\\data.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Users users = (Users) unmarshaller.unmarshal(data);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(users, System.out);
        return users;
    }

    private static void getAverageOfAllUsers(Users users) {
        double temp = 0;
        for(User user : users.getUsers()) {
            temp += user.getAge();
        }
        System.out.println("The average age of all users : " + temp / users.getSize());
    }
}
