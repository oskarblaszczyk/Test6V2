package pl.test.zadanie3.dao;

import pl.test.zadanie3.model.WorkspaceFile;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FileDaoImpl implements FileDao {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public FileDaoImpl() {
        factory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = factory.createEntityManager();
    }

    @Override
    public void save(WorkspaceFile file) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(file);
        tx.commit();
    }

    @Override
    public WorkspaceFile load(String file) {
        return entityManager.find(WorkspaceFile.class, file);
    }

    @Override
    public List<WorkspaceFile> loadAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<WorkspaceFile> criteria = builder.createQuery(WorkspaceFile.class);
        criteria.from(WorkspaceFile.class);
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public List<WorkspaceFile> loadMax() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<WorkspaceFile> cr = cb.createQuery(WorkspaceFile.class);
        Root<WorkspaceFile> root = cr.from(WorkspaceFile.class);
        cr.select(root).where(cb.lt(root.get("size"), 1000));

        Query query = entityManager.createQuery(cr);
        return query.getResultList();

//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<WorkspaceFile> cr = cb.createQuery(WorkspaceFile.class);
//        Root<WorkspaceFile> root = cr.from(WorkspaceFile.class);
// //       Instant instant1 = Instant.ofEpochSecond((long) (2022 - 4 - 21 - 16 - 21 - 31.137617));
//        cr.select(root);
//        //criteria.orderBy(builder.asc(root.get("size")));
// //       cr.where(cb.greaterThan(root.get("lastModified"), instant1));
////        criteria.from(WorkspaceFile.class);
//        Query query = entityManager.createQuery(cr);
//        return query.getResultList();
////        return entityManager.createQuery(criteria).getResultList();
    }
    /*
Session session = HibernateUtil.getHibernateSession();
CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaQuery<Item> cr = cb.createQuery(Item.class);
Root<Item> root = cr.from(Item.class);
cr.select(root);

Query<Item> query = session.createQuery(cr);
List<Item> results = query.getResultList();
     */


    @Override
    public void cleanUp() {
        entityManager.close();
        factory.close();
    }
}
