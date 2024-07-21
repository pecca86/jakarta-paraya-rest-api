package org.eclipse.jakarta.hello.resources;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.hello.entities.Company;
import org.eclipse.jakarta.hello.services.CompanyService;

@Path("/company")
@RequestScoped
public class CompanyResource {

    @Inject
    private CompanyService companyService;

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Company getCompanyById(
            @PositiveOrZero @PathParam("id") Long id
    ) {
        return companyService.findCompanyById(id);
    }

    @GET
    @Produces("application/json")
    @Path("/all")
    public Response getAllCompanies() {
        return Response.ok(companyService.findAllCompanies()).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createCompany(
            @NotNull Company company
    ) {
        return Response.created(null)
                       .entity(companyService.createCompany(company))
                       .build();
    }

}
