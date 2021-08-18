package com.book.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * @author lichuang
 * @create 2021-08-18 12:35
 */
public class Cart {

//    private Integer totalCount; // 商品数量
//    private BigDecimal totalPrice; // 商品总价
    /**
     * key是商品编号
     * value是商品信息
     * @Author lichuang
     * @Date 2021/8/18 12:52
     * @param null
     * @return
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>(); // 商品列表项

    /**
     * 添加商品项
     * @Author lichuang
     * @Date 2021/8/18 12:40
     * @param cartItem
     * @return void
     */
    public void addItem(CartItem cartItem){
       // 查看购物车中是否已经添加过该商品，如果添加过，数量累加，总金额更新，如果没添加过，直接放到集合中即可
        CartItem item = items.get(cartItem.getId());

        if(item == null){
            // 之前没添加过此商品
            items.put(cartItem.getId(),cartItem);
        }else{
            // 已经添加过
            item.setCount(item.getCount() + 1); // 数量累加
            item.setTotalPrice( item.getPrice().multiply(new BigDecimal(item.getCount())) ); // 更新总金额
        }
    }

    /**
     * 删除商品项
     * @Author lichuang
     * @Date 2021/8/18 12:41
     * @param id
     * @return void
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空购物车
     * @Author lichuang
     * @Date 2021/8/18 12:41
     * @param
     * @return void
     */
    public void clear(){
        items.clear();
    }

    /**
     * 修改商品数量
     * @Author lichuang
     * @Date 2021/8/18 12:42
     * @param id
     * @param count
     * @return void
     */
    public void updateCount(Integer id,Integer count){
        // 先查看购物车是否有此商品，如果有，修改数量，更新金额
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            cartItem.setCount(count); // 修改商品数量
            cartItem.setTotalPrice( cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())) ); // 更新总金额
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;

        for(Map.Entry<Integer,CartItem> entry:items.entrySet()){
            totalCount += entry.getValue().getCount();
        }

        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for(Map.Entry<Integer,CartItem> entry:items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }

    public Map<Integer,CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer,CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
