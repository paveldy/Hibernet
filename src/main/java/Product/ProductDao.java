package Product;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    EntityManagerFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    EntityManager em = factory.createEntityManager();


    public void addProduct(List<Product> newProduct) {
        em.getTransaction().begin();
        List<Product> fromDataBase = new ArrayList<Product>();
        String str = "select a from Product a" /*where a.productName = " + "'"+all.get(i).getProductName()+"'" +"and a.price = "+ all.get(i).getPrice()*/;
        fromDataBase.addAll(em.createQuery(str).getResultList());
        for (int i = 0; i < newProduct.size(); i++) {   
            if (fromDataBase.isEmpty()) {
                em.persist(newProduct.get(i));
            } else {
                for (int j = 0; j < fromDataBase.size(); j++) {
                    if (!newProduct.get(i).getProductName().equals(fromDataBase.get(j).getProductName())) {
                        em.persist(newProduct.get(i));
                    }
                }

            }
        }
//        for (int i = 0; i < fromDataBase.size(); i++) {
//            System.out.println(fromDataBase.get(i));
//        }
        em.getTransaction().commit();

    }


    public void findByid(long id) {  /*работает*/
        em.getTransaction().begin();
        Product otherProduct = em.find(Product.class, id);
        if (em.contains(otherProduct)) {
            System.out.println("продукт с ID " + id + " существует в базе");
            System.out.println(otherProduct.getProductName() + " " + otherProduct.getPrice() + " рублей");
        } else {
            System.out.println("продукта с ID " + id + " не найден");
        }
        em.getTransaction().commit();
    }

    public void findAll(List<Product> all) {
        em.getTransaction().begin();
//        first var
        for (int i = 0; i < all.size(); i++) {
            String name = all.get(i).getProductName();
            Product product = (Product) em.createQuery("select p from Product p where p.productName = " + "'" + name + "'").getSingleResult();
            System.out.println(product.toString());
        }
//        second var
        em.createQuery("select p from Product p").getResultList()
                .stream().forEach(p -> System.out.println(p.toString()));

        em.getTransaction().commit();
    }

    public void findAllFromTable() {  /*работает*/
        List<Product> listAll;
        em.getTransaction().begin();
        listAll = em.createQuery("select p from Product p").getResultList();
        for (int i = 0; i < listAll.size(); i++) {
            System.out.println(listAll.get(i));
        }
        em.getTransaction().commit();
    }


    public void deleteByID(long id) {
        em.getTransaction().begin();
        Product otherProduct = em.find(Product.class, id);
        if (em.contains(otherProduct)) {
            System.out.println("продукт с ID " + id + " существует в базе");
            System.out.println(otherProduct.getProductName() + " " + otherProduct.getPrice() + " рублей");
            em.remove(otherProduct);
            System.out.println("продукт с ID " + id + " удвлён из базе");

        } else {
            System.out.println("продукта с ID " + id + " не найден");
        }
        em.getTransaction().commit();
    }

}
