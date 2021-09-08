package com.codegym.moduls;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

public class Favourite {
    public Map<BlogMusic, Integer> blogMusics = new HashMap<>();


    public Favourite() {
    }

    public Favourite(Map<BlogMusic, Integer> blogMusics) {
        this.blogMusics = blogMusics;
    }

    public Map<BlogMusic, Integer> getBlogMusics() {
        return blogMusics;
    }

    public void setBlogMusics(Map<BlogMusic, Integer> blogMusics) {
        this.blogMusics = blogMusics;
    }

    //Phương thức checkInItemInFavourite() để kiểm tra xem sản phẩm yêu thích đó đã có trong home cá nhân hay chưa
    private boolean checkInItemInFavourite(BlogMusic blogMusic) {
        for (Map.Entry<BlogMusic, Integer> entry : blogMusics.entrySet()) {
            if (entry.getKey().getIdBlog() == (blogMusic.getIdBlog())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<BlogMusic, Integer> selectItemInFavourite(BlogMusic blogMusic) {
        for (Map.Entry<BlogMusic, Integer> entry : blogMusics.entrySet()) {
            if (entry.getKey().getIdBlog() == (blogMusic.getIdBlog())) {
                return entry;
            }
        }
        return null;
    }

    //Phương thức addFavourite() được sử dụng để thêm sản phẩm yêu thích vào trong home cá nhân.
    public void addFavourite(BlogMusic blogMusic) {
        if (!checkInItemInFavourite(blogMusic)) {
            blogMusics.put(blogMusic, 1);
        } else {
            Map.Entry<BlogMusic, Integer> itemEntry = selectItemInFavourite(blogMusic);
            Integer newQuantity = itemEntry.getValue() + 1;
            blogMusics.replace(itemEntry.getKey(), newQuantity);
        }
    }

    //Phương thức countFavouriteQuantity() dùng để đếm số lượng yêu thích đó hiện có trong home cá nhân.
    public Integer countFavouriteQuantity() {
        Integer favouriteQuantity = 0;
        for (Map.Entry<BlogMusic, Integer> entry : blogMusics.entrySet()) {
            favouriteQuantity += entry.getValue();
        }
        return favouriteQuantity;
    }


    //Phương thức countItemQuantity() để đếm số lượng sản phẩm yêu thích có home cá nhân.
    public Integer countItemQuantity() {
        return blogMusics.size();
    }

    //Phương thức countTotalPayment() dùng để tính tổng số tiền cần phải thanh toán.
    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<BlogMusic, Integer> entry : blogMusics.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }


}
