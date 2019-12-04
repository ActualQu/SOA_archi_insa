package fr.insat.om2m.archi.client;

import java.io.IOException;

import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.archi.mapper.Mapper;

public class Main {
	private static final String ORIGINATOR = "admin:admin";
	private static Mapper mapper = new Mapper();
	public static void main(String[] args){
		ClientInterface client = new Client();
		ContentInstance cin = new ContentInstance();
		cin.setContent("0");
		try{
			//Response response = client.create("http://localhost:9090/~/mn-cse/mn-name/WINDOW/STATUS",mapper.marshal(cin),ORIGINATOR, "4");
			Response response = client.retrieve("http://localhost:9090/~/mn-cse/mn-name/WINDOW/STATUS", ORIGINATOR);
			System.out.println(mapper.unmarshal(response.toString()));
			System.out.println(response.toString());
		}catch (IOException e) {
			System.err.println("Error creating the content instance");
			e.printStackTrace();
		}
		
		}
}
