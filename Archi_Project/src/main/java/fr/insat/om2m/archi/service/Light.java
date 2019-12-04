package fr.insat.om2m.archi.service;

import java.io.IOException;

import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.archi.client.Client;
import fr.insat.om2m.archi.client.ClientInterface;
import fr.insat.om2m.archi.client.Response;
import fr.insat.om2m.archi.mapper.Mapper;
import fr.insat.om2m.archi.mapper.MapperInterface;

public class Light {
	private static final String Originator = "admin:admin";
	private ClientInterface client = new Client();
	private MapperInterface mapper = new Mapper();
	private Response response = new Response();
	
	Light(){
	}
	
	public int TurnOnLight(){
		ContentInstance dataInstance = new ContentInstance();
		dataInstance.setContent("1");
		try {
			client.create("http://localhost:9090/~/mn-cse/mn-name/" + "LIGHT" + "/STATUS", mapper.marshal(dataInstance), Originator, "4");
		} catch (IOException e) {
			System.err.println("Error creating the content instance");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int TurnOffLight(){
		ContentInstance dataInstance = new ContentInstance();
		dataInstance.setContent("0");
		try {
			client.create("http://localhost:9090/~/mn-cse/mn-name/" + "LIGHT" + "/STATUS", mapper.marshal(dataInstance), Originator, "4");
		} catch (IOException e) {
			System.err.println("Error creating the content instance");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public Response GetStatus(){
		try{
			response = client.retrieve("http://localhost:9090/~/mn-cse/mn-name/" + "LIGHT" + "/STATUS",Originator);
			System.out.println(response.toString());
			}catch (IOException e) {
				System.err.println("Error creating the content instance");
				e.printStackTrace();
			}
		
		return response;
	}
	
	
}
