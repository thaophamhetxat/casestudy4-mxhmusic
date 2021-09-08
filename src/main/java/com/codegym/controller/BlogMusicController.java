package com.codegym.controller;


import com.codegym.moduls.*;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/blogMusic/")
@SessionAttributes("favourite")
public class BlogMusicController {
    @Autowired
    IBlogMusicService iBlogMusicService;
    @Autowired
    ITheLoaiService iTheLoaiService;
    @Autowired
    IRoleService iRoleService;
    @Autowired
    IUaThichService iUaThichService;

//
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleError(Exception e) {
//        ModelAndView modelAndView = new ModelAndView("error");
//        return modelAndView;
//    }

    @ModelAttribute
    public ArrayList<TheLoai> listTheLoai() {
        return (ArrayList<TheLoai>) iTheLoaiService.findAll();
    }

    @ModelAttribute
    public ArrayList<Role> listRole() {
        return (ArrayList<Role>) iRoleService.findAll();
    }

    //login
    @GetMapping("/")
    public ModelAndView index(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/index");
//        modelAndView.addObject("listSortViews",iBlogMusicService.SortMaxViews());
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(page, 12)));
        return modelAndView;
    }


    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @GetMapping("/showAdmin")
    public ModelAndView show(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/showAdmin");
        modelAndView.addObject("listTheLoai", new BlogMusic());
        modelAndView.addObject("listPerson", iPersonService.findAllPerson());
        modelAndView.addObject("listAdmin", iPersonService.findAllByNameAdmin());
        modelAndView.addObject("listUser", iPersonService.findAllByNamePerson());
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(page, 5, Sort.by("views"))));
        return modelAndView;
    }


    @GetMapping("/blog")
    public ModelAndView blog(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/blog");
//        modelAndView.addObject("listSortViews",iBlogMusicService.SortMaxViews());
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(page, 12)));
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("listTheLoai", new BlogMusic());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("listTheLoai") BlogMusic blogMusic, @RequestParam MultipartFile uppImg, @RequestParam MultipartFile uppMusic) {
        String nameImg = uppImg.getOriginalFilename();
        String nameMusic = uppMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\MD4-JPA\\BlogMusic\\src\\main\\webapp\\image/" + nameImg));
            FileCopyUtils.copy(uppMusic.getBytes(), new File("D:\\MD4-JPA\\BlogMusic\\src\\main\\webapp\\music/" + nameMusic));
            String urlImg = "/image/" + nameImg;
            String urlMusic = "/music/" + nameMusic;
            blogMusic.setFileImage(urlImg);
            blogMusic.setFileMusic(urlMusic);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iBlogMusicService.save(blogMusic);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogMusic/showAdmin");
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/edit", "listTheLoai", iTheLoaiService.findAll());
        modelAndView.addObject("list", iBlogMusicService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute BlogMusic blogMusic, @RequestParam MultipartFile uppImg, @RequestParam MultipartFile uppMusic) {
        String nameImg = uppImg.getOriginalFilename();
        String nameMusic = uppMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\MD4-JPA\\BlogMusic\\src\\main\\webapp\\image/" + nameImg));
            FileCopyUtils.copy(uppMusic.getBytes(), new File("D:\\MD4-JPA\\BlogMusic\\src\\main\\webapp\\music/" + nameMusic));
            String urlImg = "/image/" + nameImg;
            String urlMusic = "/music/" + nameMusic;
            blogMusic.setFileImage(urlImg);
            blogMusic.setFileMusic(urlMusic);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iBlogMusicService.edit(blogMusic);
        return new ModelAndView("redirect:/blogMusic/showAdmin");
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("/showAdmin");
        modelAndView.addObject("list", iBlogMusicService.findAllByName(findName));
        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        iBlogMusicService.delete(iBlogMusicService.findById(id));
        return new ModelAndView("redirect:/blogMusic/showAdmin");
    }


    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("list", iBlogMusicService.findById(id));
        return modelAndView;
    }


    //    blog
    @GetMapping("/playBlog/{id}")
    public ModelAndView showBlog(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/blog");
        iBlogMusicService.views(id);
//        modelAndView.addObject("listSortViews",iBlogMusicService.SortMaxViews());
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("listAll", iBlogMusicService.findAll());
        modelAndView.addObject("list", iBlogMusicService.findById(id));
        return modelAndView;
    }


    //thêm vào list yêu thích
    @GetMapping("add/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute Favourite favourite, @ModelAttribute UaThich uaThich, @RequestParam("action") String action) {
        Optional<BlogMusic> blogMusicOptional = iBlogMusicService.findByIdo(id);
        if (!blogMusicOptional.isPresent()) {
            return "/blogMusic/error";
        }
        if (action.equals("show")) {
            favourite.addFavourite(blogMusicOptional.get());
            return "redirect:/blogMusic/favourite-add";
        }
        favourite.addFavourite(blogMusicOptional.get());
        iUaThichService.save(uaThich);
        return "redirect:/blogMusic/";
    }


    @ModelAttribute("favourite")
    public Favourite setupCart() {
        return new Favourite();
    }


    @Autowired
    IPersonService iPersonService;

    @GetMapping("/create-person")
    public ModelAndView showCreateAdminOrPerson() {
        ModelAndView modelAndView = new ModelAndView("/createAdminOrPerson");
        modelAndView.addObject("listPerson", new Person());
        return modelAndView;
    }

    @PostMapping("/create-person")
    public ModelAndView createAdminOrPerson(@ModelAttribute("listPerson") Person person, @RequestParam MultipartFile uppAvatar) {
        String nameAvatar = uppAvatar.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppAvatar.getBytes(), new File("D:\\MD4-JPA\\BlogMusic\\src\\main\\webapp\\avatar/" + nameAvatar));
            String urlImg = "/avatar/" + nameAvatar;
            person.setAvatar(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iPersonService.savePerson(person);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogMusic/showAdmin");
        return modelAndView;
    }

    //register
    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("/register");
    }


    //mua bản quyền

    @ModelAttribute("cart")
    public Cart setupCartBlog() {
        return new Cart();
    }

    @GetMapping("addCart/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<BlogMusic> BlogOptional = iBlogMusicService.findByIdo(id);
        if (!BlogOptional.isPresent()) {
            return "/blogMusic/error";
        }
        if (action.equals("show")) {
            cart.addBlogMusic(BlogOptional.get());
            return "redirect:/blogMusic/shopping-cart";
        }
        cart.addBlogMusic(BlogOptional.get());
        return "redirect:/blogMusic/";
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@ModelAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

}
