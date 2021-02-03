//import Product.Product;
import Product.Product;
import Product.ProductDao;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        List<Product> newProducts = new ArrayList<Product>();
        Product p1 = new Product("Apple", 100);
        Product p2 = new Product("Orange", 150);
        Product p3 = new Product("Anion", 200);
        Product p4 = new Product("Banana", 220);
        Product p5 = new Product("Potatas", 80);
        Product p6 = new Product("Carrot", 270);



        newProducts.add(p1);   /*потмо надо убрать это все, как-то некрасиво*/
        newProducts.add(p2);
        newProducts.add(p3);
        newProducts.add(p4);
        newProducts.add(p5);
        newProducts.add(p6);
//        newProducts.add(new Product("Milk", 110));
//        newProducts.add(new Product("BioJogurt", 210));


        productDao.addProduct(newProducts); /*не работает*/

//        productDao.findByid(2); /*работает*/
//        productDao.deleteByID(4); /*работает*/
//        productDao.findAll(newProducts);   /*не понял зачем сделал, тупасть, зато научлися*/
//        productDao.findAllFromTable(); /*работает*/



//        EntityManagerFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//         Из фабрики создаем EntityManager
//        EntityManager em = factory.createEntityManager();
//
//        Product product = new Product("Apple", 100);
//
//        // Открываем транзакцию
//        em.getTransaction().begin();
////         Create (сохраняем в базе данных, и благодаря этому сущность
////         становится управляемой HibernWate и заносится в контекст постоянства)
//        em.persist(product);
////         Подтверждаем транзакцию
//        em.getTransaction().commit();
//
//        em.getTransaction().begin();
////         Read (читаем сущность из базы данных по id)
//        Person anotherPerson = em.find(Person.class, 1L);
//        em.getTransaction().commit();
//        anotherPerson.setFirstname("Artem");
//
//        em.getTransaction().begin();
//        // Update
//        em.merge(anotherPerson);
//        em.getTransaction().commit();
    }


}

