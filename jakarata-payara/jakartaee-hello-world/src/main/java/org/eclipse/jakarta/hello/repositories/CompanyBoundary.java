package org.eclipse.jakarta.hello.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.eclipse.jakarta.hello.entities.Company;

// EJB Bean, transactional by default
@Stateless
//@TransactionAttribute()
public class CompanyBoundary {

    @PersistenceContext
    private EntityManager entityManager;

    public Company findCompanyById(Long id) {
        return entityManager.find(Company.class, id);
    }
}
