package com.em.service;

import com.em.bean.UserBean;
import com.em.bean.UserCartBean;
import com.em.entity.Product;
import com.em.entity.User;
import com.em.entity.UserCart;
import com.em.repository.CartRepository;
import com.em.repository.ProductRepository;
import com.em.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cartService")
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public UserCartBean add(UserCartBean userCartBean) {
        Long userId = userCartBean.getUser().getId();
        Long productId = userCartBean.getProduct().getId();

        User user = this.userRepository.findById(userId).get();
        Product product = this.productRepository.findById(productId).get();

        UserCart userCart = new UserCart();
        userCart.setProduct(product);
        userCart.setUser(user);

        UserCartBean userCartBeanResponse = new UserCartBean();
        BeanUtils.copyProperties(this.cartRepository.save(userCart), userCartBeanResponse);
        return userCartBeanResponse;
    }
}
