package org.eclipse.jakarta.hello.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.ValidatorFactory;
import org.eclipse.jakarta.hello.entities.Company;
import org.eclipse.jakarta.hello.entities.Employee;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional // commits all transactions at the end of the method
public class EmployeeService {

    @Inject
    private ValidatorFactory validatorFactory;

    @PersistenceContext(unitName = "TestUnit")
    private EntityManager entityManager;

    public Employee findEmployeeById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAllEmployees() {
        return entityManager.createQuery("SELECT e FROM Employee e JOIN FETCH e.company", Employee.class) // instead of eager fetching, we fetch the company data within the same query
                            .getResultList();
    }

    public List<Employee> getEmployeesForCompany(Long companyId) {
        return entityManager.createQuery("SELECT e FROM Employee e WHERE e.company.id = :companyId", Employee.class)
                            .setParameter("companyId", companyId)
                            .getResultList();
    }

    public Employee createEmployee(Employee employee) {
        Set<ConstraintViolation<Employee>> violations = validatorFactory.getValidator().validate(employee);
        if (!violations.isEmpty()) {
            throw new ValidationException(violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(",")));
        }
        Company c = new Company();
        c.setName("Auto Company");
        entityManager.persist(c);
        employee.setCompany(c);
        entityManager.persist(employee);
        return employee;
    }
}
