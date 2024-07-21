package org.eclipse.jakarta.hello.resources;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.hello.entities.Employee;
import org.eclipse.jakarta.hello.services.EmployeeService;

@Path("/employees")
@RequestScoped
@Named
public class EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getEmployees(@PathParam("id") Long id) {
        return Response.ok(employeeService.findEmployeeById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
        return Response.ok(employeeService.findAllEmployees()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(@Valid Employee employee) {
        return Response.ok(employeeService.createEmployee(employee)).build();
    }


}
