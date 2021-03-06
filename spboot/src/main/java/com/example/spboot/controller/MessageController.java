package com.example.spboot.controller;

import com.example.spboot.domain.Message;
import com.example.spboot.domain.User;
import com.example.spboot.domain.dto.MessageDTO;
import com.example.spboot.repository.MessageRepository;
import com.example.spboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class MessageController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;

    @Value("${upload_path}")
    private String uploadPath;


    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
//        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/main")
    public String main(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "")  String filter,
            Model model,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<MessageDTO> messages = messageService.messageList(pageable, filter, user);

        model.addAttribute("page", messages);
        model.addAttribute("url", "/main");
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

        if (bindingResult.hasErrors()) {
            map.mergeAttributes(ControllerUtils.getErrors(bindingResult));
            map.addAttribute("message", message);
        } else {

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

    @GetMapping("user-messages/{user}")
    public String userMessages(
            @AuthenticationPrincipal User userFromSession,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Message message,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<MessageDTO> page = messageService.messageListForUser(pageable,userFromSession, user );
        model.addAttribute("userChanel", user);
        model.addAttribute("page", page);
        model.addAttribute("message", message);
        model.addAttribute("isCurrentUser", userFromSession.equals(user));
        model.addAttribute("subscriptionsCount", user.getSubscriptions().size());
        model.addAttribute("subscribersCount", user.getSubscribers().size());
        model.addAttribute("isSubscriber", user.getSubscribers().contains(userFromSession));
        model.addAttribute("url", "user-messages/" + user.getId());

        return "userMessages";
    }

    @PostMapping("user-messages/{user}")
    public String updateMessage(
            @AuthenticationPrincipal User userFromSession,
            @PathVariable User user,
            @RequestParam("id") Message message,
            @RequestParam String text,
            @RequestParam String tag) {
//        message.setText(text);
//        message.setTag(tag);
//
//        messageRepository.save(message);
//        return "redirect:/user-messages/" + user.getId();
        if (message.getUser().equals(userFromSession)) {
            if (!StringUtils.isEmpty(text)) {
                message.setText(text);
            }

            if (!StringUtils.isEmpty(tag)) {
                message.setTag(tag);
            }

//            saveFile(message, file);

            messageRepository.save(message);
        }
        return "redirect:/user-messages/" + user.getId();

    }

    @GetMapping("/messages/{message}/like")
    public String like(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Message message,
            RedirectAttributes redirectAttributes,
            @RequestHeader(required = false) String referer
    ) {
        Set<User> likes = message.getLikes();

        if (likes.contains(currentUser)) {
            likes.remove(currentUser);
        } else {
            likes.add(currentUser);
        }

        UriComponents components = UriComponentsBuilder.fromHttpUrl(referer).build();

        components.getQueryParams()
                .entrySet()
                .forEach(pair -> redirectAttributes.addAttribute(pair.getKey(), pair.getValue()));

        return "redirect:" + components.getPath();
    }




//    @PostMapping("/filter")
//    public String filter(@RequestParam(name = "filter") String tag, Map<String, Object> map){
//        List<Message> messages = messageRepository.findByTagLike(tag);
//        map.put("messages", messages);
//        return "main";
//    }

}
