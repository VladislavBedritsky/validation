package org.example.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Validated
public class MainController {

    private List<Map<String, String>> list;

    public MainController() {
        list = new ArrayList<>();
        list.add(new HashMap<String, String>() {{
          put("id", "1");
          put("name", "name");
        }});
    }

    @GetMapping("/params")
    public String getParams(Model model) {
        model.addAttribute("list", list);
        return "params";
    }

    @PostMapping("/params")
    public String saveParams(@RequestParam @NotBlank(message = "Id can't be empty")
                             String id,
                             @RequestParam @NotBlank(message = "Name can't be empty")
                             String name) {

        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);

        list.add(map);
        return "redirect:/params";
    }


}
