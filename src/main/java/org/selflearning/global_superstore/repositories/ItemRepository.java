package org.selflearning.global_superstore.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.selflearning.global_superstore.models.Item;

@Repository
public class ItemRepository {

    private List<Item> dataStore = new ArrayList<>();

    public void addItem(final Item item) {
        dataStore.add(item);
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(dataStore);
    }

    public Item getItemById(final String id) {
        for (final Item item : dataStore)
            if (item.getId().equals(id))
                return item;
        return new Item();
    }

    public void updateItem(final Item item) {
        dataStore.set(dataStore.indexOf(item), item);
    }
}
