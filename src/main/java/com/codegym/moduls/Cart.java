//package com.codegym.moduls;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Cart {
//    public Map<BlogMusic, Integer> blogMusics = new HashMap<>();
//
//    public Cart() {
//    }
//
//    public Cart(Map<BlogMusic, Integer> blogMusics) {
//        this.blogMusics = blogMusics;
//    }
//
//    public Map<BlogMusic, Integer> getBlogMusics() {
//        return blogMusics;
//    }
//
//    public void setBlogMusics(Map<BlogMusic, Integer> blogMusics) {
//        this.blogMusics = blogMusics;
//    }
//
//    //Phương thức checkIntemInCart() để kiểm tra xem sản phẩm đó đã có trong giỏ hàng hay chưa
//    private boolean checkItemInCart(BlogMusic blogMusic){
//        for (Map.Entry<BlogMusic, Integer> entry : blogMusics.entrySet()) {
//            if(entry.getKey().getIdBlog()==(blogMusic.getIdBlog())){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private Map.Entry<BlogMusic, Integer> selectItemInCart(BlogMusic blogMusic){
//        for (Map.Entry<BlogMusic, Integer> entry : blogMusics.entrySet()) {
//            if(entry.getKey().getIdBlog()==(blogMusic.getIdBlog())){
//                return entry;
//            }
//        }
//        return null;
//    }
//
//
//    //Phương thức addProduct() được sử dụng để thêm sản phẩm vào trong giỏ hàng.
//    public void addBlogMusic(BlogMusic blogMusic){
//        if (!checkItemInCart(blogMusic)){
//            blogMusics.put(blogMusic,1);
//        } else {
//            Map.Entry<BlogMusic, Integer> itemEntry = selectItemInCart(blogMusic);
//            Integer newQuantity = itemEntry.getValue() + 1;
//            blogMusics.replace(itemEntry.getKey(),newQuantity);
//        }
//    }
//
//    //Phương thức countProductQuantity() dùng để đếm số lượng sản phẩm đó hiện có trong giỏ hàng.
//
//    public Integer countBlogMusicQuantity(){
//        Integer blogQuantity = 0;
//        for (Map.Entry<BlogMusic, Integer> entry : blogMusics.entrySet()) {
//            blogQuantity += entry.getValue();
//        }
//        return blogQuantity;
//    }
//
//
//    //Phương thức countItemQuantity() để đếm số lượng sản phẩm có trong giỏ hàng.
//    public Integer countItemQuantity(){
//        return blogMusics.size();
//    }
//
//
//    //Phương thức countTotalPayment() dùng để tính tổng số tiền cần phải thanh toán.
//    public Float countTotalPayment(){
//        float payment = 0;
//        for (Map.Entry<BlogMusic, Integer> entry : blogMusics.entrySet()) {
//            payment += entry.getKey().getPrice() * (float) entry.getValue();
//        }
//        return payment;
//    }
//}
