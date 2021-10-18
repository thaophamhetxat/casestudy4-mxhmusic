package com.codegym.controller;


import com.codegym.moduls.*;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    INhacSyService iNhacSyService;
    @Autowired
    ICaSyService iCaSyService;
    @Autowired
    ICommentService iCommentService;


    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception e) {
        ModelAndView modelAndView = new ModelAndView("/error");
        return modelAndView;
    }


    @ModelAttribute
    public ArrayList<TheLoai> listTheLoai() {
        return (ArrayList<TheLoai>) iTheLoaiService.findAll();
    }

    @ModelAttribute
    public ArrayList<Role> listRole() {
        return (ArrayList<Role>) iRoleService.findAll();
    }

    @ModelAttribute
    public ArrayList<CaSy> listCaSy() {
        return (ArrayList<CaSy>) iCaSyService.findAll();
    }

    @ModelAttribute
    public ArrayList<NhacSy> listNhacSy() {
        return (ArrayList<NhacSy>) iNhacSyService.findAll();
    }

    //login
    @GetMapping("/")
    public ModelAndView index(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/index");
//        modelAndView.addObject("listSortViews",iBlogMusicService.SortMaxViews());
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("listPerson", iPersonService.findAllPerson());
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(page, 12)));
        // hiển thị danh mục ca sỹ
        modelAndView.addObject("listCaSy", iCaSyService.findAll(PageRequest.of(page, 4)));
        // hiển thị danh mục Nhạc Sỹ
        modelAndView.addObject("listNhacSy", iNhacSyService.findAll(PageRequest.of(page, 4)));
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
        modelAndView.addObject("listCaSY", new BlogMusic());
        modelAndView.addObject("listNhacSy", new BlogMusic());
        modelAndView.addObject("listPerson", iPersonService.findAllPerson());
        modelAndView.addObject("listSinger", iCaSyService.findAll());
        modelAndView.addObject("listMusician", iNhacSyService.findAll());
        modelAndView.addObject("listAdmin", iPersonService.findAllByNameAdmin().size());
        modelAndView.addObject("listUser", iPersonService.findAllByNamePerson().size());
        modelAndView.addObject("listBlog", iBlogMusicService.findAll().size());
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(page, 5, Sort.by("views"))));
        return modelAndView;
    }


    @GetMapping("/blog")
    public ModelAndView blog(@RequestParam(defaultValue = "0") int page, @PathVariable int idBlog) {
        ModelAndView modelAndView = new ModelAndView("/blog");
//        modelAndView.addObject("listSortViews",iBlogMusicService.SortMaxViews());
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("listComments", iCommentService.findAll());
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(page, 12)));
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("listTheLoai", new BlogMusic());
        modelAndView.addObject("listCaSy", new BlogMusic());
        modelAndView.addObject("listNhacSy", new BlogMusic());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("listTheLoai") BlogMusic blogMusic , BindingResult bindingResult, @RequestParam MultipartFile uppImg, @RequestParam MultipartFile uppMusic) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/create");
            return modelAndView;
        }
        String nameImg = uppImg.getOriginalFilename();
        String nameMusic = uppMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\MD4-JPA\\casestudy4-mxhmusic\\src\\main\\webapp\\image/" + nameImg));
            FileCopyUtils.copy(uppMusic.getBytes(), new File("D:\\MD4-JPA\\casestudy4-mxhmusic\\src\\main\\webapp\\music/" + nameMusic));
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


    @GetMapping("/edit/{idBlog}")
    public ModelAndView showEdit(@PathVariable int idBlog) {
        ModelAndView modelAndView = new ModelAndView("/edit", "listTheLoai", iTheLoaiService.findAll());
        modelAndView.addObject("list", iBlogMusicService.findById(idBlog));
        return modelAndView;
    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute BlogMusic blogMusic, @RequestParam MultipartFile uppImg, @RequestParam MultipartFile uppMusic) {
        String nameImg = uppImg.getOriginalFilename();
        String nameMusic = uppMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\MD4-JPA\\casestudy4-mxhmusic\\src\\main\\webapp\\image/" + nameImg));
            FileCopyUtils.copy(uppMusic.getBytes(), new File("D:\\MD4-JPA\\casestudy4-mxhmusic\\src\\main\\webapp\\music/" + nameMusic));
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

    //tìm kiếm
    @GetMapping("/search")
    public ModelAndView findByName(@RequestParam String tenBaiHat) {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("list", iBlogMusicService.findAllByName(tenBaiHat));
        return modelAndView;
    }

    @GetMapping("/search-admin")
    public ModelAndView findByNameAdmin(@RequestParam String tenBaiHat) {
        ModelAndView modelAndView = new ModelAndView("/showAdmin");
        modelAndView.addObject("list", iBlogMusicService.findAllByName(tenBaiHat));
        return modelAndView;
    }


    @GetMapping("/delete/{idBlog}")
    public ModelAndView delete(@PathVariable int idBlog) {
        iBlogMusicService.delete(iBlogMusicService.findById(idBlog));
        return new ModelAndView("redirect:/blogMusic/showAdmin");
    }


    @GetMapping("/detail/{idBlog}")
    public ModelAndView detail(@PathVariable int idBlog) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("list", iBlogMusicService.findById(idBlog));
        return modelAndView;
    }


    //    blog
    @GetMapping("/playBlog/{idBlog}")
    public ModelAndView showBlog(@RequestParam(defaultValue = "0") int page, @PathVariable int idBlog) {
        ModelAndView modelAndView = new ModelAndView("/blog");
        iBlogMusicService.views(idBlog);
//        modelAndView.addObject("listSortViews",iBlogMusicService.SortMaxViews());
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("listAll", iBlogMusicService.findAll());
        modelAndView.addObject("list", iBlogMusicService.findById(idBlog));
        //show comment
        modelAndView.addObject("listComments", iCommentService.findAll(PageRequest.of(page, 6)));
        return modelAndView;
    }


    //thêm vào list yêu thích

    @GetMapping("/add/{idBlog}")
    public ModelAndView addToCart(@PathVariable int idBlog, @ModelAttribute Favourite favourite, @RequestParam("action") String action) {
        Optional<BlogMusic> blogMusicOptional = iBlogMusicService.findByIdo(idBlog);
        if (!blogMusicOptional.isPresent()) {
            return new ModelAndView("/blogMusic/error");
        }
        if (action.equals("show")) {
            favourite.addFavourite(blogMusicOptional.get());
            return new ModelAndView("redirect:/blogMusic/favourite-add");
        }
        favourite.addFavourite(blogMusicOptional.get());
//        iUaThichService.save(uaThich);
        return new ModelAndView("redirect:/blogMusic/");
    }


    @ModelAttribute("favourite")
    public Favourite setupFavourite() {
        return new Favourite();
    }


    @GetMapping("/successCart/")
    public ModelAndView showSuccessCart() {
        ModelAndView modelAndView = new ModelAndView("/successCart");
        return modelAndView;
    }

    //tạo 1 person mới
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
            FileCopyUtils.copy(uppAvatar.getBytes(), new File("D:\\MD4-JPA\\casestudy4-mxhmusic\\src\\main\\webapp\\avatar/" + nameAvatar));
            String urlImg = "/avatar/" + nameAvatar;
            person.setAvatar(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iPersonService.savePerson(person);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogMusic/showAdmin");
        return modelAndView;
    }

    //delete person/admin
    @GetMapping("/deletePerson/{idPerson}")
    public ModelAndView deletePersonOfAdmin(@PathVariable int idPerson) {
        iPersonService.removePerson(idPerson);
        return new ModelAndView("redirect:/blogMusic/showAdmin");
    }

    //edit person/admin
    @GetMapping("/editPerson/{idPerson}")
    public ModelAndView showEditPersonOfAdmin(@PathVariable int idPerson) {
        ModelAndView modelAndView = new ModelAndView("/editPeronOfAdmin");
        modelAndView.addObject("listPA", iPersonService.findByIdPerson(idPerson).get());
        return modelAndView;
    }

    @PostMapping("/editPerson/{idPerson}")
    public ModelAndView editPersonOfAdmin(@ModelAttribute Person person, @RequestParam MultipartFile uppAvatar) {
        String nameAvatar = uppAvatar.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppAvatar.getBytes(), new File("D:\\MD4-JPA\\casestudy4-mxhmusic\\src\\main\\webapp\\avatar/" + nameAvatar));
            String urlImg = "/avatar/" + nameAvatar;
            person.setAvatar(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iPersonService.savePerson(person);
        return new ModelAndView("redirect:/blogMusic/showAdmin");
    }


    //register
    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("/register");
        modelAndView.addObject("listPerson", new Person());
        return modelAndView;
    }


    @PostMapping("/register")
    public ModelAndView createRegister(@Valid @ModelAttribute("listPerson") Person person,BindingResult bindingResult, @RequestParam MultipartFile uppAvatar) {
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/register");
            return modelAndView;
        }
        String nameAvatar = uppAvatar.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppAvatar.getBytes(), new File("D:\\MD4-JPA\\casestudy4-mxhmusic\\src\\main\\webapp\\avatar/" + nameAvatar));
            String urlImg = "/avatar/" + nameAvatar;
            person.setAvatar(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iPersonService.savePerson(person);

        ModelAndView modelAndView = new ModelAndView("redirect:/blogMusic/login");
        return modelAndView;
    }


    @GetMapping("/forgot")
    public ModelAndView forgot() {
        return new ModelAndView("/forgot");
    }

    @GetMapping("/search-register")
    public ModelAndView findAllByUserName(@RequestParam String userName) {
        ModelAndView modelAndView = new ModelAndView("/forgot");
        modelAndView.addObject("listForgot", iPersonService.findAllByUserName(userName));
        return modelAndView;
    }


