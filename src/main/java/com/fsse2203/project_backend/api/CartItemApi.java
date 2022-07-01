package com.fsse2203.project_backend.api;

import com.fsse2203.project_backend.config.EnvConfig;
import com.fsse2203.project_backend.data.cart_item.CartItemDetailData;
import com.fsse2203.project_backend.data.cart_item.dto.response.AddCartItemResponseDto;
import com.fsse2203.project_backend.data.cart_item.dto.response.RemoveCartItemResponseDto;
import com.fsse2203.project_backend.data.cart_item.dto.response.UserCartDetailResponseDto;
import com.fsse2203.project_backend.exception.CartItemNotFoundException;
import com.fsse2203.project_backend.exception.ProductNotFoundException;
import com.fsse2203.project_backend.exception.QuantityInvalidExcepution;
import com.fsse2203.project_backend.exception.UserNotFoundInCartException;
import com.fsse2203.project_backend.service.CartItemService;
import com.fsse2203.project_backend.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {EnvConfig.devBaseUrl,EnvConfig.proBaseUrl},maxAge = 3600)
@RestController
public class CartItemApi {
    public final CartItemService cartItemService;

    @Autowired
    public CartItemApi(CartItemService cartService) {
        this.cartItemService = cartService;
    }

    @PutMapping("/cart/add-item/{pid}/{quantity}")
    public AddCartItemResponseDto addItemtoCart(@PathVariable Integer pid, @PathVariable Integer quantity, Authentication authentication)throws QuantityInvalidExcepution, UserNotFoundInCartException,ProductNotFoundException{
        String firebaseUid = SecurityUtil.getFireBaseUid(authentication);
        return new AddCartItemResponseDto(cartItemService.addItemtoCart(firebaseUid,pid,quantity));
    }

    @GetMapping("/cart")
    public List<UserCartDetailResponseDto> getUserCart(Authentication authentication)throws UserNotFoundInCartException{
        String firebaseUid = SecurityUtil.getFireBaseUid(authentication);
        List<UserCartDetailResponseDto> dtos = new ArrayList<>();

        List<CartItemDetailData> datas = cartItemService.getUserCart(firebaseUid);
        for (CartItemDetailData data : datas) {
            dtos.add(new UserCartDetailResponseDto(data));
        }
        return dtos;
    }
    @PatchMapping("/cart/{pid}/{quantity}")
    public UserCartDetailResponseDto updateCartQuantity(@PathVariable Integer pid, @PathVariable Integer quantity, Authentication authentication)throws CartItemNotFoundException,QuantityInvalidExcepution {
        String firebaseUid = SecurityUtil.getFireBaseUid(authentication);
        return new UserCartDetailResponseDto(cartItemService.UpdateCartQuantity(firebaseUid,pid,quantity));
    }

    @DeleteMapping("/cart/{pid}")
    public RemoveCartItemResponseDto removeCartItem(Authentication authentication,@PathVariable Integer pid) throws CartItemNotFoundException{
        String firebaseUid = SecurityUtil.getFireBaseUid(authentication);
        return new RemoveCartItemResponseDto(cartItemService.removeCartItem(firebaseUid, pid));
    }

}
