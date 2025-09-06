package org.selflearning.global_superstore.services;

import java.util.List;

import org.selflearning.global_superstore.models.Item;
import org.selflearning.global_superstore.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void addItem(final Item item) {
        itemRepository.addItem(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    public Item getItemById(final String id) {
        if (id.equals(""))
            return new Item();

        return itemRepository.getItemById(id);
    }

    public void updateItem(final Item item) {
        itemRepository.updateItem(item);
    }

    public void addOrUpdateItem(final Item item) {
        final String itemId = item.getId();
        if (getItemById(itemId).getId().equals(itemId))
            updateItem(item);
        else
            addItem(item);
    }

    public void deleteItem(final String id) {
        itemRepository.deleteItem(id);
    }
}