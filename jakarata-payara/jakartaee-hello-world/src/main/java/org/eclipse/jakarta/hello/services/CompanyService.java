package org.eclipse.jakarta.hello.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.eclipse.jakarta.hello.entities.Company;

import java.util.List;

@ApplicationScoped
@Transactional
public class CompanyService {

    // responsible for interacting with the database
    @PersistenceContext(unitName = "TestUnit")
    private EntityManager entityManager;

    public Company findCompanyById(Long id) {
        return entityManager.find(Company.class, id);
    }

    public List<Company> findAllCompanies() {
        return entityManager.createQuery("SELECT c FROM Company c", Company.class).getResultList();
    }

    public Company createCompany(Company company) {
        entityManager.persist(company);
        return company;
    }
}
