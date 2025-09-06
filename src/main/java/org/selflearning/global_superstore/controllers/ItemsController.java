package org.selflearning.global_superstore.controllers;

import org.selflearning.global_superstore.constants.*;
import org.selflearning.global_superstore.models.Item;
import org.selflearning.global_superstore.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

@Controller
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String getForm(final Model model, @RequestParam(required = false, defaultValue = "") final String id) {
        model.addAttribute("categories", ConstantModels.ITEMS_CATEGORIES);
        model.addAttribute("item", itemService.getItemById(id));
        return Views.FORM;
    }

    @PostMapping("/submitItem")
    public String handleItemSubmission(@Valid final Item item, final BindingResult validationResult,
            final Model model) {

        if (validationResult.hasErrors()) {
            model.addAttribute("categories", ConstantModels.ITEMS_CATEGORIES);
            return Views.FORM;
        }

        itemService.addOrUpdateItem(item);

        return new StringBuilder("redirect:").append(Views.INVENTORY).toString();
    }

    @GetMapping("/inventory")
    public String getMethodName(final Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return Views.INVENTORY;
    }

    @GetMapping("/delete")
    public String deleteItem(@RequestParam(required = true, defaultValue = "") final String id) {
        if (id.equals(""))
            return Views.INVENTORY;
        itemService.deleteItem(id);
        return new StringBuilder("redirect:").append(Views.INVENTORY).toString();
    }

}
