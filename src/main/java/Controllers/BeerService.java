/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author Keane
 */
@Service
public class BeerService {

    public List<Beers> SearchBeers(String name) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        TypedQuery<Beers> tq = em.createNamedQuery("Beers.Search", Beers.class).setParameter("name", "%" + name + "%");

        List<Beers> BeerSearch = new ArrayList<>();
        try {
            BeerSearch = tq.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return BeerSearch;
    }

    public Beers getBeerById(int id) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        TypedQuery<Beers> tq = em.createNamedQuery("Beers.findById", Beers.class).setParameter("id", id);

        Beers beer = null;
        try {
            beer = tq.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return beer;
    }

    public Boolean editBeerPrice(Beers beer, double UpdatedPrice) {
        int id = beer.getId();
        double price = beer.getSellPrice();
        //System.out.println("price"+price);
        EntityManager em = DBUtil.getEmf().createEntityManager();

        EntityTransaction trans = em.getTransaction();
        em.getTransaction().begin();

        String jpqlUpdate = "UPDATE Beers SET sellPrice = :price WHERE id = :id ";
        int EntetiesUpd = em.createQuery(jpqlUpdate)
                .setParameter("price", UpdatedPrice)
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();

        return true;
    }

    public Styles getStyleByID(int styleid) {
        EntityManager em = DBUtil.getEmf().createEntityManager();

        Styles style = null;
        try {
            style = em.find(Styles.class, styleid);
            //System.out.println("PRinting result"+ property);
            if (style == null) {
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return style;
    }

    public Categories getCatByID(int catid) {
        EntityManager em = DBUtil.getEmf().createEntityManager();

        Categories cat = null;
        try {
            cat = em.find(Categories.class, catid);
            //System.out.println("PRinting result"+ property);
            if (cat == null) {
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return cat;
    }
}
