package com.maganraoit.jaxrs.service;

import com.maganraoit.jaxrs.model.Person;
import com.maganraoit.jaxrs.model.Response;

public interface PersonService {
		public Person getDummyRecord(int id);
		public Response addPersion(Person p);
		public Response deletePerson(int id);
		public Person getPerson(int id);
		public Person[] getAll();
}
