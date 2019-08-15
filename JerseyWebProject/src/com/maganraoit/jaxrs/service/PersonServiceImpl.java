package com.maganraoit.jaxrs.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.maganraoit.jaxrs.model.Person;
import com.maganraoit.jaxrs.model.Response;

@Path("/person")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class PersonServiceImpl implements PersonService {
	public static Map<Integer,Person> personMap = new HashMap<Integer, Person>();
	@Override
	@GET
	@Path("{id}/getDummy")
	public Person getDummyRecord(@PathParam("id") int id) {
		Person p = new Person();
		p.setId(id);
		p.setName("Dummy Name");
		p.setAge(30);
		return p;
	}

	@Override
	@POST
	@Path("/add")
	public Response addPersion(Person p) {
		Response r = new Response();
		if(personMap.get(p.getId())!=null){
			r.setStatus(false);
			r.setMessage("Person already exists with this id");
			return r;
		}
		personMap.put(p.getId(), p);
		r.setStatus(true);
		r.setMessage("Person is added successfully");
		return r;
	}

	@Override
	@GET
	@Path("{id}/deletePerson")
	public Response deletePerson(@PathParam("id") int id1) {
		Response r = new Response();
		if(personMap.get(id1)==null) {
			r.setStatus(false);
			r.setMessage("No record exists to Delete");
			return r;
		}
		personMap.remove(id1);
		r.setStatus(true);
		r.setMessage("Record is successfully deleted");
		return r;
	}

	@Override
	@GET
	@Path("{id}/getPerson")
	public Person getPerson(@PathParam("id") int id) {
		return personMap.get(id);
	}

	@Override
	@GET
	@Path("/getAll")
	public Person[] getAll() {
		
		Person[] persons = new Person[personMap.size()];
		Set<Entry<Integer, Person>> personEntrySet = personMap.entrySet();
		int index=0;
		for (Entry<Integer, Person> entry : personEntrySet) {
			persons[index++]=entry.getValue();
		}
		
		return persons;
	}
	
	

}
