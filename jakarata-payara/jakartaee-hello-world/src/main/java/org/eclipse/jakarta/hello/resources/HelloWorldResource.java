package org.eclipse.jakarta.hello.resources;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.hello.dtos.Hello;
import org.eclipse.jakarta.hello.dtos.Person;
import org.eclipse.jakarta.hello.configs.events.PersonCache;
import org.eclipse.jakarta.hello.dtos.AddPersonEvent;
import org.eclipse.jakarta.hello.services.GreetingService;

@Path("hello")
public class HelloWorldResource {

	@Inject
	private GreetingService greetingService;

	@Inject
	private PersonCache personCache;
	@Inject
	private Event<AddPersonEvent> addPersonEventEvent;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response hello(@QueryParam("language") String name) {
		if ((name == null) || name.trim().isEmpty())  {
			name = "world";
		}

		Hello hello = new Hello(String.format(greetingService.greet(name), name));
		return Response.ok(hello).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("persons")
	public Response getPersons() {
		return Response.ok(personCache.getPersons()).build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("persons")
	public Response handlePersonRequest(Person person) {
		addPersonEventEvent.fire(new AddPersonEvent(person));
		return Response.ok(person).build();
	}
}
