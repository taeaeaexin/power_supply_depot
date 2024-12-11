package com.Taesin.shop.Controller;

import com.Taesin.shop.Entity.Item;
import com.Taesin.shop.Repositoy.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor // lombok 문법
public class ItemController {
    private final ItemRepository itemRepository; // db입출력 함수 등록

    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
        var a = new Item();
        System.out.println(a);

        return "list.html";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }

    @PostMapping("/add")
    String writePost(@ModelAttribute Item item) {
        itemRepository.save(item);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(){
        Optional<Item> result = itemRepository.findById(1L);
        System.out.println(result.get());
        return "detail.html";
    }
}