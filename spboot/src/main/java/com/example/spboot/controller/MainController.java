package com.example.spboot.controller;

import com.example.spboot.domain.Message;
import com.example.spboot.domain.User;
import com.example.spboot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private MessageRepository messageRepository;

    @Value("${upload_path}")
    private String uploadPath;


    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
//        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepository.findAll();

        if(filter != null && !filter.isEmpty()){
            messages = messageRepository.findByTagLike(filter);
        }else {
            messages = messageRepository.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/add")
    public String add(@AuthenticationPrincipal User user,
                      @Valid Message message,
                      BindingResult bindingResult,
                      Model map,
                      @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(user.getUsername());

//        Message message = new Message();
//        message.setText(text);
//        message.setTag(tag);
        message.setUser(user);
        System.out.println("File is empty -->" + file == null);

        if(bindingResult.hasErrors()){
            map.mergeAttributes(ControllerUtils.getErrors(bindingResult));
            map.addAttribute("message", message);
        }else {

            if (file != null) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    System.out.println("File dir not exists -->");

                    uploadDir.mkdir();
                }
                String uuioFile = UUID.randomUUID().toString();
                String resultFilename = uuioFile + "." + file.getOriginalFilename();

                System.out.println("File resultFilename --> " + resultFilename);
                System.out.println("File transferTo --> " + uploadPath + "/" + resultFilename);

                file.transferTo(new File(uploadPath + "/" + resultFilename));
                message.setFilename(resultFilename);
            }
            map.addAttribute("message", null);
            messageRepository.save(message);
        }
        Iterable<Message> messages = messageRepository.findAll();
        map.addAttribute("messages", messages);
        return "main";
    }



//    @PostMapping("/filter")
//    public String filter(@RequestParam(name = "filter") String tag, Map<String, Object> map){
//        List<Message> messages = messageRepository.findByTagLike(tag);
//        map.put("messages", messages);
//        return "main";
//    }

}