//
//    @GetMapping("/comments/{idBlog}")
//    public ModelAndView comment(@PathVariable int idBlog) {
//        ModelAndView modelAndView = new ModelAndView("/blog");
//        modelAndView.addObject("listCM", iCommentService.findById(idBlog).get());
//        return modelAndView;
//    }


    @PostMapping("/comments")
    public ModelAndView editComment(@ModelAttribute Comment comment) {
        iCommentService.save(comment);
        return new ModelAndView("redirect:/blogMusic/");
    }


    //  Thêm - sửa - xóa  ca sỹ
    @GetMapping("/create-casy")
    public ModelAndView showCreateSinger() {
        ModelAndView modelAndView = new ModelAndView("/createCaSy");
        modelAndView.addObject("listSinger", new CaSy());
        return modelAndView;
    }

    @PostMapping("/create-casy")
    public ModelAndView createSinger(@Valid @ModelAttribute("listSinger") CaSy caSy,BindingResult bindingResult,@RequestParam MultipartFile uppPhotoCasy) {
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/createCaSy");
            return modelAndView;
        }
        String nameImg = uppPhotoCasy.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppPhotoCasy.getBytes(), new File("D:\\MD4-JPA\\casestudy4-mxhmusic\\src\\main\\webapp\\image/" + nameImg));
            String urlImg = "/image/" + nameImg;
            caSy.setSingerPhoto(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iCaSyService.save(caSy);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogMusic/showAdmin");
        return modelAndView;
    }

    @GetMapping("/deleteSinger/{idCaSy}")
    public ModelAndView deleteSinger(@PathVariable int idCaSy) {
        iCaSyService.delete(iCaSyService.findById(idCaSy).get());
        return new ModelAndView("redirect:/blogMusic/showAdmin");
    }


    @GetMapping("/editSinger/{idCaSy}")
    public ModelAndView showEditSinger(@PathVariable int idCaSy) {
        ModelAndView modelAndView = new ModelAndView("/editSinger");
        modelAndView.addObject("listSinger", iCaSyService.findById(idCaSy));
        return modelAndView;
    }

    @PostMapping("/editSinger/{idCaSy}")
    public ModelAndView editSinger(@RequestParam MultipartFile uppPhotoCasy, @ModelAttribute CaSy caSy) {
        String nameImg = uppPhotoCasy.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppPhotoCasy.getBytes(), new File("D:\\MD4-JPA\\casestudy4-mxhmusic\\src\\main\\webapp\\image/" + nameImg));
            String urlImg = "/image/" + nameImg;
            caSy.setSingerPhoto(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iCaSyService.edit(caSy);
        return new ModelAndView("redirect:/blogMusic/showAdmin");
    }


    //  Thêm - sửa - xóa nhạc sỹ
    @GetMapping("/create-nhacsy")
    public ModelAndView showCreateMusician() {
        ModelAndView modelAndView = new ModelAndView("/createNhacSy");
        modelAndView.addObject("listMusician", new NhacSy());
        return modelAndView;
    }

    @PostMapping("/create-nhacsy")
    public ModelAndView createMusician(@Valid @ModelAttribute("listMusician") NhacSy nhacSy,BindingResult bindingResult,@RequestParam MultipartFile uppPhotoMusician) {
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/createNhacSy");
            return modelAndView;
        }
        String nameImg = uppPhotoMusician.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppPhotoMusician.getBytes(), new File("D:\\MD4-JPA\\casestudy4-mxhmusic\\src\\main\\webapp\\image/" + nameImg));
            String urlImg = "/image/" + nameImg;
            nhacSy.setMusicianPhoto(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iNhacSyService.save(nhacSy);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogMusic/showAdmin");
        return modelAndView;
    }

    @GetMapping("/deleteMusician/{idNhacSy}")
    public ModelAndView deleteMusician(@PathVariable int idNhacSy) {
        iNhacSyService.delete(iNhacSyService.findById(idNhacSy).get());
        return new ModelAndView("redirect:/blogMusic/showAdmin");
    }

    @GetMapping("/editMusician/{idNhacSy}")
    public ModelAndView showEditMusician(@PathVariable int idNhacSy) {
        ModelAndView modelAndView = new ModelAndView("/editMusician");
        modelAndView.addObject("listMusician", iNhacSyService.findById(idNhacSy));
        return modelAndView;
    }

    @PostMapping("/editMusician/{idNhacSy}")
    public ModelAndView editMusician(@RequestParam MultipartFile uppPhotoMusician, @ModelAttribute NhacSy nhacSy) {
        String nameImg = uppPhotoMusician.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppPhotoMusician.getBytes(), new File("D:\\MD4-JPA\\casestudy4-mxhmusic\\src\\main\\webapp\\image/" + nameImg));
            String urlImg = "/image/" + nameImg;
            nhacSy.setMusicianPhoto(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iNhacSyService.save(nhacSy);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogMusic/showAdmin");
        return modelAndView;
    }


    //chi tiêt ca sỹ - nhạc sỹ
    @GetMapping("/chiTietCaSy/{idCaSy}")
    public ModelAndView hienThiChiTietCaSy(@PathVariable int idCaSy) {
        ModelAndView modelAndView = new ModelAndView("/chiTietCaSy");
        modelAndView.addObject("chiTietSinger", iCaSyService.findById(idCaSy).get());
        return modelAndView;
    }

    @GetMapping("/chiTietNhacSy/{idNhacSy}")
    public ModelAndView hienThiChiTietNhacSy(@PathVariable int idNhacSy) {
        ModelAndView modelAndView = new ModelAndView("/chiTietNhacSy");
        modelAndView.addObject("chiTietMusician", iNhacSyService.findById(idNhacSy).get());
        return modelAndView;
    }

    //show tất cả nhạc của remix-pop-us
    @GetMapping("/showMusicRemix")
    public ModelAndView showRemix(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/showMusicRemix");
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        return modelAndView;
    }

    @GetMapping("/showMusicPop")
    public ModelAndView showPop(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/showMusicPop");
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        return modelAndView;
    }

    @GetMapping("/showMusicUs")
    public ModelAndView showUs(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/showMusicUs");
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        return modelAndView;
    }


    //like
    @GetMapping("/likeblog/{idBlog}")
    public ModelAndView likeBlog(@RequestParam(defaultValue = "0") int page, @PathVariable int idBlog) {
        ModelAndView modelAndView = new ModelAndView("/index");
        iBlogMusicService.likes(idBlog);
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(page, 12)));
        // hiển thị danh mục ca sỹ
        modelAndView.addObject("listCaSy", iCaSyService.findAll(PageRequest.of(page, 4)));
        // hiển thị danh mục Nhạc Sỹ
        modelAndView.addObject("listNhacSy", iNhacSyService.findAll(PageRequest.of(page, 4)));
        return modelAndView;
    }

    @GetMapping("/unlikeblog/{idBlog}")
    public ModelAndView unlikeBlog(@RequestParam(defaultValue = "0") int page, @PathVariable int idBlog) {
        ModelAndView modelAndView = new ModelAndView("/index");
        iBlogMusicService.dislikes(idBlog);
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(page, 12)));
        // hiển thị danh mục ca sỹ
        modelAndView.addObject("listCaSy", iCaSyService.findAll(PageRequest.of(page, 4)));
        // hiển thị danh mục Nhạc Sỹ
        modelAndView.addObject("listNhacSy", iNhacSyService.findAll(PageRequest.of(page, 4)));
        return modelAndView;
    }

    //next
    @RequestMapping("/next")
    public ModelAndView listMusic() {
        List<BlogMusic> todoList = iBlogMusicService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog", "todoList", todoList);
        return modelAndView;
    }

}
