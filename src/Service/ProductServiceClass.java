package Service;

import Entities.ProductsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by VIRUS on 1/9/2019.
 */
public class ProductServiceClass {
    private EntityManager entityManager;
    private EntityManagerFactory factory;

    public ProductServiceClass(){
        factory = Persistence.createEntityManagerFactory("PROJECT");
        entityManager=factory.createEntityManager();
    }

    public List<ProductsEntity>getAllProducts(){

        TypedQuery<ProductsEntity>query=entityManager.createQuery("SELECT P from ProductsEntity P",ProductsEntity.class);

        return  query.getResultList();
    }


}
