package template.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

@Entity
@NamedQuery(name = "getAll", query = "SELECT i from Item i")
public class Item {
    @Id
    public String text;

    public Item() {
        // JPA
    }

    public Item(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static List<Item> getAll(EntityManager entityManager) {
        TypedQuery<Item> query = entityManager.createNamedQuery("getAll", Item.class);
        return query.getResultList();
    }

    public static Item create(EntityManager entityManager, String text) {
        return entityManager.merge(new Item(text));
    }
}
