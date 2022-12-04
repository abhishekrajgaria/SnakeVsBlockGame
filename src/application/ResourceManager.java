package application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceManager implements Serializable{
	/**
	 * This method is used to serialize current game state
	 * @param data data object
	 * @param filename file
	 * @throws Exception exception
	 */
public static void save(Serializable data,String filename) throws Exception
{
	try(ObjectOutputStream oos=new ObjectOutputStream(Files.newOutputStream(Paths.get(filename))))
	{
		oos.writeObject(data);
	}
}
/**
 * This method is used to retrieve the serialized data from the file
 * @param filename file
 * @return return
 * @throws Exception exception
 */
public static Object load(String filename) throws Exception
{
	try(ObjectInputStream ois=new ObjectInputStream(Files.newInputStream(Paths.get(filename))))
	{
		return ois.readObject();
	}
}
}
