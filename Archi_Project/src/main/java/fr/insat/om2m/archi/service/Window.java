package fr.insat.om2m.archi.service;

import java.io.IOException;

import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.archi.client.Client;
import fr.insat.om2m.archi.client.Response;
import fr.insat.om2m.archi.mapper.Mapper;

public class Window {
	private static final String ORIGINATOR = "admin:admin";
	private int status;
	private Client window_client;
	private Response window_response;
	private ContentInstance window_cin;
	private static Mapper mapper;
	Window(){
		status = 0;
		window_client = new Client();
		window_response = new Response();
		window_cin = new ContentInstance();
		mapper = new Mapper();
	}
	public int CloseWindow(){
		window_cin.setContent("0");
		try{
		window_response = window_client.create("http://localhost:9090/~/mn-cse/mn-name/WINDOW/STATUS",mapper.marshal(window_cin),ORIGINATOR, "4");
		System.out.println(window_response.toString());
		}catch (IOException e) {
			System.err.println("Error creating the content instance");
			e.printStackTrace();
		}
		return 0;
	}
	public int OpenWindow(){
		window_cin.setContent("1");
		try{
		window_response = window_client.create("http://localhost:9090/~/mn-cse/mn-name/WINDOW/STATUS",mapper.marshal(window_cin),ORIGINATOR, "4");
		System.out.println(window_response.toString());
		}catch (IOException e) {
			System.err.println("Error creating the content instance");
			e.printStackTrace();
		}
		return 0;
	}
	
	public Response get_status(){
		try{
		window_response = window_client.retrieve("http://localhost:9090/~/mn-cse/mn-name/WINDOW/STATUS",ORIGINATOR);
		System.out.println(window_response.toString());
		}catch (IOException e) {
			System.err.println("Error creating the content instance");
			e.printStackTrace();
		}
		return window_response;
		
	}
}
